package com.tony.cmdcanvas;

import com.tony.cmdcanvas.object.Playground;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PlaygroundTest {
    @MockBean
    private CmdRunner cmdRunner; //prevent Scanner blocking

    @InjectMocks
    @Autowired
    private Playground playground;

    @Test
    public void testPrintOutput() {
        playground.readInput("C 20 4");

        playground.readInput("L 1 2 6 2");

        playground.readInput("L 6 3 6 4");

        playground.readInput("R 14 1 18 3");

        playground.readInput("B 10 3 o");

        System.out.println("Test printing finished.");
    }

    @Test
    public void testCreateCanvas() {
        playground.readInput("C 20 10");
        assertEquals(20, playground.getCanvas().getWidth());
        assertEquals(20, playground.getCanvas().getContent()[0].length);
        assertEquals(10, playground.getCanvas().getHeight());
        assertEquals(10, playground.getCanvas().getContent().length);
    }
}
