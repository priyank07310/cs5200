package cs5200.edu.neu.dao;

import java.io.*;
import java.util.*;

import javax.xml.bind.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.persistence.*;

import cs5200.edu.neu.entity.*;


public class siteDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("xslt-jpa");
	EntityManager em = null;
	
	public Site findSite(int siteId) {
		Site site = null;
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		site = em.find(Site.class, siteId);
		
		em.getTransaction().commit();
		em.close();
		
		return site;
	}
	
	public List<Site> findAllSites() {
		List<Site> sites = new ArrayList<Site>();
		
		em = factory.createEntityManager();
		em.getTransaction().begin();
		
		Query query = em.createNamedQuery("findAllSites");
		sites = query.getResultList();
		
		em.getTransaction().commit();
		em.close();

		return sites;
	}
	
	public void exportSitesToXmlFile(SiteList sites, String xmlFileName) {
		File xmlFile = new File(xmlFileName);
		try {
			JAXBContext jaxb = JAXBContext.newInstance(SiteList.class);
			Marshaller marshaller = jaxb.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(sites, xmlFile);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void convertXmlFileToOutputFile(
			String sitesXmlFileName,
			String outputFileName,
			String xsltFileName)
	{
		File inputXmlFile = new File(sitesXmlFileName);
		File outputXmlFile = new File(outputFileName);
		File xsltFile = new File(xsltFileName);
		
		StreamSource source = new StreamSource(inputXmlFile);
		StreamSource xslt    = new StreamSource(xsltFile);
		StreamResult output = new StreamResult(outputXmlFile);
		
		TransformerFactory  factory = TransformerFactory.newInstance();
		try {
			Transformer transformer = factory.newTransformer(xslt);
			transformer.transform(source, output);
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		siteDAO d = new siteDAO();
		
		Site site = d.findSite(1);
		
		List<Site> sites = d.findAllSites();
		for(Site dir:sites) 
		{
			System.out.println(dir.getId());
			System.out.println(dir.getLatitude());
			System.out.println(dir.getLongitude());
			System.out.println(dir.getName());
		}
		
		SiteList sl=new SiteList();
		sl.setSites(sites);
		
		d.exportSitesToXmlFile(sl,"xml/SiteList.xml");
		d.convertXmlFileToOutputFile("xml/SiteList.xml", "xml/sites.html", "xml/sites2html.xslt");
		d.convertXmlFileToOutputFile("xml/SiteList.xml", "xml/equipments.html", "xml/sites2equipment.xslt");
		
	
	}
}