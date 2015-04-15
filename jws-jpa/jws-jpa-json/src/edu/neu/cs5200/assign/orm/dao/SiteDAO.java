package edu.neu.cs5200.assign.orm.dao;

import edu.neu.cs5200.assign.orm.model.Site;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/site")
public class SiteDAO {

	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jws-jpa");
	EntityManager em = null; 
	
	
	// CREATE A NEW SITE - inserts a new site record into the database and then returns a list of all the sites
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite (Site site)
	{
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(site);
		
		em.getTransaction().commit();
		
		List<Site> st=findAllSites();
		st.add(site);
		return st;
		
	}
	
	
// FIND SITE BY  ID - returns an instance of Site representing a record whose id is id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite (@PathParam("id")Integer id)
	{
		em = factory.createEntityManager();
		
		return em.find(Site.class, id);
	}
	
	
// FIND ALL SITES -  returns a list of Site instances
	@GET	
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites()
	{
		em = factory.createEntityManager();
				
		Query query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();
	}
	
	
// UPDATE SITE - updates the site record whose id is id and then returns all the sites
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite (@PathParam("id")int id, Site site)
	{
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Site st = em.find(Site.class, id);
		st.setName(site.getName());
		st.setLatitude(site.getLatitude());
		st.setLongitude(site.getLongitude());
		em.merge(st);
		
		em.getTransaction().commit();
		
		Query query = em.createQuery("select site from Site site");
		return (List<Site>)query.getResultList();
	}
	

	// REMOVE SITE - removes a site record whose id is id and the returns a list of all the sites
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> deleteSite(@PathParam("id") int id)
	{
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Site st = em.find(Site.class, id);
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
		List <Site> st1 = dao.deleteSite(2);
		for (Site st2 : st1)
		{
		System.out.println(st2.getName());
		}
	}

}