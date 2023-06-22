package com.yannick.gedcomtools.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GEDCOMS")
public class Gedcom {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "creation_time")
	private Date creationTime;

	@Column(name = "last_access_time")
	private Date lastAccessTime;

	@Column(name = "last_modified_time")
	private Date lastModifiedTime;

	@Column(name = "created_by")
	private User createdBy;

	@Column(name = "last_modified_by")
	private User lastModifiedBy;

	@Column(name = "status")
	private GedcomStatusType status;
	// private Header header = null;
	// private SubmissionRecord submissionRecord = null;
	// private Record record = null;
	// private TRLR trlr = null;

	public Gedcom(String Name, User createdBy) {
		this.name = Name;
		this.creationTime = new Date();
		this.createdBy = createdBy;
		this.status = GedcomStatusType.created;
	}

	public Gedcom(long id, String name, Date creationTime, Date lastAccessTime, Date lastModified, User createdBy,
			User lastModifiedBy, GedcomStatusType status) {
		this.id = id;
		this.name = name;
		this.creationTime = creationTime;
		this.lastAccessTime = lastAccessTime;
		this.lastModifiedTime = lastModified;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.status = status;
	}

	public long getId() {
		return this.id;
	}

	public void setId(int Id) {
		this.id = Id;
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
		return "Gedcom [id = " + id + ", name = " + name + ", creationTime = " + creationTime + ", lastAccessTime = "
				+ lastAccessTime + ", lastModifiedTime = " + lastModifiedTime + ", createdBy = " + createdBy
				+ ", lastModifiedBy = " + lastModifiedBy + ", status = " + status + "]";
	}

}
