package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.SongAlreadyDeletedException;
import com.cg.exception.SongsAlreadyExistsException;
import com.cg.model.Songs;
import com.cg.service.SongsService;

@RestController
@RequestMapping("/api/v1")
public class SongController {
	private SongsService songServ;

	@Autowired
	public SongController(SongsService songServ) {
			this.songServ = songServ;
	}
	//to add values
	@PostMapping("/songs")
	 public ResponseEntity<Songs> addSongs(@RequestBody Songs song ) throws SongsAlreadyExistsException{
        Songs savedsong = songServ.addSongs(song);
        return new ResponseEntity<>(savedsong, HttpStatus.CREATED);
    }
	//to get
	@GetMapping("/song")
	public ResponseEntity<List<Songs>> getAllSongs(){
        return new ResponseEntity<List<Songs>>((List<Songs>)songServ.getAllSongs(),HttpStatus.OK);
    }
	//for deleting
	@DeleteMapping("/song/{songId}")
	public ResponseEntity<Void> deleteSongsById(@PathVariable int songId) throws SongAlreadyDeletedException{
     songServ.deleteSongsBySongId(songId);
    return ResponseEntity.noContent().build();
    }
}
