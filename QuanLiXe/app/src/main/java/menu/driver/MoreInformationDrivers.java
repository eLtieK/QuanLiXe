/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu.driver;

import database.Drivers;
import database.Manager;
import database.Schedule;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author User
 */
public class MoreInformationDrivers extends javax.swing.JFrame {

    /**
     * Creates new form MoreInformationDrivers
     */
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static int IDofDriver;

    public MoreInformationDrivers(int id) throws Exception {
        initComponents();
        IDofDriver = id;
        setInfo();
        setButtonFalse();
        this.setTitle("INFOMATION");
       
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

    public void setInfo() throws Exception {
        Drivers driver = Manager.getDriver(IDofDriver);
        ID.setText("ID: " + driver.getId());
        Name.setText("Name: " + driver.getName());
        Phone.setText("Phone number: " + driver.getPhonenumber());
        Address.setText("Address: " + driver.getAddress());
        License.setText("License: " + driver.getLicense().toString());
        Exp.setText("Experiences: " + driver.getExperiences() + " years");
        Status.setText("Status: " + driver.getStatus().toString());
        Profit.setText("Profit / hour: " + Drivers.getProfit(driver.getLicense()) + " thousand dong / hour");
        Speed.setText("Average speed / hour: " + driver.getAverageSpeed() + " km/h");
        Type.setText("Suitable car type: " + driver.get_all_suitable_type());
        Performance.setText("Performance: " + driver.getPerformance() + " %");
        Leave_start.setText("Leave start date: " + driver.getDate_start());
        Leave_end.setText("Leave end date: " + driver.getDate_end());
    }

    public void resetText() {
        Start.setText("Start date");
        End.setText("End date");
    }

    public boolean checkForm() {
        if (Start.getText().isEmpty() || End.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean checkDate(String str) {
        dateFormat.setLenient(false); // Không cho phép chuyển đổi mềm dẻo
        try {
            // Kiểm tra việc chuyển đổi chuỗi thành đối tượng Date
            dateFormat.parse(str);
            return true;
        } catch (ParseException e) {
            // Nếu có lỗi xảy ra, chuỗi không đúng định dạng
            return false;
        }
    }

    public boolean checkLogic() {
        String start = Start.getText();
        String end = End.getText();
        return Schedule.check_logic_date(start) && Schedule.check_logic_date(end);
    }

    public boolean checkLogicCompare() {
        String start = Start.getText();
        String end = End.getText();
        return Schedule.check_logic_date(start, end);
    }

    public boolean validataForm() {
        if (!checkDate(Start.getText()) || !checkDate(End.getText())) {
            return false;
        }
        return true;
    }

    public void setButtonFalse() {
        Start.setVisible(false);
        End.setVisible(false);
        Save.setVisible(false);
    }

    public void setButtonTrue() {
        Start.setVisible(true);
        End.setVisible(true);
        Save.setVisible(true);
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
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ID = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Address = new javax.swing.JLabel();
        Phone = new javax.swing.JLabel();
        License = new javax.swing.JLabel();
        Exp = new javax.swing.JLabel();
        Status = new javax.swing.JLabel();
        Profit = new javax.swing.JLabel();
        Speed = new javax.swing.JLabel();
        Type = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Performance = new javax.swing.JLabel();
        Leave_end = new javax.swing.JLabel();
        Leave_start = new javax.swing.JLabel();
        Start = new javax.swing.JTextField();
        End = new javax.swing.JTextField();
        Save = new javax.swing.JButton();
        Schedule_maintenance = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ID.setText("ID:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ID)
        );

        Name.setText("Name:");

        Address.setText("Address:");

        Phone.setText("Phone number:");

        License.setText("License:");

        Exp.setText("Experiences:");

        Status.setText("Status:");

        Profit.setText("Profit / hour:");

        Speed.setText("Average speed / hour:");

        Type.setText("Suitable car type: ");

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Performance.setText("Performance: ");

        Leave_end.setText("Leave end date:");

        Leave_start.setText("Leave start date:");

        Start.setText("Start date");
        Start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartMouseClicked(evt);
            }
        });
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        End.setText("End date");
        End.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EndMouseClicked(evt);
            }
        });
        End.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndActionPerformed(evt);
            }
        });

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        Schedule_maintenance.setText("Schedule leave");
        Schedule_maintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Schedule_maintenanceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Phone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Address, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(License, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Profit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Speed, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
            .addComponent(Type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Exp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(End, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Schedule_maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
            .addComponent(jSeparator1)
            .addComponent(Performance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Leave_end, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Leave_start, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Address)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(License)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Exp, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Status)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Profit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Speed)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Type)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Performance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Leave_start)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Leave_end)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Save)
                        .addComponent(End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Schedule_maintenance)
                        .addComponent(Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void StartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartMouseClicked
        // TODO add your handling code here:
        Start.setText("");
    }//GEN-LAST:event_StartMouseClicked

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StartActionPerformed

    private void EndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EndMouseClicked
        // TODO add your handling code here:
        End.setText("");
    }//GEN-LAST:event_EndMouseClicked

    private void EndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EndActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        try {
            // TODO add your handling code here:
            if (!checkForm()) {
                JOptionPane.showMessageDialog(this, "Please enter the correct and complete fields !");
                resetText();
                return;
            } else if (!validataForm()) {
                JOptionPane.showMessageDialog(this, "Please re-enter the information in the correct format (yyyy-MM-dd HH:mm:ss) !");
                resetText();
                return;
            } else if (checkLogic()) {
                JOptionPane.showMessageDialog(this, "Date must be after current time");
                resetText();
                return;
            } else if (!checkLogicCompare()) {
                JOptionPane.showMessageDialog(this, "Start date must before end date");
                resetText();
                return;
            }

            int driver_id = IDofDriver;
            Drivers driver = Manager.getDriver(driver_id);
            driver.setDate_start(Start.getText());
            driver.setDate_end(End.getText());
            Leave_start.setText("Maintenance start date: " + Start.getText());
            Leave_end.setText("Maintenance end date: " + End.getText());
            check_driver_start_leave(driver);
            check_driver_done_leave(driver);
            Manager.updateDrivers();
            setButtonFalse();
        } catch (Exception ex) {
            Logger.getLogger(MoreInformationDrivers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void Schedule_maintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Schedule_maintenanceActionPerformed
        try {
            // TODO add your handling code here:
            int driver_id = IDofDriver;
            Drivers driver = Manager.getDriver(driver_id);
            if (driver.is_on_leave()) {
                JOptionPane.showMessageDialog(this, "Driver is on leave !");
                resetText();
                return;
            } else if (driver.getStatus().equals(Drivers.Status.in_trip)) {
                JOptionPane.showMessageDialog(this, "Driver is in trip !");
                resetText();
                return;
            } else if (driver.getPerformance() == 100) {
                JOptionPane.showMessageDialog(this, "Driver don't need leave !");
                resetText();
                return;
            }
            setButtonTrue();
        } catch (Exception ex) {
            Logger.getLogger(MoreInformationDrivers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Schedule_maintenanceActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Address;
    private javax.swing.JTextField End;
    private javax.swing.JLabel Exp;
    private javax.swing.JLabel ID;
    private javax.swing.JLabel Leave_end;
    private javax.swing.JLabel Leave_start;
    private javax.swing.JLabel License;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Performance;
    private javax.swing.JLabel Phone;
    private javax.swing.JLabel Profit;
    private javax.swing.JButton Save;
    private javax.swing.JButton Schedule_maintenance;
    private javax.swing.JLabel Speed;
    private javax.swing.JTextField Start;
    private javax.swing.JLabel Status;
    private javax.swing.JLabel Type;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
