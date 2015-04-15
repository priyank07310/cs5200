package edu.neu.cs5200.assign.orm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Site {
	
	@Id
	private int id;
	private String name;
	private float latitude;
	private float longitude;
	
	@OneToMany(mappedBy="site",cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Tower> Towers;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public List<Tower> getTowers() {
		return Towers;
	}
	public void setTowers(List<Tower> towers) {
		Towers = towers;
	}
	public Site(int id, String name, float latitude, float longitude,
			List<Tower> towers) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		Towers = towers;
	}
	public Site() {
		super();
		// TODO Auto-generated constructor stub
	}
	
		
	
}
