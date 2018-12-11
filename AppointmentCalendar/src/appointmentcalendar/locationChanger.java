/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentcalendar;

import java.awt.Component;
import java.util.Scanner;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class locationChanger extends javax.swing.JFrame {

    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/343Project1testdb";

  //  Database credentials
    static final String USER = "newuser";
    static final String PASS = "newpass";
    public Connection conn;
    public Statement stmt; 
    
    public locationChanger() {
        initComponents();
    }

    private void systemExit()
    {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    }
    
    private void validation()
    {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//            Statement statement = conn.createStatement();    
            String sql = "Select hospitalName, hospitalAddress FROM Appointments "
                    + "NATURAL JOIN Patients WHERE pEmail = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery(sql);
            
            statement.clearParameters();
            statement.setString(1,emailText.getText());
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                JOptionPane.showMessageDialog(null, "Email address is valid!");   
                originalHospital.append(rs.getString("hospitalName") + " " + 
                        rs.getString("hospitalAddress")); 
//                hospitalLocationList.addItem(rs.getString("hospitalName") + " " + 
//                        rs.getString("hospitalAddress"));  
            }                          
        }
        catch(Exception e)
        {
            System.out.println(e);
        }   
    }
    
    public void newLocations()
    {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
//            Statement statement = conn.createStatement();    
            String sql = "Select hospitalName, hospitalAddress FROM Hospital "
                    + "NATURAL JOIN Patients WHERE pEmail = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
//            ResultSet rs = statement.executeQuery(sql);
            
            statement.clearParameters();
            statement.setString(1,emailText.getText());
            ResultSet rs = statement.executeQuery();
         
            while(rs.next())
            {
//                hospitalLocationList.addItem(rs.getString("hospitalName") + " " + 
//                        rs.getString("hospitalAddress"));  
                hospitalLocationList.addItem(rs.getString("hospitalAddress"));
            }                          
        }
        catch(Exception e)
        {
            System.out.println(e);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        originalHospital = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        hospitalLocationList = new javax.swing.JComboBox<>();
        confirmButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        validateButton = new javax.swing.JButton();
        patientIDText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Original Location");

        originalHospital.setColumns(20);
        originalHospital.setRows(5);
        originalHospital.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                originalHospitalAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(originalHospital);

        jLabel2.setText("New Location");

        confirmButton.setText("CONFIRM");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Enter your Email Address");

        validateButton.setText("VALIDATE");
        validateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validateButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("6 digit Patient ID Number");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(validateButton)
                .addContainerGap(226, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(hospitalLocationList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(confirmButton))
                            .addComponent(emailText)
                            .addComponent(patientIDText))
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(validateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hospitalLocationList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(patientIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(confirmButton)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void originalHospitalAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_originalHospitalAncestorAdded

    }//GEN-LAST:event_originalHospitalAncestorAdded

    private void validateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validateButtonActionPerformed
        validation();
        newLocations();
    }//GEN-LAST:event_validateButtonActionPerformed
       
    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
           
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            String sql = "UPDATE Appointments SET hospitalAddress = ? "
                    + "WHERE pID = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            hospitalLocationList.getSelectedIndex();
            statement.clearParameters();
            statement.setString(1,hospitalLocationList.getSelectedItem().toString());
            statement.setString(2,patientIDText.getText());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "UPDATE SUCCESSFUL!");
            
            systemExit();
            accountLoginGUI login = new accountLoginGUI();
            login.setVisible(true);
      
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_confirmButtonActionPerformed

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
            java.util.logging.Logger.getLogger(locationChanger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(locationChanger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(locationChanger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(locationChanger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new locationChanger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextField emailText;
    private javax.swing.JComboBox<String> hospitalLocationList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea originalHospital;
    private javax.swing.JTextField patientIDText;
    private javax.swing.JButton validateButton;
    // End of variables declaration//GEN-END:variables
}
