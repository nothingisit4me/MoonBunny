package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

import static com.badlogic.gdx.Input.Keys.A;

public class Herb extends Entity{
    private static int gravity=10;
    private static Sound Beep;
    public boolean falling=false;
    public boolean taken=false;
    public Herb(SpriteBatch batch){
        super(
                new Texture("herb.png"),
                batch,
                100,
                100,
                1000,
                1920,
                0,
                0,
                0

        );
        Beep=Gdx.audio.newSound(Gdx.files.internal("Music" + File.separator+"beep-7.mp3"));
    }
    public void update(float delta) {
        if (falling&&(!taken)&&posy > 100) {
            posy -= gravity;
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
        Beep.play();
        posy = 3407;
        System.out.println("You win");
    }
}