package dreams.embarked;

public class BoxFactory {
    private static CollisionObserver collisionObserver = CollisionObserver.getInstance();
    public BoxFactory(){}
    public static CollisionBox createBox (String tag, Renderable owner, float x, float y, float width, float height){
        switch (tag.toLowerCase()){
            case "hurtbox":
                HurtBox newHurtBox = new HurtBox(x,y,width,height,owner);
                collisionObserver.addHurtBox(newHurtBox);
                return newHurtBox;
            case "hitbox":
                HitBox newHitBox = new HitBox(x,y,width,height,owner);
                collisionObserver.addHitBox(newHitBox);
                return newHitBox;
            default:
                return new CollisionBox(x,y,width,height,owner);
        }
    }
}
