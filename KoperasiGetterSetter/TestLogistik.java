import java.util.Scanner;

public class TestLogistik {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Kontainer kontainerAlfa = new Kontainer("REQ-9988", "PT. Maju Bersama", 5000);

        System.out.println("Nama Pemilik Kontainer : " + kontainerAlfa.getNamaPemilik());
        System.out.println("Kapasitas Maksimal : " + kontainerAlfa.getKapasitasMaksimal() + " kg");
        System.out.print("Masukkan berat barang yang ingin ditambahkan : ");
        double beratTambah = input.nextDouble();
        kontainerAlfa.tambahMuatan(beratTambah);
        System.out.print("Berat Muatan Saat Ini : " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");
        System.out.print("Masukkan berat barang yang ingin dibongkar : ");
        double beratTurun = input.nextDouble();
        kontainerAlfa.turunkanMuatan(beratTurun);
        System.out.print("Berat Muatan Saat Ini : " + kontainerAlfa.getBeratMuatanSaatIni() + " kg");
    }
}