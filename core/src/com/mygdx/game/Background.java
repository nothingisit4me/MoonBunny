package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Background extends Image {
    public Background(SpriteBatch batch){
        super(
                new Texture("jellyfishy.png"),
                batch,
                5000,
                MyGdxGame.V_HEIGHT,
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

    //Boundaries
        if (posx ==0) {
                posx-=velx;
        } else if (posx==MyGdxGame.V_WIDTH-width){
                posx+=velx;
        }



        /* moving on its own
        if (posx < 0 || posx > MyGdxGame.V_WIDTH-width) {

            if (posx > MyGdxGame.V_WIDTH-width) {
                posx-=1;
            } else if (posx < 0){
                posx+=1;
            }
        }*/

    }
    @Override
        public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
}




