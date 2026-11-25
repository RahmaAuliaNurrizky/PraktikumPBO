package perpustakaan;

// termasuk interface segregation
public interface DapatDipinjam {
    /** Lama peminjaman yang diizinkan, dalam hari. */
    int batasHariPinjam();

    /** Besar denda per hari keterlambatan, dalam rupiah. */
    long dendaPerHari();

    /** Denda dasar untuk sejumlah hari keterlambatan, dalam rupiah. */
    long hitungDenda(int hariTerlambat);
}