package com.cg.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.AlbumsAlreadyExistsException;
import com.cg.exception.DeletedAlreadyException;
import com.cg.model.Album;
import com.cg.service.AlbumService;



@RestController
@RequestMapping("/api/v1")
public class AlbumController {
	private AlbumService albumServ;

	@Autowired
	public AlbumController(AlbumService albumServ) {
			this.albumServ = albumServ;
	}  
	//to add values
	@PostMapping("/addalbum")
	 public ResponseEntity<Album> addAlbum(@RequestBody Album album ) throws AlbumsAlreadyExistsException{
        Album savedalbum = albumServ.addAlbum(album);
        return new ResponseEntity<>(savedalbum, HttpStatus.CREATED);
    }
    
    @GetMapping("/findallalbums")
    public ResponseEntity<List<Album>> getAllAlbum(){
        return new ResponseEntity<List<Album>>((List<Album>)albumServ.getAllAlbum(),HttpStatus.OK);
    }

    
     @DeleteMapping("/delalbum/{id}")
        public ResponseEntity<Void> deleteAlbumById(@PathVariable String id) throws DeletedAlreadyException {
            albumServ.deleteAlbumByid(id);
            return ResponseEntity.noContent().build();
        }
    	
     @GetMapping("/album")
        public Album getAlbumData() {
    	 Album a = new Album ("new","sia mus","Lovely","sia");
            return a;
    }
     

}
