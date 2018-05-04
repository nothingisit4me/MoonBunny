package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

public class HitPoints extends Image {

    private static int Hitpointsnumber=3;
    public static int getHitpointsnumber(){
        return Hitpointsnumber;
    }
    public HitPoints(SpriteBatch batch){
        super(
                new Texture("fullmoonhp.png"),
                batch,
                200,
                200,
                0,
                1780,
                0,
                0,
                0

        );
    }

    public void update(float delta){


    }
    @Override
    public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
}