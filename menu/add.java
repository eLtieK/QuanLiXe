/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package menu;
import database.Drivers;
import database.Manager;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class add extends javax.swing.JFrame {
    /**
     * Creates new form add
     */DefaultTableModel model;
    public add() {
        initComponents();
         model = (DefaultTableModel)Table.getModel();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Luu = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        BangCapjComboBox = new javax.swing.JComboBox<>();
        KinhNghiemjComboBox = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        Tuoi = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(146, 199, 207));
        jPanel1.setForeground(new java.awt.Color(251, 249, 241));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SVN-Anastasia", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Thêm mới đội xe");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 41, -1, 44));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tên tài xế : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 105, 149, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Bằng cấp tài xế :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 166, 149, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Kinh nghiệm tài xế :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 232, 149, -1));

        Name.setBackground(new java.awt.Color(204, 204, 204));
        Name.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 103, 177, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Loại xe :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 302, 149, -1));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 51, 102));
        jButton1.setText("Danh sách các tài xế của nhà xe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 418, -1, -1));

        Luu.setBackground(new java.awt.Color(51, 255, 255));
        Luu.setForeground(new java.awt.Color(255, 51, 51));
        Luu.setText("Lưu ");
        Luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LuuActionPerformed(evt);
            }
        });
        jPanel1.add(Luu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 365, -1, -1));

        Reset.setBackground(new java.awt.Color(255, 102, 102));
        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        jPanel1.add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 365, -1, -1));

        BangCapjComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A1", "A2", "A3", "A4", "A5", " " }));
        jPanel1.add(BangCapjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 164, -1, -1));

        KinhNghiemjComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lựa chọn 1", "Lựa chọn 2", "Lựa chọn 3", "Lựa chọn 4" }));
        jPanel1.add(KinhNghiemjComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 230, -1, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 300, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Số Tuổi :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(444, 105, 62, -1));

        Tuoi.setBackground(new java.awt.Color(204, 204, 204));
        Tuoi.setText(" ");
        jPanel1.add(Tuoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 103, 102, -1));

        jButton4.setText("Trở Lại");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 432, -1, -1));

        Table.setBackground(new java.awt.Color(204, 204, 204));
        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên Tài Xế", "Bằng Cấp", "Kinh Nghiệm", "Số Tuối"
            }
        ));
        jScrollPane1.setViewportView(Table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 499, 195));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/taxi-7422084_1280.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
        Name.setText("");
        BangCapjComboBox.setSelectedIndex(0);
        KinhNghiemjComboBox.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        Tuoi.setText("");
    }//GEN-LAST:event_ResetActionPerformed
    public  boolean validataForm(){
        if (Name.getText().isEmpty() || Tuoi.getText().isEmpty())
        {return false;}
        return true;
    }
    
    public Drivers getModel (){
        String name = Name.getText();
        String license = String.valueOf(BangCapjComboBox.getSelectedItem());
        int experiences = Integer.valueOf(KinhNghiemjComboBox.getSelectedItem().toString());
        Drivers Tx = new Drivers(name, "0123456789", "tphcm", Drivers.fromStringLicense(license), experiences, Manager.getNumOfDrivers());
        return Tx;
    }
    private void LuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LuuActionPerformed
        // TODO add your handling code here:
        if (validataForm()){
        String name = Name.getText();
        String license = String.valueOf(BangCapjComboBox.getSelectedItem());
        int experiences = Integer.valueOf(KinhNghiemjComboBox.getSelectedItem().toString());
        Drivers Tx = new Drivers(name, "0123456789", "tphcm", Drivers.fromStringLicense(license), experiences, Manager.getNumOfDrivers());
//        try{
//            
//        }
        }
        
        else {
            JOptionPane.showMessageDialog(this, "Hãy nhập đầy đủ thông tin","Thông Báo",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_LuuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Menu menuFrame = new Menu();
        menuFrame.setVisible(true);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> BangCapjComboBox;
    private javax.swing.JComboBox<String> KinhNghiemjComboBox;
    private javax.swing.JButton Luu;
    private javax.swing.JTextField Name;
    private javax.swing.JButton Reset;
    private javax.swing.JTable Table;
    private javax.swing.JTextField Tuoi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}