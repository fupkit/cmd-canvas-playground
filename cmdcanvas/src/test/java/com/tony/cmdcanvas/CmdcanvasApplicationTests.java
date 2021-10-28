package com.tony.cmdcanvas;

import com.tony.cmdcanvas.object.Canvas;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CmdcanvasApplicationTests {

	@Test
	void contextLoads() {
		Canvas canvas = new Canvas(5, 5);
		System.out.println(canvas.drawContent());
	}

}
