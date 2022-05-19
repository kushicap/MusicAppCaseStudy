package com.cg.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;



//it checks for a main configuration class
@SpringBootTest
public class PlayListTest {
	private PlayList p;
//It execute before current method in each test case
	@BeforeEach
	public void preConfig() {

	p = new PlayList();
	p.setId("new");
	p.setSongname("Lovely");
	p.setArtistname("Sia");
	;
	}
	@Test
	public void FavTest() {
	PlayList a = Mockito.mock(PlayList.class);
	assertNotNull(a);
	}

	@Test
	public void FavModelTestSuccess() {
	assertEquals(p.getId(),"new");
	assertEquals(p.getSongname(),"Lovely");
	assertEquals(p.getArtistname(),"Sia");


	}
	@Test
	public void FavModelTestFailure() {
	assertNotEquals(p.getId(),"");
	assertNotEquals(p.getSongname(),"");
	assertNotEquals(p.getArtistname(),"");
	




	}


}
