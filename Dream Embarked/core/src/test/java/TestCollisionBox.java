package test.java;

import dreams.embarked.CollisionBox;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCollisionBox {
    @Test
    public void testCreation() {
        CollisionBox box = new CollisionBox(0, 0, 0, 0, null);
        assertNotNull(box);
    }
}