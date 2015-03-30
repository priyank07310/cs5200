package edu.neu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.Cast;
import edu.neu.Comment;

public class CastManager {

	private Connection getConnection(){
		Connection connection=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-assign","root","root");
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}


	private void closeConnection(Connection connection) {
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void createCast(Cast newCast){
		
		String sql = "insert into MovieCast (castId, charName, actId, movId) values (NULL, ?,?,?)";
		Connection connection = getConnection();

		try 
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newCast.getCharName());
			statement.setInt(2, newCast.getMovId());
			statement.setInt(3, newCast.getActId());
		} 
		catch (SQLException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		finally 
		{
				closeConnection(connection);
		}
	}


	
public List<Cast> readAllCast() {
	
	String sql = "select castId, charname, movieId, actId from MovieCast";
	Connection connection=null;
	ArrayList<Cast> castList  = new ArrayList();
	
	try
	{
	connection = getConnection();
	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet results = statement.executeQuery();
	
	if(results.next()) 
		{
			Cast cast = new Cast();
			cast.setCastId(results.getInt("castId"));
			cast.setCharName(results.getString("charname"));
			cast.setMovId(results.getInt("movieId"));
			cast.setActId(results.getInt("actId"));
		
			castList.add(cast);
		}
	
	}
	
	catch (SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	finally 
	{
	closeConnection(connection);
	}
	
	return castList;	
}



public List<Cast> readAllCastForActor(int actId){
	
	Connection connection=null;
	String sql= "select castId, charname, movieId, actId from MovieCast where actId=?"; 
	ArrayList<Cast> castList = new ArrayList();
	
	connection = getConnection();
	PreparedStatement statement;
	Cast cast = new Cast();
	
	try 
	{
	statement = connection.prepareStatement(sql);
	
	statement.setInt(1, actId);
	ResultSet results = statement.executeQuery();
		
	if(results.next())
	  {
		cast.setCastId(results.getInt("castId"));
		cast.setCharName(results.getString("charname"));
		cast.setMovId(results.getInt("movieId"));
		cast.setActId(results.getInt("actId"));
		
		castList.add(cast);
	  }
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return castList;	
}


public List<Cast> readAllCastForMovie(int movieId){
	
	Connection connection=null;
	String sql= "select castId, charname, movieId, actId from MovieCast where movieId=?"; 
	ArrayList<Cast> castList = new ArrayList();
	
	connection = getConnection();
	PreparedStatement statement;
	Cast cast = new Cast();
	
	try 
	{
	statement = connection.prepareStatement(sql);
	
	statement.setInt(1, movieId);
	ResultSet results = statement.executeQuery();
		
	if(results.next())
	  {
		cast.setCastId(results.getInt("castId"));
		cast.setCharName(results.getString("charname"));
		cast.setMovId(results.getInt("movieId"));
		cast.setActId(results.getInt("actId"));
		
		castList.add(cast);
	  }
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return castList;	
}



public Cast readCastForId(int castId){
	
	Connection connection=null;
	String sql= "select castId, charname, movieId, actId from MovieCast where castId=?"; 
	ArrayList<Comment> castList = new ArrayList();
	
	connection = getConnection();
	PreparedStatement statement;
	Cast cast = new Cast();
	
	try 
	{
	statement = connection.prepareStatement(sql);
	
	statement.setInt(1, castId);
	ResultSet results = statement.executeQuery();
		
	if(! results.next())
	  {
		cast.setCastId(results.getInt("castId"));
		cast.setCharName(results.getString("charname"));
		cast.setMovId(results.getInt("movieId"));
		cast.setActId(results.getInt("actId"));
	  }
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return cast;	
}


public void updateCast(int castId, Cast newCast){

	Connection connection=null;
	String sql= "update Comments set charname=?, movieId=?, actId=? from Cast where castId=?"; 
		
	connection = getConnection();
	PreparedStatement statement;
		
	try 
	{
	statement = connection.prepareStatement(sql);
	statement.setString(1, newCast.getCharName());
	statement.setInt(2, newCast.getMovId());
	statement.setInt(3, newCast.getActId());
	
	ResultSet results = statement.executeQuery();
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
	

public void deleteCast(int castId){
	
	Connection connection=null;
	String sql= "delete from Cast where castId=?";
	PreparedStatement statement;
	
	try 
	{
	connection = getConnection();
	statement = connection.prepareStatement(sql);
	statement.setInt(1, castId);
	ResultSet result = statement.executeQuery();
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }

}
