package dreams.embarked;


import java.awt.*;
import com.badlogic.gdx.math.Rectangle;

public class CollisionBox extends Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;
    private String tag;
    private Renderable owner;

    public CollisionBox(int x, int y, int width, int height, String tag, Renderable owner) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.tag = tag;
        this.owner = owner;
    }
    public Renderable getOwner(){ return this.owner; }

}
