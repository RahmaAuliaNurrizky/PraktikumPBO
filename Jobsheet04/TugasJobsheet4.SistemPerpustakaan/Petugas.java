public class Petugas {
    private String nama;

    public Petugas(String nama) {
        this.nama = nama;
    }

    public void melayani(Anggota anggota) { //depedency
        System.out.println(nama + " melayani anggota " + anggota.getNama());
    }
}