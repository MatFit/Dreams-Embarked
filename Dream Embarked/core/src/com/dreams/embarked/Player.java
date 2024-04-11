package com.dreams.embarked;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;

import java.awt.*;

public class Player extends Entity {
    private static Player instance;
    private float playerX;
    private float playerY;
    private Texture playerTexture;


    private Player(Integer health, String name, Texture texture){
        super(health,name);

        playerTexture = texture;
        playerX = (Gdx.graphics.getWidth() - playerTexture.getWidth()) / 2;
        playerY = (Gdx.graphics.getHeight() - playerTexture.getHeight()) / 2;
    }
    public static synchronized Player getInstance(Integer health, String name, Texture texture){
        if (instance == null){
            instance = new Player(health, name, texture);
        }
        return instance;
    }
    public Texture grabTexture(){
        return this.playerTexture;
    }
    public float grabPlayerX(){
        return this.playerX;
    }
    public float grabPlayerY(){
        return this.playerY;
    }
}
