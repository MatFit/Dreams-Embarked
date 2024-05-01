package dreams.embarked;
import com.badlogic.gdx.math.Rectangle;

public class CollisionBox extends Rectangle {
    private Renderable owner;

    public CollisionBox(float x, float y, float width, float height, Renderable owner) {
        super(x,y,width,height);
        this.owner = owner;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Renderable getOwner(){ return this.owner; }
}
