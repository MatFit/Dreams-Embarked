package test.java;

import dreams.embarked.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayer {
    Player player = Player.getInstance(null, 0, 0, 32, 32);

    @Test
    public void testCreation() {
        assertNotNull(player);
    }
}
