package test.java;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

import dreams.embarked.Platform;
import dreams.embarked.Player;
import dreams.embarked.World;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestWorld {
    /*@BeforeAll
    public static void setup() {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        config.setWindowedMode(640, 360);
        config.setTitle("Dreams Embarked");
        config.setInitialVisible(false);
        new Lwjgl3Application(new Platform(), config);
    }
    @Test
    public void testCreation() {
        World world = World.newBuilder()
                .build();

        assertNotNull(world);
    }


    @Test
    public void testCreationOfPlayer() {
        World world = World.newBuilder()
                .createPlayer(0,10)
                .build();

        Player player = Player.getInstance(null, 0, 0, 0, 0);

        assertEquals(player.getX(), 0);
        assertEquals(player.getY(), 10);
    }*/
}
