package edu.neu.cs5200.assign.ds.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.neu.cs5200.assign.ds.model.Tower;

public class TowerDAO {
	
	DataSource ds;
		
		public TowerDAO()
		{
			try 
		
		{
			Context ctx;
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookupLink("java:comp/env/jdbc/jws-jpaDB");
			System.out.println(ds);
		} 
		catch (NamingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		// create a new Tower
		public Tower create(Tower tow)
		{
			return null;
		}
		
}			
