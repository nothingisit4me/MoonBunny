package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

public class GameClear extends Image {

    public boolean clear=false;
    public GameClear(SpriteBatch batch){
        super(
                new Texture("Screens" + File.separator +"stageclear.png"),
                batch,
                1045,
                315,
                437,
                382,
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




