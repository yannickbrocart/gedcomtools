package com.yannick.gedcomtools.model;

import java.util.Date;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "gedcom_files")
public class Gedcom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gedcom_file_id")
	private long gedcomId;

	@Column(name = "name", nullable = false, length = 64)
	private String name;

	/*
	 * private HeaderRecord header = null;
	 * 
	 * private SubmissionRecord submissionRecord = null;
	 * 
	 * private Record record = null;
	 * 
	 * private boolean trailer = null;
	 * 
	 */

	@Column(name = "creation_date")
	private Date creationTime;

	@Column(name = "last_access_date")
	private Date lastAccessTime;

	@Column(name = "last_modified_date")
	private Date lastModifiedTime;

	@ManyToOne
	@JoinColumn(referencedColumnName = "gedcom_file_user_id", name = "created_by")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@CreatedBy
	private User createdBy;

	@ManyToOne
	@JoinColumn(referencedColumnName = "gedcom_file_user_id", name = "last_modified_by")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LastModifiedBy
	private User lastModifiedBy;

	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	private GedcomStatusType status;

	public Gedcom() {
	}

	public Gedcom(String Name, User createdBy) {
		this.name = Name;
		this.creationTime = new Date();
		this.createdBy = createdBy;
		this.status = GedcomStatusType.created;
	}

	public Gedcom(long gedcomId, String name, Date creationTime, Date lastAccessTime, Date lastModified, User createdBy,
			User lastModifiedBy, GedcomStatusType status) {
		this.gedcomId = gedcomId;
		this.name = name;
		this.creationTime = creationTime;
		this.lastAccessTime = lastAccessTime;
		this.lastModifiedTime = lastModified;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.status = status;
	}

	public long getGedcomId() {
		return this.gedcomId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String Name) {
		this.name = Name;
	}

	public Date getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Date CreationTime) {
		this.creationTime = new Date();
	}

	public Date getLastModifiedTime() {
		return this.lastModifiedTime;
	}

	public void setLastModifiedTime(Date LastModifiedTime) {
		this.lastModifiedTime = new Date();
	}

	public Date getLastAccessTime() {
		return this.lastAccessTime;
	}

	public void setLastAccessTime(Date LastAccessTime) {
		this.lastAccessTime = new Date();
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(User lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public GedcomStatusType getStatus() {
		return status;
	}

	public void setStatus(GedcomStatusType status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Gedcom [gedcomId = " + gedcomId + ", name = " + name + ", creationTime = " + creationTime
				+ ", lastAccessTime = " + lastAccessTime + ", lastModifiedTime = " + lastModifiedTime + ", createdBy = "
				+ createdBy + ", lastModifiedBy = " + lastModifiedBy + ", status = " + status + "]";
	}

}
