package P2;

public class TestTransaksiPeminjaman {
    public static void main(String[] args) {
        TransaksiPeminjaman transaksi1 = new TransaksiPeminjaman();
        transaksi1.idTransaksi = "P001";
        transaksi1.namaPeminjam = "Rahma Aulia";
        transaksi1.judulBuku = "Pemrograman Java";
        transaksi1.jumlahHariTerlambat = 0;
        transaksi1.denda = transaksi1.hitungDenda();
        transaksi1.tampilDataPeminjaman();

        TransaksiPeminjaman transaksi2 = new TransaksiPeminjaman();
        transaksi2.idTransaksi = "P002";
        transaksi2.namaPeminjam = "Nur Rohman";
        transaksi2.judulBuku = "Dasar Pemrograman Berbasis Objek";
        transaksi2.jumlahHariTerlambat = 3;
        transaksi2.denda = transaksi2.hitungDenda();
        transaksi2.tampilDataPeminjaman();

        TransaksiPeminjaman transaksi3 = new TransaksiPeminjaman();
        transaksi3.idTransaksi = "P003";
        transaksi3.namaPeminjam = "Nabila Shima";
        transaksi3.judulBuku = "Struktur Data dan Algoritma";
        transaksi3.jumlahHariTerlambat = 10;
        transaksi3.denda = transaksi3.hitungDenda();
        transaksi3.tampilDataPeminjaman();
    }
}