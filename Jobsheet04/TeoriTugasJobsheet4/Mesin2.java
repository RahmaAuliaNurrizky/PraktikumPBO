public class Mesin2 {
    private int kapasitas;
    private String tipeBahanBakar;

    public Mesin2(int kapasitas, String tipeBahanBakar) {
        this.kapasitas = kapasitas;
        this.tipeBahanBakar = tipeBahanBakar;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getTipeBahanBakar() {
        return tipeBahanBakar;
    }

    public void setTipeBahanBakar(String tipeBahanBakar) {
        this.tipeBahanBakar = tipeBahanBakar;
    }
}