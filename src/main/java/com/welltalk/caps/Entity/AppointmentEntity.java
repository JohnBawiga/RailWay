package com.welltalk.caps.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_appointment")
public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int makeappointmentid;

    private String Date;
    private String Time;
    private String message;
    private int userid;
    private boolean decision;

    public AppointmentEntity() {
    }

    public AppointmentEntity(int makeappointmentid, String date, String time, String message, int userid, boolean decision) {
        super();
        this.makeappointmentid = makeappointmentid;
        Date = date;
        Time = time;
        this.message = message;
        this.userid = userid;
        this.decision = decision;
    }

    public int getMakeAppointmentid() {
        return makeappointmentid;
    }

    public void setAppointmentid(int makeappointmentid) {
        this.makeappointmentid = makeappointmentid;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public boolean getDecision() {
        return decision;
    }

    public void setDecision(boolean decision) {
        this.decision = decision;
    }
}
