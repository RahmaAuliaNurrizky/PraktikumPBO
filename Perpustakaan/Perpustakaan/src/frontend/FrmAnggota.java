package frontend;
import backend.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmAnggota extends JFrame {
    private JTextField txtIdAnggota;
    private JTextField txtNama;
    private JTextField txtAlamat;
    private JTextField txtTelepon;
    private JTextField txtCari;

    private JButton btnSimpan;
    private JButton btnTambahBaru;
    private JButton btnHapus;
    private JButton btnCari;

    private JTable tblAnggota;

    public FrmAnggota() {
        initComponents();
        tampilkanData();
        kosongkanForm();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setPreferredSize(new Dimension(465, 440));

        // ===== Baris isian =====
        JLabel lblId = new JLabel("ID Anggota");
        lblId.setBounds(10, 28, 110, 24);
        add(lblId);

        txtIdAnggota = new JTextField();
        txtIdAnggota.setBounds(130, 28, 68, 24);
        txtIdAnggota.setEnabled(false);
        add(txtIdAnggota);

        JLabel lblNama = new JLabel("Nama Anggota");
        lblNama.setBounds(10, 63, 110, 24);
        add(lblNama);

        txtNama = new JTextField();
        txtNama.setBounds(130, 63, 250, 24);
        add(txtNama);

        JLabel lblAlamat = new JLabel("Alamat");
        lblAlamat.setBounds(10, 99, 110, 24);
        add(lblAlamat);

        txtAlamat = new JTextField();
        txtAlamat.setBounds(130, 99, 250, 24);
        add(txtAlamat);

        JLabel lblTelepon = new JLabel("Telepon");
        lblTelepon.setBounds(10, 135, 110, 24);
        add(lblTelepon);

        txtTelepon = new JTextField();
        txtTelepon.setBounds(130, 135, 160, 24);
        add(txtTelepon);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(10, 181, 80, 26);
        add(btnSimpan);

        btnTambahBaru = new JButton("Tambah Baru");
        btnTambahBaru.setBounds(10, 224, 112, 26);
        add(btnTambahBaru);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(130, 224, 72, 26);
        add(btnHapus);

        txtCari = new JTextField();
        txtCari.setBounds(210, 224, 176, 26);
        add(txtCari);

        btnCari = new JButton("Cari");
        btnCari.setBounds(394, 224, 62, 26);
        add(btnCari);

        tblAnggota = new JTable();
        tblAnggota.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(tblAnggota);
        scrollPane.setBounds(10, 260, 446, 170);
        add(scrollPane);

        btnSimpan.addActionListener(evt -> btnSimpanActionPerformed());
        btnTambahBaru.addActionListener(evt -> kosongkanForm());
        btnHapus.addActionListener(evt -> btnHapusActionPerformed());
        btnCari.addActionListener(evt -> cari(txtCari.getText().trim()));
        txtCari.addActionListener(evt -> cari(txtCari.getText().trim()));

        tblAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAnggotaMouseClicked(evt);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void isiTabel(ArrayList<Anggota> list) {
        String[] kolom = {"ID", "Nama", "Alamat", "Telepon"};
        DefaultTableModel model = new DefaultTableModel(new Object[][] {}, kolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Anggota ang : list) {
            model.addRow(new Object[] {
                ang.getIdAnggota(),
                ang.getNama(),
                ang.getAlamat(),
                ang.getTelepon()
            });
        }
        tblAnggota.setModel(model);
    }

    public void tampilkanData() {
        isiTabel(new Anggota().getAll());
    }

    public void cari(String keyword) {
        isiTabel(new Anggota().search(keyword));
    }

    public void kosongkanForm() {
        txtIdAnggota.setText("0");
        txtNama.setText("");
        txtAlamat.setText("");
        txtTelepon.setText("");
        tblAnggota.clearSelection();
    }

    private void btnSimpanActionPerformed() {
        if (txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama anggota belum diisi!");
            txtNama.requestFocus();
            return;
        }

        Anggota ang = new Anggota();
        ang.setIdAnggota(Integer.parseInt(txtIdAnggota.getText()));
        ang.setNama(txtNama.getText());
        ang.setAlamat(txtAlamat.getText());
        ang.setTelepon(txtTelepon.getText());
        ang.save();

        txtIdAnggota.setText(Integer.toString(ang.getIdAnggota()));
        tampilkanData();
    }

    private void btnHapusActionPerformed() {
        int row = tblAnggota.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus terlebih dahulu!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this,
                "Apakah yakin ingin menghapus data ini?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(tblAnggota.getValueAt(row, 0).toString());
            Anggota ang = new Anggota().getById(id);
            ang.delete();
            kosongkanForm();
            tampilkanData();
        }
    }

    private void tblAnggotaMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblAnggota.getSelectedRow();

        if (row != -1) {
            txtIdAnggota.setText(tblAnggota.getValueAt(row, 0).toString());
            txtNama.setText(tblAnggota.getValueAt(row, 1).toString());
            txtAlamat.setText(tblAnggota.getValueAt(row, 2).toString());
            txtTelepon.setText(tblAnggota.getValueAt(row, 3).toString());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new FrmAnggota().setVisible(true));
    }
}