package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import java.lang.Math;

public class Bullet {
    private float x;
    private float y;
    private float w;
    private float h;
    private double theta;
    private float dmg;
    
    public Bullet(float x, float y, double theta){
        this.h = 30;
        this.w = 10;
        this.x = x-(w/2);
        this.y = y-(w/2);
        this.theta = theta;
        this.dmg = 5;
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

    public float getDmg() {
        return dmg;
    }

    public void draw(ShapeRenderer sr){
        sr.begin(ShapeType.Filled);
		sr.setColor(1, 1, 1, 1);
        sr.rect(x + 50/2 - h/2, y + 50/2 - w/2, h/2, w/2, h, w, 1, 1, (float)Math.toDegrees(theta)); 
		sr.end();
    }

    public void move(){
        x += Math.cos(theta) * Gdx.graphics.getDeltaTime() * 1500;
        y += Math.sin(theta) * Gdx.graphics.getDeltaTime() * 1500;
    }
}
