package dreams.embarked;

import com.badlogic.gdx.graphics.Texture;

public class Tile extends Renderable {
    private IdentifiableTexture texture;

    public Tile(IdentifiableTexture texture,TextureType textureType, int x, int y, int width, int height) {
        super(texture, x, y, width, height);
    }
}
