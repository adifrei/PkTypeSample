package ch.adifrei.jee.pktypes.entities.city;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import ch.adifrei.jee.pktypes.entities.weather.Weather;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name", "zip" }) })
public class City {

	@EmbeddedId
	private CityPk id = new CityPk();

	private String name;

	private Long zip;

	@OneToMany
	private List<Weather> weather = new ArrayList<>();

	private Double latitude;
	private Double longitude;

	public City() {
		super();
	}

	public City(String name, Long zip) {
		super();
		this.name = name;
		this.zip = zip;
	}

	public CityPk getId() {
		if (id == null) {
			id = new CityPk();
		}
		return id;
	}

	public void setId(CityPk id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	public void addWeather(Weather w) {
		getWeather().add(w);
		w.setCity(this);
	}
	
	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", zip=" + zip + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}
