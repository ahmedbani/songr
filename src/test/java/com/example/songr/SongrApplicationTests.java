package com.example.songr;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SongrApplicationTests {

	@Test void testAlbum(){
		Album newalbum = new Album("Kamikaze","Eminem",10,2749,"https://upload.wikimedia.org/wikipedia/en/6/62/Eminem_-_Kamikaze.jpg");
		assertEquals("Kamikaze",newalbum.getTitle());
		assertEquals("Album{title='Kamikaze', artist='Eminem', songCount=10, length=2749, imageUrl='https://upload.wikimedia.org/wikipedia/en/6/62/Eminem_-_Kamikaze.jpg'}",newalbum.toString());
	}

}
