public class Pensil {
    private String merk;
    private int panjang;

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setPanjang(int panjang) {
        this.panjang = panjang;
    }

    public void menulis() {
        System.out.println("Pensil " + merk + " dengan panjang " + panjang + " cm sedang digunakan untuk menulis.");
    }

    public void diraut() {
        System.out.println("Pensil " + merk + " dengan panjang " + panjang + " cm sedang diraut.");
    }

    public void cetakInformasi() {
        System.out.println("Merk Pensil : " + merk);
        System.out.println("Panjang     : " + panjang + " cm");
    }
}