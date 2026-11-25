package perpustakaan;

public class Mahasiswa extends Anggota {
    public Mahasiswa(String id, String nama) {
        super(id, nama);
    }

    @Override
    public int maksPinjamanAktif() {
        return 3;
    }

    @Override
    protected double faktorDenda() {
        return 1.0;
    }
}