package dreams.embarked;
import com.badlogic.gdx.math.Rectangle;

public class HitBox extends CollisionBox {
    public HitBox(int x, int y, int width, int height, Renderable owner) {
        super(x, y, width, height, "hitbox", owner);
    }
    public void update(HurtBox hurtBox){
        hurtBox.hasBeenHit();
    }
}
