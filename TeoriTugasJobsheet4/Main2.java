public class Main2 {
    public static void main(String[] args) {

        // Mesin dibuat di luar class SepedaMotor
        Mesin2 mesin = new Mesin2(150, "Pertamax");

        // Mesin diberikan ke SepedaMotor
        SepedaMotor2 motor = new SepedaMotor2("Honda","Hitam", mesin,100);

        System.out.println("Merk : " + motor.getMerk());
        System.out.println("Warna : " + motor.getWarna());
        System.out.println("Max Speed : " + motor.getMaxSpeed());

        motor.tambahKecepatan(50);
        System.out.println("Kecepatan : " + motor.getKecepatan());

        // Mencoba melebihi maxSpeed
        motor.tambahKecepatan(70);
        System.out.println("Kecepatan : " + motor.getKecepatan());

        motor.kurangiKecepatan(30);
        System.out.println("Kecepatan : " + motor.getKecepatan());

        // Uses-A / Dependency
        motor.cekMesin(mesin);
    }
}