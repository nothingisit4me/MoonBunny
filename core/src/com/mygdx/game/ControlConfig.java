package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.File;

public class ControlConfig extends Image {
    boolean starting = false;

    public ControlConfig(SpriteBatch batch) {
        super(
                new Texture("Screens" + File.separator + "ControlConfig.png"),
                batch,
                1920,
                1080,
                0,
                0,
                0,
                0,
                0


        );
    }

    public void update(float delta) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER) && !starting) {
            starting = true;

        }

    }
    @Override
    public void render () {
        batch.draw(texture, posx, posy, width, height);
    }

}
