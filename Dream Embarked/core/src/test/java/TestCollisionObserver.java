import dreams.embarked.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCollisionObserver {
    @Test
    public void testCreation(){
        CollisionObserver collisionObserver = CollisionObserver.getInstance();
        assertNotNull(collisionObserver);
    }
    @Test
    public void testAddHitBoxAndAddHurtBox(){
        BoxFactory boxFactory = new BoxFactory();
        CollisionObserver collisionObserver = CollisionObserver.getInstance();

        HitBox hitBox = (HitBox) boxFactory.createBox("hitbox", null, 1,1,1,1);
        HurtBox hurtBox = (HurtBox) boxFactory.createBox("hurtbox", null, 1,1,1,1);

        assertTrue(collisionObserver.getHitBoxesSize()==1);
        assertTrue(collisionObserver.getHurtBoxesSize()==1);
    }
    @Test
    public void testDetectCollisions(){
        BoxFactory boxFactory = new BoxFactory();
        CollisionObserver collisionObserver = CollisionObserver.getInstance();

        HitBox hitBox = (HitBox) boxFactory.createBox("hitbox", null, 21,21,11,11);
        HurtBox hurtBox = (HurtBox) boxFactory.createBox("hurtbox", null, 21,21,11,11);

        collisionObserver.detectCollisions();
        assertTrue(collisionObserver.getHasCollided());
    }

}
