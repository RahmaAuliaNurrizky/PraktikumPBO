package perpustakaan;

// termasuk single responsibility (satu class, satu tugas)
public abstract class Anggota {
    private final String id;
    private final String nama;

    protected Anggota(String id, String nama) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID tidak boleh kosong");
        }
        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }
        this.id = id.trim();
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public abstract int maksPinjamanAktif();
    protected abstract double faktorDenda();

    public final long hitungDendaAkhir(long dendaDasar) {
        if (dendaDasar <= 0) {
            return 0;
        }

        long dendaRupiah = Math.round(dendaDasar * faktorDenda());
        long sisa = dendaRupiah % 100;
        
        if (sisa == 0) {
            return dendaRupiah;
        }
        return dendaRupiah + (100 - sisa);
    }
}