package dreams.embarked;

public class HitBox extends CollisionBox {
    public HitBox(int x, int y, int width, int height, Renderable owner) {
        super(x, y, width, height, "hitbox", owner);
    }
}
