package edu.neu.cs5200.assign.orm.dao;

import edu.neu.cs5200.assign.orm.model.Site;




import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class SiteDAO {

	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jws-jpa");
	EntityManager em = null; 
	
	

 	
	
// CREATE A NEW SITE - inserts a new site record into the database and then returns a list of all the sites
	public List<Site> createSite (Site site)
	{
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(site);
		
		em.getTransaction().commit();
		
		
		Query query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();
	}
	
	
// FIND SITE BY  ID - returns an instance of Site representing a record whose id is siteId
	public Site findSite (Integer siteId)
	{
		em = factory.createEntityManager();
		
		return em.find(Site.class, siteId);
	}
	
	
// FIND ALL SITES -  returns a list of Site instances
	public List<Site> findAllSites()
	{
		em = factory.createEntityManager();
				
		Query query = em.createQuery("select site from Site site");
		
		return (List<Site>)query.getResultList();
	}
	
	
// UPDATE SITE - updates the site record whose id is siteId and then returns all the sites
	public List<Site> updateSite (Integer siteId, Site site)
	{
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Site st = em.find(Site.class, siteId);
		st.setName(site.getName());
		st.setLatitude(site.getLatitude());
		st.setLongitude(site.getLongitude());
		em.merge(st);
		
		em.getTransaction().commit();
		
		Query query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();
	}
	
// REMOVE SITE - removes a site record whose id is siteId and the returns a list of all the sites
	
	public List<Site> removeSite(int siteId)
	{
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Site st = em.find(Site.class, siteId);
		em.remove(st);
		
		em.getTransaction().commit();
		
		Query query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();
	}
	

	public static void main(String[] args) {
		SiteDAO dao = new SiteDAO();
		//Site site = new Site (null,"Boston", "110'76", "117'90");
		//List<Site> sites = dao.createSite (site);
		Site st = new Site();
		List <Site> st1 = dao.removeSite(2);
		for (Site st2 : st1)
		{
		System.out.println(st2.getName());
		}
	}

}