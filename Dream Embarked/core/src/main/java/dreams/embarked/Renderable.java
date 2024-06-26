package dreams.embarked;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import java.awt.*;

public class Renderable {
    private IdentifiableTexture texture;
    private int x;
    private int y;
    private int width;
    private int height;

    public Renderable(IdentifiableTexture texture, int x, int y, int width, int height) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public IdentifiableTexture getTexture() {
        return this.texture;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }
    public float getHeight() {
        return this.height;
    }

    public void moveX(int change) {
        this.x += change;
    }
    public void moveY(int change) {
        this.y += change;
    }

    public void setTexture(IdentifiableTexture texture) {
        this.texture = texture;
    }

    protected void update() {
    }
}
