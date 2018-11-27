/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentcalendar;

import java.util.Calendar;
import java.util.Date;
import java.io.FileWriter;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;


/**
 *
 * @author pined
 */
public class CalendarGUI extends javax.swing.JFrame {
    
    Date SelectedDate;
    String selectedDateString;
    String selectedTimeString; 
    /**
     * Creates new form CalendarGUI
     */
    public CalendarGUI() {
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

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog2 = new datechooser.beans.DateChooserDialog();
        dateChooserDialog3 = new datechooser.beans.DateChooserDialog();
        jMenu1 = new javax.swing.JMenu();
        AppointmentCalendarTitleLabel = new javax.swing.JLabel();
        SelectedAppointmentInformationLabel = new javax.swing.JLabel();
        createAppointmentButton = new javax.swing.JButton();
        deleteAppointmentButton = new javax.swing.JButton();
        editAppointmentButton = new javax.swing.JButton();
        AppointmentCalendarPanel = new datechooser.beans.DateChooserPanel();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        TimeSpinner = new javax.swing.JSpinner(sm);
        viewAppointmentButton = new javax.swing.JButton();
        newAppointmentInfoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newAppointmentTextPane = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        quitButton = new javax.swing.JButton();
        appointmentLabel = new java.awt.Label();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuEdit = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AppointmentCalendarTitleLabel.setText("Appointment Calendar");

        SelectedAppointmentInformationLabel.setText("Selected Appointment Information");

        createAppointmentButton.setText("Create Appointment");
        createAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAppointmentButtonActionPerformed(evt);
            }
        });

        deleteAppointmentButton.setText("Delete Appointment");

        editAppointmentButton.setText("Edit Appointment");
        editAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editAppointmentButtonActionPerformed(evt);
            }
        });

        AppointmentCalendarPanel.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
        AppointmentCalendarPanel.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                AppointmentCalendarPanelOnSelectionChange(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(TimeSpinner, "HH:mm");
        TimeSpinner.setEditor(de);

        viewAppointmentButton.setText("View Appointment");

        newAppointmentInfoLabel.setText("New Appointment Information");

        newAppointmentTextPane.setColumns(20);
        newAppointmentTextPane.setRows(5);
        jScrollPane1.setViewportView(newAppointmentTextPane);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        appointmentLabel.setText("Appointment Time");

        jMenuFile.setText("File");
        jMenuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFileActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenuFile);

        jMenuEdit.setText("Edit");
        jMenuBar1.add(jMenuEdit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(AppointmentCalendarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(AppointmentCalendarTitleLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(deleteAppointmentButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editAppointmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createAppointmentButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(viewAppointmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(quitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appointmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(SelectedAppointmentInformationLabel)
                                .addComponent(TimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(newAppointmentInfoLabel)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                .addComponent(jScrollPane2)))))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AppointmentCalendarTitleLabel)
                .addGap(44, 44, 44)
                .addComponent(SelectedAppointmentInformationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(appointmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(TimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(newAppointmentInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAppointmentButton)
                    .addComponent(viewAppointmentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteAppointmentButton)
                    .addComponent(editAppointmentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitButton)
                .addContainerGap())
            .addComponent(AppointmentCalendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAppointmentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_createAppointmentButtonActionPerformed

    private void editAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editAppointmentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editAppointmentButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void AppointmentCalendarPanelOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_AppointmentCalendarPanelOnSelectionChange
        // TODO add your handling code here:
        Calendar selectedDate = AppointmentCalendarPanel.getSelectedDate();
        selectedDateString =  selectedDate.get(Calendar.YEAR) + "-" +
               (selectedDate.get(Calendar.MONTH)+1)  + "-" + selectedDate.get(Calendar.DATE);
        //selectedTimeString = TimeSpinner.getValue();
        jTextArea2.setText("The Date is \n" + selectedDateString);
    }//GEN-LAST:event_AppointmentCalendarPanelOnSelectionChange

    private void jMenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFileActionPerformed

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
            java.util.logging.Logger.getLogger(CalendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalendarGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CalendarGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserPanel AppointmentCalendarPanel;
    private javax.swing.JLabel AppointmentCalendarTitleLabel;
    private javax.swing.JLabel SelectedAppointmentInformationLabel;
    private javax.swing.JSpinner TimeSpinner;
    private java.awt.Label appointmentLabel;
    private javax.swing.JButton createAppointmentButton;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private datechooser.beans.DateChooserDialog dateChooserDialog3;
    private javax.swing.JButton deleteAppointmentButton;
    private javax.swing.JButton editAppointmentButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel newAppointmentInfoLabel;
    private javax.swing.JTextArea newAppointmentTextPane;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton viewAppointmentButton;
    // End of variables declaration//GEN-END:variables
}
