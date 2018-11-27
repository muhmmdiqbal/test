package FormUpdate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MUHAMMAD-PC
 */
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import View.DBKoneksi;
import java.sql.Connection;

public class FormDataTransaksi extends javax.swing.JDialog {
    private DefaultTableModel tbl_transaksi;
    
    /**
     * Creates new form FormDataTransaksi
     */
    
    public FormDataTransaksi (java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tampil_tabel_transaksi();
    }



    
    //komponen
    public void komponen_transaksi(){
        txt_id_pelanggan.setText("");
        txt_kode_barang.setText("");
        txt_id_pegawai.setText("");
        txt_tanggal.setText("");
        txt_jumlah.setText("");
        txt_kode_transaksi.setText("");
         
    }
    
    //tampil Tabel
    public void tampil_tabel_transaksi(){
           Object[] Baris={"id pelanggan","kode barang","id pegawai","tanggal","jumlah","kode transaksi"};
           tbl_transaksi = new DefaultTableModel(null, Baris);
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

  
    public void delete_data(){
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            try {
                java.sql.Connection koneksi = new DBKoneksi().konek();
                int table = tabel_transaksi.getSelectedRow();
                String a = tabel_transaksi.getValueAt(table, 0).toString();
                String sql = "delete from tabel_transaksi where id_pelanggan = '"+a+"'";
                java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
                stat.executeUpdate();
                koneksi.close();
                tampil_tabel_transaksi();
                komponen_transaksi();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus \n"+ e);
            }
        }}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id_pelanggan = new javax.swing.JTextField();
        txt_kode_barang = new javax.swing.JTextField();
        txt_id_pegawai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_selesai = new javax.swing.JButton();
        txt_tanggal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JTextField();
        txt_kode_transaksi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entry Data Baru", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setText("ID Pelanggan");

        jLabel4.setText("Kode Barang");

        jLabel6.setText("ID Pegawai");

        txt_id_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_pegawaiActionPerformed(evt);
            }
        });

        jLabel7.setText("Tanggal");

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete Data");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_selesai.setText("Selesai");
        btn_selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_selesaiActionPerformed(evt);
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
        jScrollPane1.setViewportView(tabel_transaksi);

        jLabel8.setText("Jumlah");

        jLabel9.setText("Kode Transaksi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_selesai, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_jumlah)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id_pegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(txt_tanggal))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btn_delete)))
                            .addComponent(txt_id_pelanggan)
                            .addComponent(txt_kode_barang)
                            .addComponent(txt_kode_transaksi))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id_pelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_kode_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_id_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kode_transaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_delete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_selesai)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        if(txt_id_pelanggan.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, ID Pelanggan tidak boleh kosong!");
            txt_id_pelanggan.requestFocus();
        }
        else if(txt_kode_barang.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, Kode Barang tidak boleh kosong!");
            txt_kode_barang.requestFocus();
        }
        else if(txt_id_pegawai.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, ID Pegawai tidak boleh kosong!");
            txt_id_pegawai.requestFocus();
        }
        else if(txt_tanggal.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, Tanggal tidak boleh kosong!");
            txt_tanggal.requestFocus();
        }
        else if(txt_jumlah.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, Jumlah transaksi tidak boleh kosong!");
            txt_jumlah.requestFocus();
        }
        else if(txt_kode_transaksi.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, kode transaksi tidak boleh kosong!");
            txt_kode_transaksi.requestFocus();
        }
        else {
            java.sql.Connection koneksi = new DBKoneksi().konek();
            try {
                String sql="insert into tabel_transaksi(id_pelanggan,kode_barang,id_pegawai,tanggal,jumlah,kode_transaksi) values(?,?,?,?,?,?)";
                java.sql.PreparedStatement stmt = koneksi.prepareStatement(sql);
                try {
                    stmt.setString(1,txt_id_pelanggan.getText());
                    stmt.setString(2,txt_kode_barang.getText());
                    stmt.setString(3,txt_id_pegawai.getText());
                    stmt.setString(4,txt_tanggal.getText());
                    stmt.setString(5,txt_jumlah.getText());
                    stmt.setString(6,txt_kode_transaksi.getText());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Menyimpan Data BERHASIL");
                    komponen_transaksi();
                    tampil_tabel_transaksi();
                }
                catch(SQLException se){
                    JOptionPane.showMessageDialog(null,"Menyimpan data GAGAL \n" +se);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Koneksi GAGAL" +e);
                }
                stmt.close();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null,"Koneksi GAGAL" +e);
            }
        }
                                
       
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selesaiActionPerformed
        dispose();
    }//GEN-LAST:event_btn_selesaiActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        delete_data();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tabel_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_transaksiMouseClicked
        int table = tabel_transaksi.getSelectedRow();
        //mengambil data dari tabel
        String a = tabel_transaksi.getValueAt(table, 0).toString();
        String b = tabel_transaksi.getValueAt(table, 1).toString();
        String c = tabel_transaksi.getValueAt(table, 2).toString();
    }//GEN-LAST:event_tabel_transaksiMouseClicked

    private void txt_id_pegawaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_pegawaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_pegawaiActionPerformed
    
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
            java.util.logging.Logger.getLogger(FormDataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormDataTransaksi dialog = new FormDataTransaksi(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_selesai;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_transaksi;
    private javax.swing.JTextField txt_id_pegawai;
    private javax.swing.JTextField txt_id_pelanggan;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_kode_barang;
    private javax.swing.JTextField txt_kode_transaksi;
    private javax.swing.JTextField txt_tanggal;
    // End of variables declaration//GEN-END:variables
}
