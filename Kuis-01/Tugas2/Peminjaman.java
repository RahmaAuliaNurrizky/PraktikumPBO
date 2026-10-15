public class Peminjaman {
    private Mahasiswa mahasiswa;
    private Laptop laptop;
    private boolean aktif;

    public Peminjaman(Mahasiswa mahasiswa, Laptop laptop) {
        this.mahasiswa = mahasiswa;
        this.laptop = laptop;
        this.aktif = true;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void selesai() {
        aktif = false;
    }
}