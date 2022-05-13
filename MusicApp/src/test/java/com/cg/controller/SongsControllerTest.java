package com.cg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cg.model.Songs;
import com.cg.service.SongsService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class SongsControllerTest {
	@Autowired
	private MockMvc mocMvc;

	@Mock//It makes test code &verification error easier
	private SongsService Ss;
	private Songs s;
	private List<Songs> songlist;
	@InjectMocks
	private SongController sc;
	@BeforeEach
	public void setUp() {
	s = new Songs(1,"Cheap Thrills","Sia",2016);
	mocMvc= MockMvcBuilders.standaloneSetup(sc).build();
	}
	@Test
	public void SongsControllerTest() throws Exception{
	when(Ss.addSongs(any())).thenReturn(s);
	mocMvc.perform(post("/api/v1/songs")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(s)))
	.andExpect(status().isCreated());
	verify(Ss,times(1)).addSongs(any());



	}



	@Test
	public void getAllSongsControllerTest() throws Exception {
	when(Ss.getAllSongs()).thenReturn(songlist);
	mocMvc.perform(MockMvcRequestBuilders.get("/api/v1/song")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(s)))
	.andDo(MockMvcResultHandlers.print());
	verify(Ss,times(1)).getAllSongs();


	}


	public static String asJSONString(final Object obj) {
	// TODO Auto-generated method stub
	try {

	return new ObjectMapper().writeValueAsString(obj);
	} catch (Exception e) {
	throw new RuntimeException(e);
	}
	}

}
