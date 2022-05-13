package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.cg.exception.DeletedAlreadyExistsException;
import com.cg.exception.PlayListsAlreadyExistsException;
import com.cg.model.PlayList;
import com.cg.repository.PlayListRepository;
@Service
public class PlayListServiceImpl implements PlayListService {
	
	private PlayListRepository playlistRepo;
	@Autowired
	private MongoRepository<PlayList, String> playlistrepository;
	//parameterized constructor
	public PlayListServiceImpl(PlayListRepository playlistRepo) {
		super();
		this.playlistRepo = playlistRepo;
	}


	@Override
	public PlayList addPlayList (PlayList playlist) throws PlayListsAlreadyExistsException {
		if(playlistRepo.existsById(playlist.getId())) {
			throw new PlayListsAlreadyExistsException();
		}
		PlayList savedPlayList = playlistRepo.save(playlist);
		return savedPlayList;
	}
	@Override
    public List<PlayList> getAllPlayList() {
        List<PlayList> playlist = playlistrepository.findAll();
        System.out.println("Getting data from DB : " + playlist);
        return playlist;
    }

    @Override
	public void deletePlayListByid(String id) throws DeletedAlreadyExistsException {
		// TODO Auto-generated method stub
		Optional<PlayList>playlistDB=this.playlistRepo.findById(id);		
		if(playlistDB.isPresent())
	{
			this.playlistRepo.delete(playlistDB.get());
	}
		else {
			throw new DeletedAlreadyExistsException();
		}
		
	}



}
