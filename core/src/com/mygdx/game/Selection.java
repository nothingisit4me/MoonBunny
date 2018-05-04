package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

public class Selection extends Image {
    public Selection(SpriteBatch batch){
        super(
                new Texture("Screens" + File.separator+"selection.png"),
                batch,
                1000,
                200,
                647,
                70,
                0,
                0,
                0

        );
    }

    public void update(float delta){
        if (Gdx.input.isKeyPressed(Input.Keys.UP)){
            posy-=vely;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            posy+=vely;
        }
        if (posy < -1) {
            posy=vely;
        }
        if (posy > 500) {
            posy -= vely;
        }

    }
    @Override
    public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
}

