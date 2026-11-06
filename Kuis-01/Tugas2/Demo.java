public class Demo {
    public static void main(String[] args) {
        Laboratorium lab = new Laboratorium("Lab Pemrograman 1");

        Mahasiswa andi = new Mahasiswa("2341720001", "Andi");
        Mahasiswa rina = new Mahasiswa("2341720002", "Rina");
        Mahasiswa budi = new Mahasiswa("2341720003", "Budi");
        Mahasiswa siti = new Mahasiswa("2341720004", "Siti");

        lab.tambahLaptop(new Laptop("LP-01", "Asus", 8));
        lab.tambahLaptop(new Laptop("LP-02", "Lenovo", 16));
        lab.tambahLaptop(new Laptop("LP-03", "Acer", 8));
        lab.tambahLaptop(new Laptop("LP-04", "HP", 16));

        lab.pinjamkan(andi, "LP-01");
        lab.pinjamkan(andi, "LP-02");
        lab.pinjamkan(rina, "LP-03");
        lab.pinjamkan(budi, "LP-04");

        System.out.println("=== Jumlah Peminjaman Aktif ===");
        System.out.println("Andi: " + lab.jumlahPinjamanAktif(andi));
        System.out.println("Rina: " + lab.jumlahPinjamanAktif(rina));
        System.out.println("Budi: " + lab.jumlahPinjamanAktif(budi));
        System.out.println("Siti: " + lab.jumlahPinjamanAktif(siti));
    }
}