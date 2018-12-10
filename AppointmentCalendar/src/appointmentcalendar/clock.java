/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentcalendar;

public class clock
{
    private int hours, minutes, seconds;
    
    public void clockTicking()
    {
        seconds +=1;
        minutes = minutes + seconds/60;
        hours = hours + minutes / 60;
        seconds %= 60;
        minutes %= 60;
        hours %= 24;
    }
    
    public void clockTime()
    {
        System.out.println(hours + ":" + minutes + ":" + seconds);
        System.out.println();
    }
}
