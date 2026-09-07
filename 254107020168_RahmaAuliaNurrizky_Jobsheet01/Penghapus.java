public class Penghapus {
    private String merk;
    private String bahan;

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    public void menghapusTulisan() {
        System.out.println("Penghapus " + merk + " dengan bahan " + bahan + " sedang digunakan untuk menghapus tulisan.");
    }

    public void membersihkanPenghapus() {
        System.out.println("Penghapus " + merk + " dengan bahan " + bahan + " sedang dibersihkan.");
    }

    public void cetakInformasi() {
        System.out.println("Merk Penghapus : " + merk);
        System.out.println("Bahan          : " + bahan);
    }
}