package com.dreams.embarked;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import java.util.Arrays;

public class Platform extends ApplicationAdapter {
	Texture dirtTexture;
	Player player;
	World world;
	
	@Override
	public void create () {
		dirtTexture = new Texture("mud_tile.png");
		boolean[][] dirt = new boolean[60][40];
		Arrays.stream(dirt).forEach(a -> Arrays.fill(a, true));
		World world = World.newBuilder()
				.createTileMap(60, 40)
				.createPlayer(360, 180)
				.populateTiles(dirt, dirtTexture)
				.build();
		this.world = world;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		world.update();
		world.render();
	}
	
	@Override
	public void dispose () {
		dirtTexture.dispose();
		world.dispose();
	}
}
