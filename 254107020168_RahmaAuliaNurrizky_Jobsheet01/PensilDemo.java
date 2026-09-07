public class PensilDemo {
    public static void main(String[] args) {
        Pensil pensil1 = new Pensil();
        PensilAlis pensilAlis1 = new PensilAlis();
        PensilWarna pensilWarna1 = new PensilWarna();
        Pulpen pulpen1 = new Pulpen();
        Penghapus penghapus1 = new Penghapus();

        pensil1.setMerk("Faber-Castell");
        pensil1.setPanjang(15);
        pensil1.menulis();
        pensil1.diraut();
        pensil1.cetakInformasi();

        pensilAlis1.setMerk("Fanbo");
        pensilAlis1.setPanjang(12);
        pensilAlis1.setWarna("Hitam");
        pensilAlis1.setWaterproof(true);
        pensilAlis1.merias();
        pensilAlis1.bersihkan();
        pensilAlis1.cetakInformasi();

        pensilWarna1.setMerk("Staedtler");
        pensilWarna1.setPanjang(17);
        pensilWarna1.setWarna("Merah");
        pensilWarna1.setJenis("Keras");
        pensilWarna1.mewarnai();
        pensilWarna1.gradasiWarna();
        pensilWarna1.cetakInformasi();

        pulpen1.setMerk("Pilot");
        pulpen1.setWarnaTinta("Biru");
        pulpen1.menulisDokumen();
        pulpen1.isiUlangTinta();
        pulpen1.cetakInformasi();

        penghapus1.setMerk("Pentel");
        penghapus1.setBahan("Karet");
        penghapus1.menghapusTulisan();
        penghapus1.membersihkanPenghapus();
        penghapus1.cetakInformasi();
    }
}