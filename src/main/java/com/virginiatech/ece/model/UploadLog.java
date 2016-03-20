package com.virginiatech.ece.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the upload_log_tbl database table.
 * 
 */
@Entity
@Table(name="upload_log_tbl")
public class UploadLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int uploadID;

	@Column(name = "uploaddate")
	private String uploadDate;
	@Column(name = "uploadlocation")
	private String uploadLocation;
	@Column(name = "uploadname")
	private String uploadName;

	public UploadLog() {
	}

	public int getUploadID() {
		return this.uploadID;
	}

	public void setUploadID(int uploadID) {
		this.uploadID = uploadID;
	}

	public String getUploadDate() {
		return this.uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getUploadLocation() {
		return this.uploadLocation;
	}

	public void setUploadLocation(String uploadLocation) {
		this.uploadLocation = uploadLocation;
	}

	public String getUploadName() {
		return this.uploadName;
	}

	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}

}