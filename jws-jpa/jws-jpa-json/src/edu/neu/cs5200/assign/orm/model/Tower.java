package edu.neu.cs5200.assign.orm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Tower{

	@Id
	private int id;
	
	private String name;
	private float height;
	private int sides;
	private Integer siteid;
	@ManyToOne
	@JoinColumn(name="siteId")
	
	private Site site;
	@OneToMany(mappedBy="tower", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Equipment> equipments;
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
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public Integer getSiteid() {
		return siteid;
	}
	public void setSiteid(Integer siteid) {
		this.siteid = siteid;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	public Tower() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tower(int id, String name, float height, int sides, Integer siteid,
			Site site, List<Equipment> equipments) {
		super();
		this.id = id;
		this.name = name;
		this.height = height;
		this.sides = sides;
		this.siteid = siteid;
		this.site = site;
		this.equipments = equipments;
	}
	
	
	
	
}
