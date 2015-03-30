package edu.neu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.neu.User;

public class UserManager{
	
	
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



public void createUser(User newUser) {
	
	String sql = "insert into User (username, password, firstName, lastName, email, dob) values (?,?,?,?,?,?)";
	Connection connection = getConnection();

	try 
	{
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, newUser.getUsername());
		statement.setString(2, newUser.getPassword());
		statement.setString(3, newUser.getFirstName());
		statement.setString(4, newUser.getLastName());
		statement.setString(5, newUser.getEmail());
		statement.setDate(6, newUser.getDob());
		
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


	public List<User> readAllUsers() {
		
		String sql = "select username, passwd, firstName, lastName, email, dob from User";
		Connection connection=null;
		ArrayList<User> userList  = new ArrayList();
		
		try
		{
		connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet results = statement.executeQuery();
		
		if(results.next()) 
			{
				User user = new User();
				user.setUsername(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setFirstName(results.getString("firstName"));
				user.setLastName(results.getString("lastName"));
				user.setEmail(results.getString("email"));
				user.setDob(results.getDate("dob"));
				userList.add(user);
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
		
		return userList;	
	}

	
	public User readUser(String userName){
		
	Connection connection=null;
	String sql= "select username, passwd, firstName, lastName, email, dob from User where username=?"; 
	
	
	connection = getConnection();
	PreparedStatement statement;
	User user = new User();
	
	try 
	{
	statement = connection.prepareStatement(sql);
	
	statement.setString(1, userName);
	ResultSet results = statement.executeQuery();
		
	if(! results.wasNull())
	  {
		user.setUsername(results.getString("username"));
		user.setPassword(results.getString("password"));
		user.setFirstName(results.getString("firstName"));
		user.setLastName(results.getString("lastName"));
		user.setEmail(results.getString("email"));
		user.setDob(results.getDate("dob"));
	  }
	}
    
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return user;
	
}

	
public void updateUser(String username, User user){
	
	Connection connection=null;
	String sql= "update User set username=?, passwd=?, firstName=?, lastName=?, email=?, dob=? where username=?";
	
	try
	{
	connection = getConnection();
	PreparedStatement statement = connection.prepareStatement(sql);
	statement.setString(1, user.getUsername());
	statement.setString(2, user.getFirstName());
	statement.setString(3, user.getLastName());
	statement.setString(4, user.getEmail());
	statement.setDate(5, user.getDob());
	statement.setString(6,username);
	
	ResultSet results = statement.executeQuery();
	}
	catch (Exception e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public void deleteUser(String username){
	
	Connection connection=null;
	String sql= "delete from User where username=?";
	PreparedStatement statement;
	
	try 
	{
	connection = getConnection();
	statement = connection.prepareStatement(sql);
	statement.setString(1, username);
	ResultSet result = statement.executeQuery();
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
