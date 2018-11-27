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

public class FormDataPegawai extends javax.swing.JDialog {
    private DefaultTableModel tbl_pegawai;
    
    /**
     * Creates new form FormDataPegawai
     */
    
    public FormDataPegawai(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tampil_tabel_pegawai();
    }
    
    //bersih komponen
    public void komponen_pegawai(){
        txt_id_pegawai.setText("");
        txt_nama_pegawai.setText("");
        txt_alamat.setText("");
        txt_notelp.setText("");
         
    }
    
    //tampil Tabel
    public void tampil_tabel_pegawai(){
           Object[] Baris={"id pegawai","nama pegawai","alamat","no telpon"};
           tbl_pegawai = new DefaultTableModel(null, Baris);
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

  
    public void delete_data(){
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Anda yakin?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if(ok==0){
            try {
                java.sql.Connection koneksi = new DBKoneksi().konek();
                int table = tabel_pegawai.getSelectedRow();
                String a = tabel_pegawai.getValueAt(table, 0).toString();
                String sql = "delete from tabel_pegawai where id_pegawai = '"+a+"'";
                java.sql.PreparedStatement stat = koneksi.prepareStatement(sql);
                stat.executeUpdate();
                koneksi.close();
                tampil_tabel_pegawai();
                komponen_pegawai();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data gagal di hapus \n"+ e);
            }
            /*
              //panggil method koneksi
                java.sql.Connection koneksi = new DBConnection().connect();

                String sql="delete from tpegawai where fid='"+id_pegawai.getText()+"'";
                java.sql.PreparedStatement stmt=koneksi.prepareStatement(sql);
                stmt.executeUpdate();
                //bersihkan teks
                clear();
                JOptionPane.showMessageDialog(null,"Data Berhasil di hapus");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Data Gagal di hapus");
            }
             */
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_id_pegawai = new javax.swing.JTextField();
        txt_nama_pegawai = new javax.swing.JTextField();
        txt_alamat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_simpan = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_selesai = new javax.swing.JButton();
        txt_notelp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pegawai = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entry Data Baru", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Rounded MT Bold", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel2.setText("ID Pegawai");

        jLabel4.setText("Nama Pegawai");

        jLabel6.setText("Alamat");

        txt_id_pegawai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_pegawaiActionPerformed(evt);
            }
        });

        jLabel7.setText("No telpon");

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

        tabel_pegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pegawai", "Nama Pegawai", "Alamat", "No Telpon"
            }
        ));
        tabel_pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_pegawai);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
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
                            .addComponent(jLabel7))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id_pegawai)
                            .addComponent(txt_nama_pegawai)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_notelp, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_delete)))
                                .addGap(0, 150, Short.MAX_VALUE))
                            .addComponent(txt_alamat))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nama_pegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_notelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_delete))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_selesai)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        if(txt_id_pegawai.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, ID Pegawai tidak boleh kosong!");
            txt_id_pegawai.requestFocus();
        }
        else if(txt_nama_pegawai.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, Nama Pegawai tidak boleh kosong!");
            txt_nama_pegawai.requestFocus();
        }
        else if(txt_alamat.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, Alamat tidak boleh kosong!");
            txt_alamat.requestFocus();
        }
        else if(txt_notelp.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Maaf, NO Telp tidak boleh kosong!");
            txt_notelp.requestFocus();
        }
        else{
            java.sql.Connection koneksi = new DBKoneksi().konek();
            try{
                String sql="insert into tabel_pegawai(id_pegawai,nama_pegawai,alamat,notelp) values(?,?,?,?)";
                java.sql.PreparedStatement stmt = koneksi.prepareStatement(sql);
                try{
                    stmt.setString(1,txt_id_pegawai.getText());
                    stmt.setString(2,txt_nama_pegawai.getText());
                    stmt.setString(3,txt_alamat.getText());
                    stmt.setString(4,txt_notelp.getText());
                    stmt.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Menyimpan Data BERHASIL");
                    komponen_pegawai();
                    tampil_tabel_pegawai();
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

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        delete_data();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_selesaiActionPerformed
        dispose();
    }//GEN-LAST:event_btn_selesaiActionPerformed

    private void tabel_pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pegawaiMouseClicked
        int table = tabel_pegawai.getSelectedRow();
        //mengambil data dari tabel
        String a = tabel_pegawai.getValueAt(table, 0).toString();
        String b = tabel_pegawai.getValueAt(table, 1).toString();
        String c = tabel_pegawai.getValueAt(table, 2).toString();
    }//GEN-LAST:event_tabel_pegawaiMouseClicked

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
            java.util.logging.Logger.getLogger(FormDataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDataPegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormDataPegawai dialog = new FormDataPegawai(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_pegawai;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_id_pegawai;
    private javax.swing.JTextField txt_nama_pegawai;
    private javax.swing.JTextField txt_notelp;
    // End of variables declaration//GEN-END:variables
}
