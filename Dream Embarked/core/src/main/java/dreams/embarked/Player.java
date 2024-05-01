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
    private HitBox playerHitBox;
    private HurtBox playerHurtBox;
    private int health = 3;
    private boolean attacking = false;
    private boolean invincible = false;
    private int invincibleTime = 30;
    private int invincibleCounter = 0;
    private int attackTime = 30;
    private int attackCounter = 0;
    private IdentifiableTexture defaultTexture;


    private Player(IdentifiableTexture texture, int playerX, int playerY, int width, int height) {
        super(texture, playerX, playerY, width, height);
        this.defaultTexture = texture;
        this.playerHurtBox = (HurtBox) BoxFactory.createBox("hurtbox", this, playerX, playerY, width, height);
    }

    public static synchronized Player getInstance(IdentifiableTexture texture, int playerX, int playerY, int width, int height) {
        if (instance == null) {
            instance = new Player(texture, playerX, playerY, width, height);
        }
        return instance;
    }

    public void update() {
        if (playerHitBox != null) {
            CollisionObserver.getInstance().removeHitBox(playerHitBox);
            playerHitBox = null;
        }
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
            this.playerHitBox = (HitBox) BoxFactory.createBox(
                    "hitbox",
                    this,
                    this.getX()+ (float) this.getWidth() /2,
                    this.getY(),
                    this.getWidth(),
                    this.getHeight());
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

        if (this.invincible) {
            this.invincibleCounter += 1;
            if (this.invincibleCounter == this.invincibleTime) {
                this.invincible = false;
            }
        }

        this.moveX(xSpeed);
        this.moveY(ySpeed);
        playerHurtBox.setPosition(this.getX(), this.getY()- (float) this.getHeight()/2);
        System.out.println(this.health);
    }
    public void hasBeenDamaged(){
        if (!this.invincible) {
            this.health--;
            this.invincible = true;
            this.invincibleCounter = 0;
        }
    }

    public void disableInvincibility() {
        this.invincible = false;
    }

    public boolean isDead() {
        return this.health <= 0;
    }
}
