package ch.adifrei.jee.pktypes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Before;
import org.junit.Test;

import ch.adifrei.jee.pktypes.entities.city.City;
import ch.adifrei.jee.pktypes.entities.city.CityPk;
import ch.adifrei.jee.pktypes.entities.user.User;
import org.junit.Assert;

public class UserTest {

	private EntityManagerFactory fact;
	private EntityManager em;

	@Before
	public void setUp() {
		fact = Persistence.createEntityManagerFactory("pktypesample-jpa");
		em = fact.createEntityManager();
	}

	@Test
	public void testPersistUser() {
		em.getTransaction().begin();
		User u = new User("adrian", "password", "F");
		em.persist(u);
		em.getTransaction().commit();
		Assert.assertNotNull(u.getId().getId());
	}

	@Test
	public void testPersistUserWithFavorite() {
		em.getTransaction().begin();

		City favorite = em.find(City.class, new CityPk(1L));
		Assert.assertNotNull(favorite);

		User u = new User("aditest", "pwsd", "F");
		u.getFavorites().add(favorite);
		em.persist(u);
		em.getTransaction().commit();
		Assert.assertNotNull(u.getId().getId());
	}

	@Test
	public void testPersistUserWithHomeBase() {
		em.getTransaction().begin();

		City homebase = em.find(City.class, new CityPk(1L));
		Assert.assertNotNull(homebase);

		User u = new User("aditest2", "pw1sd", "F");
		u.setHomeBase(homebase);
		em.persist(u);
		em.getTransaction().commit();
		Assert.assertNotNull(u.getId().getId());
		Assert.assertNotNull(u.getHomeBase().getId());
	}
}
