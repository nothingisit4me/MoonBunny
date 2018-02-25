package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class Music {
    private static Sound somesound;
    boolean loop=true;
    public Music(){
        somesound= Gdx.audio.newSound(Gdx.files.internal("somesound.mp3"));
    }

    public void update(float delta){
        if(loop) {
            somesound.loop();
            loop=false;
        }
    }
}

