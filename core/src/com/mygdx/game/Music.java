package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.io.File;

public class Music {
    public Sound somesound;
    boolean loop=true;
    boolean play=true;

    public Music(){
        somesound= Gdx.audio.newSound(Gdx.files.internal("Music" + File.separator+"happy.mp3"));

    }

    public void update(float delta){
        if (play){
            if(loop) {
            somesound.loop();
            loop=false;
            }
        }else {
            somesound.stop();
        }


    }
}

