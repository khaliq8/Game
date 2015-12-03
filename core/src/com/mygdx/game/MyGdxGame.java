package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture ship;
	Texture background;
	
	Float width;
	Float height;
	
	Vector2 shiplocation = new Vector2(0,0);
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		width = (float)Gdx.graphics.getWidth();
		height = (float)Gdx.graphics.getHeight();
		ship = new Texture("ship.png");
		background = new Texture("background.gif");
		shiplocation = new Vector2((width/2 - ship.getWidth()/2), (height/2 - ship.getHeight()/2));
	}

	public void update()
	{
		if(Gdx.input.isKeyPressed(Keys.UP)){
			shiplocation.y += 5;
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)){
			shiplocation.y -= 5;
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)){
			shiplocation.x += 5;
		}	
		if(Gdx.input.isKeyPressed(Keys.LEFT)){
			shiplocation.x -= 5;
		}
	}
	
	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(background, 0, 0);
		batch.draw(ship, shiplocation.x, shiplocation.y);
		batch.end();
	}
}
