package ch.adifrei.jee.pktypes.entities.weather;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import ch.adifrei.jee.pktypes.entities.city.City;

@Entity
public class Weather {

	@EmbeddedId
	private WeatherPk id = new WeatherPk();

	@ManyToOne
	private City city;

	private LocalDate date;

	@Column(name = "last_updated")
	private LocalDateTime lastUpdated;

	@Column(name = "current_temp")
	private Double currentTemp;
	@Column(name = "date_max_temp")
	private Double dateMinTemp;
	@Column(name = "date_min_temp")
	private Double dateMaxTemp;
	private Double humidity;
	private String description;
	@Column(name = "wind_direction")
	private String windDirection;
	private String icon;

	@Column(name = "wind_speed")
	private Double windSpeed;

	private LocalDateTime sunset;

	private LocalDateTime sunrise;

	public Weather() {
		super();
	}

	public Weather(LocalDate date, LocalDateTime lastUpdated, Double currentTemp, Double dateMinTemp,
			Double dateMaxTemp, Double humidity, String description, String windDirection, String icon,
			Double windSpeed, LocalDateTime sunset, LocalDateTime sunrise) {
		super();
		this.date = date;
		this.lastUpdated = lastUpdated;
		this.currentTemp = currentTemp;
		this.dateMinTemp = dateMinTemp;
		this.dateMaxTemp = dateMaxTemp;
		this.humidity = humidity;
		this.description = description;
		this.windDirection = windDirection;
		this.icon = icon;
		this.windSpeed = windSpeed;
		this.sunset = sunset;
		this.sunrise = sunrise;
	}

	public WeatherPk getId() {
		return id;
	}

	public void setId(WeatherPk id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		city.getWeather().add(this);
		this.city = city;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Double getCurrentTemp() {
		return currentTemp;
	}

	public void setCurrentTemp(Double currentTemp) {
		this.currentTemp = currentTemp;
	}

	public Double getDateMinTemp() {
		return dateMinTemp;
	}

	public void setDateMinTemp(Double dateMinTemp) {
		this.dateMinTemp = dateMinTemp;
	}

	public Double getDateMaxTemp() {
		return dateMaxTemp;
	}

	public void setDateMaxTemp(Double dateMaxTemp) {
		this.dateMaxTemp = dateMaxTemp;
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public LocalDateTime getSunset() {
		return sunset;
	}

	public void setSunset(LocalDateTime sunset) {
		this.sunset = sunset;
	}

	public LocalDateTime getSunrise() {
		return sunrise;
	}

	public void setSunrise(LocalDateTime sunrise) {
		this.sunrise = sunrise;
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
		Weather other = (Weather) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
