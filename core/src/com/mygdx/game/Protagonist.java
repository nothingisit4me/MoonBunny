package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Protagonist extends Entity {

    static final int gravity=10;

    public  Protagonist(SpriteBatch batch){
        super(
            new Texture("Protagonist.png"),
            batch,
            100,
            100,
            -100,
            300,
            3,
            100,
            0

        );
    }
    public void update(float delta){
       //Movement
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            posx += velx;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            posx -= velx;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            posy+=vely;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            posy+=vely;
            posx+=velx;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            posy+=vely;
            posx-=velx;
        }
        //boundaries
        if (posx < -1) {
            posx+=velx;
        }
        if (posx > MyGdxGame.V_WIDTH) {
            posx-=velx;
        }
        if (posy > 500) {
                posy -= vely;
        }
       //Gravity
        if (posy>300){
            posy-=gravity;
        }
    }

    @Override
    public void render(){
        batch.draw(texture, posx, posy, width, height);
    }
    @Override
    public void handleCollision(Entity e){

    }
}
