package dreams.embarked;

public class HurtBox extends CollisionBox {
    public HurtBox(float x, float y, float width, float height, Renderable owner) {
        super(x, y, width, height, owner);
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
