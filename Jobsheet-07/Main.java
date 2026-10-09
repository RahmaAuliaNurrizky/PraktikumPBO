public class Main {
    public static void main(String[] args) {
        Manusia orang1 = new Dosen();
        Manusia orang2 = new Mahasiswa();

        orang1.bernafas();
        orang1.makan();

        orang2.bernafas();
        orang2.makan();
    }
}