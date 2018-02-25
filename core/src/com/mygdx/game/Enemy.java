package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static com.badlogic.gdx.Input.Keys.A;

public class Enemy extends Entity{
    private static int enemynumber=2;
    public static int getEnemynumber(){
        return enemynumber;
    }

    public Enemy(SpriteBatch batch,int posx){
        super(
                new Texture("Enemy.png"),
                batch,
                100,
                100,
                 posx,
                300,
                0,
                0,
                0

        );
    }
    public void update(float delta){
        if (posy > 600||posy<400) {
            if (posy > MyGdxGame.V_HEIGHT - height) {
                posy -= vely;
            } else if (posy < 400) {
                posy += vely;
            }
        }
    }
    @Override
    public void render(){
        batch.draw(texture, posx,posy,width, height);
    }
    @Override
    public void handleCollision(Entity e){
        posy=2000;
        System.out.println("I hate u");
    }

}
