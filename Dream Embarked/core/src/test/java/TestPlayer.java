package test.java;

import com.badlogic.gdx.Input;
import dreams.embarked.InputMock;
import com.badlogic.gdx.Gdx;
import dreams.embarked.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayer {
    Player player = Player.getInstance(null, 0, 0, 32, 32);

    @Test
    public void testCreation() {
        assertNotNull(player);
    }

    @Test
    public void testMovement() {
        InputMock inputMock = new InputMock();
        Gdx.input = inputMock;

        inputMock.setKeyPressed(Input.Keys.RIGHT);
        inputMock.setKeyPressed(Input.Keys.UP);
        player.update();
        inputMock.setKeyReleased(Input.Keys.RIGHT);
        inputMock.setKeyReleased(Input.Keys.UP);

        assertEquals(2, player.getX());
        assertEquals(2, player.getY());

        inputMock.setKeyPressed(Input.Keys.DOWN);
        inputMock.setKeyPressed(Input.Keys.LEFT);
        player.update();
        inputMock.setKeyReleased(Input.Keys.DOWN);
        inputMock.setKeyReleased(Input.Keys.LEFT);

        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }
}
