package com.cg.service;

import java.util.List;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.cg.exception.AlbumsAlreadyExistsException;
import com.cg.exception.DeletedAlreadyException;
import com.cg.model.Album;
import com.cg.repository.AlbumRepository;


@Service
public class AlbumServiceImpl implements AlbumService {
	private AlbumRepository albumRepo;
	@Autowired
	private MongoRepository<Album, String> albumrepository;
	//parameterized constructor
	public AlbumServiceImpl(AlbumRepository albumRepo) {
		super();
		this.albumRepo = albumRepo;
	}
	@Override
	public Album addAlbum(Album album) throws AlbumsAlreadyExistsException {
		// TODO Auto-generated method stub
		if(albumRepo.existsById(album.getId())) {
			throw new AlbumsAlreadyExistsException();
		}
		Album savedalbum = albumRepo.save(album);
		return savedalbum;
	}
	@Override
    public List<Album> getAllAlbum() {
        List<Album> album = albumrepository.findAll();
        System.out.println("Getting data from DB : " + album);
        return album;
    }

    @Override
	public void deleteAlbumByid(String id) throws DeletedAlreadyException{
		// TODO Auto-generated method stub
		Optional<Album>albumDB=this.albumRepo.findById(id);		
		if(albumDB.isPresent())
	{
			this.albumRepo.delete(albumDB.get());
	}
		else
		{
			throw new DeletedAlreadyException();
		}
		
	}


}
