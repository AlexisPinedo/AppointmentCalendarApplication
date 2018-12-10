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

public class appointmentEditor extends javax.swing.JFrame {

    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/343Project1testdb";

  //  Database credentials
    static final String USER = "newuser";
    static final String PASS = "newpass";
    public Connection conn;
    public Statement stmt; 
    
    public appointmentEditor()
    {
        initComponents();
        setSize(720,480);
    }
    
//    pID                    INT NOT NULL,
//    pFname                 VARCHAR(20) NOT NULL,
//    PLname                 VARCHAR(20) NOT NULL,
//    hID                    INT NOT NULL,
//    hospitalName           VARCHAR(50) NOT NULL,
//    hospitalAddress        VARCHAR(50) NOT NULL,
//    dID                    INT NOT NULL,
//    doctorName             VARCHAR(50) NOT NULL,
//    appointmentDateTime    VARCHAR(20),
    
    public void appointmentCBFillData()
    {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement statement = conn.createStatement();    
            String sql = "Select * FROM Appointments";
            ResultSet rs = statement.executeQuery(sql);
            
            while(rs.next())
            {
                appointmentList.addItem(Integer.toString(rs.getInt("pID")) + " " +
                   rs.getString("pFname") + " " + rs.getString("pLname") + " " + 
                   Integer.toString(rs.getInt("hID")) + " " 
                    + rs.getString("hospitalName") + " " + 
                        rs.getString("hospitalAddress") + " " +
                        Integer.toString(rs.getInt("dID")) + " " +
                        rs.getString("doctorName") + " " +
                        rs.getString("appointmentDateTime"));               
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("343Project1testdbPU").createEntityManager();
        appointmentsQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Appointments a");
        appointmentsList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : appointmentsQuery.getResultList();
        appointmentsQuery1 = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Appointments a");
        appointmentsList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : appointmentsQuery1.getResultList();
        jLabel1 = new javax.swing.JLabel();
        appointmentList = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        userEmail = new javax.swing.JTextField();
        validateButton = new javax.swing.JButton();
        changeLocationButton = new javax.swing.JButton();
        changeDoctorButton = new javax.swing.JButton();
        changeTimeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Choose an appointment to change");

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${}");
        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, appointmentsList1, eLProperty, appointmentList);
        bindingGroup.addBinding(jComboBoxBinding);

        appointmentList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentListActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter your email address");

        validateButton.setText("VALIDATE");

        changeLocationButton.setText("CHANGE LOCATION");
        changeLocationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLocationButtonActionPerformed(evt);
            }
        });

        changeDoctorButton.setText("CHANGE DOCTOR");
        changeDoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeDoctorButtonActionPerformed(evt);
            }
        });

        changeTimeButton.setText("CHANGE TIME");
        changeTimeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeTimeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(validateButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(appointmentList, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(changeLocationButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeTimeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(changeDoctorButton)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(appointmentList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeLocationButton)
                    .addComponent(changeTimeButton)
                    .addComponent(changeDoctorButton))
                .addGap(70, 70, 70))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void systemExit()
    {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    }
    
    private void appointmentListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_appointmentListActionPerformed

    
    private void changeTimeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeTimeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeTimeButtonActionPerformed

    private void changeDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeDoctorButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeDoctorButtonActionPerformed

    private void changeLocationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeLocationButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeLocationButtonActionPerformed

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
            java.util.logging.Logger.getLogger(appointmentEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(appointmentEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(appointmentEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(appointmentEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new appointmentEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> appointmentList;
    private java.util.List<appointmentcalendar.Appointments> appointmentsList;
    private java.util.List<appointmentcalendar.Appointments> appointmentsList1;
    private javax.persistence.Query appointmentsQuery;
    private javax.persistence.Query appointmentsQuery1;
    private javax.swing.JButton changeDoctorButton;
    private javax.swing.JButton changeLocationButton;
    private javax.swing.JButton changeTimeButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField userEmail;
    private javax.swing.JButton validateButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
