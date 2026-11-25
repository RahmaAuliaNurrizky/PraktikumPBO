package perpustakaan;

public class Buku extends KoleksiFisik {
    public Buku(String kode, String judul, int tahunTerbit) {
        super(kode, judul, tahunTerbit);
    }

    @Override
    public String jenis() {
        return "Buku";
    }
    // termasuk open/closed tp karena hrs diedit tiap ada aturan baru jdi bkn oc
    @Override
    public int batasHariPinjam() {
        if (getTahunTerbit() < 2000) {
            return 7;   // buku langka
        }
        return 14;      // buku biasa
    }

    @Override
    public long dendaPerHari() {
        if (getTahunTerbit() < 2000) {
            return 3000;   // buku langka
        }
        return 1000;       // buku biasa
    }
}