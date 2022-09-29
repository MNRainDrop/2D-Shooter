package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.Random;

public class Enemy {
    private float x = -1;
    private float y = -1;
    private float w;
    private float h;
    private int level;
    private float hp;
    private Texture img;

    Enemy(int level, float px, float py){
        Random rand = new Random();
        this.level = level;
        this.w = this. h = 40;
        this.hp = level * 10;
        img = new Texture("Enemy.png");
        while(this.x == -1){
            this.x = rand.nextInt(Gdx.graphics.getWidth()-40);
            if (this.x > (px - 80) && this.x < (px + 80)){
                this.x = -1;
            }
        }
        while(this.y == -1){
            this.y = rand.nextInt(Gdx.graphics.getWidth()-40);
            if (this.y > (py - 80) && this.y < (py + 80)){
                this.y = -1;
            }
        }
        this.y = rand.nextInt(Gdx.graphics.getHeight()-40);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getW() {
        return w;
    }

    public float getH() {
        return h;
    }

    public int getLevel() {
        return level;
    }

    public float getHp() {
        return hp;
    }
    public void subtractHP(float hp) {
        this.hp -= hp;
    }

    public void draw(SpriteBatch sb){
        sb.begin();
        sb.draw(img, x, y, w, h);
        sb.end();
    }
    
    public void move(Player p1){
        double theta = Math.atan2(Math.abs(y) - p1.getY(), x - p1.getX());
        x -= Math.cos(theta) * Gdx.graphics.getDeltaTime() * 500;
        y -= Math.sin(theta) * Gdx.graphics.getDeltaTime() * 500;
    }
}
