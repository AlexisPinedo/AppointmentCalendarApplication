/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentcalendar;

import java.awt.Toolkit;
import java.awt.*;
import java.sql.SQLException;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Pir8
 */
public class appointmentCreator extends javax.swing.JFrame {

    /**
     * Creates new form appointmentCreator
     */
    
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/343Project1testdb";

  //  Database credentials
    static final String USER = "newuser";
    static final String PASS = "newpass";
    public Connection conn;
    public Statement stmt; 
    
    public appointmentCreator() {
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

        jLabel1 = new javax.swing.JLabel();
        hospitalComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        locationComboBox = new javax.swing.JComboBox<>();
        confirmAppointmentButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        timeComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("SELECT AN HOSPITAL");

        hospitalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kaiser Permanente" }));

        jLabel2.setText("SELECT THE LOCATION OF THE HOSPITAL");

        locationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3401 S Harbor Blvd, Santa Ana, CA", "3717 S Euclid St, Garden Grove, CA", "5451 S Chapman Ave, Orange, CA", "506 S Beach Blvd, Huntington Beach, CA", "2523 S La Palma Ave, Anaheim, CA" }));

        confirmAppointmentButton.setText("CONFIRM APPOINTMENT");
        confirmAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAppointmentButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("SELECT THE TIME");

        timeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hospitalComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(confirmAppointmentButton)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hospitalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(confirmAppointmentButton)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void systemExit()
    {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    }
        
    private String getDoctor() throws SQLException
    {
        String doctorName = "";
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            String appointmentDate = timeComboBox.getSelectedItem().toString();
            String hospitalLocation = locationComboBox.getSelectedItem().toString();

            String sql = "SELECT doctorName FROM Appointments WHERE appointmentDateTime = '" + appointmentDate + "OR hospitalAddress = '" + hospitalLocation ;
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.clearParameters();           
            System.out.print("Statement exectued\n");
            ResultSet rs = statement.executeQuery();
            String getData = "";
            while(rs.next()){
                getData = getData + " " + rs.getString("APPOINTMENTSTARTTIME");
            }
            System.out.print("Statement executed and stored into rs\n");
            doctorName = getData;
            System.out.print("Statement stored into appointmentinfo\n");
            conn.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
        return doctorName;

    }
        
    private void appointmentInserter() throws SQLException
    {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "INSERT INTO Appointments (pID, pFname, pLname, hID, "
                    + "hospitalName, hospitalAddress, dID, doctorName, "
                    + "appointmentDateTime) VALUES (?,?,?,?,?,?,?,?,?)";
            
            String doctorNameSQL = "SELECT doctorName FROM Appointments "
                    + "WHERE appointmentDateTime = '2018-12-12 08:00";
            
            PreparedStatement statement = conn.prepareStatement(sql);      

            statement.clearParameters();
            statement.setInt(1,getPatientID());
            statement.setString(2,getFirstName());
            statement.setString(3,getLastName());
            statement.setString(4,getHospitalID());
            statement.setString(5,hospitalComboBox.getSelectedItem().toString());
            statement.setString(6,locationComboBox.getSelectedItem().toString()); 
            statement.setString(7,getDoctorID());
            statement.setString(8,getDoctor());
            statement.setString(9,timeComboBox.getSelectedItem().toString()); 
            statement.executeUpdate();
            System.out.println("Appointment is successfully created!");
            conn.close();
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot create Appointment");
        } 
    }
    
    private void confirmAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmAppointmentButtonActionPerformed
        
    }//GEN-LAST:event_confirmAppointmentButtonActionPerformed

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
            java.util.logging.Logger.getLogger(appointmentCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(appointmentCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(appointmentCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(appointmentCreator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new appointmentCreator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmAppointmentButton;
    private javax.swing.JComboBox<String> hospitalComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> locationComboBox;
    private javax.swing.JComboBox<String> timeComboBox;
    // End of variables declaration//GEN-END:variables
}
