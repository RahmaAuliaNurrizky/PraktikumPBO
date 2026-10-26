public class Rektor {
    public void beriSertifikatMawapres(IBerprestasi mahasiswaBerprestasi) {
        System.out.println("Saya REKTOR, memberikan sertifikat MAWAPRES.");
        System.out.println("Selamat! Bagaimana Anda bisa berprestasi?");

        mahasiswaBerprestasi.menjuaraiKompetisi();
        mahasiswaBerprestasi.membuatPublikasiIlmiah();

        System.out.println("----------------------------------------");
    }
}