package tilesystem;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.texture.Texture;

public class Room {
    private TileMap tilemap;
    private Texture background;

    public Room() {
        Generator gen = new Generator();
        background = FXGL.getAssetLoader().loadTexture(gen.genNewRoom());
    }
}
