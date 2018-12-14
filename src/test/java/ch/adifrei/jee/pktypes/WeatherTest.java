package ch.adifrei.jee.pktypes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.adifrei.jee.pktypes.entities.weather.Weather;

public class WeatherTest {

	private EntityManagerFactory fact;
	private EntityManager em;

	@Before
	public void setUp() {
		fact = Persistence.createEntityManagerFactory("pktypesample-jpa");
		em = fact.createEntityManager();
	}

	@Test
	public void testPersistWeather() {
		em.getTransaction().begin();
		Weather w = new Weather(LocalDate.now(), LocalDateTime.now(), 2.5d, 2.0d, 5.0d, 0.85d, "Sehr kalt", "Ost",
				"cold.img", 6.56d, LocalDateTime.now(), LocalDateTime.now());
		em.persist(w);
		em.getTransaction().commit();
		Assert.assertNotNull(w.getId().getId());
	}

}
