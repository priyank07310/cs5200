package edu.neu.cs5200.assign.orm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipment {

	@Id
	private Integer eid;
	private String ename;
	private String brand;
	private String description;
	private Integer price;
	private Integer towerid;
	
	
	public Equipment(Integer eid, String ename, String brand,
			String description, Integer price, Integer towerid) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.brand = brand;
		this.description = description;
		this.price = price;
		this.towerid = towerid;
	}


	public Equipment() {
		super();
	}


	public Integer getEid() {
		return eid;
	}


	public void setEid(Integer eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getTowerid() {
		return towerid;
	}


	public void setTowerid(Integer towerid) {
		this.towerid = towerid;
	}
	
	
	
}
