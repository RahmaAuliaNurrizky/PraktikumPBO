public class Laptop {
    public String kodeInventaris;
    public String merk;
    public int ramGB;

    public void tampilSpesifikasi() {
        System.out.println("Kode Inventaris : " + kodeInventaris);
        System.out.println("Merk            : " + merk);
        System.out.println("RAM             : " + ramGB + " GB");
    }

    //method dengan argumen dan nilai balik (return)
    public int upgradeRam(int tambahanGB) {
        ramGB += tambahanGB;
        return ramGB;
    }

    public int hitungHargaSewa(int jumlahHari) {
        int hargaSewaPerHari = 25000;
        return hargaSewaPerHari * jumlahHari;
    }
}