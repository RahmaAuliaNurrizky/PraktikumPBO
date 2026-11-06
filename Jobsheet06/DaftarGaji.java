public class DaftarGaji {
    private Pegawai[] listPegawai;

    public DaftarGaji(int jumlahPegawai) {
        listPegawai = new Pegawai[jumlahPegawai];
    }

    public void addPegawai(Pegawai pegawai) {
        for (int i = 0; i < listPegawai.length; i++) {
            if (listPegawai[i] == null) {
                listPegawai[i] = pegawai;
                return;
            }
        }

        System.out.println("Daftar pegawai sudah penuh.");
    }

    public void printSemuaGaji() {
        for (Pegawai pegawai : listPegawai) {
            if (pegawai != null) {
                System.out.println("Nama Pegawai : " + pegawai.getNama());
                System.out.println("Gaji         : Rp " + pegawai.getGaji());
                System.out.println();
            }
        }
    }
}