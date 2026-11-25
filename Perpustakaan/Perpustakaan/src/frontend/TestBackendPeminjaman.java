package frontend;
import backend.Anggota;
import backend.Buku;
import backend.Peminjaman;

public class TestBackendPeminjaman {
    public static void main(String[] args) {
        // Ambil data anggota dan buku yang sudah ada di database
        Anggota anggota = new Anggota().getAll().get(0);
        Buku buku1 = new Buku().getAll().get(0);
        Buku buku2 = new Buku().getAll().get(0);

        Peminjaman pinjam1 = new Peminjaman(anggota, buku1, "2026-11-20", "");
        Peminjaman pinjam2 = new Peminjaman(anggota, buku2, "2026-11-21", "");
        Peminjaman pinjam3 = new Peminjaman(anggota, buku2, "2026-11-22", "");

        // test insert
        pinjam1.save();
        pinjam2.save();
        pinjam3.save();

        // test update (buku dikembalikan)
        pinjam2.setTanggalkembali("2026-11-25");
        pinjam2.save();

        // test delete
        pinjam3.delete();

        // test select all
        for(Peminjaman p : new Peminjaman().getAll()) {
            System.out.println("Anggota: " + p.getAnggota().getNama()
                    + ", Buku: " + p.getBuku().getJudul()
                    + ", Pinjam: " + p.getTanggalpinjam()
                    + ", Kembali: " + p.getTanggalkembali());
        }

        // test search
        for(Peminjaman p : new Peminjaman().search("timun")) {
            System.out.println("Anggota: " + p.getAnggota().getNama()
                    + ", Buku: " + p.getBuku().getJudul());
        }
    }
}