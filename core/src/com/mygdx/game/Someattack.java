package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.jndi.url.dns.dnsURLContext;

public class Someattack extends Entity {

    public Someattack(SpriteBatch batch){
        super(
                new Texture("rme.png"),
                batch,
                100,
                100,
                1000,
                700,
                0,
                0,
                0

        );
    }
    public void update(float delta){

    }
    @Override
    public void render(){
        batch.draw(texture, posx, posy, width, height);
    }
    @Override
    public void handleCollision(Entity e){

    }
}
