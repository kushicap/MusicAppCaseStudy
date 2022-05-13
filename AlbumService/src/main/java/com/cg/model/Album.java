package com.cg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Album")
public class Album {
	@Id//primary key
	private String id;
	private String albumname;
	private String songname;
	private String artistname;
	//default constructor
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	//parameterized constructor
	public Album(String id, String albumname, String songname, String artistname) {
		super();
		this.id = id;
		this.albumname = albumname;
		this.songname = songname;
		this.artistname = artistname;
	}
	//setter and getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
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
		return "Album [id=" + id + ", albumname=" + albumname + ", songname=" + songname + ", artistname=" + artistname
				+ "]";
	}
	
	
	
	
}
