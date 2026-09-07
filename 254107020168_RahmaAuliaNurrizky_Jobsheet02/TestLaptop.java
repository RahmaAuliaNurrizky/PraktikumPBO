package P2;

public class TestLaptop {
    public static void main(String[] args) {
        Laptop lab1 = new Laptop();
        lab1.kodeInventaris = "LAB-JTI-017";
        lab1.merk = "Lenovo ThinkPad E14";
        lab1.ramGB = 8;
        lab1.tampilSpesifikasi();
        //memanggil method dengan argumen dan nilai balik
        System.out.println("RAM setelah upgrade : " + lab1.upgradeRam(8) + " GB");
        lab1.tampilSpesifikasi();
        System.out.println("Harga sewa selama 5 hari : Rp " + lab1.hitungHargaSewa(5));
    }
}