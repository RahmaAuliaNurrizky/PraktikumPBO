import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Laboratorium {
    public static final int MAKS_PINJAM = 2;

    private final String nama;
    private final List<Laptop> daftarLaptop = new ArrayList<>();
    private final List<Peminjaman> riwayat = new ArrayList<>();

    public Laboratorium(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public boolean tambahLaptop(Laptop lp) {
        if (lp == null || cariLaptop(lp.getKodeAset()) != null) {
            return false;
        }
        daftarLaptop.add(lp);
        return true;
    }

    public Laptop cariLaptop(String kodeAset) {
        if (kodeAset == null) {
            return null;
        }

        for (Laptop lp : daftarLaptop) {
            if (lp.getKodeAset().equals(kodeAset)) {
                return lp;
            }
        }
        return null;
    }

    public int jumlahPinjamanAktif(Mahasiswa m) {
        if (m == null) {
            return 0;
        }

        int jumlah = 0;
        for (Peminjaman p : riwayat) {
            if (p.isAktif()
                    && p.getMahasiswa().getNim().equals(m.getNim())) {
                jumlah++;
            }
        }
        return jumlah;
    }

    public Peminjaman pinjamkan(Mahasiswa m, String kodeAset) {
        if (m == null || kodeAset == null) {
            return null;
        }

        Laptop lp = cariLaptop(kodeAset);

        if (lp == null || !lp.isTersedia()
                || jumlahPinjamanAktif(m) >= MAKS_PINJAM) {
            return null;
        }

        if (lp.pinjam()) {
            Peminjaman p = new Peminjaman(m, lp);
            riwayat.add(p);
            return p;
        }

        return null;
    }

    public boolean kembalikan(String kodeAset) {
        if (kodeAset == null) {
            return false;
        }

        for (Peminjaman p : riwayat) {
            if (p.isAktif()
                    && p.getLaptop().getKodeAset().equals(kodeAset)) {
                p.getLaptop().kembalikan();
                p.selesai();
                return true;
            }
        }

        return false;
    }

    public List<Laptop> getDaftarLaptop() {
        return Collections.unmodifiableList(daftarLaptop);
    }
}