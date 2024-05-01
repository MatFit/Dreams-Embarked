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
        collisionObserver.clearHitBox();
        collisionObserver.clearHurtBox();

        HitBox hitBox = (HitBox) boxFactory.createBox("hitbox", null, 1,1,1,1);
        HurtBox hurtBox = (HurtBox) boxFactory.createBox("hurtbox", null, 1,1,1,1);

        assertEquals(1, collisionObserver.getHitBoxesSize());
        assertEquals(1, collisionObserver.getHurtBoxesSize());
    }
    @Test
    public void testDetectCollisions(){
        BoxFactory boxFactory = new BoxFactory();
        CollisionObserver collisionObserver = CollisionObserver.getInstance();
        collisionObserver.clearHitBox();
        collisionObserver.clearHurtBox();

        HitBox hitBox = (HitBox) boxFactory.createBox("hitbox", null, 1,1,2,2);
        HurtBox hurtBox = (HurtBox) boxFactory.createBox("hurtbox", null, 2,2,1,1);


        collisionObserver.detectCollisions();
        assertTrue(collisionObserver.getHasCollided());
    }

}
