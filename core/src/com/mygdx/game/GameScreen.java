package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.xml.internal.bind.v2.model.core.ID;

import static com.mygdx.game.Entity.entities;

public class GameScreen implements Screen {

    //Fields
//Useful variables
    private MyGdxGame game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private final int LEVEL_WIDTH;
    private final int LEVEL_HEIGHT;

    Pausing pausing;
    Image image;
    Background background;
    Ground ground;
    Protagonist protagonist;
    Someattack someattack;
    Enemy[] enemy;
    BlackScreen blackscreen;
    Music music;

    //Constructor
    public GameScreen(MyGdxGame game) {
        this.game = game;

//Equates variable values to that declared in MyGdxGame class
        LEVEL_WIDTH = MyGdxGame.V_WIDTH;
        LEVEL_HEIGHT = MyGdxGame.V_HEIGHT;
//Creates a new window to project game onto. Then actually declares the window’s dimensions equal to previously declared height and width values.
        gameCam = new OrthographicCamera();
        gamePort = new ExtendViewport(LEVEL_WIDTH, LEVEL_HEIGHT, gameCam);
        pausing=new Pausing();
        background = new Background(game.batch);
        ground = new Ground(game.batch);
        protagonist = new Protagonist(game.batch);
        //Entity.entities.add(protagonist);
        someattack = new Someattack(game.batch);
        //Entity.entities.add(someattack);
        enemy=new Enemy[Enemy.getEnemynumber()];
        for(int i=0;i<=Enemy.getEnemynumber()-1;i++){
            enemy[i] = new Enemy(game.batch,((int)((i+400)*Math.random())));
            Entity.entities.add(enemy[i]);
        }
        blackscreen = new BlackScreen(game.batch);
        music=new Music();
    }

    //Methods
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);

        //Clears Screen
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Allows images to be transparent
        //game.batch.enableBlending();

//Beginning of all rendered objects
        game.batch.begin();
        background.render();
        ground.render();
        protagonist.render();
        someattack.render();
        for(int i=0;i<=Enemy.getEnemynumber()-1;i++) {
            enemy[i].render();
        }
        blackscreen.render();

        //End of all rendered objects
        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }


    //Updates game using update method in each class
    public void update(float delta) {
        pausing.update(delta);
        music.update(delta);
        if(!pausing.pause) {
           background.update(delta);
           ground.update(delta);
           protagonist.update(delta);
           someattack.update(delta);
           for (int i = 0; i <= Enemy.getEnemynumber() - 1; i++) {
               enemy[i].update(delta);
           }
           blackscreen.update(delta);
           }
        for (Entity e : Entity.entities) {
            if (protagonist.isCollide(e)) {
                protagonist.handleCollision(e);
                e.handleCollision(protagonist);

            }
            if (someattack.isCollide(e)) {
                someattack.handleCollision(e);
                e.handleCollision(someattack);

               /*if (enemy.isCollide(e)) {
                enemy.handleCollision(e);
                e.handleCollision(enemy);

                }*/
            }
       }

    }
}

