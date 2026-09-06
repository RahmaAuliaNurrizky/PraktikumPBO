public class PensilAlis extends Pensil {
    private String warna;
    private Boolean waterproof;

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setWaterproof(Boolean waterproof) {
        this.waterproof = waterproof;
    }

    public void merias() {
        System.out.println("Pensil alis " + warna + " sedang digunakan untuk merias alis.");
    }

    public void bersihkan() {
        System.out.println("Pensil alis " + warna + " sedang dibersihkan.");
    }

    @Override
    public void cetakInformasi() {
        super.cetakInformasi();
        System.out.println("Warna       : " + warna);
        System.out.println("Tipe        : Pensil Alis");
        System.out.println("Waterproof  : " + (waterproof ? "Ya" : "Tidak"));
    }
}