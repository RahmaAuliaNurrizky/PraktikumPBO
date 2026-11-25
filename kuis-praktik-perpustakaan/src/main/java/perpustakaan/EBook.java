package perpustakaan;
// termasuk liskov subsitution

public class EBook extends Koleksi implements DapatDiunduh { // bukan DapatDipinjam
    // tidak ada batasHariPinjam() atau dendaPerHari() palsu
    private final double ukuranMB;

    public EBook(String kode, String judul, int tahunTerbit, double ukuranMB) {
        super(kode, judul, tahunTerbit);
        if (ukuranMB <= 0) {
            throw new IllegalArgumentException("Ukuran harus lebih dari 0");
        }
        this.ukuranMB = ukuranMB;
    }

    @Override
    public String jenis() {
        return "E-Book";
    }

    @Override
    public int batasUnduhanPerHari() {
        if (ukuranMB > 50) {
            return 1;
        }
        return 3;
    }
}