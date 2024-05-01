package dreams.embarked;
import com.badlogic.gdx.math.Rectangle;

public class CollisionBox extends Rectangle {
    private int x;
    private int y;
    private int width;
    private int height;
    private String tag;
    private Renderable owner;

    public CollisionBox(int x, int y, int width, int height, String tag, Renderable owner) {
        super(x,y,width,height);
        this.tag = tag;
        this.owner = owner;
    }
    public Renderable getOwner(){ return this.owner; }
}
