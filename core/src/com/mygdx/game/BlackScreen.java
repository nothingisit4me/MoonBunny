package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BlackScreen extends Image{
    public BlackScreen(SpriteBatch batch){
        super(
                new Texture("blackscreen.png"),
                batch,
                MyGdxGame.V_WIDTH,
                MyGdxGame.V_HEIGHT,
                0,
                0,
                0,
                0,
                0


        );
    }

    public void update(float delta){
        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            posy+=2000;

        }
    }
    @Override
    public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
}
