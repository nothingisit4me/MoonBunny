package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;

import java.io.File;
import java.util.ArrayList;

public class Protagonist extends Entity {
        private static float animationTime=0;
        private static int gravity=10;
        public static int hp=10;
        boolean loop=true;
        public static Sound soundwalking;
        public Protagonist(SpriteBatch batch){
            super(
                    new Texture("Bun1.png"),
                    batch,
                    300,
                    300,
                    -100,
                    150,
                    2,
                    100,
                    0

            );
            soundwalking= Gdx.audio.newSound(Gdx.files.internal("Music" + File.separator+"walking.mp3"));
    }

    public void update(float delta) {

        //Movement
        if ((Gdx.input.isKeyPressed(Input.Keys.RIGHT))) {
            posx += velx;
            animationTime=0;
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.RIGHT))) {
            soundwalking.play();
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            posx -= velx;
            animationTime=0;
        }
        if ((Gdx.input.isKeyJustPressed(Input.Keys.LEFT))) {
            soundwalking.play(1/8f);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            soundwalking.play(1/8f);
            posy += vely;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            soundwalking.play(1/8f);
            posy += vely;
            posx += velx;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            soundwalking.play(1/8f);
            posy += vely;
            posx -= velx;
        }
        //boundaries
        if (posx < -50) {
            posx += velx;
        }
        if (posx > 2000) {
            posx -= velx;
        }
        if (posy > 400) {
            posy -= vely;
        }
        //Gravity
        if (posy > 100) {
            posy -= gravity;
        }

    }

    @Override
    public void render() {
        batch.draw(texture, posx, posy, width, height);
    }
    @Override
    public void create()
    {}
    @Override
    public void dispose() {

    }
    @Override
    public void handleCollision (Entity e){


    }

}
