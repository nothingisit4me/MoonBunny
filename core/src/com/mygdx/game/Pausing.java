package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

public class Pausing extends Image {

    boolean pause=false;
    boolean gameexit= false;
    boolean returntomenu=false;
    public Pausing(SpriteBatch batch){
        super(
                new Texture("Screens" + File.separator +"PauseScreen.png"),
                batch,
                625,
                1000,
                647,
                80,
                0,
                0,
                0



        );
    }

    public void update(float delta){
        if(Gdx.input.isKeyJustPressed(Input.Keys.P)&&!pause){
            pause=true;
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)&&pause){
            pause=false;
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)&&pause){
            if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                returntomenu=true;
            }
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)&&pause) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)) {
                    gameexit=true;
                }
            }
            pause = false;
        }
    }
    @Override
    public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
}
