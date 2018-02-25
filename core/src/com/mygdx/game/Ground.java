package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ground extends Image {
    public Ground(SpriteBatch batch){
        super(
                new Texture("snowy.png"),
                batch,
                5000,
                300,
                0,
                0,
                5,
                0,
                0

        );
    }

    public void update(float delta){
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            posx-=velx;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            posx+=velx;
        }
        if (posx ==0) {
            posx-=velx;
        } else if (posx==MyGdxGame.V_WIDTH-width){
            posx+=velx;
        }

    }
    @Override
    public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
}

