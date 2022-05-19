package com.cg.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.exception.SongAlreadyDeletedException;
import com.cg.exception.SongsAlreadyExistsException;
import com.cg.model.Songs;
import com.cg.repository.SongRepository;

@Service //It provide some bussiness logics
//Implements songsservice layer
public class SongsServiceImpl implements SongsService {
	private SongRepository songRepo;
	@Autowired
	//parameterized constructor
	public SongsServiceImpl(SongRepository songRepo) {
		super();
		this.songRepo = songRepo;
	}
	@Override
	public Songs addSongs(Songs song) throws SongsAlreadyExistsException {
		// TODO Auto-generated method stub
		if(songRepo.existsById(song.getSongId())) {
			throw new SongsAlreadyExistsException();
		}
		Songs savedSong = songRepo.save(song);
		return savedSong;
	}
	@Override
	public List<Songs> getAllSongs() {
		// TODO Auto-generated method stub
		return (List<Songs>) songRepo.findAll();
	}
	
	@Override
	public void deleteSongsBySongId(int SongId) throws SongAlreadyDeletedException {
		// TODO Auto-generated method stub
		Optional<Songs>songDB=this.songRepo.findById(SongId);		
		if(songDB.isPresent())
	{
			this.songRepo.delete(songDB.get());
	}
		else {
			throw new SongAlreadyDeletedException ();
		}
		
	}

}
