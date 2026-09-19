public class Perpustakaan {
    private String nama;
    private Buku buku;
    private Anggota anggota;

    public Perpustakaan(String nama) {
        this.nama = nama;

        //composition
        this.buku = new Buku("Pemrograman Berorientasi Objek");
    }

    //aggregation
    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public void tampilkanInfo() {
        System.out.println("Perputakaan : " + nama);
        System.out.println("Buku : " + buku.getJudul());
        System.out.println("Anggota : " + anggota.getNama());
    }
}