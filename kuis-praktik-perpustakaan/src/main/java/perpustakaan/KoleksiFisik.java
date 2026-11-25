package perpustakaan;

public abstract class KoleksiFisik extends Koleksi implements DapatDipinjam {
    protected KoleksiFisik(String kode, String judul, int tahunTerbit) {
        super(kode, judul, tahunTerbit);
    }
    // termasuk open/closed
    @Override
    public final long hitungDenda(int hariTerlambat) {
        if (hariTerlambat <= 0) {
            return 0;
        }

        long denda = hariTerlambat * dendaPerHari();

        if (denda > dendaMaksimum()) {
            denda = dendaMaksimum();
        }
        return denda;
    }

    protected long dendaMaksimum() {
        return 10 * dendaPerHari();
    }
}