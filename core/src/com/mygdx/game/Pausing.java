package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Pausing {

    boolean pause=false;


    public void update(float delta){
        if(Gdx.input.isKeyJustPressed(Input.Keys.P)&&!pause){
            pause=true;
        }else if(Gdx.input.isKeyJustPressed(Input.Keys.P)&&pause){
            pause=false;
        }

    }
}
