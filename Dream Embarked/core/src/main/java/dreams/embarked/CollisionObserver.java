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

    public void detectCollisions() {
        for (HitBox hitBox : hitBoxes) {
            for (HurtBox hurtBox : hurtBoxes) {
                if (hitBox.overlaps(hurtBox)) {
                    hitBox.notifyCollision(hurtBox);
                    hasCollided = true;
                }
            }
        }
    }
    public int getHitBoxesSize(){ return hitBoxes.size(); }
    public int getHurtBoxesSize(){ return hurtBoxes.size(); }
    public boolean getHasCollided(){ return hasCollided; }
}
