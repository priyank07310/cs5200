package edu.neu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.Comment;

public class CommentManager {

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


	public void createComment(Comment newComment){
		
		String sql = "insert into Comments (commId, comment, commDate, username, movieId) values (NULL, ?,?,?,?)";
		Connection connection = getConnection();

		try 
		{
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newComment.getComment());
			statement.setDate(2, newComment.getCommDate());
			statement.setString(3, newComment.getUsername());
			statement.setInt(4, newComment.getMovieId());
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


	
public List<Comment> readAllComments() {
	
	String sql = "select commId, comment, commDate, username, movieId from Comments";
	Connection connection=null;
	ArrayList<Comment> commentList  = new ArrayList();
	
	try
	{
	connection = getConnection();
	PreparedStatement statement = connection.prepareStatement(sql);
	ResultSet results = statement.executeQuery();
	
	if(results.next()) 
		{
			Comment comment = new Comment();
			comment.setCommId(results.getInt("commId"));
			comment.setMovieId(results.getInt("movieId"));
			comment.setUsername(results.getString("username"));
			comment.setComment(results.getString("comment"));
			comment.setCommDate(results.getDate("commDate"));
		
			commentList.add(comment);
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
	
	return commentList;	
}



public List<Comment> readAllCommentsForUsername(String username){
	
	Connection connection=null;
	String sql= "select commId, comment, commDate, username, movieId from Comments where username=?"; 
	ArrayList<Comment> commentList = new ArrayList();
	
	connection = getConnection();
	PreparedStatement statement;
	Comment comment = new Comment();
	
	try 
	{
	statement = connection.prepareStatement(sql);
	
	statement.setString(1, username);
	ResultSet results = statement.executeQuery();
		
	if(! results.next())
	  {
		comment.setCommId(results.getInt("commId"));
		comment.setComment(results.getString("comment"));
		comment.setCommDate(results.getDate("commDate"));
		comment.setUsername(results.getString("username"));
		comment.setMovieId(results.getInt("movieId"));
		commentList.add(comment);
	  }
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return commentList;	
}


public List<Comment> readAllCommentsForMovie(int movieId){
	
	Connection connection=null;
	String sql= "select commId, comment, commDate, username, movieId from Comments where movieId=?"; 
	ArrayList<Comment> commentList = new ArrayList();
	
	connection = getConnection();
	PreparedStatement statement;
	Comment comment = new Comment();
	
	try 
	{
	statement = connection.prepareStatement(sql);
	
	statement.setInt(1, movieId);
	ResultSet results = statement.executeQuery();
		
	if(! results.next())
	  {
		comment.setCommId(results.getInt("commId"));
		comment.setComment(results.getString("comment"));
		comment.setCommDate(results.getDate("commDate"));
		comment.setUsername(results.getString("username"));
		comment.setMovieId(results.getInt("movieId"));
		commentList.add(comment);
	  }
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return commentList;	
}



public Comment readCommentForId(int commId){
	
	Connection connection=null;
	String sql= "select commId, comment, commDate, username, movieId from Comments where commId=?"; 
	ArrayList<Comment> commentList = new ArrayList();
	
	connection = getConnection();
	PreparedStatement statement;
	Comment comment = new Comment();
	
	try 
	{
	statement = connection.prepareStatement(sql);
	
	statement.setInt(1, commId);
	ResultSet results = statement.executeQuery();
		
	if(! results.next())
	  {
		comment.setCommId(results.getInt("commId"));
		comment.setComment(results.getString("comment"));
		comment.setCommDate(results.getDate("commDate"));
		comment.setUsername(results.getString("username"));
		comment.setMovieId(results.getInt("movieId"));
		commentList.add(comment);
	  }
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return comment;	
}


public void updateComment(int commId, Comment newComment){

	Connection connection=null;
	String sql= "update Comments set comment=?, username=?, movieId=? from Comments where commId=?"; 
		
	connection = getConnection();
	PreparedStatement statement;
		
	try 
	{
	statement = connection.prepareStatement(sql);
	statement.setString(1, newComment.getComment());
	statement.setString(2, newComment.getUsername());
	statement.setInt(1, newComment.getMovieId());
	
	ResultSet results = statement.executeQuery();
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
	

public void deleteComment(int commId){
	
	Connection connection=null;
	String sql= "delete from Comments where commId=?";
	PreparedStatement statement;
	
	try 
	{
	connection = getConnection();
	statement = connection.prepareStatement(sql);
	statement.setInt(1, commId);
	ResultSet result = statement.executeQuery();
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }

}
