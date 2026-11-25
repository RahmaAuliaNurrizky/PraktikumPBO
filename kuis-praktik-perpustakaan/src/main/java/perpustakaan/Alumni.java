package perpustakaan;

public class Alumni extends Anggota {
    public Alumni(String id, String nama) {
        super(id, nama);
    }

    @Override
    public int maksPinjamanAktif() {
        return 1;
    }
    // termasuk open/closed
    @Override
    protected double faktorDenda() {
        return 1.5;
    }
}