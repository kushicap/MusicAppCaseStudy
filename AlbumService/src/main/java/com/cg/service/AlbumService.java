package com.cg.service;

import java.util.List;


import com.cg.exception.AlbumsAlreadyExistsException;
import com.cg.exception.DeletedAlreadyException;
import com.cg.model.Album;



public interface AlbumService {
	public Album addAlbum(Album album) throws AlbumsAlreadyExistsException ;
	public List<Album> getAllAlbum();
	public void deleteAlbumByid(String id) throws DeletedAlreadyException;
	
}


