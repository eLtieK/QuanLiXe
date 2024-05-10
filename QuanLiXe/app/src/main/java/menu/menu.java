/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu;

import database.Drivers;
import menu.trip.TableTrips;
import menu.trip.OnTrip;
import menu.trip.EditTrips;
import menu.trip.addTrips;
import menu.vehicle.addCar;
import menu.vehicle.TableVehicles;
import menu.vehicle.EditVehicles;
import menu.driver.Table;
import menu.driver.EditDrivers;
import menu.driver.add;
import database.Manager;
import database.Schedule;
import database.Trips;
import database.Vehicles;
import java.awt.Frame;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import menu.driver.OnLeave;
import menu.driver.OnLeaveDone;
import menu.vehicle.Maintenance;
import menu.vehicle.MaintenanceDone;

/**
 *
 * @author User
 */
public class menu extends javax.swing.JFrame {

    /**
     * Creates new form menu
     */
    // ADD
    public menu() {
        initComponents();
        this.setTitle("MENU");
        RunTime();
        if (!firstmenu) {
            firstmenu = true;
            check_map_trip_on_duty();
            check_map_vehicle_maitenance();
            check_map_driver_leave();
        }
    }

    public boolean Exit() {
        int choice = JOptionPane.showConfirmDialog(this,
                "Do you want to exit the application?",
                "Exit",
                JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }
    private static boolean firstmenu = false;

    public void RunTime() {
        Thread updateThread = new Thread(() -> {
            while (true) {
                try {
                    Time.setText(Schedule.get_now_time_string());
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        updateThread.start();
    }

    public void check_map_driver_leave() {
        for (Map.Entry<String, Drivers> entry : Manager.getFirebase().driversManager.entrySet()) {
            Drivers driver = entry.getValue();
            check_driver_start_leave(driver);
            check_driver_done_leave(driver);
        }
    }

    public void check_driver_done_leave(Drivers driver) {
        Thread updateThread = new Thread(() -> {
            while (true) {
                try {
                    if (driver.getDate_end().equals("0000-00-00 00:00:00")) {
                        break;
                    } else if (driver.chech_end()) {
                        OnLeaveDone onleavedone = new OnLeaveDone(driver.getId());
                        onleavedone.setVisible(true);
                        onleavedone.setLocationRelativeTo(null);
                        break;
                    }
                    Thread.sleep(5000);
                } catch (Exception ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        updateThread.start();
    }

    public void check_driver_start_leave(Drivers driver) {
        Thread updateThread = new Thread(() -> {
            while (true) {
                try {
                    if (driver.getDate_start().equals("0000-00-00 00:00:00")) {
                        break;
                    } else if (driver.getStatus().equals(Drivers.Status.not_available)) {
                        break;
                    } else if (driver.chech_start()) {
                        OnLeave onleave = new OnLeave(driver.getId());
                        onleave.setVisible(true);
                        onleave.setLocationRelativeTo(null);
                        break;
                    }
                    Thread.sleep(5000);
                } catch (Exception ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        updateThread.start();
    }

    public void check_map_vehicle_maitenance() {
        for (Map.Entry<String, Vehicles> entry : Manager.getFirebase().vehiclesManager.entrySet()) {
            Vehicles vehicle = entry.getValue();
            check_vehicle_start_maintenance(vehicle);
            check_vehicle_done_maintenance(vehicle);
        }
    }

    public void check_vehicle_done_maintenance(Vehicles vehicle) {
        Thread updateThread = new Thread(() -> {
            while (true) {
                try {
                    if (vehicle.getDate_end().equals("0000-00-00 00:00:00")) {
                        break;
                    } else if (vehicle.chech_end()) {
                        MaintenanceDone maintenance = new MaintenanceDone(vehicle.getId());
                        maintenance.setVisible(true);
                        maintenance.setLocationRelativeTo(null);
                        break;
                    }
                    Thread.sleep(5000);
                } catch (Exception ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        updateThread.start();
    }

    public void check_vehicle_start_maintenance(Vehicles vehicle) {
        Thread updateThread = new Thread(() -> {
            while (true) {
                try {
                    if (vehicle.getDate_start().equals("0000-00-00 00:00:00")) {
                        break;
                    } else if (vehicle.getStatus().equals(Vehicles.Status.under_maintenance)) {
                        break;
                    } else if (vehicle.chech_start()) {
                        Maintenance maintenance = new Maintenance(vehicle.getId());
                        maintenance.setVisible(true);
                        maintenance.setLocationRelativeTo(null);
                        break;
                    }
                    Thread.sleep(5000);
                } catch (Exception ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        updateThread.start();
    }

    public void check_map_trip_on_duty() {
        for (Map.Entry<String, Trips> entry : Manager.getFirebase().tripManager.entrySet()) {
            Trips trip = entry.getValue();
            check_trip_on_duty(trip);
        }
    }

    public void check_trip_on_duty(Trips trip) {
        Thread updateThread = new Thread(() -> {
            while (true) {
                try {
                    if (trip.trip_on_ready()) {
                        OnTrip on_trip = new OnTrip(trip.getId());
                        on_trip.setVisible(true);
                        on_trip.setLocationRelativeTo(null);
                        break;
                    }
                    if (trip.is_done()) {
                        break;
                    }
                    Thread.sleep(5000);
                } catch (Exception ex) {
                    Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        updateThread.start();
    }

    // Phương thức mở menu
    // đóng menu 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        Time = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(65, 176, 110));

        jPanel2.setBackground(new java.awt.Color(255, 245, 224));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 50)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(20, 30, 70));
        jLabel1.setText("WELCOME");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 92, -1, 56));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(75, 82, 126));
        jLabel2.setText("VEHILCLE MANAGEMENT APPLICATION");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 154, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(75, 82, 126));
        jLabel8.setText("HAVE A GOOD DAY !");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 179, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("E:\\HocTap\\QuanLiXe\\app\\src\\main\\resources\\icon\\—Pngtree—golf photography_253750 (1).jpg")); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 430));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 245, 224));
        jLabel3.setText("MENU");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 245, 224));
        jLabel4.setText("     Drivers");

        jButton1.setBackground(new java.awt.Color(255, 245, 224));
        jButton1.setForeground(new java.awt.Color(20, 30, 70));
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 245, 224));
        jButton2.setForeground(new java.awt.Color(20, 30, 70));
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 245, 224));
        jButton3.setForeground(new java.awt.Color(20, 30, 70));
        jButton3.setText("Information");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 245, 224));
        jLabel6.setText("    Vehicles");

        jButton4.setBackground(new java.awt.Color(255, 245, 224));
        jButton4.setForeground(new java.awt.Color(20, 30, 70));
        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 245, 224));
        jButton5.setForeground(new java.awt.Color(20, 30, 70));
        jButton5.setText("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 245, 224));
        jButton6.setForeground(new java.awt.Color(20, 30, 70));
        jButton6.setText("Information");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 245, 224));
        jLabel7.setText("      Trips");

        jButton7.setBackground(new java.awt.Color(255, 245, 224));
        jButton7.setForeground(new java.awt.Color(20, 30, 70));
        jButton7.setText("Add");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 245, 224));
        jButton8.setForeground(new java.awt.Color(20, 30, 70));
        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(255, 245, 224));
        jButton9.setForeground(new java.awt.Color(20, 30, 70));
        jButton9.setText("Information");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setBackground(new java.awt.Color(255, 245, 224));
        jButton10.setForeground(new java.awt.Color(20, 30, 70));
        jButton10.setText("Log Out");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        Exit.setBackground(new java.awt.Color(255, 245, 224));
        Exit.setForeground(new java.awt.Color(20, 30, 70));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        Time.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        Time.setForeground(new java.awt.Color(255, 245, 224));
        Time.setText("2024-04-19 22:00:00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Time)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Time))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Exit)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(jButton1)
                        .addGap(0, 0, 0)
                        .addComponent(jButton2)
                        .addGap(0, 0, 0)
                        .addComponent(jButton3)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(jButton4)
                        .addGap(0, 0, 0)
                        .addComponent(jButton5)
                        .addGap(0, 0, 0)
                        .addComponent(jButton6)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(jButton7)
                        .addGap(0, 0, 0)
                        .addComponent(jButton8)
                        .addGap(0, 0, 0)
                        .addComponent(jButton9))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        if (Exit()) {
            Frame[] frames = Frame.getFrames();
            for (Frame frame : frames) {
                if (frame instanceof JFrame) {
                    ((JFrame) frame).dispose();
                }
            }
        }
    }//GEN-LAST:event_ExitActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        Frame[] frames = Frame.getFrames();
        for (Frame frame : frames) {
            if (frame instanceof JFrame) {
                ((JFrame) frame).dispose();
            }
        }

        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            // TODO add your handling code here:
            TableTrips tabletrips = new TableTrips();
            tabletrips.setVisible(true);
            tabletrips.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        EditTrips editTrips = new EditTrips();
        editTrips.setVisible(true);
        editTrips.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        addTrips addtrips = new addTrips();
        addtrips.setVisible(true);
        addtrips.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        TableVehicles tableVe;
        try {
            tableVe = new TableVehicles();
            tableVe.setVisible(true);
            tableVe.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        EditVehicles editcar = new EditVehicles();
        editcar.setVisible(true);
        editcar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        addCar addcar = new addCar();
        addcar.setVisible(true);
        addcar.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        try {
            Table tableDriver;
            tableDriver = new Table();
            tableDriver.setVisible(true);
            tableDriver.setLocationRelativeTo(null);
        } catch (Exception ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        EditDrivers edit = new EditDrivers();
        edit.setVisible(true);
        edit.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            add addDriver = new add();
            addDriver.setVisible(true);
            addDriver.setLocationRelativeTo(null);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JLabel Time;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
