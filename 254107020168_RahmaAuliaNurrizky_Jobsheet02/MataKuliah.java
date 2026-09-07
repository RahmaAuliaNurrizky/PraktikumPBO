package P2;

public class MataKuliah {
    public String kodeMK;
    public String namaMK;
    public int sks;
    public double nilaiAngka;

    public double hitungBobotNilai() {
        return sks * nilaiAngka;
    }

    public void tampilData() {
        System.err.println("Kode Mata Kuliah    : " + kodeMK);
        System.err.println("Nama Mata Kuliah    : " + namaMK);
        System.err.println("SKS                 : " + sks);
        System.err.println("Nilai Angka         : " + nilaiAngka);
        System.err.println("Bobot Nilai         : " + hitungBobotNilai());
    }
}