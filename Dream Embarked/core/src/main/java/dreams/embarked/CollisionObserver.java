package dreams.embarked;
import java.util.ArrayList;
import java.util.List;

public class CollisionObserver {
    private boolean hasCollided = false;
    private static CollisionObserver instance;
    private List<HitBox> hitBoxes = new ArrayList<>();
    private List<HurtBox> hurtBoxes = new ArrayList<>();

    public static synchronized CollisionObserver getInstance() {
        if (instance == null) {
            instance = new CollisionObserver();
        }
        return instance;
    }

    public void addHitBox(HitBox hitBox) {
        hitBoxes.add(hitBox);
    }

    public void addHurtBox(HurtBox hurtBox) {
        hurtBoxes.add(hurtBox);
    }
    public void clearHitBox(){
        hitBoxes.clear();
    }
    public void clearHurtBox(){
        hurtBoxes.clear();
    }
    public void removeHitBox(HitBox hitbox) { hitBoxes.remove(hitbox); }


    public void detectCollisions() {
        this.hasCollided = false;
        for (HitBox hitBox : hitBoxes) {
            for (HurtBox hurtBox : hurtBoxes) {
                if (hitBox.overlaps(hurtBox) && hitBox.getOwner() != hurtBox.getOwner()) {
                    hitBox.notifyCollision(hurtBox);
                    this.hasCollided = true;
                }
            }
        }
    }
    public int getHitBoxesSize(){ return hitBoxes.size(); }
    public int getHurtBoxesSize(){ return hurtBoxes.size(); }
    public boolean getHasCollided(){ return this.hasCollided; }
}
