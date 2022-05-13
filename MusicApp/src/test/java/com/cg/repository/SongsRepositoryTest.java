package com.cg.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Songs;
@SpringBootTest
@ExtendWith(SpringExtension.class)


public class SongsRepositoryTest {
	@Autowired
	private SongRepository songRepo;

	@Test
	public void givenSongsShouldReturnSongsObject() {
		Songs S1 = new Songs(1,"Baby","Justin Bieber",2010);//user Input
		songRepo.save(S1);//data saved into database
		Songs S2= songRepo.findById(S1.getSongId()).get();//fetching the data from database
		assertNotNull(S2);//to check if its returning the songs object
		assertEquals(S1.getArtistname(),S2.getArtistname());
	}
	@Test
	/*public void getAllmustReturnAllSongs() {
		Songs S3=new Songs(2,"Happier Than Ever","Billeeilish",2022);
		Songs S4=new Songs(3,"Lovely","Billeeilish",2020);
		songRepo.save(S3);
		songRepo.save(S4);
		List<Songs> songlist=(List<Songs>) songRepo.findAll();
		assertEquals("Lovely",songlist.get(1).getSongName());
	    //assertEquals(11,songlist.size());
	}*/
	public void getAllmustReturnAllSongss()
	{
		Songs S3=new Songs(2,"Happier Than Ever","Billeeilish",2022); //user input
		Songs S4=new Songs(3,"Lovely","Billeeilish",2020); //user input
		songRepo.save(S3); //data saved to database
		songRepo.save(S4); //data saved to database
		
		List<Songs> songlist1 =(List<Songs>)songRepo.findAll();
		assertEquals("Billeeilish",songlist1.get(2).getArtistname());
		//assertEquals(3,songlist1.size());
		
	}
	
}
