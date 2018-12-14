package ch.adifrei.jee.pktypes.entities.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ch.adifrei.jee.pktypes.entities.city.City;

@Entity
public class User {

	@EmbeddedId
	private UserPk id = new UserPk();

	@Column(unique = true, length = 200)
	private String username;

	private String password;

	@Column(name = "temperature_unit")
	private String temperatureUnit;

	@OneToMany
	private List<City> favorites = new ArrayList<>();

//	@OneToOne(mappedBy="home_base_id")
	private City homeBase;

	public User(String username, String password, String temperatureUnit) {
		super();
		this.username = username;
		this.password = password;
		this.temperatureUnit = temperatureUnit;
	}

	public User() {
	}

	public UserPk getId() {
		return id;
	}

	public void setId(UserPk id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTemperatureUnit() {
		return temperatureUnit;
	}

	public void setTemperatureUnit(String temperatureUnit) {
		this.temperatureUnit = temperatureUnit;
	}

	public List<City> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<City> favorites) {
		this.favorites = favorites;
	}

	public City getHomeBase() {
		return homeBase;
	}

	public void setHomeBase(City homeBase) {
		this.homeBase = homeBase;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
