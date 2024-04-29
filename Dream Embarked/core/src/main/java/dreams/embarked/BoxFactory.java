package dreams.embarked;

public class BoxFactory {
    public BoxFactory(){}
    public static CollisionBox createBox (String tag, Renderable owner, int x, int y, int width, int height){
        switch (tag.toLowerCase()){
            case "hurtbox":
                return new HurtBox(x,y,width,height,owner);
            case "hitbox":
                return new HitBox(x,y,width,height,owner);
            default:
                return new CollisionBox(x,y,width,height,"default",owner);
        }
    }
}
