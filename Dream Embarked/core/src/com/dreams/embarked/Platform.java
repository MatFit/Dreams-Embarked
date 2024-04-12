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
		img = new Texture("beta player.png");
		player = Player.getInstance(1,"name", img);
		camera = player.getCamera();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 1, 0, 1);

		player.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(player.getTexture(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
