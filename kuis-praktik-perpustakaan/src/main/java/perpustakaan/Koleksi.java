package perpustakaan;

// termasuk single responsibility (satu class, satu tugas)
public abstract class Koleksi {
    // encapsulation: data disembunyikan (private), tidak bisa diubah (final)
    private final String kode;
    private final String judul;
    private final int tahunTerbit;

    protected Koleksi(String kode, String judul, int tahunTerbit) {
        // validasi: kode tidak boleh kosong
        if (kode == null || kode.isBlank()) {
            throw new IllegalArgumentException("Kode tidak boleh kosong");
        }
        // validasi: judul tidak boleh kosong
        if (judul == null || judul.isBlank()) {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
        // validasi: tahun minimal 1900
        if (tahunTerbit < 1900) {
            throw new IllegalArgumentException("Tahun terbit minimal 1900");
        }

        this.kode = kode.trim().toUpperCase();   // rapikan: buang spasi, jadikan huruf besar
        this.judul = judul.trim();               // rapikan: buang spasi
        this.tahunTerbit = tahunTerbit;
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public abstract String jenis();

    public String info() {
        return "[" + jenis() + "] " + kode + " - " + judul + " (" + tahunTerbit + ")";
    }

    // dua koleksi dianggap sama kalau kodenya sama
    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Koleksi)) { // 1. cek: apakah isi kotaknya memang Koleksi, kalau bukan, jelas tidak sama
            return false;
        }
        Koleksi lain = (Koleksi) o; // 2. yakin isinya Koleksi, jadi buka kotaknya
        return kode.equals(lain.kode); // 3. sekarang kode bisa dibandingkan
    }

    @Override
    public final int hashCode() {
        return kode.hashCode();
    }
}