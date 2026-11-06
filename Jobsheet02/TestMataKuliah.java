public class TestMataKuliah {
    public static void main(String[] args) {
        MataKuliah MK1 = new MataKuliah();
        MK1.kodeMK = "L001";
        MK1.namaMK = "Dasar Pemrograman";
        MK1.sks = 2;
        MK1.nilaiAngka = 3.5;
        MK1.hitungBobotNilai();
        MK1.tampilData();

        MataKuliah MK2 = new MataKuliah();
        MK2.kodeMK = "L002";
        MK2.namaMK = "Bahasa Inggris";
        MK2.sks = 2;
        MK2.nilaiAngka = 4;
        MK2.hitungBobotNilai();
        MK2.tampilData();

        MataKuliah MK3 = new MataKuliah();
        MK3.kodeMK = "L003";
        MK3.namaMK = "Kewarganegaraan";
        MK3.sks = 2;
        MK3.nilaiAngka = 4;
        MK3.hitungBobotNilai();
        MK3.tampilData();

        double totalBobot = MK1.hitungBobotNilai() + MK2.hitungBobotNilai() + MK3.hitungBobotNilai();
        System.err.println("Total Bobot Nilai : " + totalBobot);
    }
}