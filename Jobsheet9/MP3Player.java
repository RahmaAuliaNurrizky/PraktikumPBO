public class MP3Player implements ChargeAble {
    private int storageCapacity;

    public void playMusic (String fileName) {
        System.out.println("Memutar lagu : " + fileName);
    }

    @Override 
    public void doCharge() {
        System.out.println("MP#Player sedang di-charge");
    }
}