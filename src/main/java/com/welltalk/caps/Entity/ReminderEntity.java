package com.welltalk.caps.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_reminder")

public class ReminderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderId;
    private String title;
    private String reminder;
    private String counselor;
    private String date;
    // Use @Lob to store binary data (e.g., images)
    @Lob
    @Column(columnDefinition = "LONGBLOB")

    private byte[] image;

    public ReminderEntity() {
        // Default constructor
    }

	public ReminderEntity(Long reminderId, String title, String reminder, String counselor, String date, byte[] image) {
		super();
		this.reminderId = reminderId;
		this.title = title;
		this.reminder = reminder;
		this.counselor = counselor;
		this.date = date;
		this.image = image;
	}

	public Long getReminderId() {
		return reminderId;
	}

	public void setReminderId(Long reminderId) {
		this.reminderId = reminderId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReminder() {
		return reminder;
	}

	public void setReminder(String reminder) {
		this.reminder = reminder;
	}

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	

}