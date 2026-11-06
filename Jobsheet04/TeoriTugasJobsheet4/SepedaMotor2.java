public class SepedaMotor2 {
    private String merk;
    private String warna;
    private Mesin2 mesin;
    private int maxSpeed;
    private int kecepatan;

    public SepedaMotor2(String merk, String warna, Mesin2 mesin, int maxSpeed) {
        this.merk = merk;
        this.warna = warna;
        this.mesin = mesin;
        this.maxSpeed = maxSpeed;
        this.kecepatan = 0;
    }

    public void tambahKecepatan(int nilai) {
        if (nilai < 0) {
            return;
        }

        if (kecepatan + nilai > maxSpeed) {
            kecepatan = maxSpeed;
        } else {
            kecepatan += nilai;
        }
    }

    public void kurangiKecepatan(int nilai) {
        if (nilai < 0) {
            return;
        }

        if (kecepatan - nilai < 0) {
            kecepatan = 0;
        } else {
            kecepatan -= nilai;
        }
    }

    public void cekMesin(Mesin2 mesin) {
        System.out.println("Kapasitas mesin: " + mesin.getKapasitas() + " cc");
        System.out.println("Tipe bahan bakar: " + mesin.getTipeBahanBakar());
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public Mesin2 getMesin() {
        return mesin;
    }

    public void setMesin(Mesin2 mesin) {
        this.mesin = mesin;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getKecepatan() {
        return kecepatan;
    }
}