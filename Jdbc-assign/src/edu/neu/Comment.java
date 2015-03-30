package edu.neu;

import java.sql.Date;

public class Comment {

	private String comment;
	private Date commDate;
	private String username;
	private int movieId;
	private int commId;
	
	public Comment(){
	super();
	}
	
	public Comment(String comment, Date commDate, String username, int movieId){
		
		this.comment = comment;
		this.commDate = commDate;
		this.username = username;
		this.movieId = movieId;
	}

		
	public int getCommId() {
		return commId;
	}

	public void setCommId(int commId) {
		this.commId = commId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommDate() {
		return commDate;
	}

	public void setCommDate(Date commDate) {
		this.commDate = commDate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
}
