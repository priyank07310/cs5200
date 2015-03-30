package edu.neu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.Movie;

public class MovieManager {

	
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



public void createMovie(Movie newMovie) {
	
	String sql = "insert into Movie (id, title, posterImage, releaseDate) values (NULL,?,?,?)";
	Connection connection = getConnection();

	try 
	{
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, newMovie.getTitle());
		statement.setString(2, newMovie.getPosterImage());
		statement.setDate(3, newMovie.getReleaseDate());
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


	public List<Movie> readAllMovies() {
		
		String sql = "select id, title, posterImage, releaseDate from Movie";
		Connection connection=null;
		ArrayList<Movie> movieList  = new ArrayList();
		
		try
		{
		connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet results = statement.executeQuery();
		
		if(results.next()) 
			{
				Movie movie = new Movie();
				movie.setId(results.getInt("id"));
				movie.setTitle(results.getString("title"));
				movie.setPosterImage(results.getString("posterImage"));
				movie.setReleaseDate(results.getDate("releaseDate"));
			
				movieList.add(movie);
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
		
		return movieList;	
	}

	
	public Movie readMovie(int movieId){
		
	Connection connection=null;
	String sql= "select id, title, posterImage, releaseDate from Movie where id=?"; 
	
	
	connection = getConnection();
	PreparedStatement statement;
	Movie movie = new Movie();
	
	try 
	{
	statement = connection.prepareStatement(sql);
	
	statement.setInt(1, movieId);
	ResultSet results = statement.executeQuery();
		
	if(! results.wasNull())
	  {
		movie.setId(results.getInt("id"));
		movie.setTitle(results.getString("title"));
		movie.setPosterImage(results.getString("posterImage"));
		movie.setReleaseDate(results.getDate("releaseDate"));
		
	  }
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return movie;
	
}

	
public void updateMovie(int movieId, Movie movie){
	
	Connection connection=null;
	String sql= "update Movie set title=?, posterImage=?, releaseDate=? where id=?";
	
	try
	{
	connection = getConnection();
	PreparedStatement statement = connection.prepareStatement(sql);
	statement.setString(1, movie.getTitle());
	statement.setString(2, movie.getPosterImage());
	statement.setDate(3, movie.getReleaseDate());
	
	ResultSet results = statement.executeQuery();
	}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void deleteMovie(int movieId){
	
	Connection connection=null;
	String sql= "delete from Movie where id=?";
	PreparedStatement statement;
	
	try 
	{
	connection = getConnection();
	statement = connection.prepareStatement(sql);
	statement.setInt(1, movieId);
	ResultSet result = statement.executeQuery();
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }

}
