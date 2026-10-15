public class MainPerpustakaan {
    public static void main(String[] args) {
        Anggota anggota = new Anggota("Rahma");
        Petugas petugas = new Petugas("Budi");
        Perpustakaan perpustakaan = new Perpustakaan("Perpustakaan Kampus");
        perpustakaan.setAnggota(anggota);
        petugas.melayani(anggota);
        perpustakaan.tampilkanInfo();
    }   
}