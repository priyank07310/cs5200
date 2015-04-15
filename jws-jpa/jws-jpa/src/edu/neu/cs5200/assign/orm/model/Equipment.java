package edu.neu.cs5200.assign.orm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.*;

@Entity
public class Equipment {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String brand;
	@XmlAttribute
	private String description;
	@XmlAttribute
	private int price;
	@XmlAttribute
	private int towerid;
	
	@ManyToOne
	@JoinColumn(name="towerId")
	@XmlTransient
	private Tower tower;

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTowerid() {
		return towerid;
	}

	public void setTowerid(int towerid) {
		this.towerid = towerid;
	}

	public Tower getTower() {
		return tower;
	}

	public void setTower(Tower tower) {
		this.tower = tower;
	}

	public Equipment() {
		super();
	}
	
}