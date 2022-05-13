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

import com.cg.exception.DeletedAlreadyExistsException;
import com.cg.exception.PlayListsAlreadyExistsException;
import com.cg.model.PlayList;
import com.cg.service.PlayListService;
@RestController
@RequestMapping("/api/v1")
public class PlaylistController {
	private PlayListService playlistServ;

	@Autowired
	public PlaylistController(PlayListService playlistServ) {
			this.playlistServ = playlistServ;
	}  
	
	//to add playlist details
    @PostMapping("/addplaylist")
    public ResponseEntity<PlayList> addPlayList(@RequestBody PlayList playlist ) throws PlayListsAlreadyExistsException{
        PlayList savedplaylist = playlistServ.addPlayList(playlist);
        return new ResponseEntity<>(savedplaylist, HttpStatus.CREATED);
    }
    //to get all playlist details
    @GetMapping("/findAllplaylists")
    public ResponseEntity<List<PlayList>> getAllPlayList(){
        return new ResponseEntity<List<PlayList>>((List<PlayList>)playlistServ.getAllPlayList(),HttpStatus.OK);
    }

    //to delete with id
     @DeleteMapping("/delplaylist/{id}")
        public ResponseEntity<Void> deletePlayListById(@PathVariable String id) throws DeletedAlreadyExistsException{
            playlistServ.deletePlayListByid(id);
            return ResponseEntity.noContent().build();
        }
    	
     @GetMapping("/Playlist")
        public PlayList getPlayListData() {
         PlayList pl = new PlayList ("new","Lovely","sia" );
            return pl;
    }
     
}