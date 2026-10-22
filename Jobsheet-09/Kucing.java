public class Kucing extends Hewan {
    public Kucing() {
        super("Kucing Kampung");
    }

    @Override 
    public void bergerak() {
        System.out.println("Berjalan dengan KAKI, \"tap..tap..\"");
    }
}