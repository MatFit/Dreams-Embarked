package com.dreams.embarked;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Platform extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Player player;
	OrthographicCamera camera;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Color-blue.jpg");
		player = Player.getInstance(1,"name", img);
		camera = new OrthographicCamera();
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		float cameraX = (Gdx.graphics.getWidth() - player.grabTexture().getWidth() / 2);
		float cameraY = (Gdx.graphics.getHeight() - player.grabTexture().getHeight() / 2);
		camera.position.set(cameraX, cameraY, 0);
		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(player.grabTexture(), player.grabPlayerX(), player.grabPlayerY());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
