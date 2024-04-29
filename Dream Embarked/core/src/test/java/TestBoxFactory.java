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
        Renderable renderableTemp = new Renderable(null, 0, 0, 0, 0);
        HitBox hitBox = (HitBox) boxFactory.createBox("hitbox", renderableTemp, 0,0,0,0);

        assertNotNull(hitBox);
    }
    @Test
    public void testHurtBoxCreation() {
        Renderable renderableTemp = new Renderable(null, 0, 0, 0, 0);
        HurtBox hurtBox = (HurtBox) boxFactory.createBox("hurtbox", renderableTemp, 0,0,0,0);

        assertNotNull(hurtBox);
    }
    @Test
    public void testDefaultBoxCreation() {
        Renderable renderableTemp = new Renderable(null, 0, 0, 0, 0);
        CollisionBox collisionBox = (CollisionBox) boxFactory.createBox("normal", renderableTemp, 0,0,0,0);

        assertNotNull(collisionBox);
    }

}
