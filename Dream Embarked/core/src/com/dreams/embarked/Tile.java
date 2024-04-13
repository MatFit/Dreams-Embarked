package com.dreams.embarked;

import com.badlogic.gdx.graphics.Texture;

public class Tile extends Renderable {
    private Texture texture;

    public Tile(Texture texture, int x, int y, int width, int height) {
        super(texture, x, y, width, height);
    }
}
