package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

import java.io.File;
import java.sql.Time;

public class LoadingScreen extends Image{
   // private float timeSeconds=0f;
   boolean loading=true;
    public LoadingScreen(SpriteBatch batch){
        super(
                new Texture("Screens" + File.separator +"LoadingScreen.png"),
                batch,
                MyGdxGame.V_WIDTH,
                MyGdxGame.V_HEIGHT,
                0,
                0,
                0,
                0,
                0


        );
    }

    public void update(float delta){

        if (loading){
            Timer.schedule(new Timer.Task(){
                @Override
                public void run(){
                    posy+=2000;
                    loading=false;
                }
            }, 5);

        }

    }
    @Override
    public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
}

