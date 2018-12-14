package ch.adifrei.jee.pktypes;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ch.adifrei.jee.pktypes.entities.city.City;
import ch.adifrei.jee.pktypes.entities.city.CityPk;



public class PkTypeSampleApp {
	final static Logger logger = Logger.getLogger(PkTypeSampleApp.class.getSimpleName());

	public static void main(String[] args) {
		EntityManagerFactory fact = Persistence.createEntityManagerFactory("pktypesample-jpa");
		EntityManager em = fact.createEntityManager();
		logger.info("Open" + em.isOpen());
		
		CityPk pk = new CityPk(1L);
		
		City  c = em.find(City.class, pk);
		
		logger.info("Result: "+ c);
		 
		em.getTransaction().begin();
		City insert = new City("Entenhausen", 9999L);
		em.persist(insert);
		em.getTransaction().commit();
		em.close();
		fact.close();
	}
}
