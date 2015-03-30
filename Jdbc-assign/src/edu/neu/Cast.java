package edu.neu;

public class Cast {
	private String charName;
	private int movId;
	private int actId;
	private int castId;

public Cast(){
super();
}

public int getCastId() {
	return castId;
}



public void setCastId(int castId) {
	this.castId = castId;
}



public String getCharName() {
	return charName;
}


public void setCharName(String charName) {
	this.charName = charName;
}


public int getMovId() {
	return movId;
}


public void setMovId(int movId) {
	this.movId = movId;
}


public int getActId() {
	return actId;
}


public void setActId(int actId) {
	this.actId = actId;
}


public Cast(String charName, int movId, int actId){
	super();
	this.charName = charName;
	this.movId = movId;
	this.actId = actId;
}

}

	