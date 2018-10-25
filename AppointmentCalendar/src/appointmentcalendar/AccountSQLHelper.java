package appointmentcalendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountSQLHelper
{
    static final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    static final String DB_URL = "jdbc:derby://localhost:1527/343Project1testdb";

  //  Database credentials
    static final String USER = "newuser";
    static final String PASS = "newpass";
    public Connection conn;
    public Statement stmt; 
    
    public AccountSQLHelper()
    {
        try
        {
          Class.forName(JDBC_DRIVER);
          conn = DriverManager.getConnection(DB_URL,USER,PASS);
          stmt = conn.createStatement();
        }
        catch(SQLException se)
        {
            System.out.println("Cannot connect to Database Server");
            System.exit(0);
        }
        catch(Exception e)
        {

        }
    }
    
    public void Select(String sql,int table) 
    {   
       try
       {
             ResultSet rs = stmt.executeQuery(sql);
             Print(rs,table);
       }
       catch(SQLException e)
       {
           System.out.println("Bad SQL statement, try again");
       }
    } 
    
    public void Select(String table, String patientID)
    {
        try
        {     
        if(table.equals("Patients"))
        {
            String sql = "SELECT pFname, pLname, pDOB, pEmail FROM Patients WHERE pID = ?";
            PreparedStatement statment = conn.prepareStatement(sql);
            
            statment.clearParameters();
            statment.setString(1,patientID); 
            ResultSet rs = statment.executeQuery();
            if(rs.next())  
            { 
              PreparedStatement stat2 = conn.prepareStatement(sql); 
              stat2.clearParameters();
              stat2.setString(1,patientID);
             
              ResultSet ps = stat2.executeQuery();
              Print(ps,3);
            }
            }
            else
            {
                System.out.println("Patient Does Not Exist!");
                return;
            }
        
            //TODO - SELECT FOR HOSPITAL AND APPOINTMENT DATA
        }
        
        catch(SQLException e)
        {
            System.out.println("Patient Does Not Exist! try again");
        }
    }
    
    /**
     * lets the user insert values to the tables
     * @param values - array that holds the new values to be inserted to be table
     */
    public void Insert(String []values) 
    {
        if(values.length == 6)
        {
            try
            {
            String sql = "INSERT INTO Patients VALUES(?,?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.clearParameters();
            statement.setString(1,values[0]);
            statement.setString(2,values[1]);
            statement.setString(3,values[2]);
            statement.setString(4,values[3]);
            statement.setString(5,values[4]);
            statement.setString(6,values[5]);
            
            statement.executeUpdate();
            }
            catch(SQLException se)
            {
               
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        
        
        else if(values.length == 5)
        {
            try
            {
            String sql = "Insert INTO Hospital VALUES(?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.clearParameters();
            statement.setString(1,values[0]);
            statement.setString(2,values[1]);
            statement.setString(3,values[2]);
            statement.setString(4,values[3]);
            statement.setString(5,values[4]);
            
            statement.executeUpdate();
            }
            catch(SQLException se)
            {
                se.printStackTrace();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        //TOD0 - INSERT VALUES TO APPOINTMENT TABLE
    }
    
    /**
     * Verifies whether the email and password are in the records
     * @param Name
     * @param table
     * @return 
     */
    public boolean validateEntry(String emailCode, String passCode, int table)
    {
        try
        {
        if(table == 1)
        {
            String eSQL = "SELECT pID FROM Patients WHERE pEmail = ? AND password = ?";
            PreparedStatement statment = conn.prepareStatement(eSQL);
            
            statment.clearParameters();
            statment.setString(1,emailCode);
            statment.setString(2,passCode);
            ResultSet rs = statment.executeQuery();
            if(rs.next())
             {
               return true;  
             }
            else
            {
                System.out.println("Invalid email address");
                return false;
            }
        }
        }
        catch(SQLException e)
        {
            System.out.println("Email does not exist in our records");
            return false;
        }
        
        return true;
        //TODO - VALIDATE HOSPITAL AND APPOINTMENTS
    }
     
    public void Print(ResultSet rs, int table)
    { 
        String pID, hID, assignedDoctor, appointmentDate, hospitalName;
        String hospitalAddress, hospitalPhone, hospitalEmail;
        String pFname, pLname, pDOB, pEmail, password;
                 
        try{
          if(table == 1) //Patients
          {
              
            while(rs.next())
           {    
              
                pID = rs.getString("pID");
                pFname = rs.getString("pFname");
                pLname = rs.getString("pLname");
                pDOB = rs.getString("pDOB");
                pEmail = rs.getString("pEmail");
                password = rs.getString("password");
                 try
                 {
                    hID = rs.getString("hID");
                    hospitalName = rs.getString("hospitalName");
                    hospitalAddress = rs.getString("hospitalAddress");
                    hospitalPhone  = rs.getString("hospitalPhone");
                    hospitalEmail  = rs.getString("hospitalEmail");
                    assignedDoctor = rs.getString("assignedDoctor");
                    appointmentDate = rs.getString("assignmentDate");
                 }
                 catch(SQLException e)
                 {
                    hID = null;
                    hospitalName = null;
                    hospitalAddress = null;
                    hospitalPhone  = null;
                    hospitalEmail  = null;
                    assignedDoctor = null;
                    appointmentDate = null;
                 }
                
                 System.out.print("patientID: " + pID);
                 System.out.print(", First Name : " + pFname);
                 System.out.print(", Last Name: " + pLname);
                 System.out.print(", Birthday: " + pDOB);
                 System.out.print(", Email: " + pEmail);
                
                 
                 if(hID != null)
                 {
                       System.out.print(", hospital ID : " + hID);
                       System.out.print(", hospital Name: " + hospitalName);
                       System.out.print(", hospital Address: " + hospitalAddress);
                       System.out.print(", hospital Phone Number : " + hospitalPhone);
                       System.out.print(", hospital Email: " + hospitalEmail);
                       System.out.print(", Doctor: " + assignedDoctor);
                       System.out.print(", Appointment Date: " + appointmentDate);
                 }
                 System.out.println('\n');
                 System.out.println();      
            }
          }
          //TODO - PRINT THE RESULT FOR THE HOSPITAL TABLE (TABLE 2) AND APPOINTMENT TABLE (TABLE 3)
       }
       catch(SQLException e)
       {
           System.out.println("Error Printing try again");   
       }
    } 
    
    /**
     * closes the connection for the servers
     */
    void closeConnections()
    {
        try
        {
            conn.close();
            stmt.close();
        }

        catch(SQLException e)
        {
            System.out.println("Could not close connections");
        }
    }
}