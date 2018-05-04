package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

public class TitleScreen extends Image{
    boolean start=false;
    boolean gameRunning=true;
    public TitleScreen(SpriteBatch batch){
        super(
                new Texture("Screens" + File.separator +"TitleScreen.png"),
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
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)&&(!start)){
            posy+=2000;
            start=true;
        }else if(!gameRunning&&!start){
            posy-=2000;
        }
    }
    @Override
    public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
}

