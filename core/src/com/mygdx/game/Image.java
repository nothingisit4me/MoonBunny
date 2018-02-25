package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public abstract class Image {
    public Texture texture;
    public SpriteBatch batch;
    public int width;
    public int height;
    public int posx;
    public int posy;
    public int velx;
    public int vely;
    public int ID;

    public Image(Texture texture,SpriteBatch batch, int width,int height, int posx, int posy, int velx, int vely, int ID){
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
    public abstract void render();

}


