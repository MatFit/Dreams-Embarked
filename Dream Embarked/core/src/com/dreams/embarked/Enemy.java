package com.dreams.embarked;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Renderable {
    private Enemy(Texture texture, int playerX, int playerY, int width, int height) {
        super(texture, playerX, playerY, width, height);
    }
}
