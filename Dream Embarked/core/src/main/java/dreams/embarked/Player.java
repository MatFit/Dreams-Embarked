package dreams.embarked;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.awt.*;

public class Player extends Renderable {
    private static Player instance;
    private int moveSpeed = 2;
    private int prevX;
    private int prevY;
    private Rectangle playerRectangle;
    private boolean attacking = false;
    private int attackTime = 30;
    private int attackCounter = 0;
    private IdentifiableTexture defaultTexture;


    private Player(IdentifiableTexture texture, int playerX, int playerY, int width, int height) {
        super(texture, playerX, playerY, width, height);
        defaultTexture = texture;
        playerRectangle = new Rectangle(playerX, playerY, width, height); // Create player's rectangle
    }

    public static synchronized Player getInstance(IdentifiableTexture texture, int playerX, int playerY, int width, int height) {
        if (instance == null) {
            instance = new Player(texture, playerX, playerY, width, height);
        }
        return instance;
    }

    public void update() {
        boolean left = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean right = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean up = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean down = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean attack = Gdx.input.isKeyJustPressed(Input.Keys.Z);

        int xSpeed = 0;
        int ySpeed = 0;

        if (right && this.getX() < World.screenWidth - this.getWidth()) {
            prevX = this.getX();
            xSpeed = moveSpeed;
        } else if (left && this.getX() > 0) {
            prevX = this.getX();
            xSpeed = -moveSpeed;
        }

        if (up && this.getY() < World.screenHeight - this.getHeight()) {
            prevY = this.getY();
            ySpeed = moveSpeed;
        } else if (down && this.getY() > 0) {
            prevY = this.getY();
            ySpeed = -moveSpeed;
        }

        if (attack && !this.attacking) {
            this.attackCounter = 0;
            IdentifiableTexture attackTexture = new IdentifiableTexture(TextureType.Player, "player_swing.png");
            this.setTexture(attackTexture);
            this.attacking = true;
        }
        if (attacking) {
            this.attackCounter += 1;
            if (this.attackCounter == this.attackTime) {
                this.attacking = false;
                this.setTexture(defaultTexture);
            }
        }

        this.moveX(xSpeed);
        this.moveY(ySpeed);
    }
}
