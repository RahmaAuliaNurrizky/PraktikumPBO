public class TestRuangKelas {
    public static void main(String[] args) {
        RuangKelas ruang1 = new RuangKelas();
        ruang1.kodeRuang = "001";
        ruang1.namaGedung = "Gedung A";
        ruang1.kapasitas = 30;
        ruang1.jumlahMahasiswa = 25;
        ruang1.hitungSisaKursi();
        ruang1.tampilData();

        RuangKelas ruang2 = new RuangKelas();
        ruang2.kodeRuang = "002";
        ruang2.namaGedung = "Gedung B";
        ruang2.kapasitas = 40;
        ruang2.jumlahMahasiswa = 30;
        ruang2.hitungSisaKursi();
        ruang2.tampilData();

        RuangKelas ruang3 = new RuangKelas();
        ruang3.kodeRuang = "003";
        ruang3.namaGedung = "Gedung C";
        ruang3.kapasitas = 50;
        ruang3.jumlahMahasiswa = 25;
        ruang3.hitungSisaKursi();
        ruang3.tampilData();
    }
}