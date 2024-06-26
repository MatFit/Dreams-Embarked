package dreams.embarked;

import com.badlogic.gdx.graphics.Texture;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Random;

public class Enemy extends Renderable {
    private int health = 1;
    private int arrowTime = 180;
    private int arrowCounter = 0;
    private LinkedList<Renderable> children = new LinkedList<>();
    private HurtBox hurtbox;
    public Enemy(IdentifiableTexture texture, int x, int y, int width, int height) {
        super(texture, x, y, width, height);
        hurtbox = (HurtBox) BoxFactory.createBox("hurtbox", this, x, y, width, height);
    }
    public void hasBeenDamaged(){
        this.health -= 1;
    }

    public boolean isDead() {
        return this.health <= 0;
    }

    public void update() {
        if (this.arrowCounter >= this.arrowTime) {
            IdentifiableTexture arrowTexture = new IdentifiableTexture(TextureType.Enemy, "arrow.png");
            Arrow arrow = new Arrow(arrowTexture, this.getX(), this.getY(), 3, this);
            this.children.add(arrow);
            this.arrowCounter = 0;
        }
        Random rand = new Random();
        this.arrowCounter += rand.nextInt(5);
        for (Renderable arrow : this.children) {
            arrow.update();
        }
        this.hurtbox.setPosition(this.getX(), this.getY() - this.getHeight() / 2);
    }

    public LinkedList<Renderable> getChildren() {
        return new LinkedList<>(this.children);
    }
}
