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

import com.cg.model.Album;
import com.cg.service.AlbumService;
import com.fasterxml.jackson.databind.ObjectMapper;
@ExtendWith(MockitoExtension.class)
public class AlbumControllerTest {
	@Autowired
	private MockMvc mocMvc;

	@Mock
	private AlbumService As;
	private Album a;
	private List<Album> Albumlist;
	@InjectMocks
	private AlbumController Ac;
	@BeforeEach
	public void setUp() {
	a = new Album("sia","sia","Happier Than Ever","Billeeilish");
	mocMvc= MockMvcBuilders.standaloneSetup(Ac).build();
	}
	@Test
	public void AlbumControllerTest() throws Exception{
	when(As.addAlbum(any())).thenReturn(a);
	mocMvc.perform(post("/api/v1/addalbum")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(a)))
	.andExpect(status().isCreated());
	verify(As,times(1)).addAlbum(any());



	}



	@Test
	public void getAllAlbumControllerTest() throws Exception {
	when(As.getAllAlbum()).thenReturn(Albumlist);
	mocMvc.perform(MockMvcRequestBuilders.get("/api/v1/findallalbums")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(a)))
	.andDo(MockMvcResultHandlers.print());
	verify(As,times(1)).getAllAlbum();


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
