package perpustakaan;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

// kurang sesuai dengan single responsibility, karena mengurus pinjam, kembali, laporan, memformat angka rupiah
public class LayananPeminjaman {
    private final RepositoriPeminjaman repositori;
    private final Notifikasi notifikasi;

    public LayananPeminjaman(RepositoriPeminjaman repositori, Notifikasi notifikasi) {
        if (repositori == null || notifikasi == null) {
            throw new IllegalArgumentException("Repositori dan notifikasi tidak boleh null");
        }
        this.repositori = repositori;
        this.notifikasi = notifikasi;
    }

    // termasuk liskov subsitution
    public Peminjaman pinjam(Anggota anggota, KoleksiFisik koleksi, LocalDate tanggal) {
        if (anggota == null || koleksi == null || tanggal == null) {
            throw new IllegalArgumentException("Argumen tidak boleh null");
        }

        // 1. koleksi masih dipinjam orang lain?
        if (cariPeminjamanAktif(koleksi.getKode()) != null) {
            throw new IllegalStateException("Koleksi sedang dipinjam");
        }

        // 2. anggota sudah mencapai batas pinjaman?
        if (jumlahPinjamanAktif(anggota.getId()) >= anggota.maksPinjamanAktif()) {
            throw new IllegalStateException("Batas pinjaman tercapai");
        }

        // 3. buat peminjaman, simpan, lalu kembalikan
        LocalDate jatuhTempo = tanggal.plusDays(koleksi.batasHariPinjam());
        Peminjaman baru = new Peminjaman(anggota, koleksi, tanggal, jatuhTempo);
        repositori.simpan(baru);
        return baru;
    }

    public long kembalikan(String kodeKoleksi, LocalDate tanggalKembali) {
        if (kodeKoleksi == null || tanggalKembali == null) {
            throw new IllegalArgumentException("Kode dan tanggal kembali wajib diisi");
        }

        // 1. cari peminjaman yang masih aktif
        String kode = kodeKoleksi.trim().toUpperCase();
        Peminjaman pinjaman = cariPeminjamanAktif(kode);
        if (pinjaman == null) {
            throw new IllegalArgumentException("Koleksi tidak sedang dipinjam");
        }

        // 2. tanggal kembali tidak boleh sebelum tanggal pinjam
        if (tanggalKembali.isBefore(pinjaman.getTanggalPinjam())) {
            throw new IllegalArgumentException("Tanggal kembali sebelum tanggal pinjam");
        }

        // 3. hitung hari terlambat (minimal 0)
        long hariTerlambat = ChronoUnit.DAYS.between(pinjaman.getJatuhTempo(), tanggalKembali);
        if (hariTerlambat < 0) {
            hariTerlambat = 0;
        }

        // 4. hitung denda: dasar dari koleksi, akhir dari anggota
        long dendaDasar = pinjaman.getKoleksi().hitungDenda((int) hariTerlambat);
        long dendaAkhir = pinjaman.getAnggota().hitungDendaAkhir(dendaDasar);

        // 5. tandai selesai
        pinjaman.selesai(tanggalKembali, dendaAkhir);

        // 6. kirim notifikasi hanya jika ada denda
        if (dendaAkhir > 0) {
            String pesan = "Denda Rp" + formatRibuan(dendaAkhir)
                    + " untuk \"" + pinjaman.getKoleksi().getJudul() + "\""
                    + ", terlambat " + hariTerlambat + " hari";
            notifikasi.kirim(pinjaman.getAnggota(), pesan);
        }

        return dendaAkhir;
    }

    public int jumlahPinjamanAktif(String idAnggota) {
        int jumlah = 0;
        for (Peminjaman p : repositori.semua()) {
            if (p.isAktif() && p.getAnggota().getId().equals(idAnggota)) {
                jumlah++;
            }
        }
        return jumlah;
    }

    public long totalDenda(String idAnggota) {
        long total = 0;
        for (Peminjaman p : repositori.semua()) {
            if (!p.isAktif() && p.getAnggota().getId().equals(idAnggota)) {
                total += p.getDenda();
            }
        }
        return total;
    }

    public List<Peminjaman> daftarTerlambat(LocalDate hariIni) {
        List<Peminjaman> hasil = new ArrayList<>();
        for (Peminjaman p : repositori.semua()) {
            if (p.isAktif() && p.getJatuhTempo().isBefore(hariIni)) {
                hasil.add(p);
            }
        }

        // urutkan: jatuh tempo paling awal dulu, kalau sama urut kode koleksi
        hasil.sort((a, b) -> {
            int banding = a.getJatuhTempo().compareTo(b.getJatuhTempo());
            if (banding != 0) {
                return banding;
            }
            return a.getKoleksi().getKode().compareTo(b.getKoleksi().getKode());
        });
        return hasil;
    }

    // mencari peminjaman aktif untuk kode koleksi tertentu (null kalau tidak ada)
    private Peminjaman cariPeminjamanAktif(String kodeKoleksi) {
        for (Peminjaman p : repositori.semua()) {
            if (p.isAktif() && p.getKoleksi().getKode().equals(kodeKoleksi)) {
                return p;
            }
        }
        return null;
    }

    // mengubah 1234500 menjadi "1.234.500"
    private String formatRibuan(long angka) {
        String teks = String.valueOf(angka);
        String hasil = "";
        int hitung = 0;
        for (int i = teks.length() - 1; i >= 0; i--) {
            if (hitung == 3) {
                hasil = "." + hasil;
                hitung = 0;
            }
            hasil = teks.charAt(i) + hasil;
            hitung++;
        }
        return hasil;
    }
}