package frontend;
import backend.*;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

public class FrmBuku extends JFrame {
    static {
        System.setProperty("swing.boldMetal", "false");
    }

    private JTextField txtIdBuku;
    private JComboBox cmbKategori;
    private JTextField txtJudul;
    private JTextField txtPenerbit;
    private JTextField txtPenulis;
    private JTextField txtCari;

    private JButton btnSimpan;
    private JButton btnTambahBaru;
    private JButton btnHapus;
    private JButton btnCari;

    private JTable tblBuku;

    public FrmBuku() {
        initComponents();
        tampilkanData();
        tampilkanCmbKategori();
        kosongkanForm();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setPreferredSize(new Dimension(566, 500));

        JLabel lblId = new JLabel("ID Buku");
        lblId.setBounds(12, 34, 90, 24);
        add(lblId);

        txtIdBuku = new JTextField();
        txtIdBuku.setBounds(108, 34, 66, 24);
        txtIdBuku.setEnabled(false);
        add(txtIdBuku);

        JLabel lblKategori = new JLabel("Kategori");
        lblKategori.setBounds(12, 64, 90, 24);
        add(lblKategori);

        cmbKategori = new JComboBox();
        cmbKategori.setBounds(108, 64, 198, 24);
        cmbKategori.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Kategori) {
                    setText(((Kategori) value).getNama());
                }
                return this;
            }
        });
        add(cmbKategori);

        JLabel lblJudul = new JLabel("Judul");
        lblJudul.setBounds(12, 102, 90, 24);
        add(lblJudul);

        txtJudul = new JTextField();
        txtJudul.setBounds(108, 102, 444, 24);
        add(txtJudul);

        JLabel lblPenerbit = new JLabel("Penerbit");
        lblPenerbit.setBounds(12, 139, 90, 24);
        add(lblPenerbit);

        txtPenerbit = new JTextField();
        txtPenerbit.setBounds(108, 139, 198, 24);
        add(txtPenerbit);

        JLabel lblPenulis = new JLabel("Penulis");
        lblPenulis.setBounds(12, 170, 90, 24);
        add(lblPenulis);

        txtPenulis = new JTextField();
        txtPenulis.setBounds(108, 170, 198, 24);
        add(txtPenulis);

        // ===== Tombol =====
        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(14, 218, 78, 25);
        add(btnSimpan);

        btnTambahBaru = new JButton("Tambah Baru");
        btnTambahBaru.setBounds(14, 258, 130, 25);
        add(btnTambahBaru);

        btnHapus = new JButton("Hapus");
        btnHapus.setBounds(154, 258, 73, 25);
        add(btnHapus);

        txtCari = new JTextField();
        txtCari.setBounds(261, 258, 223, 25);
        add(txtCari);

        btnCari = new JButton("Cari");
        btnCari.setBounds(493, 258, 58, 25);
        add(btnCari);

        tblBuku = new JTable();
        tblBuku.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(tblBuku);
        scrollPane.setBounds(13, 299, 538, 190);
        add(scrollPane);

        btnSimpan.addActionListener(evt -> btnSimpanActionPerformed());
        btnTambahBaru.addActionListener(evt -> kosongkanForm());
        btnHapus.addActionListener(evt -> btnHapusActionPerformed());
        btnCari.addActionListener(evt -> cari(txtCari.getText().trim()));
        txtCari.addActionListener(evt -> cari(txtCari.getText().trim()));

        tblBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBukuMouseClicked(evt);
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void isiTabel(ArrayList<Buku> list) {
        String[] kolom = {"ID", "Kategori", "Judul", "Penulis", "Penerbit"};
        DefaultTableModel model = new DefaultTableModel(new Object[][] {}, kolom) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Buku buku : list) {
            model.addRow(new Object[] {
                buku.getIdbuku(),
                buku.getKategori().getNama(),
                buku.getJudul(),
                buku.getPenulis(),
                buku.getPenerbit()
            });
        }
        tblBuku.setModel(model);
    }

    public void tampilkanData() {
        isiTabel(new Buku().getAll());
    }

    public void cari(String keyword) {
        isiTabel(new Buku().search(keyword));
    }

    public void tampilkanCmbKategori() {
        cmbKategori.setModel(new DefaultComboBoxModel(new Kategori().getAll().toArray()));
    }

    public void kosongkanForm() {
        txtIdBuku.setText("0");
        if (cmbKategori.getItemCount() > 0) {
            cmbKategori.setSelectedIndex(0);
        }
        txtJudul.setText("");
        txtPenulis.setText("");
        txtPenerbit.setText("");
        tblBuku.clearSelection();
    }

    private void btnSimpanActionPerformed() {
        if (txtJudul.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Judul buku belum diisi!");
            txtJudul.requestFocus();
            return;
        }

        Buku buku = new Buku();
        buku.setIdbuku(Integer.parseInt(txtIdBuku.getText()));
        buku.setKategori((Kategori) cmbKategori.getSelectedItem());
        buku.setJudul(txtJudul.getText());
        buku.setPenulis(txtPenulis.getText());
        buku.setPenerbit(txtPenerbit.getText());
        buku.save();

        txtIdBuku.setText(Integer.toString(buku.getIdbuku()));
        tampilkanData();
    }

    private void btnHapusActionPerformed() {
        int row = tblBuku.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data yang akan dihapus terlebih dahulu!");
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this,
                "Apakah yakin ingin menghapus data ini?",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(tblBuku.getValueAt(row, 0).toString());
            Buku buku = new Buku().getById(id);
            buku.delete();
            kosongkanForm();
            tampilkanData();
        }
    }

    private void tblBukuMouseClicked(java.awt.event.MouseEvent evt) {
        int row = tblBuku.getSelectedRow();

        if (row != -1) {
            int id = Integer.parseInt(tblBuku.getValueAt(row, 0).toString());
            Buku buku = new Buku().getById(id);

            txtIdBuku.setText(String.valueOf(buku.getIdbuku()));
            cmbKategori.getModel().setSelectedItem(buku.getKategori());
            txtJudul.setText(buku.getJudul());
            txtPenerbit.setText(buku.getPenerbit());
            txtPenulis.setText(buku.getPenulis());
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new FrmBuku().setVisible(true));
    }
}