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

        HitBox hitBox = (HitBox) boxFactory.createBox("hitbox", null, 0,0,0,0);
        HurtBox hurtBox = (HurtBox) boxFactory.createBox("hurtbox", null, 0,0,0,0);

        assertTrue(collisionObserver.getHitBoxesSize()==1);
        assertTrue(collisionObserver.getHurtBoxesSize()==1);
    }
}
