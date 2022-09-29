package com.shooter.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.*;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.*;
import com.badlogic.gdx.Gdx;

public class Score {
    int level;
    int killedEnemies;
    FreeTypeFontGenerator generator;
    FreeTypeFontParameter parameter;
    SpriteBatch batch;

    Score(){
        generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/joystix.ttf"));
        parameter = new FreeTypeFontParameter();
        parameter.size = 16;
    }

    public void render(){
        batch.begin();
            
    }

    public void dispose(){
        generator.dispose();
    }

}
