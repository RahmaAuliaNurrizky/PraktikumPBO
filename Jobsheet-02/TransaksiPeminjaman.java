public class TransaksiPeminjaman {
    public String idTransaksi;
    public String namaPeminjam;
    public String judulBuku;
    public int jumlahHariTerlambat;
    public int denda;

    public int hitungDenda() {
        int dendaPerHari = 1000;
        return jumlahHariTerlambat * dendaPerHari;
    }

    public void tampilDataPeminjaman() {
        System.out.println("ID Transaksi       : " + idTransaksi);
        System.out.println("Nama Peminjam      : " + namaPeminjam);
        System.out.println("Judul Buku         : " + judulBuku);
        System.out.println("Terlambat          : " + jumlahHariTerlambat + " hari");
        System.out.println("Denda              : Rp " + denda);
    }
}