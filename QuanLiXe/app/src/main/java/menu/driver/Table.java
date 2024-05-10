/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu.driver;

import database.Drivers;
import database.Manager;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author User
 */
public class Table extends javax.swing.JFrame {

    /**
     * Creates new form Table
     */
    DefaultTableModel model = new DefaultTableModel();
    public void showAll() throws Exception {
        for (Map.Entry<String, Drivers> entry : Manager.getFirebase().driversManager.entrySet()) {
            Drivers driver = entry.getValue();
            Manager.readDriver(driver);
            model.addRow(new Object[]{
                driver.getId(), driver.getName(), driver.getLicense().toString(), driver.getExperiences(), driver.getStatus().toString(), driver.getPhonenumber(), driver.getAddress(), driver.getPerformance()
            });
        }
    }
   
    public void reset() {
        model.setRowCount(0);
    }

    public Table() throws Exception {
        initComponents();
        model = (DefaultTableModel) TableDrivers.getModel();
        model.setRowCount(0);
        showAll();
        TableDrivers.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDrivers = new javax.swing.JTable();
        Delete = new javax.swing.JButton();
        InputID = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableDrivers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "License", "Experiences", "Status", "Phone Number", "Address"
            }
        ));
        TableDrivers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDriversMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableDrivers);

        Delete.setText("Delete");
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        InputID.setText("Input ID");
        InputID.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InputIDMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                InputIDMouseExited(evt);
            }
        });
        InputID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputIDActionPerformed(evt);
            }
        });

        jButton4.setText("Reset");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("More Information");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Search");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(InputID, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Delete)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(31, 31, 31)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Delete)
                    .addComponent(InputID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableDriversMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDriversMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_TableDriversMouseClicked

    private void InputIDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputIDMouseClicked
        InputID.setText("");
    }//GEN-LAST:event_InputIDMouseClicked

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed

    }//GEN-LAST:event_DeleteActionPerformed
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

    public void resetText() {
        InputID.setText("Input ID");
    }

    public boolean showDeleteMess() {
        int choice = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to delete this driver?",
                "Delete",
                JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }
    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked
        // TODO add your handling code here:
        if ("".equals(InputID.getText()) || !checkSo(InputID.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid input");
            resetText();
            return;
        }
        try {
            // TODO add your handling code here:

            int driver_id = Integer.parseInt(InputID.getText());
            if (Manager.checkDriverInTrip(driver_id)) {
                JOptionPane.showMessageDialog(this, "Driver in trip");
                resetText();
                return;
            } else if (!Manager.checkValidDriver(driver_id)) {
                JOptionPane.showMessageDialog(this, "Driver not available");
                resetText();
                return;
            }
            Drivers driver = Manager.getDriver(driver_id);
            if (showDeleteMess()) {
                Manager.removeDriver(driver);
            }
            reset();
            showAll();
            resetText();
        } catch (Exception ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_DeleteMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            // TODO add your handling code here:
            reset();
            showAll();
            resetText();
        } catch (Exception ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    public void showDriver(Drivers driver) {
        model.addRow(new Object[]{
            driver.getId(), driver.getName(), driver.getLicense().toString(), driver.getExperiences(), driver.getStatus().toString(), driver.getPhonenumber(), driver.getAddress(), driver.getPerformance()
        });
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if ("".equals(InputID.getText()) || !checkSo(InputID.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid input");
            resetText();
            return;
        }
        try {
            // TODO add your handling code here:
            int driver_id = Integer.parseInt(InputID.getText());
            if (!Manager.checkValidDriver(driver_id)) {
                JOptionPane.showMessageDialog(this, "Driver not available");
                resetText();
                return;
            }
            Drivers driver = Manager.getDriver(driver_id);
            reset();
            showDriver(driver);
            resetText();
        } catch (Exception ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void InputIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputIDActionPerformed

    private void InputIDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InputIDMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_InputIDMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if ("".equals(InputID.getText()) || !checkSo(InputID.getText())) {
            JOptionPane.showMessageDialog(this, "Invalid input");
            resetText();
            return;
        }
        try {
            // TODO add your handling code here:
            int driver_id = Integer.parseInt(InputID.getText());
            if (!Manager.checkValidDriver(driver_id)) {
                JOptionPane.showMessageDialog(this, "Driver not available");
                resetText();
                return;
            }
            MoreInformationDrivers informationDriver = new MoreInformationDrivers(driver_id);
            informationDriver.setVisible(true);
            informationDriver.setLocationRelativeTo(null);
            resetText();
        } catch (Exception ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Table().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete;
    private javax.swing.JTextField InputID;
    private javax.swing.JTable TableDrivers;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

   
}
