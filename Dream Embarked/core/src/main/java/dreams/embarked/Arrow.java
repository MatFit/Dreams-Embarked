package dreams.embarked;

public class Arrow extends Renderable {
    private int xSpeed;
    private HitBox hitbox;

    public Arrow(IdentifiableTexture texture, int x, int y, int xSpeed) {
        super(texture, x, y, 32, 32);
        this.xSpeed = xSpeed;
        this.hitbox = (HitBox) BoxFactory.createBox("hitbox", this, x, y, 20, 4);
    }

    public void update() {
        this.moveX(xSpeed);
        this.hitbox.setPosition(this.getX(), this.getY());
    }
}
