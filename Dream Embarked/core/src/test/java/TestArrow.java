package test.java;

import dreams.embarked.Arrow;
import dreams.embarked.CollisionObserver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestArrow {
    @Test
    public void testCreation() {
        CollisionObserver.getInstance().clearHitBox();
        Arrow arrow = new Arrow(null, 0, 0, 0);

        assertNotNull(arrow);
        assertEquals(1, CollisionObserver.getInstance().getHitBoxesSize());
    }

    @Test
    public void testArrowUpdate() {
        Arrow arrow = new Arrow(null, 0, 0, 1);

        arrow.update();

        assertEquals(1, arrow.getX());
    }
}
