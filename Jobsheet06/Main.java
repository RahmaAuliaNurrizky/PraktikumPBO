public class Main {
    public static void main(String[] args) {
        DaftarGaji daftarGaji = new DaftarGaji(3);
        Dosen dosen1 = new Dosen("001","Rahma Aulia","Malang");
        Dosen dosen2 = new Dosen("002","Septian Caraka","Malang");
        dosen1.setSKS(12);
        dosen2.setSKS(16);
        daftarGaji.addPegawai(dosen1);
        daftarGaji.addPegawai(dosen2);
        daftarGaji.printSemuaGaji();
    }
}