package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import java.io.File;

public class Music2 {

    public Sound somesound2;
    boolean play2=true;
    boolean loop2=true;

    public Music2(){
        somesound2= Gdx.audio.newSound(Gdx.files.internal("Music" + File.separator+"sad.mp3"));
    }

    public void update(float delta) {
        if (play2) {
            if (loop2) {
                somesound2.loop();
                loop2 = false;
            }
        }else {
            somesound2.stop();
        }


    }
}