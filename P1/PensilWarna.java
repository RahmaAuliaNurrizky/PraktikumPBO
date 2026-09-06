public class PensilWarna extends Pensil {
    private String warna;
    private String jenis;

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public void mewarnai() {
        System.out.println("Pensil warna " + warna + " dengan jenis " + jenis + " sedang digunakan untuk mewarnai.");
    }

    public void gradasiWarna() {
        System.out.println("Pensil warna " + warna + " dengan jenis " + jenis + " sedang digunakan untuk membuat gradasi warna.");
    }

    @Override
    public void cetakInformasi() {
        super.cetakInformasi();
        System.out.println("Warna       : " + warna);
        System.out.println("Tipe        : Pensil Warna (" + jenis + ")");
    }
}