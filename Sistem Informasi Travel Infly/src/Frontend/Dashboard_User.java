/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;

/**
 *
 * @author WINDOWS 10
 */
import Backend.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class Dashboard_User extends javax.swing.JFrame {

    int id = UserSession.getIdUser();
    String username = UserSession.getUsernameUser();
    String password = UserSession.getPasswordUser();
    String namaUser = UserSession.getNamaUser();
    String tglLahir = UserSession.getTglLahir();
    String jenisKelamin = UserSession.getJenisKelamin();
    String alamatUser = UserSession.getAlamatUser();
    String telepon = UserSession.getTelepon();
    String email = UserSession.getEmail();
    /**
     * Creates new form Dashboard_User
     */
    public Dashboard_User() {
        initComponents();
        lblIDUser.setText(String.valueOf(id));
        lblNamaUser.setText(namaUser);
        tampilkanData();
        tampilkanDataReservasi();
        setCmbAsalKota();
        setCmbTujuanKota();
        setCmbPesawat();
        setCmbMaskapai();

    }
    public void tampilkanData(){
        Object[] namaKolom = new Object[] {"ID","Asal","Tujuan","Pesawat","Maskapai","Harga","Jam Berangkat","Jam Kedatangan","Tanggal Keberangkatan"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(namaKolom);
        
        ArrayList<Penerbangan> listPenerbangan = Penerbangan.getAll();
        Object[] rowData = new Object[9];
        
        for(Penerbangan pb : listPenerbangan){
            rowData[0] = pb.getIdpaket();
            rowData[1] = pb.getAsalkota().getNamaKota();
            rowData[2] = pb.getTujuankota().getNamaKota();
            rowData[3] = pb.getPesawat().getNamaPesawat();
            rowData[4] = pb.getMaskapai().getNamaPerusahaan();
            rowData[5] = pb.getHargaTiket();
            rowData[6] = pb.getJamBerangkat();
            rowData[7] = pb.getJamKedatangan();
            rowData[8] = pb.getTanggalBerangkat();
            
            model.addRow(rowData);
            
        }                
        tblPenerbangan.setModel(model);
    }
    
    public void tampilkanDataReservasi(){
        Object[] namaKolom = new Object[] {"ID","Nama Pemesan","Asal","Tujuan","Pesawat","Tanggal Berangkat","Kelas","Harga","Tanggal Bayar","Status"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(namaKolom);
        
        ArrayList<Reservasi> listReservasi = Reservasi.getAll();
        Object[] rowData = new Object[10];
        
        for(Reservasi res : listReservasi){
            rowData[0] = res.getIdreservasi();
            rowData[1] = res.getNamaPemesan();
            rowData[2] = res.getAsalkota().getNamaKota();
            rowData[3] = res.getTujuankota().getNamaKota();
            rowData[4] = res.getPesawat().getNamaPesawat();
            rowData[5] = res.getPenerbangan().getTanggalBerangkat();
            rowData[6] = res.getKelas();
            rowData[7] = res.getHargaTiket();
            rowData[8] = res.getTglBayar();
            rowData[9] = res.getStatus();
            
            model.addRow(rowData);
            
        }                
        tblReservasi.setModel(model);
    }
    
    
    public void cari(String keyword){
        Object[] namaKolom = new Object[] {"ID","Asal","Tujuan","Pesawat","Maskapai","Harga","Jam Berangkat","Jam Kedatangan","Tanggal Keberangkatan"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(namaKolom);
        
        ArrayList<Penerbangan> listPenerbangan = Penerbangan.search(keyword);
        Object[] rowData = new Object[9];
        
        for(Penerbangan pb : listPenerbangan){
            rowData[0] = pb.getIdpaket();
            rowData[1] = pb.getAsalkota().getNamaKota();
            rowData[2] = pb.getTujuankota().getNamaKota();
            rowData[3] = pb.getPesawat().getNamaPesawat();
            rowData[4] = pb.getMaskapai().getNamaPerusahaan();
            rowData[5] = pb.getHargaTiket();
            rowData[6] = pb.getJamBerangkat();
            rowData[7] = pb.getJamKedatangan();
            rowData[8] = pb.getTanggalBerangkat();
            
            model.addRow(rowData);
            
        }                
        tblPenerbangan.setModel(model);
    }
    
    public void cariDataReservasi(String keyword){
        Object[] namaKolom = new Object[] {"ID","Nama Pemesan","Asal","Tujuan","Pesawat","Tanggal Berangkat","Kelas","Harga","Tanggal Bayar","Status"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(namaKolom);
        
        ArrayList<Reservasi> listReservasi = Reservasi.search(keyword);
        Object[] rowData = new Object[10];
        
        for(Reservasi res : listReservasi){
            rowData[0] = res.getIdreservasi();
            rowData[1] = res.getNamaPemesan();
            rowData[2] = res.getAsalkota().getNamaKota();
            rowData[3] = res.getTujuankota().getNamaKota();
            rowData[4] = res.getPesawat().getNamaPesawat();
            rowData[5] = res.getPenerbangan().getTanggalBerangkat();
            rowData[6] = res.getKelas();
            rowData[7] = res.getHargaTiket();
            rowData[8] = res.getTglBayar();
            rowData[9] = res.getStatus();
            
            model.addRow(rowData);
            
        }                
        tblReservasi.setModel(model);
    }
    
    
    public void setCmbAsalKota(){
        DefaultComboBoxModel model = new DefaultComboBoxModel(Kota.getAll().toArray());
        cmbAsalkota.setModel(model);
    }
    public void setCmbTujuanKota(){
        DefaultComboBoxModel model = new DefaultComboBoxModel(Kota.getAll().toArray());
        cmbTujuanKota.setModel(model);
    }
    public void setCmbPesawat(){
        DefaultComboBoxModel model = new DefaultComboBoxModel(Pesawat.getAll().toArray());
        cmbPesawat.setModel(model);
    }
    public void setCmbMaskapai(){
        DefaultComboBoxModel model = new DefaultComboBoxModel(Maskapai.getAll().toArray());
        cmbMaskapai.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtIdpaket = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtHargaAwal = new javax.swing.JTextField();
        txtTanggalBerangkat = new javax.swing.JTextField();
        txtJamKedatangan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtJamBerangkat = new javax.swing.JTextField();
        cmbAsalkota = new javax.swing.JComboBox<String>();
        cmbTujuanKota = new javax.swing.JComboBox<String>();
        cmbMaskapai = new javax.swing.JComboBox<String>();
        cmbPesawat = new javax.swing.JComboBox<String>();
        jLabel15 = new javax.swing.JLabel();
        txtNamaPemesan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cmbKelas = new javax.swing.JComboBox<String>();
        btnPesan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblIDUser = new javax.swing.JLabel();
        lblNamaUser = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReservasi = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        txtIDPemesan = new javax.swing.JTextField();
        txtNamaCust = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtHargaFinal = new javax.swing.JTextField();
        btnBatalPesan = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPenerbangan = new javax.swing.JTable();
        txtCari = new javax.swing.JTextField();
        btnCari = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        txtCariPembayaran = new javax.swing.JTextField();
        btnCariPembayaran = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(19, 167, 218));

        jLabel6.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID");

        txtIdpaket.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Asal");

        jLabel8.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Tujuan");

        jLabel9.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Maskapai");

        jLabel10.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Pesawat");

        jLabel11.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Harga");

        txtHargaAwal.setEditable(false);

        txtTanggalBerangkat.setEditable(false);
        txtTanggalBerangkat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalBerangkatActionPerformed(evt);
            }
        });

        txtJamKedatangan.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jam Kedatangan");

        jLabel13.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Tanggal  Berangkat");

        jLabel14.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Jam Berangkat");

        txtJamBerangkat.setEditable(false);

        cmbAsalkota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAsalkota.setEnabled(false);
        cmbAsalkota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAsalkotaActionPerformed(evt);
            }
        });

        cmbTujuanKota.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTujuanKota.setEnabled(false);

        cmbMaskapai.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbMaskapai.setEnabled(false);

        cmbPesawat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbPesawat.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nama Pemesan");

        jLabel18.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Kelas");

        cmbKelas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ekonomi", "Bisnis", "Utama" }));
        cmbKelas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbKelasItemStateChanged(evt);
            }
        });
        cmbKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbKelasActionPerformed(evt);
            }
        });

        btnPesan.setBackground(new java.awt.Color(255, 255, 0));
        btnPesan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPesan.setText("Pesan");
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbMaskapai, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtHargaAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(txtTanggalBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtJamKedatangan, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtJamBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbTujuanKota, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtIdpaket)
                                .addComponent(cmbAsalkota, 0, 181, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbPesawat, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNamaPemesan, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPesan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbKelas, 0, 181, Short.MAX_VALUE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdpaket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbAsalkota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbTujuanKota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbMaskapai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPesawat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtHargaAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtJamBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtJamKedatangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTanggalBerangkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNamaPemesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(cmbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo4.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/customer_menu.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ID :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Hallo, ");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(19, 167, 218));
        jLabel5.setText("TIKET PESAWAT");

        lblIDUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIDUser.setText("ID");

        lblNamaUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNamaUser.setText("Nama");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIDUser))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNamaUser)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(351, 351, 351)
                .addComponent(jLabel1)
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(lblIDUser))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(lblNamaUser)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel1)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Penerbangan");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Pembayaran");

        tblReservasi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        tblReservasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReservasiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblReservasi);

        jLabel25.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel25.setText("ID");

        jLabel26.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel26.setText("Nama");

        jLabel27.setFont(new java.awt.Font("Swis721 Hv BT", 0, 11)); // NOI18N
        jLabel27.setText("Harga");

        txtHargaFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaFinalActionPerformed(evt);
            }
        });

        btnBatalPesan.setBackground(new java.awt.Color(204, 0, 0));
        btnBatalPesan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBatalPesan.setForeground(new java.awt.Color(255, 255, 255));
        btnBatalPesan.setText("Batalkan Pesanan");
        btnBatalPesan.setPreferredSize(new java.awt.Dimension(67, 23));
        btnBatalPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalPesanActionPerformed(evt);
            }
        });

        btnBayar.setBackground(new java.awt.Color(0, 204, 51));
        btnBayar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        tblPenerbangan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tblPenerbangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPenerbanganMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPenerbangan);
        if (tblPenerbangan.getColumnModel().getColumnCount() > 0) {
            tblPenerbangan.getColumnModel().getColumn(0).setResizable(false);
            tblPenerbangan.getColumnModel().getColumn(1).setResizable(false);
            tblPenerbangan.getColumnModel().getColumn(2).setResizable(false);
            tblPenerbangan.getColumnModel().getColumn(3).setResizable(false);
            tblPenerbangan.getColumnModel().getColumn(4).setResizable(false);
            tblPenerbangan.getColumnModel().getColumn(5).setResizable(false);
            tblPenerbangan.getColumnModel().getColumn(6).setResizable(false);
            tblPenerbangan.getColumnModel().getColumn(7).setResizable(false);
            tblPenerbangan.getColumnModel().getColumn(8).setResizable(false);
        }

        btnCari.setBackground(new java.awt.Color(19, 167, 218));
        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(255, 0, 0));
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        txtCariPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCariPembayaranActionPerformed(evt);
            }
        });

        btnCariPembayaran.setBackground(new java.awt.Color(19, 167, 218));
        btnCariPembayaran.setText("Cari");
        btnCariPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariPembayaranActionPerformed(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 102, 255));
        btnRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDPemesan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel25)))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel26)
                                        .addGap(145, 145, 145)
                                        .addComponent(jLabel27))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNamaCust, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtHargaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBatalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCariPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCariPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 854, Short.MAX_VALUE)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtCariPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCariPembayaran))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBatalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtHargaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIDPemesan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNamaCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(62, 62, 62))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        
        int row = tblReservasi.getSelectedRow();
        
        int idReservasi = Integer.parseInt(tblReservasi.getValueAt(row, 0).toString());
        Reservasi rs = new Reservasi();
        rs.setIdreservasi(idReservasi);
        rs.setStatus("Lunas");
        rs.bayar();
        JOptionPane.showMessageDialog(null,"Pembayaran Berhasil");
        tampilkanDataReservasi();
       
        
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnBatalPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalPesanActionPerformed
        int row = tblReservasi.getSelectedRow();
        
        int idReservasi = Integer.parseInt(tblReservasi.getValueAt(row,0).toString());
        Reservasi rs = new Reservasi();
        rs.setIdreservasi(idReservasi);
        rs.setStatus("Pesanan Batal");
        rs.batalBayar();
        JOptionPane.showMessageDialog(null,"Pesanan dibatalkan");
        tampilkanDataReservasi();
    }//GEN-LAST:event_btnBatalPesanActionPerformed

    private void tblPenerbanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPenerbanganMouseClicked
        DefaultTableModel model = (DefaultTableModel)tblPenerbangan.getModel();
        int rowIndex = tblPenerbangan.getSelectedRow();
        int idpaket = Integer.parseInt(model.getValueAt(rowIndex,0).toString());
        
        Penerbangan penerbangan = Penerbangan.getById(idpaket);
        txtIdpaket.setText(Integer.toString(idpaket));
        
        cmbAsalkota.getModel().setSelectedItem(penerbangan.getAsalkota());
        cmbTujuanKota.getModel().setSelectedItem(penerbangan.getTujuankota());
        cmbPesawat.getModel().setSelectedItem(penerbangan.getPesawat());
        cmbMaskapai.getModel().setSelectedItem(penerbangan.getMaskapai());
        txtHargaAwal.setText(Integer.toString(penerbangan.getHargaTiket()));
        txtJamBerangkat.setText(penerbangan.getJamBerangkat());
        txtJamKedatangan.setText(penerbangan.getJamKedatangan());
        txtTanggalBerangkat.setText(penerbangan.getTanggalBerangkat());
  
    }//GEN-LAST:event_tblPenerbanganMouseClicked

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed
        String namaPemesan = txtNamaPemesan.getText();
        String hargaTiket = txtHargaAwal.getText();
        String kelas = cmbKelas.getSelectedItem().toString();
        String status = "Belum Lunas";
        
        if(!(namaPemesan.isEmpty()&&kelas.isEmpty())){
            int idPenerbangan = Integer.parseInt(txtIdpaket.getText());
            Penerbangan pb = Penerbangan.getById(idPenerbangan);
            Reservasi res = new Reservasi();
            res.setPenerbangan(pb);
            res.setUser(User.getById(Integer.parseInt(lblIDUser.getText())));
            res.setKelas(kelas);
            res.setHargaTiket(hargaTiket);
            res.setNamaPemesan(namaPemesan);
            res.setStatus(status);
            res.save();
   
            JOptionPane.showMessageDialog(null,"Pemesanan tiket berhasil");
            tampilkanDataReservasi();
        } else {
            JOptionPane.showMessageDialog(null,"Lengkapi data");
        }
        
    }//GEN-LAST:event_btnPesanActionPerformed

    private void cmbAsalkotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAsalkotaActionPerformed

    }//GEN-LAST:event_cmbAsalkotaActionPerformed

    private void txtTanggalBerangkatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalBerangkatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalBerangkatActionPerformed

    private void cmbKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbKelasActionPerformed
        
    }//GEN-LAST:event_cmbKelasActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cari(txtCari.getText());
    }//GEN-LAST:event_btnCariActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        Login_User ang = new Login_User();
        ang.setVisible(true);
        ang.pack();
        ang.setLocationRelativeTo(null);
        ang.setDefaultCloseOperation(Dashboard_User.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void tblReservasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservasiMouseClicked
        DefaultTableModel model = (DefaultTableModel)tblReservasi.getModel();
        int rowIndex = tblReservasi.getSelectedRow();
        int idreservasi = Integer.parseInt(model.getValueAt(rowIndex,0).toString());
        
        Reservasi res = Reservasi.getById(idreservasi);
        txtIDPemesan.setText(Integer.toString(idreservasi));
        txtNamaCust.setText(res.getNamaPemesan());
        txtHargaFinal.setText(res.getHargaTiket());
    }//GEN-LAST:event_tblReservasiMouseClicked

    private void btnCariPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariPembayaranActionPerformed
        cariDataReservasi(txtCariPembayaran.getText());
    }//GEN-LAST:event_btnCariPembayaranActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        txtIdpaket.setText("");
        cmbAsalkota.setSelectedIndex(0);
        cmbTujuanKota.setSelectedIndex(0);
        cmbMaskapai.setSelectedIndex(0);
        cmbPesawat.setSelectedIndex(0);
        txtHargaAwal.setText("");
        txtJamBerangkat.setText("");
        txtJamKedatangan.setText("");
        txtTanggalBerangkat.setText("");
        txtIDPemesan.setText("");
        txtNamaCust.setText("");
        txtNamaPemesan.setText("");
        txtHargaFinal.setText("");
        txtCari.setText("");
        txtCariPembayaran.setText("");
        tampilkanDataReservasi();
        tampilkanData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cmbKelasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbKelasItemStateChanged
        String kelas = cmbKelas.getSelectedItem().toString();
        int idPenerbangan = Integer.parseInt(txtIdpaket.getText());
        Penerbangan pb = Penerbangan.getById(idPenerbangan);
      
        int hargaTotal = 0;
        if(kelas.equals("Ekonomi")){
            hargaTotal = pb.getHargaTiket();
        } else if(kelas.equals("Bisnis")){
            int tambahHarga = 10000;
            hargaTotal = (pb.getHargaTiket()+tambahHarga);
        } else if(kelas.equals("Utama")){
            int tambahHarga = 20000;
            hargaTotal = (pb.getHargaTiket()+tambahHarga);
        }
        txtHargaAwal.setText(Integer.toString(hargaTotal));
    }//GEN-LAST:event_cmbKelasItemStateChanged

    private void txtHargaFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaFinalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaFinalActionPerformed

    private void txtCariPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCariPembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCariPembayaranActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatalPesan;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnCariPembayaran;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPesan;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> cmbAsalkota;
    private javax.swing.JComboBox<String> cmbKelas;
    private javax.swing.JComboBox<String> cmbMaskapai;
    private javax.swing.JComboBox<String> cmbPesawat;
    private javax.swing.JComboBox<String> cmbTujuanKota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblIDUser;
    private javax.swing.JLabel lblNamaUser;
    private javax.swing.JTable tblPenerbangan;
    private javax.swing.JTable tblReservasi;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtCariPembayaran;
    private javax.swing.JTextField txtHargaAwal;
    private javax.swing.JTextField txtHargaFinal;
    private javax.swing.JTextField txtIDPemesan;
    private javax.swing.JTextField txtIdpaket;
    private javax.swing.JTextField txtJamBerangkat;
    private javax.swing.JTextField txtJamKedatangan;
    private javax.swing.JTextField txtNamaCust;
    private javax.swing.JTextField txtNamaPemesan;
    private javax.swing.JTextField txtTanggalBerangkat;
    // End of variables declaration//GEN-END:variables
}
