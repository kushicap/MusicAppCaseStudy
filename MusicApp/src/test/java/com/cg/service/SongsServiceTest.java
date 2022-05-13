package com.cg.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.SongsAlreadyExistsException;
import com.cg.model.Songs;
import com.cg.repository.SongRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class SongsServiceTest {
	@Mock
	private SongRepository Ss;
	@InjectMocks
	private SongsServiceImpl Ssl;
	

	@Test
	public void TestAddSongs() throws SongsAlreadyExistsException {
		Songs S1 = new Songs(1,"Baby","Justin Bieber",2010);
		when(Ss.save(any())).thenReturn(S1);
		Ssl.addSongs(S1);
		verify(Ss,times(1)).save(any());
	}
	@Test
	public void testgetAllSongs() {
	    Songs S1=new Songs(2,"Happier Than Ever","Bille eilish",2022);
	    Songs S2=new Songs(3,"Lovely","Bille eilish",2020);
	    Songs S3=new Songs(4,"Bored","Bille eilish",2020);
		
		Ss.save(S1);
		Ss.save(S2);
		Ss.save(S3);
		List<Songs> songlist = new ArrayList<>();
		songlist.add(S1);
		songlist.add(S2);
		songlist.add(S3);
		when(Ss.findAll()).thenReturn(songlist);
		List<Songs> songlist1=Ssl.getAllSongs();
		//Asserts if two objects are equal
		assertEquals(songlist,songlist1);
		verify(Ss,times(1)).save(S1);
		verify(Ss,times(1)).findAll();
		}
}
