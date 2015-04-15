package edu.neu.cs5200.assign.orm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.*;

	@Entity
	@XmlRootElement
	@XmlAccessorType(value = XmlAccessType.FIELD)
	public class Tower {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@XmlAttribute
		private int id;
		@XmlAttribute
		private String name;
		@XmlAttribute
		private int height;
		@XmlAttribute
		private int sides;
		
		@OneToMany(mappedBy="tower", cascade=CascadeType.ALL, orphanRemoval=true)
		@XmlElement(name="equipment")
		private List<Equipment> equipments;
		@ManyToOne
		@JoinColumn(name="siteId")
		@XmlTransient
		private Site site;
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
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getSides() {
			return sides;
		}
		public void setSides(int sides) {
			this.sides = sides;
		}
		public List<Equipment> getEquipments() {
			return equipments;
		}
		public void setEquipments(List<Equipment> equipments) {
			this.equipments = equipments;
		}
		public Site getSite() {
			return site;
		}
		public void setSite(Site site) {
			this.site = site;
		}
		public Tower() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}	