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

        jLabel2 = new javax.swing.JLabel();
        locationComboBox = new javax.swing.JComboBox<>();
        confirmAppointmentButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        timeComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        doctorComboBox1 = new javax.swing.JComboBox<>();
        pLname = new javax.swing.JTextField();
        pFname = new javax.swing.JTextField();
        pID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        passFieldTxt = new javax.swing.JPasswordField();
        validateButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("SELECT THE LOCATION OF THE HOSPITAL");

        confirmAppointmentButton.setText("CONFIRM APPOINTMENT");
        confirmAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmAppointmentButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("SELECT THE DOCTOR");

        jLabel4.setText("SELECT THE TIME");

        jLabel5.setText("FIRST NAME");

        jLabel6.setText("PATIENT ID");

        jLabel7.setText("LAST NAME");

        doctorComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Glenn Quagmire", "Judit Lorin", "Milenko Gozzo", "Clive Barter", "Gregory Marwa", "Roni Milanka", "Amika Hanna", "Wu Ning", "Chin Kun" }));

        pFname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pFnameActionPerformed(evt);
            }
        });

        jLabel8.setText("ENTER YOUR PASSWORD");

        validateButton.setText("VALIDATE");
        validateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("ENTER YOUR EMAIL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(confirmAppointmentButton))
                    .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctorComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pLname)
                    .addComponent(pFname)
                    .addComponent(pID)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passFieldTxt)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(validateButton))
                    .addComponent(emailTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passFieldTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(doctorComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(pFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(confirmAppointmentButton)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void systemExit()
    {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    }
    
    private void hospitalChoices()
    {
         try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//            Statement statement = conn.createStatement();    
            String sql = "Select hospitalName FROM Appointments NATURAL JOIN Patients"
                    + "WHERE pEmail = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery(sql);
            
            statement.clearParameters();
            statement.setString(1,emailTxt.getText());
            statement.setString(2,passFieldTxt.getText());
            ResultSet rs = statement.executeQuery();
            JOptionPane.showMessageDialog(null, "PASSWORD IS VALID!");
            
            while(rs.next())
            {
//                hospitalLocationList.addItem(rs.getString("hospitalName") + " " + 
//                        rs.getString("hospitalAddress"));  
                locationComboBox.addItem(rs.getString("hospitalName"));
            }                          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }           
    }
        
    private void timeChoices()
    {
         try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//            Statement statement = conn.createStatement();    
            String sql = "SELECT timeStart FROM Doctors WHERE doctorName = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery(sql);
            
            statement.clearParameters();
            statement.setString(1,doctorComboBox1.getSelectedItem().toString());
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
//                hospitalLocationList.addItem(rs.getString("hospitalName") + " " + 
//                        rs.getString("hospitalAddress"));  
                locationComboBox.addItem(rs.getString("hospitalName"));
            }                          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }           
    }
    
    private void doctorChoices()
    {
         try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//            Statement statement = conn.createStatement();    
            String sql = "Select doctorName FROM Doctors NATURAL JOIN Hospital"
                    + "WHERE hospitalAddress = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery(sql);
            
            statement.clearParameters();
            statement.setString(1,locationComboBox.getSelectedItem().toString());
            ResultSet rs = statement.executeQuery();
         
            while(rs.next())
            {
 
                doctorComboBox1.addItem(rs.getString("doctorName"));
            }                          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }           
    }
        
    private int getHospitalID() throws SQLException
    {
        int hospitalID = 0;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            String sql = "SELECT hID FROM Hospital "
                    + "WHERE hospitalAddress = ?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery(sql);
            
            statement.clearParameters();
            statement.setString(1,locationComboBox.getSelectedItem().toString());
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                hospitalID = rs.getInt("hID");
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
        
        return hospitalID;
    }
    
    private int getDoctorID() throws SQLException
    {
        int doctorID = 0;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            String sql = "SELECT dID FROM Doctors "
                    + "WHERE doctorName = ?";
            
            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery(sql);
            
            statement.clearParameters();
            statement.setString(1,doctorComboBox1.getSelectedItem().toString());
            ResultSet rs = statement.executeQuery();
            
            while(rs.next()){
                doctorID = rs.getInt("hID");
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
        
        return doctorID;
    }
          
    private void appointmentInserter() throws SQLException
    {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "INSERT INTO Appointments (pID, pFname, pLname, hID, "
                    + "hospitalAddress, dID, doctorName, "
                    + "appointmentDateTime) VALUES (?,?,?,?,?,?,?,?,?)";
            
            String patientID = pID.getText();
            int pID = Integer.parseInt(patientID);
            int hID = getHospitalID();
            int dID = getDoctorID();
            PreparedStatement statement = conn.prepareStatement(sql);      

            statement.clearParameters();
            statement.setInt(1,pID);
            statement.setString(2,pFname.getText());
            statement.setString(3,pLname.getText());
            statement.setInt(4,hID);
            statement.setString(5,locationComboBox.getSelectedItem().toString()); 
            statement.setInt(6,dID);
            statement.setString(7,doctorComboBox1.getSelectedItem().toString());
            statement.setString(8,timeComboBox1.getSelectedItem().toString()); 
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
        try
        {
            appointmentInserter();
        }catch(Exception e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cannot Create Appointment!");
        }
        
        systemExit();
    }//GEN-LAST:event_confirmAppointmentButtonActionPerformed

    private void pFnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pFnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pFnameActionPerformed

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateButtonActionPerformed
        hospitalChoices();
    }//GEN-LAST:event_validateButtonActionPerformed

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
    private javax.swing.JComboBox<String> doctorComboBox1;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox<String> locationComboBox;
    private javax.swing.JTextField pFname;
    private javax.swing.JTextField pID;
    private javax.swing.JTextField pLname;
    private javax.swing.JPasswordField passFieldTxt;
    private javax.swing.JComboBox<String> timeComboBox1;
    private javax.swing.JButton validateButton;
    // End of variables declaration//GEN-END:variables
}
