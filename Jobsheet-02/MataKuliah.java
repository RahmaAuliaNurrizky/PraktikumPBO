public class MataKuliah {
    public String kodeMK;
    public String namaMK;
    public int sks;
    public double nilaiAngka;

    public double hitungBobotNilai() {
        return sks * nilaiAngka;
    }

    public void tampilData() {
        System.out.println("Kode Mata Kuliah    : " + kodeMK);
        System.out.println("Nama Mata Kuliah    : " + namaMK);
        System.out.println("SKS                 : " + sks);
        System.out.println("Nilai Angka         : " + nilaiAngka);
        System.out.println("Bobot Nilai         : " + hitungBobotNilai());
    }
}