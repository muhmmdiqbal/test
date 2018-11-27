/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MUHAMMAD-PC
 */
public class mainform extends javax.swing.JFrame {

    /**
     * Creates new form mainform
     * @param loginuser
     */
    public mainform (String loginuser) {
        initComponents();
       
        tampil_tabel_barang();
        tampil_tabel_restock();
        tampil_tabel_pelanggan();
        tampil_tabel_pegawai();
        tampil_tabel_transaksi();
        tampil_tabel_pemasok();
        
        }     


       public void tampil_tabel_pemasok(){
           Object[] Baris={"id pemasok","nama pemasok","alamat","no telpon"};
        DefaultTableModel tbl_pemasok = new DefaultTableModel(null, Baris);
           tabel_pemasok.setModel(tbl_pemasok);

           //panggil method koneksi
           java.sql.Connection koneksi = new DBKoneksi().konek();

           //untuk menampilkan di table
           try{
               String sql="Select * from tabel_pemasok order by id_pemasok asc";
               java.sql.Statement stmt=koneksi.createStatement();
               java.sql.ResultSet res=stmt.executeQuery(sql);
               while(res.next()){
                   String id_pemasok = res.getString("id_pemasok");
                   String nama_pemasok = res.getString("nama_pemasok");
                   String alamat = res.getString("alamat");
                   String notelp = res.getString("notelp");
                   String[] dataField={id_pemasok, nama_pemasok, alamat, notelp};
                   tbl_pemasok.addRow(dataField);
               }
               //JOptionPane.showMessageDialog(null, "Menampilkan data ke tabel BERHASIL");
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Menampilkan data ke tabel GAGAL");
           }
    }
            public void tampil_tabel_transaksi(){
           Object[] Baris={"id pelanggan","kode barang","id pegawai","tanggal","jumlah","kode transaksi"};
        DefaultTableModel tbl_transaksi = new DefaultTableModel(null, Baris);
           tabel_transaksi.setModel(tbl_transaksi);

           //panggil method koneksi
           java.sql.Connection koneksi = new DBKoneksi().konek();

           //untuk menampilkan di table
           try{
               String sql="Select * from tabel_transaksi order by tanggal asc";
               java.sql.Statement stmt=koneksi.createStatement();
               java.sql.ResultSet res=stmt.executeQuery(sql);
               while(res.next()){
                   String id_pelanggan = res.getString("id_pelanggan");
                   String kode_barang = res.getString("kode_barang");
                   String id_pegawai = res.getString("id_pegawai");
                   String tanggal = res.getString("tanggal");
                   String jumlah= res.getString("jumlah");
                   String kode_transaksi = res.getString("kode_transaksi");
                   String[] dataField={id_pelanggan, kode_barang, id_pegawai,  tanggal, jumlah, kode_transaksi};
                   tbl_transaksi.addRow(dataField);
               }
               //JOptionPane.showMessageDialog(null, "Menampilkan data ke tabel BERHASIL");
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Menampilkan data transaksi ke tabel GAGAL");
           }
    }
           public void tampil_tabel_pelanggan(){
           Object[] Baris={"id pelanggan","nama pelanggan","alamat","no telpon"};
        DefaultTableModel tbl_pelanggan = new DefaultTableModel(null, Baris);
           tabel_pelanggan.setModel(tbl_pelanggan);

           //panggil method koneksi
           java.sql.Connection koneksi = new DBKoneksi().konek();

           //untuk menampilkan di table
           try{
               String sql="Select * from tabel_pelanggan order by id_pelanggan asc";
               java.sql.Statement stmt=koneksi.createStatement();
               java.sql.ResultSet res=stmt.executeQuery(sql);
               while(res.next()){
                   String id_pelanggan = res.getString("id_pelanggan");
                   String nama_pelanggan = res.getString("nama_pelanggan");
                   String alamat = res.getString("alamat");
                   String notelp = res.getString("notelp");
                   String[] dataField={id_pelanggan, nama_pelanggan, alamat, notelp};
                   tbl_pelanggan.addRow(dataField);
               }
               //JOptionPane.showMessageDialog(null, "Menampilkan data ke tabel BERHASIL");
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Menampilkan data ke tabel GAGAL");
           }
    } 
         public void tampil_tabel_pegawai(){
           Object[] Baris={"id pegawai","nama pegawai","alamat","no telpon"};
        DefaultTableModel tbl_pegawai = new DefaultTableModel(null, Baris);
           tabel_pegawai.setModel(tbl_pegawai);

           //panggil method koneksi
           java.sql.Connection koneksi = new DBKoneksi().konek();

           //untuk menampilkan di table
           try{
               String sql="Select * from tabel_pegawai order by id_pegawai asc";
               java.sql.Statement stmt=koneksi.createStatement();
               java.sql.ResultSet res=stmt.executeQuery(sql);
               while(res.next()){
                   String id_pegawai = res.getString("id_pegawai");
                   String nama_pegawai = res.getString("nama_pegawai");
                   String alamat = res.getString("alamat");
                   String notelp = res.getString("notelp");
                   String[] dataField={id_pegawai, nama_pegawai, alamat, notelp};
                   tbl_pegawai.addRow(dataField);
               }
               //JOptionPane.showMessageDialog(null, "Menampilkan data ke tabel BERHASIL");
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Menampilkan data ke tabel GAGAL");
           }
    }
      public void tampil_tabel_restock(){
           Object[] Baris={"id pegawai","kode barang","tanggal","jumlah restock","nota"};
        DefaultTableModel tbl_restock = new DefaultTableModel(null, Baris);
           tabel_restock.setModel(tbl_restock);

           //panggil method koneksi
           java.sql.Connection koneksi = new DBKoneksi().konek();

           //untuk menampilkan di table
           try{
               String sql="Select * from tabel_restock order by kode_barang asc";
               java.sql.Statement stmt=koneksi.createStatement();
               java.sql.ResultSet res=stmt.executeQuery(sql);
               while(res.next()){
                   String id_pegawai = res.getString("id_pegawai");
                   String kode_barang = res.getString("kode_barang");
                   String tanggal = res.getString("tanggal");
                   String jumlah_restock = res.getString("jumlah_restock");
                   String nota = res.getString("nota");
                   String[] dataField={id_pegawai, kode_barang, tanggal, jumlah_restock, nota};
                   tbl_restock.addRow(dataField);
               }
               //JOptionPane.showMessageDialog(null, "Menampilkan data ke tabel BERHASIL");
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Menampilkan data restock ke tabel GAGAL");
           }
    }

     //tampil Tabel barang
    public void tampil_tabel_barang(){
           Object[] Baris={"kode barang","nama barang","harga","jumlah"};
        DefaultTableModel tbl_barang = new DefaultTableModel(null, Baris);
           tabel_barang.setModel(tbl_barang);

           //panggil method koneksi
           java.sql.Connection koneksi = new DBKoneksi().konek();

           //untuk menampilkan di table
           try{
               String sql="Select * from tabel_barang order by kode_barang asc";
               java.sql.Statement stmt=koneksi.createStatement();
               java.sql.ResultSet res=stmt.executeQuery(sql);
               while(res.next()){
                   String kode_barang = res.getString("kode_barang");
                   String nama_barang = res.getString("nama_barang");
                   String harga = res.getString("harga");
                   String jumlah = res.getString("jumlah");
                   String[] dataField={kode_barang, nama_barang, harga, jumlah};
                   tbl_barang.addRow(dataField);
               }
               //JOptionPane.showMessageDialog(null, "Menampilkan data ke tabel BERHASIL");
           }catch(Exception ex){
               JOptionPane.showMessageDialog(null, "Menampilkan data barang ke tabel GAGAL");
           }
                
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_barang = new javax.swing.JTable();
        btn_entry_barang_baru = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_restock = new javax.swing.JTable();
        btn_entry_restock_baru = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_pegawai = new javax.swing.JTable();
        btn_entry_pegawai_baru = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabel_pemasok = new javax.swing.JTable();
        btn_entry_pemasok_baru = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabel_pelanggan = new javax.swing.JTable();
        btn_entry_pelanggan_baru = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btn_entry_transaksi_baru = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lblselamatdatang = new javax.swing.JLabel();
        btn_logout_stok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        tabel_barang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "kode barang", "nama barang", "harga", "jumlah"
            }
        ));
        jScrollPane1.setViewportView(tabel_barang);

        btn_entry_barang_baru.setText("Edit Data");
        btn_entry_barang_baru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_entry_barang_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entry_barang_baruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_entry_barang_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_entry_barang_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jTabbedPane1.addTab("Stok Barang", jPanel2);

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));

        tabel_restock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pegawai", "ID Barang", "Tanggal ", "Jumlah Restock", "Nota"
            }
        ));
        jScrollPane3.setViewportView(tabel_restock);

        btn_entry_restock_baru.setText("Edit Data");
        btn_entry_restock_baru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_entry_restock_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entry_restock_baruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_entry_restock_baru)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_entry_restock_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Re-stock", jPanel3);

        jPanel6.setBackground(new java.awt.Color(102, 204, 255));

        tabel_pegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id pegawai", "nama pegawai", "alamat", "no telpon"
            }
        ));
        jScrollPane2.setViewportView(tabel_pegawai);

        btn_entry_pegawai_baru.setText("Edit Data");
        btn_entry_pegawai_baru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_entry_pegawai_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entry_pegawai_baruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btn_entry_pegawai_baru)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_entry_pegawai_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jTabbedPane1.addTab("Pegawai", jPanel6);

        jPanel7.setBackground(new java.awt.Color(102, 204, 255));

        tabel_pemasok.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id pemasok", "nama pemasok", "alamat", "no telpon"
            }
        ));
        jScrollPane5.setViewportView(tabel_pemasok);

        btn_entry_pemasok_baru.setText("Edit Data");
        btn_entry_pemasok_baru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_entry_pemasok_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entry_pemasok_baruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_entry_pemasok_baru)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_entry_pemasok_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jTabbedPane1.addTab("Pemasok", jPanel7);

        jPanel8.setBackground(new java.awt.Color(102, 204, 255));

        tabel_pelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id pelanggan", "nama pelanggan", "alamat", "no telpon"
            }
        ));
        jScrollPane6.setViewportView(tabel_pelanggan);

        btn_entry_pelanggan_baru.setText("Edit Data");
        btn_entry_pelanggan_baru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_entry_pelanggan_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entry_pelanggan_baruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btn_entry_pelanggan_baru)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_entry_pelanggan_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        jTabbedPane1.addTab("Pelanggan", jPanel8);

        jPanel9.setBackground(new java.awt.Color(102, 204, 255));

        btn_entry_transaksi_baru.setText("Edit Data");
        btn_entry_transaksi_baru.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_entry_transaksi_baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entry_transaksi_baruActionPerformed(evt);
            }
        });

        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id pelanggan", "kode barang", "id pegawai", "tanggal", "jumlah", "kode transaksi"
            }
        ));
        tabel_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_transaksiMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabel_transaksi);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_entry_transaksi_baru)
                .addGap(28, 478, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(btn_entry_transaksi_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(70, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Transaksi", jPanel9);

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));

        lblselamatdatang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblselamatdatang.setForeground(new java.awt.Color(255, 255, 255));
        lblselamatdatang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblselamatdatang.setText("APLIKASI BARANG-BARANG");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblselamatdatang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(lblselamatdatang, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );

        btn_logout_stok.setText("Log-Out");
        btn_logout_stok.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_logout_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout_stokActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_logout_stok)
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_logout_stok, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logout_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout_stokActionPerformed
        logout_barang();
    }//GEN-LAST:event_btn_logout_stokActionPerformed
    public void logout_barang(){
        
    
    
        new Form_Utama().show();
        this.dispose();
    
        
        
    }
    
    private void btn_entry_barang_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entry_barang_baruActionPerformed
    new FormUpdate.FormDataBarang(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btn_entry_barang_baruActionPerformed

    private void btn_entry_restock_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entry_restock_baruActionPerformed
        // TODO add your handling code here:
         new FormUpdate.FormDataRestock(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btn_entry_restock_baruActionPerformed

    private void btn_entry_pegawai_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entry_pegawai_baruActionPerformed
        // TODO add your handling code here:
         new FormUpdate.FormDataPegawai(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btn_entry_pegawai_baruActionPerformed

    private void btn_entry_pemasok_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entry_pemasok_baruActionPerformed
        // TODO add your handling code here:
         new FormUpdate.FormDataPemasok(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btn_entry_pemasok_baruActionPerformed

    private void btn_entry_pelanggan_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entry_pelanggan_baruActionPerformed
        // TODO add your handling code here
         new FormUpdate.FormDataPelanggan(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btn_entry_pelanggan_baruActionPerformed

    private void btn_entry_transaksi_baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entry_transaksi_baruActionPerformed
        // TODO add your handling code here:
        new FormUpdate.FormDataTransaksi(this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_btn_entry_transaksi_baruActionPerformed

    private void tabel_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_transaksiMouseClicked
  
    }//GEN-LAST:event_tabel_transaksiMouseClicked

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
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entry_barang_baru;
    private javax.swing.JButton btn_entry_pegawai_baru;
    private javax.swing.JButton btn_entry_pelanggan_baru;
    private javax.swing.JButton btn_entry_pemasok_baru;
    private javax.swing.JButton btn_entry_restock_baru;
    private javax.swing.JButton btn_entry_transaksi_baru;
    private javax.swing.JButton btn_logout_stok;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblselamatdatang;
    private javax.swing.JTable tabel_barang;
    private javax.swing.JTable tabel_pegawai;
    private javax.swing.JTable tabel_pelanggan;
    private javax.swing.JTable tabel_pemasok;
    private javax.swing.JTable tabel_restock;
    private javax.swing.JTable tabel_transaksi;
    // End of variables declaration//GEN-END:variables

