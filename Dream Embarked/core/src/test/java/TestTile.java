package test.java;

import dreams.embarked.TextureType;
import dreams.embarked.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestTile {
    @Test
    public void testCreation() {
        Tile tile = new Tile(null, TextureType.Player, 0, 0, 0, 0);
        assertNotNull(tile);
    }
}
