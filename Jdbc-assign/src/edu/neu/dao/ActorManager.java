package edu.neu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.Actor;

public class ActorManager {

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



	public void createActor(Actor newActor) {
		
		String sql = "insert into Movie (actId, firstName, lastName, dateOfBirth) values (NULL,?,?,?)";
		Connection connection = getConnection();

		try 
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newActor.getFirstName());
			statement.setString(2, newActor.getLastName());
			statement.setDate(3, newActor.getDateOfBirth());
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


		public List<Actor> readAllActors() {
			
			String sql = "select actId, firstName, lastName, dateOfBirth from Actor";
			Connection connection=null;
			ArrayList<Actor> actorList  = new ArrayList();
			
			try
			{
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet results = statement.executeQuery();
			
			if(results.next()) 
				{
					Actor actor = new Actor();
					actor.setActId(results.getInt("actId"));
					actor.setFirstName(results.getString("firstName"));
					actor.setLastName(results.getString("lastName"));
					actor.setDateOfBirth(results.getDate("releaseDate"));
				
					actorList.add(actor);
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
			
			return actorList;	
		}

		
		public Actor readActor(int actId){
			
		Connection connection=null;
		String sql= "select actId, firstName, lastName, releaseDate from Actor where actId=?"; 
		
		
		connection = getConnection();
		PreparedStatement statement;
		Actor actor = new Actor();
		
		try 
		{
		statement = connection.prepareStatement(sql);
		
		statement.setInt(1, actId);
		ResultSet results = statement.executeQuery();
			
		if(! results.wasNull())
		  {
			actor.setActId(results.getInt("actId"));
			actor.setFirstName(results.getString("firstName"));
			actor.setLastName(results.getString("lasdName"));
			actor.setDateOfBirth(results.getDate("releaseDate"));
			
		  }
		}
	    
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return actor;
		
	}

		
	public void updateActor(int actId, Actor actor){
		
		Connection connection=null;
		String sql= "update Movie set firstName=?, lastName=?, releaseDate=? where actId=?";
		
		try
		{
		connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, actor.getFirstName());
		statement.setString(2, actor.getLastName());
		statement.setDate(3, actor.getDateOfBirth());
		
		ResultSet results = statement.executeQuery();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteMovie(int actId){
		
		Connection connection=null;
		String sql= "delete from Actor where actId=?";
		PreparedStatement statement;
		
		try 
		{
		connection = getConnection();
		statement = connection.prepareStatement(sql);
		statement.setInt(1, actId);
		ResultSet result = statement.executeQuery();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }


}
