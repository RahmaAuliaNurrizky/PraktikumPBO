package perpustakaan;
import java.util.List;

// termasuk interface segregation
public interface RepositoriPeminjaman { // hanya dua tugas
    /** Menyimpan peminjaman baru. */
    void simpan(Peminjaman peminjaman);

    /** Semua peminjaman yang pernah disimpan (aktif maupun selesai), urut sesuai waktu simpan. */
    List<Peminjaman> semua();
}