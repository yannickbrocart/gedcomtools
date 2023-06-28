package com.yannick.gedcomtools.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gedcoms")
public class Gedcom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gedcom_id", nullable=false)
	private long gedcomId;

	@Column(name = "name", nullable=false)
	private String name;

	@Column(name = "creation_date", nullable=false)
	private Date creationTime;

	@Column(name = "last_access_date", nullable=true)
	private Date lastAccessTime;

	@Column(name = "last_modified_date", nullable=true)
	private Date lastModifiedTime;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gedcoms_users_id")
	@Column(name = "created_by", nullable=true)
	private User createdBy;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "gedcoms_users_id")
	@Column(name = "last_modified_by", nullable=true)
	private User lastModifiedBy;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private GedcomStatusType status;
	
	// private Header header = null;
	// private SubmissionRecord submissionRecord = null;
	// private Record record = null;
	// private TRLR trlr = null;

	public Gedcom() {}
	
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
