/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentcalendar;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Pir8
 */
@Embeddable
public class AppointmentsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "PID")
    private int pid;
    @Basic(optional = false)
    @Column(name = "HID")
    private int hid;
    @Basic(optional = false)
    @Column(name = "DID")
    private int did;

    public AppointmentsPK() {
    }

    public AppointmentsPK(int pid, int hid, int did) {
        this.pid = pid;
        this.hid = hid;
        this.did = did;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) pid;
        hash += (int) hid;
        hash += (int) did;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppointmentsPK)) {
            return false;
        }
        AppointmentsPK other = (AppointmentsPK) object;
        if (this.pid != other.pid) {
            return false;
        }
        if (this.hid != other.hid) {
            return false;
        }
        if (this.did != other.did) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appointmentcalendar.AppointmentsPK[ pid=" + pid + ", hid=" + hid + ", did=" + did + " ]";
    }
    
}
