package dreams.embarked;
import com.badlogic.gdx.math.Rectangle;

public class HitBox extends CollisionBox {
    public HitBox(float x, float y, float width, float height, Renderable owner) {
        super(x, y, width, height, owner);
    }
    public void notifyCollision(HurtBox hurtBox){
        hurtBox.hasBeenHit();
    }
}
