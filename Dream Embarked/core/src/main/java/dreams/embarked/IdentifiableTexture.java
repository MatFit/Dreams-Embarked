package dreams.embarked;

import com.badlogic.gdx.graphics.Texture;

public class IdentifiableTexture extends Texture {
    private TextureType textureType;

    public IdentifiableTexture(TextureType identifier, String internalPath) {
        super(internalPath);
        this.textureType = textureType;
    }

    public TextureType getTextureType() {
        return textureType;
    }

}
