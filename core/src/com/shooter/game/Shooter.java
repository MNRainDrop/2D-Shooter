package com.shooter.game;

import java.util.ArrayList;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Shooter extends ApplicationAdapter {
	Player p1;
	Cursor c1;
	SpriteBatch sb;
	ShapeRenderer sr;
	ArrayList<Bullet> bullets;
	ArrayList<Enemy> enemies;
	int killedEnemies = 0;
	float runtime = 0;
	float timer = 1;
	double period = 0.5;

	@Override
	public void create () {
		c1 = new Cursor();
		p1 = new Player();
		sb = new SpriteBatch();
		sr = new ShapeRenderer(); 
		bullets = new ArrayList<Bullet>();
		enemies = new ArrayList<Enemy>();
		enemies.add(new Enemy(killedEnemies/5, p1.getX(), p1.getY()));
	}

	@Override
	public void render () {
		Gdx.input.setCursorCatched(true);
		ScreenUtils.clear(0, 0, 0, 1);
		timer += Gdx.graphics.getDeltaTime();
		runtime += Gdx.graphics.getDeltaTime();
		ArrayList<Bullet> bgone = new ArrayList<Bullet>();
		ArrayList<Enemy> egone = new ArrayList<Enemy>();
		
		//detects player input and moves accordingly
		p1.move();
		c1.move(p1);
		for (Enemy enemy : enemies){
			enemy.move(p1);
		}
		for (Bullet bullet : bullets){
			bullet.move();
		}

		//creates bullet that moves toward cursor when key pressed
		if (p1.isShot() && timer >= period){
			timer = 0;
			bullets.add(new Bullet(p1.getX(), p1.getY(), Math.atan2(Math.abs(c1.getY()) - (p1.getY() + p1.getH()/2), c1.getX() - (p1.getX() + p1.getW()/2))));
		}

		for (Enemy enemy : enemies){
			for (Bullet bullet : bullets){
				if (bullet.getX() >= enemy.getX() - enemy.getW()/2 &&
					bullet.getX() <= enemy.getX() + enemy.getW()/2 &&
					bullet.getY() >= enemy.getY() - enemy.getH()/2 &&
					bullet.getY() <= enemy.getY() + enemy.getH()/2){
					bgone.add(bullet);
					enemy.subtractHP(bullet.getDmg());
					if (enemy.getHp() <= 0) {
						killedEnemies++;
						egone.add(enemy);
					}
				}
			}
		}
		enemies.removeAll(egone);
		bullets.removeAll(bgone);

		if (enemies.size() < 1){
			enemies.add(new Enemy(killedEnemies/5, p1.getX(), p1.getY()));
		}
				
		//Detects if bullet comes to edge of screen
		//    If bullet comes to edge of screen, destroy it
		
		for (Bullet bullet : bullets){
			if (bullet.getX() >= Gdx.graphics.getWidth() + bullet.getW()/2 ||
				bullet.getX() <= 0 - bullet.getW()/2 ||
				bullet.getY() >= Gdx.graphics.getHeight() + bullet.getH()/2 ||
				bullet.getY() <= 0 - bullet.getH()/2){
				bgone.add(bullet);
			}
			bullet.draw(sr);
		}
		bullets.removeAll(bgone);

		for (Enemy enemy : enemies){
			enemy.draw(sb);
		}

		p1.draw(sr);
		c1.draw(sb);
	}
	
	@Override
	public void dispose () {
		sr.dispose();
	}
}
