package com.cg.service;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.exception.AlbumsAlreadyExistsException;
import com.cg.model.Album;
import com.cg.repository.AlbumRepository;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AlbumServiceTest {
	@Mock
	private AlbumRepository As;
	@InjectMocks
	private AlbumServiceImpl Asl;
	

	@Test
	public void TestAddAlbum() throws AlbumsAlreadyExistsException {
		Album A1 = new Album("sia","sia","Happier Than Ever","Billeeilish");
		when(As.save(any())).thenReturn(A1);
		Asl.addAlbum(A1);
		verify(As,times(1)).save(any());
	}
	
}
