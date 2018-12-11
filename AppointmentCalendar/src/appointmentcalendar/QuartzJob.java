/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentcalendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 *
 * @author Alex and Abby's
 */
public class QuartzJob implements Job {

    @Override
    public int execute(JobExecutionContext arg0) throws JobExecutionException){
        
        return 5;
    }
}
