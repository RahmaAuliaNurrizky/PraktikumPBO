package frontend;
import backend.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmPeminjaman extends JFrame {
    static {
        System.setProperty("swing.boldMetal", "false");
    }

    private JTextField txtIdPeminjaman;
    private JTextField txtIdAnggota;
    private JButton btnCariAnggota;
    private JLabel lblNamaAnggota;
    private JTextField txtIdBuku;
    private JButton btnCariBuku;
    private JLabel lblJudulBuku;
    private JTextField txtTanggalPinjam;
    private JTextField txtTanggalKembali;

    private JButton btnSimpan;
    private JButton btnTambahBaru;
    private JButton btnHapus;

    private JTable tblPeminjaman;

    public FrmPeminjaman() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }

    private void initComponents() {
        setTitle("Peminjaman dan Pengembalian Buku");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setPreferredSize(new Dimension(620, 480));

        JLabel lblId = new JLabel("ID");
        lblId.setBounds(12, 20, 110, 24);
        add(lblId);

        txtIdPeminjaman = new JTextField();
        txtIdPeminjaman.setBounds(130, 20, 80, 24);
        txtIdPeminjaman.setEnabled(false);
        add(txtIdPeminjaman);

        JLabel lblIdAnggota = new JLabel("ID Anggota");
        lblIdAnggota.setBounds(12, 52, 110, 24);
        add(lblIdAnggota);

        txtIdAnggota = new JTextField();
        txtIdAnggota.setBounds(130, 52, 80, 24);
        add(txtIdAnggota);

        btnCariAnggota = new JButton("Cari");
        btnCariAnggota.setBounds(220, 52, 70, 24);
        add(btnCariAnggota);

        lblNamaAnggota = new JLabel("Nama Anggota");
        lblNamaAnggota.setBounds(300, 52, 300, 24);
        add(lblNamaAnggota);

        JLabel lblIdBuku = new JLabel("ID Buku");
        lblIdBuku.setBounds(12, 84, 110, 24);
        add(lblIdBuku);

        txtIdBuku = new JTextField();
        txtIdBuku.setBounds(130, 84, 80, 24);
        add(txtIdBuku);

        btnCariBuku = new JButton("Cari");
        btnCariBuku.setBounds(220, 84, 70, 24);
        add(btnCariBuku);

        lblJudulBuku = new JLabel("Judul Buku");
        lblJudulBuku.setBounds(300, 84, 300, 24);
        add(lblJudulBuku);

        JLabel lblPinjam = new JLabel("Tanggal Pinjam");
        lblPinjam.setBounds(12, 116, 110, 24);
        add(lblPinjam);

        txtTanggalPinjam = new JTextField();
        txtTanggalPinjam.setBounds(130, 116, 160, 24);
        add(txtTanggalPinjam);

        JLabel lblFormat1 = new JLabel("Format: YYYY/MM/DD");
        lblFormat1.setBounds(300, 116, 200, 24);
        add(lblFormat1);

        JLabel lblKembali = new JLabel("Tanggal Kembali");
        lblKembali.setBounds(12, 148, 110, 24);
        add(lblKembali);

        txtTanggalKembali = new JTextField();
        txtTanggalKembali.setBounds(130, 148, 160, 24);
        add(txtTanggalKembali);

        JLabel lblFormat2 = new JLabel("Format: YYYY/MM/DD (kosong = belum kembali)");
        lblFormat2.setBounds(300, 148, 300, 24);
        add(lblFormat2);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(14, 190, 90, 25);
        add(btnSimpan);

        btnTambahBaru = new JButton("Tambah Baru");
        btnTambahBaru.setBounds(14, 225, 130, 25);
        add(btnTambahBaru);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(154, 225, 90, 25);
        add(btnHapus);

        tblPeminjaman = new JTable();
        tblPeminjaman.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(tblPeminjaman);
        scrollPane.setBounds(13, 265, 594, 200);
        add(scrollPane);

        btnCariAnggota.addActionListener(evt -> ambilAnggota(true));
        btnCariBuku.addActionListener(evt -> ambilBuku(true));
        txtIdAnggota.addActionListener(evt -> ambilAnggota(true));
        txtIdBuku.addActionListener(evt -> ambilBuku(true));
        btnSimpan.addActionListener(evt -> btnSimpanActionPerformed());
        btnTambahBaru.addActionListener(evt -> kosongkanForm());
        btnHapus.addActionListener(evt -> btnHapusActionPerformed());

        tblPeminjaman.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPeminjamanMouseClicked(evt);
            }
        });
        pack();
        setLocationRelativeTo(null);
    }

    private String keTampilan(String tgl) {
        return tgl == null ? "" : tgl.replace("-", "/");
    }

    private String keDatabase(String tgl) {
        return tgl.trim().replace("/", "-");
    }

    private boolean tanggalValid(String tgl) {
        try {
            LocalDate.parse(keDatabase(tgl));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Anggota ambilAnggota(boolean tampilkanPesan) {
        try {
            int id = Integer.parseInt(txtIdAnggota.getText().trim());
            Anggota a = new Anggota().getById(id);
            if (a.getIdAnggota() != 0) {
                lblNamaAnggota.setText(a.getNama());
                return a;
            }
        } catch (NumberFormatException e) {
            // ID bukan angka, diperlakukan sebagai tidak ditemukan
        }
        lblNamaAnggota.setText("Nama Anggota");
        if (tampilkanPesan) {
            JOptionPane.showMessageDialog(this, "Anggota tidak ditemukan!");
        }
        return null;
    }

    private Buku ambilBuku(boolean tampilkanPesan) {
        try {
            int id = Integer.parseInt(txtIdBuku.getText().trim());
            Buku b = new Buku().getById(id);
            if (b.getIdbuku() != 0) {
                lblJudulBuku.setText(b.getJudul());
                return b;
            }
        } catch (NumberFormatException e) {
            // ID bukan angka, diperlakukan sebagai tidak ditemukan
        }
        lblJudulBuku.setText("Judul Buku");
        if (tampilkanPesan) {
            JOptionPane.showMessageDialog(this, "Buku tidak ditemukan!");
        }
        return null;
    }

    private void isiTabel(ArrayList<Peminjaman> list) {
        String[] kolom = {"ID", "Anggota", "Buku", "Tgl Pinjam", "Tgl Kembali", "Status"};
        DefaultTableModel model = new DefaultTableModel(new Object[][] {}, kolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Peminjaman p : list) {
            boolean sudahKembali = p.getTanggalkembali() != null && !p.getTanggalkembali().isEmpty();
            model.addRow(new Object[] {
                p.getIdpeminjaman(),
                p.getAnggota().getNama(),
                p.getBuku().getJudul(),
                keTampilan(p.getTanggalpinjam()),
                keTampilan(p.getTanggalkembali()),
                sudahKembali ? "Dikembalikan" : "Dipinjam"
            });
        }
        tblPeminjaman.setModel(model);
    }

    public void tampilkanData() {
        isiTabel(new Peminjaman().getAll());
    }

    public void kosongkanForm() {
        txtIdPeminjaman.setText("0");
        txtIdAnggota.setText("");
        lblNamaAnggota.setText("Nama Anggota");
        txtIdBuku.setText("");
        lblJudulBuku.setText("Judul Buku");
        txtTanggalPinjam.setText(keTampilan(LocalDate.now().toString()));
        txtTanggalKembali.setText("");
        tblPeminjaman.clearSelection();
    }

    private void btnSimpanActionPerformed() {
        Anggota anggota = ambilAnggota(false);
        if (anggota == null) {
            JOptionPane.showMessageDialog(this, "ID Anggota tidak valid! Isi ID lalu tekan Cari.");
            txtIdAnggota.requestFocus();
            return;
        }

        Buku buku = ambilBuku(false);
        if (buku == null) {
            JOptionPane.showMessageDialog(this, "ID Buku tidak valid! Isi ID lalu tekan Cari.");
            txtIdBuku.requestFocus();
            return;
        }

        String pinjam = txtTanggalPinjam.getText().trim();
        String kembali = txtTanggalKembali.getText().trim();

        if (!tanggalValid(pinjam)) {
            JOptionPane.showMessageDialog(this, "Tanggal pinjam tidak valid! Gunakan format YYYY/MM/DD.");
            txtTanggalPinjam.requestFocus();
            return;
        }

        if (!kembali.isEmpty()) {
            if (!tanggalValid(kembali)) {
                JOptionPane.showMessageDialog(this, "Tanggal kembali tidak valid! Gunakan format YYYY/MM/DD.");
                txtTanggalKembali.requestFocus();
                return;
            }
            if (LocalDate.parse(keDatabase(kembali)).isBefore(LocalDate.parse(keDatabase(pinjam)))) {
                JOptionPane.showMessageDialog(this, "Tanggal kembali tidak boleh sebelum tanggal pinjam!");
                txtTanggalKembali.requestFocus();
                return;
            }
        }

        int idPeminjaman = Integer.parseInt(txtIdPeminjaman.getText());

        if (kembali.isEmpty() && new Peminjaman().bukuSedangDipinjam(buku.getIdbuku(), idPeminjaman)) {
            JOptionPane.showMessageDialog(this, "Buku ini sedang dipinjam dan belum dikembalikan!");
            return;
        }

        Peminjaman p = new Peminjaman();
        p.setIdpeminjaman(idPeminjaman);
        p.setAnggota(anggota);
        p.setBuku(buku);
        p.setTanggalpinjam(keDatabase(pinjam));
        p.setTanggalkembali(kembali.isEmpty() ? "" : keDatabase(kembali));
        p.save();

        txtIdPeminjaman.setText(Integer.toString(p.getIdpeminjaman()));
        tampilkanData();
    }

    private void btnHapusActionPerformed() {
        int row = tblPeminjaman.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus terlebih dahulu!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this,
                "Apakah yakin ingin menghapus data ini?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(tblPeminjaman.getValueAt(row, 0).toString());
            Peminjaman p = new Peminjaman().getById(id);
            p.delete();
            kosongkanForm();
            tampilkanData();
        }
    }

    private void tblPeminjamanMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblPeminjaman.getSelectedRow();

        if (row != -1) {
            int id = Integer.parseInt(tblPeminjaman.getValueAt(row, 0).toString());
            Peminjaman p = new Peminjaman().getById(id);

            txtIdPeminjaman.setText(String.valueOf(p.getIdpeminjaman()));
            txtIdAnggota.setText(String.valueOf(p.getAnggota().getIdAnggota()));
            lblNamaAnggota.setText(p.getAnggota().getNama());
            txtIdBuku.setText(String.valueOf(p.getBuku().getIdbuku()));
            lblJudulBuku.setText(p.getBuku().getJudul());
            txtTanggalPinjam.setText(keTampilan(p.getTanggalpinjam()));
            txtTanggalKembali.setText(keTampilan(p.getTanggalkembali()));
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new FrmPeminjaman().setVisible(true));
    }
}