/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjaman.barang;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Akito
 */
public class main extends javax.swing.JFrame {
    String nol_jam = "";
    String nol_menit = "";
    String nol_detik = "";
    /**
     * Creates new form main
     */
    public main(String nama) {
        initComponents();
        selectData();
        setJam();
        setTanggal();
        petugas.setText(nama);
        
    }
    
    public void selectData(){
            String kolom[] = {"ID Pinjam","NIS","Nama Siswa","Kelas","Alamat","Barang","Jumlah","Tgl Pinjam","Tgl Kembali"};
            DefaultTableModel dtm = new DefaultTableModel(null, kolom);
            String SQL = "SELECT * FROM peminjaman";
            ResultSet rs = KoneksiDB.executeQuery(SQL);
            try {
                while (rs.next()) {
                    String id = rs.getString(1);
                    String NIS = rs.getString(2);
                    String Nama = rs.getString(3);
                    String Kelas = rs.getString(4);
                    String Alamat = rs.getString(5);
                    String Barang = rs.getString(6);
                    String jumlah = rs.getString(7);
                    String pinjam = String.valueOf(rs.getDate(8));
                    String kembali = String.valueOf(rs.getDate(9));
                    String data[] = {id,NIS,Nama,Kelas,Alamat,Barang,jumlah,pinjam,kembali};
                    dtm.addRow(data);
                }
        } catch (SQLException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
            tabel.setModel(dtm);
        }
    
    public void setJam(){
     ActionListener taskPerformer = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date dt = new Date();
                int nilai_jam = dt.getHours();
                int nilai_menit = dt.getMinutes();
                int nilai_detik = dt.getSeconds();
                if (nilai_jam <= 9) {
                    nol_jam = "0";
                }
                if (nilai_menit <=9) {
                    nol_menit = "0";
                }
                if (nilai_detik <= 9) {
                    nol_detik = "0";
                }
                
                String jams = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = Integer.toString(nilai_detik);
                jam.setText(jams+ ":" + menit +":"+detik);
                
            }
        };
    new Timer(100, taskPerformer).start();
}
    public void setTanggal(){
    java.util.Date skrg = new java.util.Date();
    java.text.SimpleDateFormat kal = new SimpleDateFormat("dd/MM/yyyy");
    tanggal.setText(kal.format(skrg));
    
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
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        petugas = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jam = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        NIS = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kelas = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        barang = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jumlah = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        tglPinjam = new com.toedter.calendar.JDateChooser();
        tglKembali = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("Aplikasi Peminjaman Barang Sarpra");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(20, 10, 440, 50);

        jLabel10.setText("Petugas :");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(20, 74, 70, 20);
        jPanel1.add(petugas);
        petugas.setBounds(90, 74, 140, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Jam :");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(450, 50, 40, 20);

        jam.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(jam);
        jam.setBounds(490, 50, 80, 20);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Tanggal :");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(450, 80, 70, 20);

        tanggal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.add(tanggal);
        tanggal.setBounds(510, 80, 80, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 610, 110);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);
        jPanel2.add(NIS);
        NIS.setBounds(30, 30, 120, 30);

        jLabel1.setText("NIS");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 10, 120, 20);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "NIS", "Nama", "Kelas", "Alamat", "Barang", "Jumlah", "Tanggal Pinjam", "Tanggal Kembali"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(30, 230, 560, 160);

        jLabel2.setText("Kelas");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 130, 120, 20);

        jLabel3.setText("Nama");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 70, 120, 20);
        jPanel2.add(nama);
        nama.setBounds(30, 90, 120, 30);

        jLabel4.setText("Alamat");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(170, 130, 120, 20);

        kelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "X RPL 1", "X RPL 2", "X RPL 3", "X RPL 4", "X RPL 5", "X RPL 6", "X TKJ 1", "X TKJ 2", "X TKJ 3", "X TKJ 4", "X TKJ 5", "X TKJ 6", "XI RPL 1", "XI RPL 2", "XI RPL 3", "XI RPL 4", "XI RPL 5", "XI RPL 6", "XI TKJ 1", "XI TKJ 2", "XI TKJ 3", "XI TKJ 4", "XI TKJ 5" }));
        jPanel2.add(kelas);
        kelas.setBounds(30, 150, 120, 30);

        jButton6.setText("Pinjam");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(450, 30, 90, 30);

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(450, 70, 90, 30);

        jButton8.setText("Exit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(450, 150, 90, 30);

        jPanel2.add(barang);
        barang.setBounds(170, 30, 120, 30);

        jLabel5.setText("Jumlah");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(170, 70, 120, 20);
        jPanel2.add(jumlah);
        jumlah.setBounds(170, 90, 120, 30);

        jLabel6.setText("Barang yang dipinjam");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(170, 10, 120, 20);

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane2.setViewportView(alamat);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(170, 150, 260, 30);

        jPanel2.add(tglPinjam);
        tglPinjam.setBounds(300, 30, 130, 30);
        jPanel2.add(tglKembali);
        tglKembali.setBounds(300, 90, 130, 30);

        jLabel7.setText("Tanggal Kembali");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(300, 70, 130, 20);

        jLabel8.setText("Tanggal Pinjam");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(300, 10, 130, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Data Peminjaman");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(30, 194, 470, 30);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(450, 110, 90, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 120, 610, 410);

        setBounds(0, 0, 626, 569);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        int baris = tabel.getSelectedRow();
        if (baris != 1) {
            String NIS = tabel.getValueAt(baris,1).toString();
            String SQL = "DELETE FROM peminjaman WHERE NIS='"+NIS+"'";
            int status = KoneksiDB.execute(SQL);
            if (status == 1) {
                
                    JOptionPane.showMessageDialog(this, "Data berhasil Di hapus", "Sukses",JOptionPane.INFORMATION_MESSAGE);
                   
                    
            }else{
                    JOptionPane.showMessageDialog(this, "Data gagal Di Hapus", "Gagal",JOptionPane.WARNING_MESSAGE);
                }
       }else{
            JOptionPane.showMessageDialog(this, "Pilih Baris Data Terlebih Dahulu", "ERROR",JOptionPane.WARNING_MESSAGE);
        }
        selectData();
        setTanggal();
        setJam();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String SQL = "select * from barang";
        ResultSet rs = KoneksiDB.executeQuery(SQL);
        
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        try {
            while(rs.next()) {
                String is= rs.getString(2);
                model.addElement(is);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal", "Gagal",JOptionPane.WARNING_MESSAGE);
        }
        barang.setModel(model);
    }//GEN-LAST:event_formWindowOpened

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String tglpinjam = dateFormat.format(tglPinjam.getDate());
        String tglkembali = dateFormat.format(tglKembali.getDate());
        String SQLU = "select * from barang where NamaBarang='"+barang.getSelectedItem()+"'";
        ResultSet rs = KoneksiDB.executeQuery(SQLU);
        try {
            
            if (rs.next()) {
            int stok = rs.getInt(3);
            int jum = Integer.parseInt(String.valueOf(jumlah.getValue()));
            int total = stok - jum;
            if ("".equals(NIS.getText()) || "".equals(nama.getText()) || alamat.equals("") || "".equals(kelas.getSelectedItem()) 
                    || "".equals(barang.getSelectedItem()) || "".equals(jumlah.getValue()) || tglpinjam.equals("") || "".equals(tglkembali)) {
            JOptionPane.showMessageDialog(this, "Harap Lengkapi Data","ERROR", JOptionPane.WARNING_MESSAGE);
        }else{
            
                String SQLI = "UPDATE barang set Stok='"+total+"' where NamaBarang='"+barang.getSelectedItem()+"'";
                int statusu = KoneksiDB.execute(SQLI);
                String SQL = "INSERT INTO peminjaman (id_pinjam,NIS,NamaSiswa,Kelas,Alamat,Barang,Jumlah,TglPinjam,TglKembali) " 
                        + "VALUES(NULL,'"+NIS.getText()+"','"+nama.getText()+"','"+kelas.getSelectedItem()+"','"+alamat.getText()
                        +"','"+barang.getSelectedItem()+"','"+jumlah.getValue()+"','"+tglpinjam+"','"+tglkembali+"')";
                
                int status = KoneksiDB.execute(SQL);
                if (status == 1 && statusu == 1) {
                
                    JOptionPane.showMessageDialog(this, "Peminjaman Sukses", "Sukses",JOptionPane.INFORMATION_MESSAGE);
                    selectData();
                    setTanggal();
                    setJam();
            }else{
                    JOptionPane.showMessageDialog(this, "Peminjaman Gagal", "Gagal",JOptionPane.WARNING_MESSAGE);
                }
        }
          }
            
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        selectData();
        setTanggal();
            setJam();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int baris = tabel.getSelectedRow();

        if (baris != -1) {
            NIS.setText(tabel.getValueAt(baris, 1).toString());
            nama.setText(tabel.getValueAt(baris, 2).toString());
            kelas.setSelectedItem(tabel.getValueAt(baris, 3).toString());
            alamat.setText(tabel.getValueAt(baris, 4).toString());
            barang.setSelectedItem(tabel.getValueAt(baris, 5));
            
            SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
            Date dateFormat = null;
            Date dateFormat1 = null;
            try {
            dateFormat = date.parse(tabel.getValueAt(baris, 7).toString());
            dateFormat1 = date.parse(tabel.getValueAt(baris, 8).toString());
            } catch (ParseException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
            tglPinjam.setDate(dateFormat);
            tglKembali.setDate(dateFormat1);

            setTanggal();
            setJam();
        }
    }//GEN-LAST:event_tabelMouseClicked

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NIS;
    private javax.swing.JTextArea alamat;
    private javax.swing.JComboBox<String> barang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jam;
    private javax.swing.JSpinner jumlah;
    private javax.swing.JComboBox<String> kelas;
    private javax.swing.JTextField nama;
    private javax.swing.JLabel petugas;
    private javax.swing.JTable tabel;
    private javax.swing.JLabel tanggal;
    private com.toedter.calendar.JDateChooser tglKembali;
    private com.toedter.calendar.JDateChooser tglPinjam;
    // End of variables declaration//GEN-END:variables
}