package perpustakaan;

public class Jurnal extends KoleksiFisik {
    public Jurnal(String kode, String judul, int tahunTerbit) {
        super(kode, judul, tahunTerbit);
    }

    @Override
    public String jenis() {
        return "Jurnal";
    }

    @Override
    public int batasHariPinjam() {
        return 7;
    }

    @Override
    public long dendaPerHari() {
        return 2000;
    }
    // termasuk open/closed
    @Override
    protected long dendaMaksimum() {
        return 30000;
    }
}