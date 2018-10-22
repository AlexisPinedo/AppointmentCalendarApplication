
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pined
 */
public class Appointment {
    Date appointmentDate;
    Calendar appointmentTime;
    String appointmentDetails;
    
    
    void SetAppointment(Date setDate, Calendar setTime, String setDetails) {
        appointmentDate = setDate;
        appointmentTime = setTime;
        appointmentDetails = setDetails;
    }
    
    String GetAppointment()
    {
        return appointmentDetails;
    }
}
