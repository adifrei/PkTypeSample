package ch.adifrei.jee.pktypes;


import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.adifrei.jee.pktypes.entities.city.City;
import ch.adifrei.jee.pktypes.entities.weather.Weather;

public class CityTest {

	private EntityManagerFactory fact;
	private EntityManager em;

	@Before
	public void setUp() {
		fact = Persistence.createEntityManagerFactory("pktypesample-jpa");
		em = fact.createEntityManager();
	}

	@Test
	public void testPersistCity() {
		em.getTransaction().begin();
		City c = new City("Entenhausen", 9999L);
		em.persist(c);
		em.getTransaction().commit();
		Assert.assertNotNull(c.getId().getId());
	}

	@Test
	public void testPersistCityWithWeather() {

		em.getTransaction().begin();

		Weather w = new Weather(LocalDate.now().plusDays(1), LocalDateTime.now().plusDays(1), 2.5d, 2.0d, 5.0d, 0.85d, "Sehr kalt", "Ost",
				"cold.img", 6.56d, LocalDateTime.now(), LocalDateTime.now());
		em.persist(w);

		City c = new City("Entenhausen", 9998L);
		em.persist(c);

//		c.addWeather(w);
		w.setCity(c);
		
		em.persist(c);

		em.getTransaction().commit();
		Assert.assertNotNull(c.getId().getId());
		Assert.assertNotNull(w.getCity());
		Assert.assertTrue(c.getWeather().contains(w));
	}
}
