package edu.neu.cs5200.assign.orm.model;

import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@NamedQueries(value = { @NamedQuery(
		name = "findAllSites",
		query = "select dir from Site dir") })
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
public class Site {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@XmlAttribute
	private int id;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private float latitude;
	@XmlAttribute
	private float longitude;
	
	@OneToMany(mappedBy="site", cascade=CascadeType.ALL, orphanRemoval=true)
	@XmlElement(name="tower")
	private List<Tower> towers;

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
		return towers;
	}

	public void setTowers(List<Tower> towers) {
		this.towers = towers;
	}

	public Site(int id, String name, float latitude, float longitude,
			List<Tower> towers) {
		super();
		this.id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.towers = towers;
	}

	public Site() {
		super();
	}
	
	
}