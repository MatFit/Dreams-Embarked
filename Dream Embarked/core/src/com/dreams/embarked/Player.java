package com.dreams.embarked;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Player extends Entity {
    private static Player instance;
    private float x;
    private float y;
    private Texture playerTexture;
    private OrthographicCamera camera;
    private int width = 32;
    private int height = 32;

    private Player(Integer health, String name, Texture texture){
        super(health,name);

        playerTexture = texture;
        x = 0;
        y = 0;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 360);
    }
    public static synchronized Player getInstance(Integer health, String name, Texture texture){
        if (instance == null){
            instance = new Player(health, name, texture);
        }
        return instance;
    }
    public OrthographicCamera getCamera() {
        return this.camera;
    }
    public void update() {
        camera.position.set(this.x, this.y, 0);
        camera.update();
    }
    public Texture getTexture(){
        return this.playerTexture;
    }
    public float getX(){ return this.x; }
    public float getY(){
        return this.y;
    }
    public float getWidth(){ return this.width; }
    public float getHeight(){ return this.height; }
}
