package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

import static com.badlogic.gdx.Input.Keys.A;

public class Enemy extends Entity{
    private static int enemynumber=20;
    private static float animationTime=0;
    private static Sound dyingmew;
    public static int getEnemynumber(){
        return enemynumber;
    }


    public Enemy(SpriteBatch batch,int posx){
        super(
               new Texture("ene1.png"),
                batch,
                200,
                200,
                 posx,
                100,
                0,
                0,
                0


        );
        dyingmew=Gdx.audio.newSound(Gdx.files.internal("Music" + File.separator+"meow.mp3"));
        //still.getKeyFrame(0);
    }

    public void update(float delta) {
        //animationTime+=delta;
        //setRegion(still.getKeyFrame(animationTime));


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
            posy = 2000;
            System.out.println("I hate u");
    }

    }

