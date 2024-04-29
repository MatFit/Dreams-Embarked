import dreams.embarked.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestBoxFactory {
    private BoxFactory boxFactory = new BoxFactory();

    @Test
    public void testCreation() {
        BoxFactory boxFactory = new BoxFactory();
        assertNotNull(boxFactory);
    }

    @Test
    public void testHitBoxCreation() {
        HitBox hitBox = (HitBox) boxFactory.createBox("hitbox", null, 0,0,0,0);
        assertNotNull(hitBox);
    }
    @Test
    public void testHurtBoxCreation() {
        HurtBox hurtBox = (HurtBox) boxFactory.createBox("hurtbox", null, 0,0,0,0);
        assertNotNull(hurtBox);
    }
    @Test
    public void testDefaultBoxCreation() {
        CollisionBox collisionBox = (CollisionBox) boxFactory.createBox("normal", null, 0,0,0,0);
        assertNotNull(collisionBox);
    }

}
