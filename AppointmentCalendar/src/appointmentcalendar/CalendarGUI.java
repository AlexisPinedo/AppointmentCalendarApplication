/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentcalendar;

import static appointmentcalendar.accountLoginGUI.JDBC_DRIVER;
<<<<<<< HEAD
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
=======
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
>>>>>>> 274841a856c87fad4aeac9d7c6d4675a5da3e318
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author pined
 */
public class CalendarGUI extends javax.swing.JFrame {
    
    Date SelectedDate;
    String selectedDateString;
    String selectedTimeString; 
    Calendar selectedDate;
    
    //Initialize database
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/343Project1testdb";
    
    //used to log into the database
    static final String USER = "newuser";
    static final String PASS = "newpass";
    
    //establish connection
    public Connection conn;
    public Statement stmt; 
    
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
        jDialog1 = new javax.swing.JDialog();
        label1 = new java.awt.Label();
        button1 = new java.awt.Button();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        jSpinner1 = new javax.swing.JSpinner();
        AppointmentCalendarTitleLabel = new javax.swing.JLabel();
        SelectedAppointmentInformationLabel = new javax.swing.JLabel();
        createAppointmentButton = new javax.swing.JButton();
        importFileButton = new javax.swing.JButton();
        exportFileButton = new javax.swing.JButton();
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

        jDialog1.setName("CreateAppointmentGUI"); // NOI18N

        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("Please Select an Appointment Day and Time");

        button1.setLabel("Close");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        label1.getAccessibleContext().setAccessibleName("CreateAppointmentLabel");
        button1.getAccessibleContext().setAccessibleName("CloseCreateAppointmentButton");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AppointmentCalendarTitleLabel.setText("Appointment Calendar");

        SelectedAppointmentInformationLabel.setText("Selected Appointment Information");

        createAppointmentButton.setText("Create Appointment");
        createAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAppointmentButtonActionPerformed(evt);
            }
        });

        importFileButton.setLabel("Import File");
        importFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importFileButtonActionPerformed(evt);
            }
        });

        exportFileButton.setText("Export File");
        exportFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileButtonActionPerformed(evt);
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
        TimeSpinner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TimeSpinnerMouseClicked(evt);
            }
        });

        viewAppointmentButton.setText("View Appointment");
        viewAppointmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAppointmentButtonActionPerformed(evt);
            }
        });

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(AppointmentCalendarTitleLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(createAppointmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(importFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(viewAppointmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                    .addComponent(exportFileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(quitButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(appointmentLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SelectedAppointmentInformationLabel)
                                    .addComponent(TimeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newAppointmentInfoLabel)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 109, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
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
                .addGap(42, 42, 42)
                .addComponent(newAppointmentInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAppointmentButton)
                    .addComponent(viewAppointmentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importFileButton)
                    .addComponent(exportFileButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(quitButton)
                .addContainerGap())
            .addComponent(AppointmentCalendarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void systemExit()
    {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }
    
    private void createAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAppointmentButtonActionPerformed
        systemExit();
        appointmentCreator creator = new appointmentCreator();
        creator.setVisible(true);
    }//GEN-LAST:event_createAppointmentButtonActionPerformed

    private void exportFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileButtonActionPerformed
        // TODO add your handling code here:
        CSVWriter writer;
        
        try {
            writer = new CSVWriter(new FileWriter("Appointments.csv"), '\t');
            Boolean includeHeaders = true;

            //java.sql.ResultSet myResultSet = .... //your resultset logic here

            //writer.writeAll(myResultSet, includeHeaders);

        writer.close();
        } catch (IOException ex) {
            Logger.getLogger(CalendarGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_exportFileButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void AppointmentCalendarPanelOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_AppointmentCalendarPanelOnSelectionChange
        // TODO add your handling code here:
        selectedDate = AppointmentCalendarPanel.getSelectedDate();

    }//GEN-LAST:event_AppointmentCalendarPanelOnSelectionChange

    private void jMenuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuFileActionPerformed

    private void TimeSpinnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimeSpinnerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TimeSpinnerMouseClicked

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        //jDialog1.setVisible(false);
    }//GEN-LAST:event_button1ActionPerformed

    private void viewAppointmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAppointmentButtonActionPerformed

        //selectedTimeString = TimeSpinner.getValue();
        //selectedDateString = GetDateString();
        //selectedTimeString = GetTimeString();
        //jTextArea2.setText("The Date is \n" + selectedDateString + "\n" + "The time is \n" + selectedTimeString);
        String theAppointmentInfo = "";
        try {
            theAppointmentInfo = ViewAppointmantSQL();
        } catch (SQLException ex) {
            Logger.getLogger(CalendarGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea2.setText(theAppointmentInfo); 
        
    }//GEN-LAST:event_viewAppointmentButtonActionPerformed

    private void importFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFileButtonActionPerformed
          //Declare Variable
          JFileChooser fileChooser = new JFileChooser();
          FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
          fileChooser.setFileFilter(filter);
          StringBuilder sb = new StringBuilder();

          if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){

           //get the file
           java.io.File file = fileChooser.getSelectedFile();

           //create a scanner for the file
           Scanner input;
           try {
                input = new Scanner(file);
                while(input.hasNext()){
                    sb.append(input.nextLine());
                    sb.append("\n");;
                }
                input.close();
                
                String appointmentInfo = "";
                try{
                    Class.forName(JDBC_DRIVER);
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);

                    String sql = sb.toString();
                    newAppointmentTextPane.setText(sql);
                    PreparedStatement statement = conn.prepareStatement(sql);
                    System.out.print("Statement stored into Database\n");
                    conn.close();
                }catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, e);

                }                 
          } catch (FileNotFoundException ex) {
                 Logger.getLogger(CalendarGUI.class.getName()).log(Level.SEVERE, null, ex);
                     }
           //read text from file
          }
          else{
           sb.append("No file was selected");
           newAppointmentTextPane.setText(sb.toString());
          }       
    }//GEN-LAST:event_importFileButtonActionPerformed

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
    private java.awt.Button button1;
    private javax.swing.JButton createAppointmentButton;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserDialog dateChooserDialog2;
    private datechooser.beans.DateChooserDialog dateChooserDialog3;
    private javax.swing.JButton exportFileButton;
    private javax.swing.JButton importFileButton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea2;
    private java.awt.Label label1;
    private javax.swing.JLabel newAppointmentInfoLabel;
    private javax.swing.JTextArea newAppointmentTextPane;
    private javax.swing.JButton quitButton;
    private javax.swing.JButton viewAppointmentButton;
    // End of variables declaration//GEN-END:variables

    
    String GetDateString(){
        String temp;
        //selectedDate = AppointmentCalendarPanel.getSelectedDate();
        temp =  selectedDate.get(Calendar.YEAR) + "-" +
               (selectedDate.get(Calendar.MONTH)+1)  + "-" + selectedDate.get(Calendar.DATE);
        System.out.print(temp + " in get date function\n");
        return temp;
    }
    
    String GetTimeString(){
        String temp;
        Calendar selectedTime = AppointmentCalendarPanel.getSelectedDate();
        selectedTime.setTime((Date)TimeSpinner.getValue());
        temp = String.format("%02d:%02d", selectedTime.get(Calendar.HOUR_OF_DAY), selectedTime.get(Calendar.MINUTE) );
        System.out.print(temp + " in get time function\n");
        return temp;
    }
    
    private String ViewAppointmantSQL() throws SQLException {
        String appointmentInfo = "";
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            selectedDateString = GetDateString();
            System.out.print(selectedDateString + "\n");
            selectedTimeString = GetTimeString();
            System.out.print(selectedTimeString+"\n");

            String sql = "SELECT * FROM APPOINTMENTS WHERE appointmentDateTime = '" + selectedDateString + " " + selectedTimeString + "' " ;
            System.out.print( sql + "\n");
            
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.clearParameters();
            
            System.out.print("Statement exectued\n");
            ResultSet rs = statement.executeQuery();
            String getData = "";
            while(rs.next()){
                //pID, pFname, pLname, hID, hospitalName, hospitalAddress, dID, doctorName, appointmentDateTime
                getData = getData + "Appointment found: " + rs.getString("pFname") + " " +
                        rs.getString("pLname") + "\n at " + rs.getString("hospitalName") + "\n";
            }
            System.out.print("Statement executed and stored into rs\n");
            appointmentInfo = getData;
            System.out.print("Statement stored into appointmentinfo\n");
            conn.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }    
        return appointmentInfo;
    }
    
}
