public class Laptop {
    private String kodeAset;
    private String merk;
    private int ramGB;
    private boolean tersedia;
    private boolean ramValid(int ram) {
        return ram == 4 || ram == 8 || ram == 16 || ram == 32;
    }

    public Laptop(String kodeAset, String merk, int ramGB) {
        if (kodeAset == null || !kodeAset.startsWith("LP-")) {
            throw new IllegalArgumentException("Kode aset tidak valid");
        }
        if (merk == null || merk.trim().isEmpty()) {
            throw new IllegalArgumentException("Merk tidak boleh kosong");
        }
        if (!ramValid(ramGB)) {
            throw new IllegalArgumentException("RAM tidak valid");
        }
        this.kodeAset = kodeAset;
        this.merk = merk;
        this.ramGB = ramGB;
        this.tersedia = true;
    }

    public String getKodeAset() {
        return kodeAset;
    }

    public String getMerk() {
        return merk;
    }

    public int getRamGB() {
        return ramGB;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void upgradeRam(int ramBaru) {
        if (!ramValid(ramBaru) || ramBaru <= ramGB) {
            throw new IllegalArgumentException("RAM tidak valid");
        }
        ramGB = ramBaru;
    }

    public boolean pinjam() {
        if (tersedia) {
            tersedia = false;
            return true;
        }
        return false;
    }

    public void kembalikan() {
        if (!tersedia) {
            tersedia = true;
        } else {
            throw new IllegalStateException("Laptop tidak sedang dipinjam");
        }
    }

    public String info() {
        String status = tersedia ? "tersedia" : "dipinjam";
        return kodeAset + " | " + merk + " | " + ramGB + " GB | " + status;
    }
}