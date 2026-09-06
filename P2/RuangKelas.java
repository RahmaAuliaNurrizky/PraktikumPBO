package P2;

public class RuangKelas {
    public String kodeRuang;
    public String namaGedung;
    public int kapasitas;
    public int jumlahMahasiswa;

    public int hitungSisaKursi() {
        int sisaKursi = kapasitas - jumlahMahasiswa;
        return sisaKursi;
    }

    public void tampilData() {
        System.out.println("Kode Ruang         : " + kodeRuang);
        System.out.println("Nama Gedung        : " + namaGedung);
        System.out.println("Kapasitas          : " + kapasitas + " orang");
        System.out.println("Jumlah Mahasiswa   : " + jumlahMahasiswa + " orang");
        System.err.println("Sisa Kursi         : " + hitungSisaKursi() + " kursi");
    }
}