package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;

public class Player {
    private float x;
    private float y;
    private float w;
    private float h;
    private float hp;

    public Player(){
        this.w = this.h = 40;
        this.x = Gdx.graphics.getWidth()/2 - w/2;
        this.y = Gdx.graphics.getHeight()/2 - h/2;
        this.hp = 10;
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

    public float getHP() {
        return hp;
    }

    public void draw(ShapeRenderer sr){
        sr.begin(ShapeType.Filled);
		sr.setColor(0.827f, 0.827f, 0.827f, 1);
		sr.rect(x, y, w, h);
		sr.end();
    }

    public void move(){
        if (Gdx.input.isKeyPressed(Keys.A)) {
            x -= 500 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.D)) {
            x += 500 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.W)) {
            y += 500 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Keys.S)) {
            y -= 500 * Gdx.graphics.getDeltaTime();
        }

        if (x > Gdx.graphics.getWidth() - w){
            x = Gdx.graphics.getWidth() - w;
        }
        if (x < 0){
            x = 0;
        }
        if (y > Gdx.graphics.getHeight() - h){
            y = Gdx.graphics.getHeight() - h;
        }
        if (y < 0){
            y = 0;
        }
    }

    public boolean isShot(){
        if (Gdx.input.isKeyPressed(Keys.SPACE) || Gdx.input.isButtonPressed(Buttons.LEFT)){
            return true;
        }
        else {
            return false;
        }
    }
    

}


