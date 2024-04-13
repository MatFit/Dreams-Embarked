package main.java.embarked;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class Player extends Renderable {
    private static Player instance;
    private int moveSpeed = 2;

    private Player(Texture texture, int playerX, int playerY, int width, int height) {
        super(texture, playerX, playerY, width, height);
    }
    public static synchronized Player getInstance(Texture texture, int playerX, int playerY, int width, int height){
        if (instance == null){
            instance = new Player(texture, playerX, playerY, width, height);
        }
        return instance;
    }
    public void update() {
        boolean left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean up = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean down = Gdx.input.isKeyPressed(Input.Keys.DOWN);

        int xSpeed = 0;
        int ySpeed = 0;

        if (right && this.getX() < World.screenWidth - this.getWidth()) {
            xSpeed = moveSpeed;
        } else if (left && this.getX() > 0) {
            xSpeed = -moveSpeed;
        }

        if (up && this.getY() < World.screenHeight - this.getHeight()) {
            ySpeed = moveSpeed;
        } else if (down && this.getY() > 0) {
            ySpeed = -moveSpeed;
        }

        this.moveX(xSpeed);
        this.moveY(ySpeed);
    }
}
