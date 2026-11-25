package backend;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Peminjaman {
    private int idpeminjaman;
    private Anggota anggota = new Anggota();
    private Buku buku = new Buku();
    private String tanggalpinjam;   // format yyyy-MM-dd
    private String tanggalkembali;  // format yyyy-MM-dd, kosong/null = belum dikembalikan

    public int getIdpeminjaman() {
        return idpeminjaman;
    }

    public void setIdpeminjaman(int idpeminjaman) {
        this.idpeminjaman = idpeminjaman;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
        this.anggota = anggota;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTanggalpinjam() {
        return tanggalpinjam;
    }

    public void setTanggalpinjam(String tanggalpinjam) {
        this.tanggalpinjam = tanggalpinjam;
    }

    public String getTanggalkembali() {
        return tanggalkembali;
    }

    public void setTanggalkembali(String tanggalkembali) {
        this.tanggalkembali = tanggalkembali;
    }

    public Peminjaman() {

    }

    public Peminjaman(Anggota anggota, Buku buku, String tanggalpinjam, String tanggalkembali) {
        this.anggota = anggota;
        this.buku = buku;
        this.tanggalpinjam = tanggalpinjam;
        this.tanggalkembali = tanggalkembali;
    }

    private static final String BASE_SELECT = "SELECT "
            + "    p.idpeminjaman AS idpeminjaman, "
            + "    p.tanggalpinjam AS tanggalpinjam, "
            + "    p.tanggalkembali AS tanggalkembali, "
            + "    a.idanggota AS idanggota, "
            + "    a.nama AS namaanggota, "
            + "    b.idbuku AS idbuku, "
            + "    b.judul AS judul "
            + "    FROM peminjaman p "
            + "    LEFT JOIN anggota a ON p.idanggota = a.idanggota "
            + "    LEFT JOIN buku b ON p.idbuku = b.idbuku ";

    private Peminjaman mapRow(ResultSet rs) throws Exception {
        Peminjaman p = new Peminjaman();
        p.setIdpeminjaman(rs.getInt("idpeminjaman"));
        p.getAnggota().setIdAnggota(rs.getInt("idanggota"));
        p.getAnggota().setNama(rs.getString("namaanggota"));
        p.getBuku().setIdbuku(rs.getInt("idbuku"));
        p.getBuku().setJudul(rs.getString("judul"));
        p.setTanggalpinjam(rs.getString("tanggalpinjam"));
        p.setTanggalkembali(rs.getString("tanggalkembali"));
        return p;
    }

    public Peminjaman getById(int id) {
        Peminjaman peminjaman = new Peminjaman();
        ResultSet rs = DBHelper.selectQuery(BASE_SELECT + "    WHERE p.idpeminjaman = '" + id + "'");
        try {
            while(rs.next()) {
                peminjaman = mapRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peminjaman;
    }

    public ArrayList<Peminjaman> getAll() {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();
        ResultSet rs = DBHelper.selectQuery(BASE_SELECT + " ORDER BY p.idpeminjaman");
        try {
            while(rs.next()) {
                ListPeminjaman.add(mapRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    public ArrayList<Peminjaman> search(String keyword) {
        ArrayList<Peminjaman> ListPeminjaman = new ArrayList();
        ResultSet rs = DBHelper.selectQuery(BASE_SELECT
                                          + "    WHERE a.nama LIKE '%" + keyword + "%' "
                                          + "       OR b.judul LIKE '%" + keyword + "%' ");

        try {
            while(rs.next()) {
                ListPeminjaman.add(mapRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ListPeminjaman;
    }

    // Cek apakah buku masih dipinjam (tanggal kembali masih kosong) oleh transaksi lain
    public boolean bukuSedangDipinjam(int idbuku, int idPeminjamanDikecualikan) {
        boolean hasil = false;
        ResultSet rs = DBHelper.selectQuery("SELECT COUNT(*) AS jumlah FROM peminjaman "
                                          + "WHERE idbuku = '" + idbuku + "' "
                                          + "  AND tanggalkembali IS NULL "
                                          + "  AND idpeminjaman <> '" + idPeminjamanDikecualikan + "'");

        try {
            if(rs.next()) {
                hasil = rs.getInt("jumlah") > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hasil;
    }

    private String sqlTanggalKembali() {
        if(tanggalkembali == null || tanggalkembali.trim().isEmpty()) {
            return "NULL";
        }
        return "'" + tanggalkembali + "'";
    }

    public void save() {
        if(getById(idpeminjaman).getIdpeminjaman() == 0) {
            String SQL = "INSERT INTO peminjaman (idanggota, idbuku, tanggalpinjam, tanggalkembali) VALUES("
                       + "     '" + this.getAnggota().getIdAnggota() + "', "
                       + "     '" + this.getBuku().getIdbuku() + "', "
                       + "     '" + this.tanggalpinjam + "', "
                       + "     " + sqlTanggalKembali() + " "
                       + "     )";
            this.idpeminjaman = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE peminjaman SET "
                       + "     idanggota = '" + this.getAnggota().getIdAnggota() + "', "
                       + "     idbuku = '" + this.getBuku().getIdbuku() + "', "
                       + "     tanggalpinjam = '" + this.tanggalpinjam + "', "
                       + "     tanggalkembali = " + sqlTanggalKembali() + " "
                       + "     WHERE idpeminjaman = '" + this.idpeminjaman + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM peminjaman WHERE idpeminjaman = '" + this.idpeminjaman + "'";
        DBHelper.executeQuery(SQL);
    }
}