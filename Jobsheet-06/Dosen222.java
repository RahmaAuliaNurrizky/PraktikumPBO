public class Dosen222 extends Pegawai {
    private int jumlahSKS;
    private int TARIF_SKS = 100000;

    public Dosen222(String nip, String nama, String alamat) {
        super(nip1, nama1, alamat1);
        this.jumlahSKS = 0;
    }

    public void setSKS(int jumlahSKS) {
        this.jumlahSKS = jumlahSKS;
    }

    @Override
    public int getGaji() {
        return jumlahSKS * TARIF_SKS;
    }
}