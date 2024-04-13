package test.java;

import dreams.embarked.Renderable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRenderable {
    @Test
    public void testCreation() {
        Renderable renderable = new Renderable(null, 0, 0, 0, 0);

        assertNotNull(renderable);
    }
    @Test
    public void testGetX(){
        Renderable renderable = new Renderable(null, 10, 0, 0, 0);

        assertEquals(renderable.getX(), 10);
    }
    @Test
    public void testGetY(){
        Renderable renderable = new Renderable(null, 0, 10, 0, 0);

        assertEquals(renderable.getY(), 10);
    }
    @Test
    public void testGetWidth(){
        Renderable renderable = new Renderable(null, 0, 0, 10, 0);

        assertEquals(renderable.getWidth(), 10);
    }
    @Test
    public void testGetHeight(){
        Renderable renderable = new Renderable(null, 0, 0, 0, 10);

        assertEquals(renderable.getHeight(), 10);
    }
    @Test
    public void testMoveX(){
        Renderable renderable = new Renderable(null, 0, 0, 0, 10);

        renderable.moveX(-10);

        assertEquals(renderable.getX(), -10);
    }
    @Test
    public void testMoveY(){
        Renderable renderable = new Renderable(null, 0, 0, 0, 10);

        renderable.moveY(-10);

        assertEquals(renderable.getY(), -10);
    }
}
