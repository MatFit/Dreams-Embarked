package com.dreams.embarked;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.dreams.embarked.Enemy;
import com.dreams.embarked.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

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

    // TODO: Put in Builder
    private int screenWidth = 640;
    private int screenHeight = 360;

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

    private int[] drawPosition(int actualX, int actualY) {
        int[] ret = new int[2];
        int newX;
        int newY;
        if (actualX < camera.position.x) {
            newX = (int) (screenWidth/2 - (camera.position.x - actualX));
        } else {
            newX = (int) (screenWidth/2 + (actualX - camera.position.x));
        }
        if (actualY < camera.position.y) {
            newY = (int) (screenHeight/2 - (camera.position.y - actualY));
        } else {
            newY = (int) (screenHeight/2 + (actualY - camera.position.y));
        }

        ret[0] = newX;
        ret[1] = newY;
        return ret;
    }

    public void render() {
        // Calculate section of world to render
        int playerX = player.getX();
        int playerY = player.getY();

        int minX = (playerX - screenWidth/2)/textureWidth - 1;
        int maxX = (playerX + screenWidth/2)/textureWidth + 1;

        int minY = (playerY - screenHeight/2)/textureHeight - 1;
        int maxY = (playerY + screenHeight/2)/textureHeight + 1;

        if (minX < 0) {
            minX = 0;
        } else if (maxX >= mapWidth) {
            maxX = mapWidth-1;
        }

        if (minY < 0) {
            minY = 0;
        } else if (maxY >= mapHeight) {
            maxY = mapHeight;
        }

        // Move camera
        camera.position.set(playerX, playerY, 0);

//        if (minX > 0 && maxX < mapWidth) {
//            camera.position.x = playerX;
//        }
//        if (minY > 0 && maxY < mapHeight) {
//            camera.position.y = playerY;
//        }
        camera.update();
        System.out.println(camera.position);

        // Setup batch
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        // Background Tiles
        for (int i = minX; i < maxX; i++) {
            for (int j = mapHeight-minY-1; j >= mapHeight-maxY; j--) {
                Tile tile = background[i][j];
                int[] drawnPositions = drawPosition(tile.getX(), tile.getY());
                batch.draw(tile.getTexture(), drawnPositions[0], drawnPositions[1], tile.getWidth(), tile.getHeight());
            }
        }
        // Enemies

        // Items

        // Player
        int[] playerDrawnPositions = drawPosition(player.getX(), player.getY());
        batch.draw(player.getTexture(), playerDrawnPositions[0], playerDrawnPositions[1], player.getWidth(), player.getHeight());

        batch.end();
    }

    public void dispose () {
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
                        background[i][j] = new Tile(texture, textureWidth*i,
                                textureHeight*(mapHeight-(j+1)), textureWidth, textureHeight);
                    }
                }
            }
            return this;
        }

        public World build() {
            return new World(this);
        }
    }

}