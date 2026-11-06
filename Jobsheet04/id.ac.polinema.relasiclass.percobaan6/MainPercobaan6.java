public class MainPercobaan6 {
    public static void main(String[] args) {
        Printer printer = new Printer("Epson L3110");
        Laptop11 laptop = new Laptop11("Thinkpad", printer);
        laptop.cetakDokumen(printer, "Laporan.pdf");
    }
}