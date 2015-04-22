package edu.neu.cs5200.assign.orm.dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import edu.neu.cs5200.assign.orm.model.Site;
import edu.neu.cs5200.assign.orm.model.Sites;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.persistence.*;
import javax.print.attribute.standard.Media;


@Path("/site")
public class SiteDAO {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("jws-jpa");
	EntityManager em = factory.createEntityManager();

	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	//createSite
	public List<Site> createSite(Site site) {
		em.getTransaction().begin();
		em.persist(site);
		em.getTransaction().commit();
		List<Site> sites=findAllSites();
		sites.add(site);
		return sites;
	}
	
	//findsiteByID
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id")Integer id)
	{
		return em.find(Site.class,id);
	}
	
	
	@GET	
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	//findAllSites
	public List<Site> findAllSites()
	{
		Query query=em.createQuery("select site from Site site ");
		return (List<Site>)query.getResultList();
	}
	
	//updateSite
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id")Integer id,Site site)
	{
		site=findSite(id);
		site.setName("hello");
		em.getTransaction().begin();
		em.merge(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<Site> removeSite(@PathParam("id") int i) {
		Site site=findSite(i);
		em.getTransaction().begin();
		em.remove(site);
		em.getTransaction().commit();
		return findAllSites();
	}
	public static void main(String[] args){
		
		SiteDAO dao = new SiteDAO();
		
		
		List<Site> updatedsites = dao.findAllSites();
			for(Site updatedsite: updatedsites)
			{
				System.out.println(updatedsite.getName());
	 	    }
			
	}
	


	
	
}