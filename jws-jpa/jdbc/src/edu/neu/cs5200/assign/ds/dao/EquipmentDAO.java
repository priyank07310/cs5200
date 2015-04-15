package edu.neu.cs5200.assign.ds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



import edu.neu.cs5200.assign.ds.model.Equipment;

public class EquipmentDAO {

	DataSource ds;
	
	public EquipmentDAO()
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
	
	// create a Equipment
	public Equipment create(Equipment eqp)
	{
		String sql ="insert into EQUIPMENT values (null,?,?,?,?,?)";
		Connection conn;
		
		try {
			conn = ds.getConnection();
			PreparedStatement prep = conn.prepareStatement(sql);
			
			prep.setString(1,eqp.getEqName());
			prep.setString(2,eqp.getBrand());
			prep.setString(3,eqp.getDesc());
			prep.setLong(4,eqp.getPrice());
			prep.setLong(5,eqp.getId());
			
			prep.executeUpdate();
			
			}
		
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	// retrieve an Equipment
	
	// update an Equipment
	
	// delete an Equipment
}
