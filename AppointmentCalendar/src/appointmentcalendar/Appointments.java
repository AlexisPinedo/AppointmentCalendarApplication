/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointmentcalendar;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Pir8
 */
@Entity
@Table(name = "APPOINTMENTS", catalog = "", schema = "NEWUSER")
@NamedQueries({
    @NamedQuery(name = "Appointments.findAll", query = "SELECT a FROM Appointments a")
    , @NamedQuery(name = "Appointments.findByPid", query = "SELECT a FROM Appointments a WHERE a.appointmentsPK.pid = :pid")
    , @NamedQuery(name = "Appointments.findByPfname", query = "SELECT a FROM Appointments a WHERE a.pfname = :pfname")
    , @NamedQuery(name = "Appointments.findByPlname", query = "SELECT a FROM Appointments a WHERE a.plname = :plname")
    , @NamedQuery(name = "Appointments.findByHid", query = "SELECT a FROM Appointments a WHERE a.appointmentsPK.hid = :hid")
    , @NamedQuery(name = "Appointments.findByHospitalname", query = "SELECT a FROM Appointments a WHERE a.hospitalname = :hospitalname")
    , @NamedQuery(name = "Appointments.findByHospitaladdress", query = "SELECT a FROM Appointments a WHERE a.hospitaladdress = :hospitaladdress")
    , @NamedQuery(name = "Appointments.findByDid", query = "SELECT a FROM Appointments a WHERE a.appointmentsPK.did = :did")
    , @NamedQuery(name = "Appointments.findByDoctorname", query = "SELECT a FROM Appointments a WHERE a.doctorname = :doctorname")
    , @NamedQuery(name = "Appointments.findByAppointmentdatetime", query = "SELECT a FROM Appointments a WHERE a.appointmentdatetime = :appointmentdatetime")})
public class Appointments implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AppointmentsPK appointmentsPK;
    @Basic(optional = false)
    @Column(name = "PFNAME")
    private String pfname;
    @Basic(optional = false)
    @Column(name = "PLNAME")
    private String plname;
    @Basic(optional = false)
    @Column(name = "HOSPITALNAME")
    private String hospitalname;
    @Basic(optional = false)
    @Column(name = "HOSPITALADDRESS")
    private String hospitaladdress;
    @Basic(optional = false)
    @Column(name = "DOCTORNAME")
    private String doctorname;
    @Column(name = "APPOINTMENTDATETIME")
    private String appointmentdatetime;

    public Appointments() {
    }

    public Appointments(AppointmentsPK appointmentsPK) {
        this.appointmentsPK = appointmentsPK;
    }

    public Appointments(AppointmentsPK appointmentsPK, String pfname, String plname, String hospitalname, String hospitaladdress, String doctorname) {
        this.appointmentsPK = appointmentsPK;
        this.pfname = pfname;
        this.plname = plname;
        this.hospitalname = hospitalname;
        this.hospitaladdress = hospitaladdress;
        this.doctorname = doctorname;
    }

    public Appointments(int pid, int hid, int did) {
        this.appointmentsPK = new AppointmentsPK(pid, hid, did);
    }

    public AppointmentsPK getAppointmentsPK() {
        return appointmentsPK;
    }

    public void setAppointmentsPK(AppointmentsPK appointmentsPK) {
        this.appointmentsPK = appointmentsPK;
    }

    public String getPfname() {
        return pfname;
    }

    public void setPfname(String pfname) {
        String oldPfname = this.pfname;
        this.pfname = pfname;
        changeSupport.firePropertyChange("pfname", oldPfname, pfname);
    }

    public String getPlname() {
        return plname;
    }

    public void setPlname(String plname) {
        String oldPlname = this.plname;
        this.plname = plname;
        changeSupport.firePropertyChange("plname", oldPlname, plname);
    }

    public String getHospitalname() {
        return hospitalname;
    }

    public void setHospitalname(String hospitalname) {
        String oldHospitalname = this.hospitalname;
        this.hospitalname = hospitalname;
        changeSupport.firePropertyChange("hospitalname", oldHospitalname, hospitalname);
    }

    public String getHospitaladdress() {
        return hospitaladdress;
    }

    public void setHospitaladdress(String hospitaladdress) {
        String oldHospitaladdress = this.hospitaladdress;
        this.hospitaladdress = hospitaladdress;
        changeSupport.firePropertyChange("hospitaladdress", oldHospitaladdress, hospitaladdress);
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        String oldDoctorname = this.doctorname;
        this.doctorname = doctorname;
        changeSupport.firePropertyChange("doctorname", oldDoctorname, doctorname);
    }

    public String getAppointmentdatetime() {
        return appointmentdatetime;
    }

    public void setAppointmentdatetime(String appointmentdatetime) {
        String oldAppointmentdatetime = this.appointmentdatetime;
        this.appointmentdatetime = appointmentdatetime;
        changeSupport.firePropertyChange("appointmentdatetime", oldAppointmentdatetime, appointmentdatetime);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentsPK != null ? appointmentsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Appointments)) {
            return false;
        }
        Appointments other = (Appointments) object;
        if ((this.appointmentsPK == null && other.appointmentsPK != null) || (this.appointmentsPK != null && !this.appointmentsPK.equals(other.appointmentsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "appointmentcalendar.Appointments[ appointmentsPK=" + appointmentsPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
