package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="PlayList")
public class PlayList {
	//Attributes
	@Id//primary key
	private String id;
	private String songname;
	private String artistname;
	
	//default constructor
	public PlayList() {
		super();
		// TODO Auto-generated constructor stub
	}
	//parameterized constructor

	public PlayList(String id, String songname, String artistname) {
		super();
		this.id = id;
		this.songname = songname;
		this.artistname = artistname;
	}
	//Setter and Getter

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSongname() {
		return songname;
	}

	public void setSongname(String songname) {
		this.songname = songname;
	}

	public String getArtistname() {
		return artistname;
	}

	public void setArtistname(String artistname) {
		this.artistname = artistname;
	}
	//To String

	@Override
	public String toString() {
		return "PlayList [id=" + id + ", songname=" + songname + ", artistname=" + artistname + "]";
	}
	
}