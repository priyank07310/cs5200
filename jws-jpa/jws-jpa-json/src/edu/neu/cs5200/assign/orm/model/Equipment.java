package edu.neu.cs5200.assign.orm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Equipment {

	@Id
	private int id;
	
	private String name;
	private String brand;
	private String description;
	private float price;
	private float towerid;
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTowerid() {
		return towerid;
	}
	public void setTowerid(float towerid) {
		this.towerid = towerid;
	}
	public Equipment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
