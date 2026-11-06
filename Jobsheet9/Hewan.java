public abstract class Hewan {
    protected int umur;

    public Hewan(String nama) {
        this.umur = 0;
    }

    public void bertambahUmur() {
        this.umur += 1;
    }

    public abstract void bergerak();
}