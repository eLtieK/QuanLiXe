/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu.vehicle;

import menu.driver.EditDrivers;
import database.Manager;
import database.Vehicles;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import menu.menu;

/**
 *
 * @author User
 */
public class EditVehicles extends javax.swing.JFrame {

    /**
     * Creates new form EditVehicles
     */
    public EditVehicles() {
        initComponents();
        this.setTitle("EDIT VEHICLES");
        Enter();
    }

    public void Enter() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    save();
                }
            }
        });
        this.setFocusable(true);
        this.requestFocus();
        ID.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    save();
                }
            }
        });
        Size.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    save();
                }
            }
        });
        Weight.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    save();
                }
            }
        });
        TypeBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    save();
                }
            }
        });
        FuelBox.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    save();
                }
            }
        });
        jButton3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    save();
                }
            }
        });
    }

    public boolean checkForm() {
        if (ID.getText().isEmpty() || Weight.getText().isEmpty() || Size.getText().isEmpty()) {
            return true;
        }
        return false;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        Size = new javax.swing.JTextField();
        Weight = new javax.swing.JTextField();
        TypeBox = new javax.swing.JComboBox<>();
        FuelBox = new javax.swing.JComboBox<>();
        Save = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel9.setText("Back");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jLabel9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel9KeyPressed(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jButton4.setFont(new java.awt.Font("SVN-Bear", 1, 18)); // NOI18N
        jButton4.setText("List of Vehicles");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, 140, 30));

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("SVN-Bear", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Get Data From ID");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 176, 160, 40));

        jLabel1.setFont(new java.awt.Font("SVN-Bear", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Edit Vehicles");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("ID :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel3.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Type :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Weight :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, 50));

        jLabel5.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Size :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, 20));

        jLabel6.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Fuel :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, -1, -1));

        ID.setBackground(new java.awt.Color(204, 204, 204));
        ID.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 60, 30));

        Size.setBackground(new java.awt.Color(204, 204, 204));
        Size.setForeground(new java.awt.Color(0, 0, 0));
        Size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SizeActionPerformed(evt);
            }
        });
        jPanel1.add(Size, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 133, 30));

        Weight.setBackground(new java.awt.Color(204, 204, 204));
        Weight.setForeground(new java.awt.Color(0, 0, 0));
        Weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WeightActionPerformed(evt);
            }
        });
        jPanel1.add(Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 250, 133, 30));

        TypeBox.setBackground(new java.awt.Color(204, 204, 204));
        TypeBox.setFont(new java.awt.Font("SVN-Bear", 1, 18)); // NOI18N
        TypeBox.setForeground(new java.awt.Color(0, 0, 0));
        TypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Truck", "Coach", "Car", "Container" }));
        jPanel1.add(TypeBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        FuelBox.setBackground(new java.awt.Color(204, 204, 204));
        FuelBox.setFont(new java.awt.Font("SVN-Bear", 1, 18)); // NOI18N
        FuelBox.setForeground(new java.awt.Color(0, 0, 0));
        FuelBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Diesel", "Gasoline", "Ethanol" }));
        jPanel1.add(FuelBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, -1));

        Save.setFont(new java.awt.Font("SVN-Bear", 1, 18)); // NOI18N
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel1.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 80, 30));

        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setIcon(new javax.swing.ImageIcon("E:\\HocTap\\QuanLiXe\\app\\src\\main\\resources\\icon\\—Pngtree—las vegas_534391 (1).jpg")); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 490));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void WeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WeightActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        TableVehicles tableVe;
        try {
            tableVe = new TableVehicles();
            tableVe.setVisible(true);
            tableVe.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if ("".equals(ID.getText()) || !checkSo(ID.getText())) {
                JOptionPane.showMessageDialog(this, "Invalid input");
                return;
            }
            int id = Integer.parseInt(ID.getText());
            if (!Manager.checkValidVehicle(id)) {
                JOptionPane.showMessageDialog(this, "Vehicle not available");
                return;
            }
            Vehicles vehicle = Manager.getVehicle(id);
            Weight.setText(String.valueOf(vehicle.getWeight()));
            Size.setText(String.valueOf(vehicle.getSize()));
            TypeBox.setSelectedIndex(Vehicles.index_type(vehicle.getType()));
            FuelBox.setSelectedIndex(Vehicles.index_fuel(vehicle.getFuel()));
        } catch (Exception ex) {
            Logger.getLogger(EditDrivers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void SizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SizeActionPerformed
    public void reset() {
        Weight.setText("");
        Size.setText("");
        TypeBox.setSelectedIndex(0);
        FuelBox.setSelectedIndex(0);
        ID.setText("");
    }
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_SaveActionPerformed
    public void save() {
        try {
            // TODO add your handling code here:
            if (checkForm()) {
                JOptionPane.showMessageDialog(this, "Please enter all the required information !");
                reset();
                return;
            } else if (!checkSo(ID.getText()) || !checkSo(Weight.getText()) || !checkSo(Size.getText())) {
                JOptionPane.showMessageDialog(this, "Please enter the correct format !");
                reset();
                return;
            }
            int id = Integer.parseInt(ID.getText());

            int weight = Integer.parseInt(Weight.getText());
            int size = Integer.parseInt(Size.getText());
            String type = String.valueOf(TypeBox.getSelectedItem());
            String fuel = String.valueOf(FuelBox.getSelectedItem());
            if (!Manager.checkValidVehicle(id)) {
                JOptionPane.showMessageDialog(this, "Vehicle not available !");
                reset();
                return;
            } else if (Manager.checkVehicleInTrip(id)) {
                JOptionPane.showMessageDialog(this, "Vehicle in trip");
                reset();
                return;
            }
            Vehicles vehicle = Manager.getVehicle(id);
            vehicle.setSize(size);
            vehicle.setWeight(weight);
            vehicle.setFuel(fuel);
            vehicle.setType(type);
            Manager.updateVehicles();
            JOptionPane.showMessageDialog(this, "Successfully saved !");
            reset();
        } catch (Exception ex) {
            Logger.getLogger(EditDrivers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jLabel9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel9KeyPressed
        // TODO add your handling code here:
        menu menuFrame = new menu();
        menuFrame.setVisible(true);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel9KeyPressed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        menu menuFrame = new menu();
        menuFrame.setVisible(true);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

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
            java.util.logging.Logger.getLogger(EditVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditVehicles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditVehicles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> FuelBox;
    private javax.swing.JTextField ID;
    private javax.swing.JButton Save;
    private javax.swing.JTextField Size;
    private javax.swing.JComboBox<String> TypeBox;
    private javax.swing.JTextField Weight;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
