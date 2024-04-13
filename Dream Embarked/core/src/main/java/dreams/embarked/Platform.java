package dreams.embarked;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.ScreenUtils;

public class Platform extends ApplicationAdapter {
    Texture grass;
    Texture dirt;
    Texture stone;
    Player player;
    World world;

    @Override
    public void create() {
        grass = new Texture("grass_tile.png");
        dirt = new Texture("mud_tile.png");
        stone = new Texture("stone_tile.png");

        Texture[][] backgroundMatrix = {
                {stone, stone, stone, stone, stone, stone, stone, stone, stone, stone, stone, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {dirt, dirt, dirt, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {dirt, dirt, dirt, dirt, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, dirt, dirt, dirt, dirt, dirt, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, dirt, dirt, dirt, dirt, dirt, dirt, grass, grass, stone, stone},
                {stone, grass, grass, grass, dirt, dirt, dirt, dirt, dirt, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, dirt, dirt, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, grass, grass, grass, grass, grass, grass, grass, grass, grass, grass, stone, stone},
                {stone, stone, stone, stone, stone, stone, stone, stone, stone, stone, stone, stone, stone},
        };
        World world = World.newBuilder()
                .createTileMap(20, 12)
                .createPlayer(320 - 16, 100)
                .populateTilesFromMatrix(backgroundMatrix)
                .build();
        this.world = world;
    }

    @Override
    public void render() {
        ScreenUtils.clear(0, 0, 0, 1);

        world.update();
        world.render();
    }

    @Override
    public void dispose() {
        dirt.dispose();
        grass.dispose();
        stone.dispose();
        world.dispose();
    }
}
