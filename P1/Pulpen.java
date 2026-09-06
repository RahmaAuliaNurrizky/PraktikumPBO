public class Pulpen {
    private String merk;
    private String warnaTinta;

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setWarnaTinta(String warnaTinta) {
        this.warnaTinta = warnaTinta;
    }

    public void menulisDokumen() {
        System.out.println("Pulpen " + merk + " dengan warna tinta " + warnaTinta + " sedang digunakan untuk menulis dokumen.");
    }

    public void isiUlangTinta() {
        System.out.println("Pulpen " + merk + " dengan warna tinta " + warnaTinta + " sedang diisi ulang tintanya.");
    }

    public void cetakInformasi() {
        System.out.println("Merk Pulpen : " + merk);
        System.out.println("Warna Tinta : " + warnaTinta);
    }
}