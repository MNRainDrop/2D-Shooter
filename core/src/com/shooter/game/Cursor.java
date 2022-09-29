package com.shooter.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Cursor {
    
    private Texture img;
    private float x;
    private float y;
    private float r;
    private boolean mouseInput;
    private float aimx;
    private float aimy;

    public Cursor(){
        img = new Texture("cursor.png");
        aimx = 300;
        aimy = 0;
        mouseInput = true;
        this.r = 40;
        this.x = Gdx.graphics.getWidth()/2;
        this.y = Gdx.graphics.getHeight()/2;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getR(){
        return r;
    }

    public void draw(SpriteBatch sb){
        sb.begin();
        sb.draw(img, x - r/2, y - r/2);
        sb.end();
    }

    public void move(Player p1){
        if (Gdx.input.isKeyJustPressed(Keys.F10)){
            Gdx.input.setCursorPosition((int) x, Gdx.graphics.getHeight() - (int) y);
            mouseInput = !mouseInput;
        }

        if (mouseInput){
            x = Gdx.input.getX();
            y = Gdx.graphics.getHeight() - Gdx.input.getY();

            if (x > Gdx.graphics.getWidth()){
                Gdx.input.setCursorPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight() - (int) y);
            }
            if (x < 0){
                Gdx.input.setCursorPosition(0, Gdx.graphics.getHeight() - (int) y);
            }
            if (y > Gdx.graphics.getHeight()){
                Gdx.input.setCursorPosition((int) x, 0);
            }
            if (y < 0){
                Gdx.input.setCursorPosition((int) x, Gdx.graphics.getHeight());
            }
        }
        else{
            if (Gdx.input.isKeyPressed(Keys.J) && Gdx.input.isKeyPressed(Keys.I)) {
                aimx = (float) (-300 * Math.sqrt(2) / 2);
                aimy = (float) (300 * Math.sqrt(2) / 2);
            }
            else if (Gdx.input.isKeyPressed(Keys.J) && Gdx.input.isKeyPressed(Keys.K)) {
                aimx = (float) (-300 * Math.sqrt(2) / 2);
                aimy = (float) (-300 * Math.sqrt(2) / 2);
            }
            else if (Gdx.input.isKeyPressed(Keys.L) && Gdx.input.isKeyPressed(Keys.I)) {
                aimx = (float) (300 * Math.sqrt(2) / 2);
                aimy = (float) (300 * Math.sqrt(2) / 2);
            }
            else if (Gdx.input.isKeyPressed(Keys.L) && Gdx.input.isKeyPressed(Keys.K)) {
                aimx = (float) (300 * Math.sqrt(2) / 2);
                aimy = (float) (-300 * Math.sqrt(2) / 2);
            }
            else if (Gdx.input.isKeyPressed(Keys.J)) {
                aimx = -300;
                aimy = 0;
            }
            else if (Gdx.input.isKeyPressed(Keys.L)) {
                aimx = 300;
                aimy = 0;
            }
            else if (Gdx.input.isKeyPressed(Keys.I)) {
                aimx = 0;
                aimy = 300;
            }
            else if (Gdx.input.isKeyPressed(Keys.K)) {
                aimx = 0;
                aimy = -300;
            }
            

            x = p1.getX() + p1.getW()/2 + aimx;
            y = p1.getY() + p1.getH()/2 + aimy;
        }        

    }
    

}


