public class Main {
    public static void main(String[] args) {
        DaftarGaji daftarGaji = new DaftarGaji(3);
        Dosen222 dosen1 = new Dosen222("001","Rahma Aulia","Malang");
        Dosen222 dosen2 = new Dosen222("002","Septian Caraka","Malang");
        dosen1.setSKS(12);
        dosen2.setSKS(16);
        daftarGaji.addPegawai(dosen1);
        daftarGaji.addPegawai(dosen2);
        daftarGaji.printSemuaGaji();
    }
}