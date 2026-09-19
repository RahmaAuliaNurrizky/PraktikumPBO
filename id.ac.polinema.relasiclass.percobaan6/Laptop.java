public class Laptop {
    private String merk;
    private Printer printerDefault;

    public Laptop(String merk, Printer printer) {
        this.merk = merk;
        this.printerDefault = printer;
    }

    public void cetakDokumen(Printer printer, String namaFile) {
        System.out.println(merk + " mengirim dokumen ke printer...");
        printer.cetak(namaFile);
    }
}          