package test.java;

import dreams.embarked.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEnemy {
    @Test
    public void testCreation() {
        Enemy enemy = new Enemy(null, 0, 0, 0, 0);

        assertNotNull(enemy);
    }
}
