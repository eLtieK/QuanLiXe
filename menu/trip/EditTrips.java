/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu.trip;

import menu.vehicle.TableVehicles;
import menu.driver.Table;
import menu.driver.EditDrivers;
import database.Drivers;
import database.Manager;
import database.Trips;
import database.Vehicles;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import menu.menu;

/**
 *
 * @author User
 */
public class EditTrips extends javax.swing.JFrame {

    /**
     * Creates new form EditTrips
     */
    public EditTrips() {
        initComponents();
        str1 = "Ho_Chi_Minh";
        str2 = "Ha_Noi";
        this.setTitle("EDIT TRIPS");
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
        jLabel8 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        IDvehicle = new javax.swing.JTextField();
        IDdriver = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        DateStart = new javax.swing.JTextField();
        TimeStart = new javax.swing.JTextField();
        CbStart = new javax.swing.JComboBox<>();
        CbEnd = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(750, 500));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("SVN-Bear", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Back");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 443, 80, 40));

        jButton4.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jButton4.setText("Help");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, -1, -1));

        jButton6.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jButton6.setText("List of Trip");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 150, 30));

        IDvehicle.setBackground(new java.awt.Color(204, 204, 204));
        IDvehicle.setForeground(new java.awt.Color(51, 51, 51));
        IDvehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDvehicleActionPerformed(evt);
            }
        });
        jPanel1.add(IDvehicle, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 110, 30));

        IDdriver.setBackground(new java.awt.Color(204, 204, 204));
        IDdriver.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(IDdriver, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 110, 30));

        ID.setBackground(new java.awt.Color(204, 204, 204));
        ID.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 106, -1));

        jLabel7.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("ID :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 30, -1));

        jButton5.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jButton5.setText("Get More Data From ID");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 220, 30));

        jLabel1.setFont(new java.awt.Font("SVN-Bear", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Edit Trips");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 130, -1));

        jLabel2.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Date start :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 80, 30));

        jLabel3.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Time start :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 90, 30));

        jLabel4.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Starting location :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jLabel5.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Ending location :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("ID of Vehicle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 150, 40));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("ID of Driver");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 150, 40));

        Save.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jPanel1.add(Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 90, 30));

        DateStart.setBackground(new java.awt.Color(204, 204, 204));
        DateStart.setForeground(new java.awt.Color(51, 51, 51));
        DateStart.setText("yyyy-MM-dd");
        DateStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DateStartMouseClicked(evt);
            }
        });
        jPanel1.add(DateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 106, -1));

        TimeStart.setBackground(new java.awt.Color(204, 204, 204));
        TimeStart.setForeground(new java.awt.Color(51, 51, 51));
        TimeStart.setText("HH:mm:ss");
        TimeStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimeStartMouseClicked(evt);
            }
        });
        TimeStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeStartActionPerformed(evt);
            }
        });
        jPanel1.add(TimeStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 106, -1));

        CbStart.setBackground(new java.awt.Color(204, 204, 204));
        CbStart.setForeground(new java.awt.Color(51, 51, 51));
        CbStart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ho_Chi_Minh", "Ha_Noi", "Da_Nang", "Hue", "Can_Tho", "Hai_Phong" }));
        CbStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbStartActionPerformed(evt);
            }
        });
        jPanel1.add(CbStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 273, -1, -1));

        CbEnd.setBackground(new java.awt.Color(204, 204, 204));
        CbEnd.setForeground(new java.awt.Color(51, 51, 51));
        CbEnd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ha_Noi", "Ho_Chi_Minh", "Da_Nang", "Hue", "Can_Tho", "Hai_Phong" }));
        CbEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbEndActionPerformed(evt);
            }
        });
        jPanel1.add(CbEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 110, -1));

        jLabel6.setFont(new java.awt.Font("SVN-Bear", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon("E:\\HocTap\\QuanLiXe\\app\\src\\main\\resources\\icon\\—Pngtree—spring fresh nature graduation travel_909912 (1).jpg")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 500));

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
    String str1, str2;

    private void TimeStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeStartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeStartActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TableVehicles tableVe;
        try {
            tableVe = new TableVehicles();
            tableVe.setVisible(true);
            tableVe.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        try {
            Table tableDriver;
            tableDriver = new Table();
            tableDriver.setVisible(true);
            tableDriver.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed
    public void resetCB() {
        CbStart.setSelectedIndex(0);
        CbEnd.setSelectedIndex(0);
    }

    public boolean checkForm() {
        if (ID.getText().isEmpty() || DateStart.getText().isEmpty() || TimeStart.getText().isEmpty() || IDvehicle.getText().isEmpty() || IDdriver.getText().isEmpty()) {
            return true;
        }
        return false;
    }

    public void reset() {
        ID.setText("");
        DateStart.setText("yyyy-MM-dd");
        TimeStart.setText("HH:mm:ss");
        CbStart.setSelectedIndex(0);
        CbEnd.setSelectedIndex(0);
        IDvehicle.setText("");
        IDdriver.setText("");
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
    private void CbEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbEndActionPerformed
        // TODO add your handling code here:
        str2 = String.valueOf(CbEnd.getSelectedItem());
        if (str1 == str2) {
            JOptionPane.showMessageDialog(this, "The starting and ending points cannot be the same location !", "ERROR", JOptionPane.ERROR_MESSAGE);
            resetCB();
        }
    }//GEN-LAST:event_CbEndActionPerformed

    private void CbStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbStartActionPerformed
        // TODO add your handling code here:
        str1 = String.valueOf(CbStart.getSelectedItem());
        if (str1 == str2) {
            JOptionPane.showMessageDialog(this, "The starting and ending points cannot be the same location !", "ERROR", JOptionPane.ERROR_MESSAGE);
            resetCB();
        }
    }//GEN-LAST:event_CbStartActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if ("".equals(ID.getText()) || !checkSo(ID.getText())) {
                JOptionPane.showMessageDialog(this, "Invalid input");
                return;
            }
            int id = Integer.parseInt(ID.getText());
            if (!Manager.checkValidTrip(id)) {
                JOptionPane.showMessageDialog(this, "Trip not available");
                return;
            }
            Trips trip = Manager.getTrip(id);
            DateStart.setText(trip.getDateStart());
            TimeStart.setText(trip.getTimeStart());
            CbStart.setSelectedIndex(Trips.index_destination_start(trip.getDestination_start()));
            CbEnd.setSelectedIndex(Trips.index_destination_end(trip.getDestination_end()));
            IDdriver.setText(String.valueOf(trip.getDriverId()));
            IDvehicle.setText(String.valueOf(trip.getVehicleId()));
        } catch (Exception ex) {
            Logger.getLogger(EditDrivers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void IDvehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDvehicleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDvehicleActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            TableTrips tabletrips = new TableTrips();
            tabletrips.setVisible(true);
            tabletrips.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    public boolean checkID(int DriverID, int VehicleID) throws Exception {
        return Manager.checkValidDriver(DriverID) && Manager.checkValidVehicle(VehicleID);
    }

    public boolean checkInTrip(int DriverID, int VehicleID) {
        return Manager.checkDriverInTrip(DriverID) || Manager.checkVehicleInTrip(VehicleID);
    }

    public boolean checksuitable(int driverID, int vehicleID) throws Exception {
        Drivers driver = Manager.getDriver(driverID);
        Vehicles vehicle = Manager.getVehicle(vehicleID);
        return Trips.check_suitable(driver.getLicense(), vehicle.getType());
    }
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            if (checkForm()) {
                JOptionPane.showMessageDialog(this, "Please enter all the required information !");
                reset();
                return;
            } else if (!checkSo(ID.getText()) || !checkSo(IDdriver.getText()) || !checkSo(IDvehicle.getText())) {
                JOptionPane.showMessageDialog(this, "Please enter the correct format !");
                reset();
                return;
            }
            int id = Integer.parseInt(ID.getText());

            String date_start = DateStart.getText();
            String time_start = TimeStart.getText();
            Trips.Destination des_start = Trips.fromStringDestination(String.valueOf(CbStart.getSelectedItem()));
            Trips.Destination des_end = Trips.fromStringDestination(String.valueOf(CbEnd.getSelectedItem()));
            int driverId = Integer.parseInt(IDdriver.getText());
            int vehicleId = Integer.parseInt(IDvehicle.getText());

            if (!Manager.getTrip(id).is_trip_done()) {
                JOptionPane.showMessageDialog(this, "Trip is on_duty");
                reset();
                return;
            } else if (!checkID(driverId, vehicleId)) {
                JOptionPane.showMessageDialog(this, "ID not available !");
                reset();
                return;
            } else if (Manager.getVehicle(vehicleId).is_maintenance()) {
                JOptionPane.showMessageDialog(this, "Vehicle is under_maintenance");
                reset();
                return;
            } else if (checkInTrip(driverId, vehicleId)) {
                JOptionPane.showMessageDialog(this, "Vehicle or driver in another trip");
                reset();
                return;
            } else if (!checksuitable(driverId, vehicleId)) {
                JOptionPane.showMessageDialog(this, "Driver and Vehicle are not suitable!");
                reset();
                return;
            }
            Trips trip = Manager.getTrip(id);
            trip.set_up_waiting();

            trip.setDateStart(date_start);
            trip.setTimeStart(time_start);
            trip.setDesStart(des_start);
            trip.setDesEnd(des_end);

            trip.setDriverId(driverId);
            trip.setVehicleId(vehicleId);
            trip.set_up_in_trip();
            JOptionPane.showMessageDialog(this, "Saved successfully !");
            Manager.updateTrips();
            reset();
        } catch (Exception ex) {
            Logger.getLogger(EditDrivers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Help help = new Help();
        help.setVisible(true);
        help.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void DateStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DateStartMouseClicked
        // TODO add your handling code here:
        DateStart.setText("");
    }//GEN-LAST:event_DateStartMouseClicked

    private void TimeStartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimeStartMouseClicked
        // TODO add your handling code here:
        TimeStart.setText("");
    }//GEN-LAST:event_TimeStartMouseClicked

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
            java.util.logging.Logger.getLogger(EditTrips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditTrips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditTrips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditTrips.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditTrips().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbEnd;
    private javax.swing.JComboBox<String> CbStart;
    private javax.swing.JTextField DateStart;
    private javax.swing.JTextField ID;
    private javax.swing.JTextField IDdriver;
    private javax.swing.JTextField IDvehicle;
    private javax.swing.JButton Save;
    private javax.swing.JTextField TimeStart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
