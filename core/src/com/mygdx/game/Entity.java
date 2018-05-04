package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public abstract class Entity {
    public Texture texture;
    public SpriteBatch batch;
    public int width;
    public int height;
    public int posx;
    public int posy;
    public int velx;
    public int vely;
    public int ID;


    public static ArrayList<Entity> entities = new ArrayList<Entity>();



    public Entity(Texture texture,SpriteBatch batch, int width,int height, int posx, int posy, int velx, int vely, int ID){
        this.texture=texture;
        this.batch=batch;
        this.width=width;
        this.height=height;
        this.posx=posx;
        this.posy=posy;
        this.velx=velx;
        this.vely=vely;
        this.ID=ID;

    }

    public boolean isCollide(Entity e){
        if(
            posx < e.posx + e.width &&
                    posx + width > e.posx &&
                    posy < e.posy + e.height &&
                    height + posy > e.posy
                )
        {
            return true;
        } else {
            return false;
        }
    }
    public abstract void render();
    public abstract void create();
    public abstract void dispose();
    public abstract void handleCollision(Entity e);

}

