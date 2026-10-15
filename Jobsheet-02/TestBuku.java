public class TestBuku {

    public static void main(String[] args) {
        Buku buku1 = new Buku();
        buku1.isbn = "978-979-29-6104-2";
        buku1.judul = "Dasar Pemrograman Berbasis Objek";
        buku1.penulis = "Abdul Kadir";
        buku1.tahunTerbit = 2021;
        buku1.tampilInfoBuku();

        Buku buku2= new Buku();
        buku2.isbn = "999-999-99-9999-9";
        buku2.judul = "Dasar Pemrograman";
        buku2.penulis = "Budi Santoso";
        buku2.penerbit = "Informatika";
        buku2.tahunTerbit = 2023;
        buku2.tampilInfoBuku();

        Buku buku3 = new Buku();
        buku3.isbn = "888-888-88-8888-8";
        buku3.judul = "Pemrograman Java";
        buku3.penulis = "Andi Wijaya";
        buku3.penerbit = "Elex Media Komputindo";
        buku3.tahunTerbit = 2020;
        buku3.tampilInfoBuku();
    }
}