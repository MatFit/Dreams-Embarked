package com.dreams.embarked;

import com.badlogic.gdx.graphics.Texture;

public class Renderable {
    private Texture texture;
    private int x;
    private int y;
    private int width;
    private int height;

    public Renderable(Texture texture, int x, int y, int width, int height) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Texture getTexture(){
        return this.texture;
    }
    public int getX(){ return this.x; }
    public int getY(){
        return this.y;
    }
    public int getWidth(){ return this.width; }
    public float getHeight(){ return this.height; }
}
