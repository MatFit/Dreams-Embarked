package com.dreams.embarked;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Player extends Renderable {
    private static Player instance;
    private int x;
    private int y;
    private Texture texture;
    private int width;
    private int height;

    private Player(Texture texture, int playerX, int playerY, int width, int height) {
        super(texture, playerX, playerY, width, height);
    }
    public static synchronized Player getInstance(Texture texture, int playerX, int playerY, int width, int height){
        if (instance == null){
            instance = new Player(texture, playerX, playerY, width, height);
        }
        return instance;
    }
    public void update() {}
}
