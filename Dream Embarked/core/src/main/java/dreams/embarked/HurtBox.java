package dreams.embarked;

public class HurtBox extends CollisionBox {
    public HurtBox(int x, int y, int width, int height, Renderable owner) {
        super(x, y, width, height, "hurtbox", owner);
    }
    public void hasBeenHit(){
        if (this.getOwner() instanceof Player){
            ((Player) this.getOwner()).hasBeenDamaged();
        }
        else if (this.getOwner() instanceof Enemy){
            ((Enemy) this.getOwner()).hasBeenDamaged();
        }
    }
}
