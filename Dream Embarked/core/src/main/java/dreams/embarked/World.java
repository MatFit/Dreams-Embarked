package dreams.embarked;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;

public class World {
    SpriteBatch batch;
    private Player player;
    private OrthographicCamera camera;
    private LinkedList<Enemy> enemies = new LinkedList<>();
    private Tile[][] background;
    private int textureWidth;
    private int textureHeight;
    private int mapWidth;
    private int mapHeight;

    public static int screenWidth = 640;
    public static int screenHeight = 360;

    public World(Builder worldBuilder) {
        this.player = worldBuilder.player;
        this.enemies = worldBuilder.enemies;
        this.background = worldBuilder.background;
        this.textureWidth = worldBuilder.textureWidth;
        this.textureHeight = worldBuilder.textureHeight;
        this.mapWidth = worldBuilder.mapWidth;
        this.mapHeight = worldBuilder.mapHeight;

        this.batch = new SpriteBatch();

        this.camera = new OrthographicCamera();
        this.camera.setToOrtho(false, 640, 360);
    }

    public void update() {
        player.update();
    }


    public void render() {
        camera.update();

        // Setup batch
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        // Background Tiles
        for (int i = 0; i < mapWidth; i++) {
            for (int j = 0; j < mapHeight; j++) {
                Tile tile = background[i][j];
                batch.draw(tile.getTexture(), tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
            }
        }
        // Enemies

        // Items

        // Player
        batch.draw(player.getTexture(), player.getX(), player.getY(), player.getWidth(), player.getHeight());

        batch.end();
    }

    public void dispose() {
        batch.dispose();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Player player;
        private LinkedList<Enemy> enemies = new LinkedList<>();
        private Tile[][] background;
        private int textureWidth = 32;
        private int textureHeight = 32;
        private int mapWidth;
        private int mapHeight;

        public Builder() {
            super();
        }

        public Builder createPlayer(int x, int y) {
            Texture img = new Texture("beta player.png");
            player = Player.getInstance(img, x, y, 32, 32);
            return this;
        }

        public Builder createTileMap(int width, int height) {
            background = new Tile[width][height];
            this.mapWidth = width;
            this.mapHeight = height;
            return this;
        }

        public Builder populateTiles(boolean[][] baseMap, Texture texture) {
            for (int i = 0; i < mapWidth; i++) {
                for (int j = 0; j < mapHeight; j++) {
                    if (baseMap[i][j]) {
                        background[i][j] = new Tile(texture, textureWidth * i,
                                textureHeight * (mapHeight - (j + 1)), textureWidth, textureHeight);
                    }
                }
            }
            return this;
        }

        public Builder populateTilesFromMatrix(Texture[][] baseMap) {
            for (int i = 0; i < mapWidth; i++) {
                for (int j = 0; j < mapHeight; j++) {
                    background[i][j] = new Tile(baseMap[i][j], textureWidth * i, textureHeight * (mapHeight - (j + 1)),
                            textureWidth, textureHeight);
                }
            }
            return this;
        }

        public World build() {
            return new World(this);
        }
    }

}