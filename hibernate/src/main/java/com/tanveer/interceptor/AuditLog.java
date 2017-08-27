package com.tanveer.interceptor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditlog", catalog = "tanveerdb")
public class AuditLog implements java.io.Serializable {

	private static final long serialVersionUID = -39673005068818634L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long auditLogId;
	private String action;
	private String detail;
	private Date createdDate;
	private long entityId;
	private String entityName;
	
	public AuditLog(String action, String detail, Date createdDate, Long auditLogId, String entityName) {
		this.action=action;
		this.detail=detail;
		this.createdDate=createdDate;
		this.auditLogId=auditLogId;
		this.entityName=entityName;
	}
	
	public Long getAuditLogId() {
		return auditLogId;
	}
	public void setAuditLogId(Long auditLogId) {
		this.auditLogId = auditLogId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public long getEntityId() {
		return entityId;
	}
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
        
}