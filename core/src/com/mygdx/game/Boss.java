package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

public class Boss extends Entity{
    private static float animationTime=0;
    private static Sound dyingmew;


    public Boss(SpriteBatch batch){
        super(
                new Texture("ene2.png"),
                batch,
                800,
                800,
                5000,
                0,
                30,
                0,
                0


        );
        dyingmew=Gdx.audio.newSound(Gdx.files.internal("Music" + File.separator+"meow.mp3"));
        //still.getKeyFrame(0);
    }

    public void update(float delta) {
        //animationTime+=delta;
        //setRegion(still.getKeyFrame(animationTime));
        if ((Gdx.input.isKeyPressed(Input.Keys.RIGHT))) {
            posx -= velx;
            animationTime=0;
        }

    }
    @Override
    public void render () {
        batch.draw(texture, posx, posy, width, height);
    }

    @Override
    public void create () {
    }

    @Override
    public void dispose() {

    }
    @Override
    public void handleCollision (Entity e){
        dyingmew.play();
        posy = 4000;
        System.out.println("I love u");
    }

}

