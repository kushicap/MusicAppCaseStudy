package com.cg.service;

import java.util.List;


import com.cg.exception.SongAlreadyDeletedException;
import com.cg.exception.SongsAlreadyExistsException;
import com.cg.model.Songs;


public interface SongsService {
	public Songs addSongs(Songs song) throws SongsAlreadyExistsException;
	public List<Songs> getAllSongs();
	public void deleteSongsBySongId(int SongId) throws SongAlreadyDeletedException;

}
