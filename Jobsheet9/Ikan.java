public class Ikan extends Hewan {
    public Ikan() {
        super("Lumba-Lumba");
    }

    @Override 
    public void bergerak() {
        System.out.println("Berenang dengan SIRIP, \"wush..wush..\"");
    }
}