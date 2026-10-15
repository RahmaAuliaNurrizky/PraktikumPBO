public class MainPercobaan1 {
    public static void main(String[] args) {
        Processor p = new Processor("Intel i5", 3);
        Laptop11 l = new Laptop11("Thinkpad", p);
        l.info();

        Processor p1 = new Processor();
        p1.setMerk("Intel i5");
        p1.setCache(4);
        Laptop11 l1 = new Laptop11();
        l1.setMerk("Thinkpad");
        l1.setProc(p1);
        l1.info();

        Laptop11 l2 = new Laptop11("Thinkpad",
            new Processor("Intel i5", 3));
    }
}