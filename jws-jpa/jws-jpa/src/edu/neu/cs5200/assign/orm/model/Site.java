package edu.neu.cs5200.assign.orm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Site {
	
	@Id
	private Integer sid;
	private String tname;
	private String latitude;
	private String longitude;
	
	
	public Integer getSid() {
		return sid;
	}


	public void setSid(Integer sid) {
		this.sid = sid;
	}


	public String getTname() {
		return tname;
	}


	public void setTname(String tname) {
		this.tname = tname;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	
	public Site(Integer sid, String tname, String latitude, String longitude) {
		super();
		this.sid = sid;
		this.tname = tname;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public Site() {
		super();
	}
	
	
	
	
	
	
}
