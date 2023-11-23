package com.welltalk.caps.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_journal")
public class JournalEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int JournalID;
		
		private int userid;
		private String Type;
		private String Date;
		private String Mood;
		private String Title;
		private String Message;
		public JournalEntity() {
			
		}
		public JournalEntity(int journalID, int userid, String type, String date, String mood, String title, String message) {
			super();
			
			JournalID = journalID;
			userid = userid;
			Type = type;
			Date = date;
			Mood = mood;
			Title = title;
			Message = message;
		}
		public int getJournalID() {
			return JournalID;
		}
		
		public String getType() {
			return Type;
		}
		public int getUserid() {
			return userid;
		}
		public void setType(String type) {
			Type = type;
		}
		public String getDate() {
			return Date;
		}
		public void setDate(String date) {
			Date = date;
		}
		public String getMood() {
			return Mood;
		}
		public void setMood(String mood) {
			Mood = mood;
		}
		public String getTitle() {
			return Title;
		}
		public void setTitle(String title) {
			Title = title;
		}
		public String getMessage() {
			return Message;
		}
		public void setMessage(String message) {
			Message = message;
		}
		
}
