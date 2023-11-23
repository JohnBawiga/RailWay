package com.welltalk.caps.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_guidance")
public class GuidanceEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int scheduleID;
		
		private int appointmentid;
		private String counselorsName;
		private String Date;
		private String Time;
		private String Type;
		
		
		
		public GuidanceEntity() {
		}

		public GuidanceEntity(int scheduleID,  int appointmentid, String counselorsName, String date, String time, String type) {
			super();
			this.scheduleID = scheduleID;
			this.appointmentid = appointmentid;
			this.counselorsName = counselorsName;
			Date = date;
			Time = time;
			Type = type;
		}

		public int getScheduleID() {
			return scheduleID;
		}
		
	
		public int getAppointmentid() {
			return appointmentid;
		}
		public void setAppointmentid(int appointmentid) {
			this.appointmentid = appointmentid;
		}
		public String getCounselorsName() {
			return counselorsName;
		}
		public void setCounselorsName(String counselorsName) {
			this.counselorsName = counselorsName;	
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
		public String getType() {
			return Type;
		}
		public void setType(String type) {
			Type = type;
		}
		
}
