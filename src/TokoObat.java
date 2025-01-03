

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.DefaultListModel;

public class TokoObat extends javax.swing.JFrame {
    Connection conn; // Koneksi ke database
    DefaultListModel<String> modelListObatDipilih = new DefaultListModel<>();
    HashMap<String, Integer> hargaObatMap = new HashMap<>();
    int totalHargaSemua = 0;

    public TokoObat() {
        initComponents();
        connectToDatabase();
        loadJenisObat();
        listObatDipilih.setModel(modelListObatDipilih);
    }

    // Koneksi ke database
    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/apotek"; // URL Database
            String user = "root"; // Username MySQL
            String password = ""; // Password MySQL
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Koneksi Gagal: " + e.getMessage());
        }
    }

    // Load jenis_obat ke ComboBox
    private void loadJenisObat() {
        try {
            String query = "SELECT DISTINCT jenis_obat FROM obat";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            jenisObat.removeAllItems();
            while (rs.next()) {
                jenisObat.addItem(rs.getString("jenis_obat"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal Load Jenis Obat: " + e.getMessage());
        }
    }

    // Load List Obat sesuai jenis_obat
    private void loadListObat(String jenis) {
        try {
            String query = "SELECT nama_obat, harga_obat FROM obat WHERE jenis_obat = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, jenis);
            ResultSet rs = ps.executeQuery();
            DefaultListModel<String> listModel = new DefaultListModel<>();
            hargaObatMap.clear(); // Bersihkan HashMap

            while (rs.next()) {
                String namaObat = rs.getString("nama_obat");
                int harga = rs.getInt("harga_obat");
                listModel.addElement(namaObat);
                hargaObatMap.put(namaObat, harga);
            }
            listObat.setModel(listModel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal Load List Obat: " + e.getMessage());
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

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tambahKeTerpilih = new javax.swing.JButton();
        jenisObat = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listObat = new javax.swing.JList<>();
        kuantitas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listObatDipilih = new javax.swing.JList<>();
        jumlah = new javax.swing.JTextField();
        kembalian = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        hitung = new javax.swing.JButton();
        totalHarga = new javax.swing.JTextField();
        logOut = new javax.swing.JButton();
        cetakStruk = new javax.swing.JButton();
        tanggal = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        jLabel12.setFont(new java.awt.Font("Montserrat Black", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(242, 242, 242));
        jLabel12.setText("List Obat");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        tambahKeTerpilih.setBackground(new java.awt.Color(0, 102, 102));
        tambahKeTerpilih.setForeground(new java.awt.Color(255, 255, 255));
        tambahKeTerpilih.setText("Tambah");
        tambahKeTerpilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahKeTerpilihActionPerformed(evt);
            }
        });

        jenisObat.setBackground(new java.awt.Color(0, 102, 102));
        jenisObat.setForeground(new java.awt.Color(255, 255, 255));
        jenisObat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jenisObat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisObatActionPerformed(evt);
            }
        });

        listObat.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listObat);

        kuantitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kuantitasActionPerformed(evt);
            }
        });

        listObatDipilih.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listObatDipilih);

        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });

        kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalianActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Montserrat Black", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(242, 242, 242));
        jLabel9.setText("Jenis Obat");

        hitung.setBackground(new java.awt.Color(0, 102, 102));
        hitung.setForeground(new java.awt.Color(255, 255, 255));
        hitung.setText("Hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });

        totalHarga.setBackground(new java.awt.Color(0, 102, 102));
        totalHarga.setForeground(new java.awt.Color(255, 255, 255));
        totalHarga.setText("Total Harga Rp. 0");
        totalHarga.setSelectionColor(new java.awt.Color(255, 255, 255));
        totalHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalHargaActionPerformed(evt);
            }
        });

        logOut.setBackground(new java.awt.Color(0, 102, 102));
        logOut.setFont(new java.awt.Font("Montserrat Black", 0, 14)); // NOI18N
        logOut.setForeground(new java.awt.Color(242, 242, 242));
        logOut.setText("Logout");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });

        cetakStruk.setBackground(new java.awt.Color(0, 102, 102));
        cetakStruk.setFont(new java.awt.Font("Montserrat Black", 0, 14)); // NOI18N
        cetakStruk.setForeground(new java.awt.Color(242, 242, 242));
        cetakStruk.setText("Cetak Struk");
        cetakStruk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakStrukActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Montserrat Black", 0, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(242, 242, 242));
        jLabel15.setText("Menu Kasir");

        jLabel16.setFont(new java.awt.Font("Montserrat Black", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(242, 242, 242));
        jLabel16.setText("List Obat");

        jLabel17.setFont(new java.awt.Font("Montserrat Black", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(242, 242, 242));
        jLabel17.setText("Kuantitas");

        jLabel18.setFont(new java.awt.Font("Montserrat Black", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(242, 242, 242));
        jLabel18.setText("Obat Terpilih:");

        jLabel19.setFont(new java.awt.Font("Montserrat Black", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(242, 242, 242));
        jLabel19.setText("Jumlah Uang:");

        jLabel20.setFont(new java.awt.Font("Montserrat Black", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(242, 242, 242));
        jLabel20.setText("Kembalian:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOut)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cetakStruk))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(hitung, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jenisObat, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tambahKeTerpilih)
                                    .addComponent(jLabel17))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))))))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jLabel20))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(181, Short.MAX_VALUE)
                    .addComponent(jLabel15)
                    .addGap(159, 159, 159)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 68, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jenisObat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(kuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(tambahKeTerpilih)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hitung)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(totalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addComponent(cetakStruk, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel15)
                    .addContainerGap(346, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembalianActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        // TODO add your handling code here:
        try {
            int uang = Integer.parseInt(jumlah.getText());
            int kembalianUang = uang - totalHargaSemua;
            if (kembalianUang < 0) {
                JOptionPane.showMessageDialog(this, "Uang tidak cukup!");
            } else {
                kembalian.setText("Rp. " + kembalianUang);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan jumlah uang yang valid!");
        }
    }//GEN-LAST:event_hitungActionPerformed

    private void totalHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalHargaActionPerformed

    private void jenisObatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisObatActionPerformed
        // TODO add your handling code here:
        String selectedJenis = (String) jenisObat.getSelectedItem();
        loadListObat(selectedJenis);
    }//GEN-LAST:event_jenisObatActionPerformed

    private void tambahKeTerpilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahKeTerpilihActionPerformed
        // TODO add your handling code here:
        String selectedObat = listObat.getSelectedValue();
        int qty;
        try {
            qty = Integer.parseInt(kuantitas.getText());
            if (selectedObat == null || qty <= 0) {
                JOptionPane.showMessageDialog(this, "Pilih obat dan masukkan kuantitas yang valid!");
                return;
            }
            int hargaSatuan = hargaObatMap.get(selectedObat);
            int subtotal = hargaSatuan * qty;
            totalHargaSemua += subtotal;

            modelListObatDipilih.addElement(selectedObat + " - " + qty + " x " + hargaSatuan + " = " + subtotal);
            totalHarga.setText("Total Harga Rp. " + totalHargaSemua);
            kuantitas.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Kuantitas harus berupa angka!");
        }
    }//GEN-LAST:event_tambahKeTerpilihActionPerformed

    private void kuantitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kuantitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kuantitasActionPerformed

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        // TODO add your handling code here:
        Login loginFrame = new Login();
        loginFrame.setVisible(true);
        loginFrame.pack(); // Sesuaikan ukuran frame
        loginFrame.setLocationRelativeTo(null); // Tempatkan di tengah layar

        // Tutup jendela saat ini
        this.dispose();
    }//GEN-LAST:event_logOutActionPerformed

    private void cetakStrukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakStrukActionPerformed
        // TODO add your handling code here:
    // Membuat header struk
    StringBuilder struk = new StringBuilder();
    struk.append("========== STRUK PEMBELIAN ==========\n");
    
    // Menambahkan informasi obat yang dipilih
    for (int i = 0; i < modelListObatDipilih.size(); i++) {
        struk.append(modelListObatDipilih.getElementAt(i)).append("\n");
    }

    // Menambahkan total harga
    struk.append("-------------------------------------\n");
    struk.append("Total Harga      : Rp. " + totalHargaSemua + "\n");
    
    // Mengambil tanggal dari JDateChooser
    java.util.Date selectedDate = tanggal.getDate(); // Mengambil tanggal yang dipilih
    if (selectedDate != null) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = sdf.format(selectedDate); // Format tanggal menjadi string
        struk.append("Tanggal          : " + formattedDate + "\n");
    } else {
        struk.append("Tanggal          : Tidak Diketahui\n"); // Jika tidak ada tanggal yang dipilih
    }

    // Menambahkan jumlah uang yang dibayar
    try {
        int uangDibayar = Integer.parseInt(jumlah.getText()); // Mengambil jumlah uang dari JTextField
        struk.append("Jumlah Uang      : Rp. " + uangDibayar + "\n"); // Menambahkan jumlah uang pada struk

        // Menghitung kembalian
        int kembalianUang = uangDibayar - totalHargaSemua;
        if (kembalianUang < 0) {
            JOptionPane.showMessageDialog(this, "Uang tidak cukup!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            struk.append("Kembalian        : Rp. " + kembalianUang + "\n"); // Menambahkan kembalian
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Masukkan jumlah uang yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Menambahkan pesan terima kasih
    struk.append("====================================\n");
    struk.append("Terima kasih atas pembelian Anda!\n");
    
    // Menampilkan struk dalam bentuk JOptionPane
    JOptionPane.showMessageDialog(this, struk.toString(), "Struk Pembelian", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_cetakStrukActionPerformed

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
            java.util.logging.Logger.getLogger(TokoObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TokoObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TokoObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TokoObat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TokoObat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetakStruk;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jenisObat;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField kuantitas;
    private javax.swing.JList<String> listObat;
    private javax.swing.JList<String> listObatDipilih;
    private javax.swing.JButton logOut;
    private javax.swing.JButton tambahKeTerpilih;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTextField totalHarga;
    // End of variables declaration//GEN-END:variables
}
