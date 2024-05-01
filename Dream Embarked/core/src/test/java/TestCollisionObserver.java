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
        Renderable hitOwner = new Renderable(null, 0, 0, 0, 0);
        Renderable hurtOwner = new Renderable(null, 1, 1, 0, 0);

        HitBox hitBox = (HitBox) boxFactory.createBox("hitbox", hitOwner, 1,1,3,3);
        HurtBox hurtBox = (HurtBox) boxFactory.createBox("hurtbox", hurtOwner, 2,2,1,1);

        collisionObserver.detectCollisions();
        assertTrue(collisionObserver.getHasCollided());
    }
    @Test
    public void testSameOwnerCollision(){
        BoxFactory boxFactory = new BoxFactory();
        CollisionObserver collisionObserver = CollisionObserver.getInstance();
        collisionObserver.clearHitBox();
        collisionObserver.clearHurtBox();
        Renderable owner = new Renderable(null, 0, 0, 0, 0);

        HitBox hitBox = (HitBox) boxFactory.createBox("hitbox", owner, 1,1,3,3);
        HurtBox hurtBox = (HurtBox) boxFactory.createBox("hurtbox", owner, 2,2,1,1);

        collisionObserver.detectCollisions();
        assertFalse(collisionObserver.getHasCollided());
    }

}
