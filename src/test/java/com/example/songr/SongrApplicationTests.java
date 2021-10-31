package com.example.songr;

import com.example.songr.Models.Album;
import com.example.songr.Models.Song;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SongrApplicationTests {

	@Test
	void albumConstructor() {
		Album album = new Album("code 401","ahmed",45,10,"url");
		assertEquals("Album{id=0, title='code 401', artist='ahmed', songCount=45, length=10, imageUrl='url', songs=null}",album.toString());
		Song song = new Song("cracked",150,5,album);
		assertEquals("Song{title='cracked', length=150, trackNumber=5, album=code 401}",song.toString());
		ArrayList songList = new ArrayList();
		songList.add(song);
		Album newAlbum = new Album("code 401","ahmed",45,10,"url",songList);
		assertEquals("Album{id=0, title='code 401', artist='ahmed', songCount=45, length=10, imageUrl='url', songs=[Song{title='cracked', length=150, trackNumber=5, album=code 401}]}",newAlbum.toString());
	}

}
