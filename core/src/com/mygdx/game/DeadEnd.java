package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

public class DeadEnd extends Image {

    public DeadEnd(SpriteBatch batch){
        super(
                new Texture("Screens" + File.separator +"DeadScreen.png"),
                batch,
                1920,
                1080,
                0,
                0,
                0,
                0,
                0

        );
    }

    public void update(float delta){


    }
    @Override
    public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
}




