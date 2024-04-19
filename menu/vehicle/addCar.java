/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu.vehicle;

import menu.driver.add;
import database.Drivers;
import database.Manager;
import database.Vehicles;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import menu.menu;

/**
 *
 * @author User
 */
public class addCar extends javax.swing.JFrame {

    /**
     * Creates new form addCar
     */
    public addCar() {
        initComponents();

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
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Weight = new javax.swing.JTextField();
        Size = new javax.swing.JTextField();
        TypeBox = new javax.swing.JComboBox<>();
        FuelBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 244, 197));
        jPanel1.setForeground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("SVN-Bear", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Back");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI Black", 3, 14)); // NOI18N
        jButton3.setText("List of Vehicles");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 160, -1));

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel1.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel1.setFont(new java.awt.Font("SVN-Bear", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Add Vehicles");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Fuel :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, -1, -1));

        jLabel3.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Type :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Weight :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Size :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        Weight.setBackground(new java.awt.Color(204, 204, 204));
        Weight.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 175, -1));

        Size.setBackground(new java.awt.Color(204, 204, 204));
        Size.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(Size, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 175, -1));

        TypeBox.setBackground(new java.awt.Color(204, 204, 204));
        TypeBox.setForeground(new java.awt.Color(0, 0, 0));
        TypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Truck", "Coach", "Car", "Container" }));
        TypeBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeBoxActionPerformed(evt);
            }
        });
        jPanel1.add(TypeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, -1, -1));

        FuelBox.setBackground(new java.awt.Color(204, 204, 204));
        FuelBox.setForeground(new java.awt.Color(0, 0, 0));
        FuelBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diesel", "Gasoline", "Ethanol" }));
        FuelBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FuelBoxActionPerformed(evt);
            }
        });
        jPanel1.add(FuelBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 90, -1));

        jLabel6.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("E:\\HocTap\\QuanLiXe\\app\\src\\main\\resources\\icon\\—Pngtree—las vegas_534391 (1).jpg")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   public boolean validataForm() {
        if (!checkSo(Weight.getText()) || !checkSo(Size.getText())) {
            return false;
        }
        return true;
    }

    public boolean checkSo(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public void reset() {
        Weight.setText("");
        FuelBox.setSelectedIndex(0);
        TypeBox.setSelectedIndex(0);
        Size.setText("");
    }
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        if (validataForm()) {
            try {
                Manager manager = Manager.getInstance();
                int weight = Integer.parseInt(Weight.getText());
                int size = Integer.parseInt(Size.getText());
                Vehicles.Type type = Vehicles.fromStringType(String.valueOf(TypeBox.getSelectedItem()));
                Vehicles.Fuel fuel = Vehicles.fromStringFuel(String.valueOf(FuelBox.getSelectedItem()));

                Vehicles vehicle = new Vehicles(weight, size, fuel, type, Manager.getNewVehicleId());
                Manager.addVehicle(vehicle);
                reset();
                JOptionPane.showMessageDialog(this, "Information saved successfully !");
            } catch (IOException ex) {
                Logger.getLogger(add.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please enter the correct and complete fields !");
        }

    }//GEN-LAST:event_SaveActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        TableVehicles tableVehicles;
        try {
            tableVehicles = new TableVehicles();
            tableVehicles.setVisible(true);
            tableVehicles.pack();
            tableVehicles.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(addCar.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void TypeBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeBoxActionPerformed

    private void FuelBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FuelBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FuelBoxActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        menu menuFrame = new menu();
        menuFrame.setVisible(true);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(addCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> FuelBox;
    private javax.swing.JButton Save;
    private javax.swing.JTextField Size;
    private javax.swing.JComboBox<String> TypeBox;
    private javax.swing.JTextField Weight;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
