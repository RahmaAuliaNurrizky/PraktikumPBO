package perpustakaan;

public class Dosen extends Anggota {
    public Dosen(String id, String nama) {
        super(id, nama);
    }

    @Override
    public int maksPinjamanAktif() {
        return 10;
    }

    @Override
    protected double faktorDenda() {
        return 0.0;
    }
}