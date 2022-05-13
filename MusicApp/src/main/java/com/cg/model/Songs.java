package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

////POJO class
@Document(collection="Songs")
public class Songs {
	@Id//primary keys
public int songId;
public String songName;
public String artistname;
public int year;

//default constructor
public Songs() {
	super();
	// TODO Auto-generated constructor stub
}
//Parameterized constructor

public Songs(int songId, String songName, String artistname, int year) {
	super();
	this.songId = songId;
	this.songName = songName;
	this.artistname = artistname;
	this.year = year;
}
//Setters and Getters
public int getSongId() {
	return songId;
}

public void setSongId(int songId) {
	this.songId = songId;
}

public String getSongName() {
	return songName;
}

public void setSongName(String songName) {
	this.songName = songName;
}

public String getArtistname() {
	return artistname;
}

public void setArtistname(String artistname) {
	this.artistname = artistname;
}

public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}
//To String
@Override
public String toString() {
	return "Songs [songId=" + songId + ", songName=" + songName + ", artistname=" + artistname + ", year=" + year + "]";
}



}
