package com.welltalk.caps.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_schedule")
public class ScheduleEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleid;
	
	private String counselorid;
    private String date;
    private String time;
    private String type;
    private boolean done;
    private String userid;
    
    public ScheduleEntity() {
    	
    }

	public ScheduleEntity(Long scheduleid, String counselorid, String date, String time, String type, boolean done,
			String userid) {
		super();
		this.scheduleid = scheduleid;
		this.counselorid = counselorid;
		this.date = date;
		this.time = time;
		this.type = type;
		this.done = done;
		this.userid = userid;
	}

	public Long getScheduleid() {
		return scheduleid;
	}

	public void setScheduleid(Long scheduleid) {
		this.scheduleid = scheduleid;
	}

	public String getCounselorid() {
		return counselorid;
	}

	public void setCounselorid(String counselorid) {
		this.counselorid = counselorid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	
	
}
