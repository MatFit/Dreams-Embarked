package dreams.embarked;

import com.badlogic.gdx.graphics.Texture;

public class Enemy extends Renderable {
    public Enemy(IdentifiableTexture texture, int playerX, int playerY, int width, int height) {
        super(texture, playerX, playerY, width, height);
    }
}
