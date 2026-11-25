package frontend;
import backend.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmKategori extends JFrame {
    private JTextField txtIdKategori;
    private JTextField txtNama;
    private JTextField txtKeterangan;
    private JTextField txtCari;

    private JButton btnSimpan;
    private JButton btnTambahBaru;
    private JButton btnHapus;
    private JButton btnCari;

    private JTable tblKategori;

    public FrmKategori() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setPreferredSize(new Dimension(465, 400));

        JLabel lblId = new JLabel("ID Kategori");
        lblId.setBounds(10, 28, 110, 24);
        add(lblId);

        txtIdKategori = new JTextField();
        txtIdKategori.setBounds(130, 28, 68, 24);
        txtIdKategori.setEnabled(false);
        add(txtIdKategori);

        JLabel lblNama = new JLabel("Nama Kategori");
        lblNama.setBounds(10, 63, 110, 24);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(130, 63, 192, 24);
        add(txtNama);

        JLabel lblKeterangan = new JLabel("Keterangan");
        lblKeterangan.setBounds(10, 99, 110, 24);
        add(lblKeterangan);

        txtKeterangan = new JTextField();
        txtKeterangan.setBounds(130, 99, 192, 24);
        add(txtKeterangan);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(10, 145, 80, 26);
        add(btnSimpan);

        btnTambahBaru = new JButton("Tambah Baru");
        btnTambahBaru.setBounds(10, 188, 112, 26);
        add(btnTambahBaru);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(130, 188, 72, 26);
        add(btnHapus);

        txtCari = new JTextField();
        txtCari.setBounds(210, 188, 176, 26);
        add(txtCari);

        btnCari = new JButton("Cari");
        btnCari.setBounds(394, 188, 62, 26);
        add(btnCari);

        tblKategori = new JTable();
        tblKategori.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(tblKategori);
        scrollPane.setBounds(10, 224, 446, 166);
        add(scrollPane);

        btnSimpan.addActionListener(evt -> btnSimpanActionPerformed());
        btnTambahBaru.addActionListener(evt -> kosongkanForm());
        btnHapus.addActionListener(evt -> btnHapusActionPerformed());
        btnCari.addActionListener(evt -> cari(txtCari.getText().trim()));
        txtCari.addActionListener(evt -> cari(txtCari.getText().trim()));

        tblKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKategoriMouseClicked(evt);
            }
        });
        pack();
        setLocationRelativeTo(null);
    }

    private void isiTabel(ArrayList<Kategori> list) {
        String[] kolom = {"ID", "Nama", "Keterangan"};
        DefaultTableModel model = new DefaultTableModel(new Object[][] {}, kolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Kategori kat : list) {
            model.addRow(new Object[] {
                kat.getIdKategori(),
                kat.getNama(),
                kat.getKeterangan()
            });
        }
        tblKategori.setModel(model);
    }

    public void tampilkanData() {
        isiTabel(new Kategori().getAll());
    }

    public void cari(String keyword) {
        isiTabel(new Kategori().search(keyword));
    }

    public void kosongkanForm() {
        txtIdKategori.setText("0");
        txtNama.setText("");
        txtKeterangan.setText("");
        tblKategori.clearSelection();
    }

    private void btnSimpanActionPerformed() {
        if (txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama kategori belum diisi!");
            txtNama.requestFocus();
            return;
        }

        Kategori kat = new Kategori();
        kat.setIdKategori(Integer.parseInt(txtIdKategori.getText()));
        kat.setNama(txtNama.getText());
        kat.setKeterangan(txtKeterangan.getText());
        kat.save();

        txtIdKategori.setText(Integer.toString(kat.getIdKategori()));
        tampilkanData();
    }

    private void btnHapusActionPerformed() {
        int row = tblKategori.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus terlebih dahulu!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this,
                "Apakah yakin ingin menghapus data ini?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(tblKategori.getValueAt(row, 0).toString());
            Kategori kat = new Kategori().getById(id);
            kat.delete();
            kosongkanForm();
            tampilkanData();
        }
    }

    private void tblKategoriMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblKategori.getSelectedRow();

        if (row != -1) {
            txtIdKategori.setText(tblKategori.getValueAt(row, 0).toString());
            txtNama.setText(tblKategori.getValueAt(row, 1).toString());
            txtKeterangan.setText(tblKategori.getValueAt(row, 2).toString());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new FrmKategori().setVisible(true));
    }
}