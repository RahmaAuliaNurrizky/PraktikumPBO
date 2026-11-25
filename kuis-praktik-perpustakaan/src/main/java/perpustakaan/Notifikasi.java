package perpustakaan;

// termasuk interface segregation
public interface Notifikasi { // hanya satu tugas
    void kirim(Anggota penerima, String pesan);
}