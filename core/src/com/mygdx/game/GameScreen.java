package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import net.dermetfan.gdx.graphics.g2d.AnimatedSprite;

public class GameScreen implements Screen {

    //Fields
    //Useful variables
    private MyGdxGame game;
    private OrthographicCamera gameCam;
    private Viewport gamePort;
    private final int LEVEL_WIDTH;
    private final int LEVEL_HEIGHT;
    private Animation animation;
    private AnimatedSprite animatedSprite;
    private SpriteBatch batch;
    private TextureAtlas enemyAtlas;
    private TextureAtlas protagonistAtlas;

    ControlConfig controlConfig;
    Pausing pausing;
    Image image;
    Stage1 stage1;
    Stage2 stage2;
    Stage3 stage3;
    Protagonist protagonist;
    Herb herb;
    Enemy[] enemy;
    Boss boss;
    Ground ground;
    DeadEnd deadEnd;
    Music music;
    Music2 music2;
    HUD hud;
    HitPoints[] hitPoints;
    TitleScreen titleScreen;
    LoadingScreen loadingScreen;
    GameClear gameClear;

    //Constructor
    public GameScreen(MyGdxGame game) {
        this.game = game;

//Equates variable values to that declared in MyGdxGame class
        LEVEL_WIDTH = MyGdxGame.V_WIDTH;
        LEVEL_HEIGHT = MyGdxGame.V_HEIGHT;
//Creates a new window to project game onto. Then actually declares the window’s dimensions equal to previously declared height and width values.
        gameCam = new OrthographicCamera();
        gamePort = new ExtendViewport(LEVEL_WIDTH, LEVEL_HEIGHT, gameCam);
        pausing=new Pausing(game.batch);
        stage1 = new Stage1(game.batch);
        stage2 = new Stage2(game.batch);
        stage3 = new Stage3(game.batch);

        //Entity.entities.add(protagonist);
        enemy=new Enemy[Enemy.getEnemynumber()];
        if (stage1.currentstage){
            for(int i=0;i<=Enemy.getEnemynumber()-1;i++){
                enemy[i] = new Enemy(game.batch, (int)((i+5000)*Math.random()));
                Entity.entities.add(enemy[i]);
            }
        }
        boss =new Boss(game.batch);
        Entity.entities.add(boss);
        protagonist=new Protagonist(game.batch);
        herb=new Herb(game.batch);
        Entity.entities.add(herb);
        ground = new Ground(game.batch);
        deadEnd=new DeadEnd(game.batch);
        gameClear=new GameClear(game.batch);
        controlConfig=new ControlConfig(game.batch);
        music=new Music();
        music2=new Music2();
        hud=new HUD(game.batch);
        hitPoints=new HitPoints[HitPoints.getHitpointsnumber()];
        for(int i=0;i<=HitPoints.getHitpointsnumber()-1;i++){
            hitPoints[i] = new HitPoints(game.batch);

        }
        loadingScreen=new LoadingScreen(game.batch);
        titleScreen= new TitleScreen(game.batch);

    }

    //Methods
    @Override
    public void show() {
        batch=new SpriteBatch();
       // Animation animation=new Animation(1/3f, new TextureRegion(new Texture("enemy.png")),new TextureRegion(new Texture("Bun1.png")));
        //animation.setPlayMode(Animation.PlayMode.LOOP);
        //animatedSprite=new AnimatedSprite(animation);

        //enemyAtlas = new TextureAtlas("enesli.txt");
        //Animation still;
        //still=new Animation(1/2f, enemyAtlas.findRegions("still"));
        protagonistAtlas = new TextureAtlas("bunbun.pack");
        Animation stillRight, stillLeft;
        stillRight=new Animation(1/2f, protagonistAtlas.findRegions("stillRight"));
        stillLeft=new Animation(1/2f, protagonistAtlas.findRegions("stillLeft"));
        stillLeft.setPlayMode(Animation.PlayMode.LOOP);

        stillRight.setPlayMode(Animation.PlayMode.LOOP);
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
        if (stage1.currentstage){
            stage1.render();
        }
        if ((protagonist.posx>1920)&& (stage1.currentstage)){
            stage1.currentstage=false;
            stage2.currentstage=true;
        }
        if (stage2.currentstage){
            stage2.render();
            boss.render();
        }
        if ((protagonist.posx>1920)&&(stage2.currentstage)){
            stage2.currentstage=false;
            stage3.currentstage=true;
        }
        if (stage3.currentstage){
            stage3.render();
            if (protagonist.posx>300){
                herb.render();
            }
        }
        //batch.begin();
        //animatedSprite.draw(batch);
        //batch.end();
        protagonist.render();
        if (stage1.currentstage){
            for(int i=0;i<=Enemy.getEnemynumber()-1;i++) {
                enemy[i].render();
            }
        }
        if (stage1.currentstage){ground.render();}

        if(protagonist.hp==0){
            deadEnd.render();
        }
        for(int i=0;i<=HitPoints.getHitpointsnumber()-1;i++) {
            hitPoints[i].render();
        }
        if(gameClear.clear){
            gameClear.render();
        }
        if(pausing.pause){
            pausing.render();
        }
        if(!controlConfig.starting){
            controlConfig.render();
        }

        //End of all rendered objects
        game.batch.end();
        //hud.stage.draw();
        game.batch.begin();
        loadingScreen.render();
        titleScreen.render();
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

        protagonistAtlas.dispose();
    }


    //Updates game using update method in each class
    public void update(float delta) {
        titleScreen.update(delta);
        if(titleScreen.start) {
        loadingScreen.update(delta);
        if(!loadingScreen.loading) {
            controlConfig.update(delta);
            if (controlConfig.starting) {
                if (protagonist.hp > 0) {
                    pausing.update(delta);
                    if (!pausing.pause) {
                        if (stage1.currentstage) {
                            music.update(delta);
                            stage1.update(delta);
                            protagonist.update(delta);

                            for (int i = 0; i <= Enemy.getEnemynumber() - 1; i++) {
                                enemy[i].update(delta);
                            }

                            ground.update(delta);
                            if (music.play && Gdx.input.isKeyJustPressed(Input.Keys.M)) {
                                music.somesound.pause();
                                music.play = false;
                            } else if (!music.play && Gdx.input.isKeyJustPressed(Input.Keys.M)) {
                                music.somesound.play();
                                music.play = true;
                            }
                            if ((protagonist.posx > 1920) && (stage1.currentstage)) {
                                stage1.currentstage = false;
                                stage2.currentstage = true;
                                protagonist.posx = -10;
                                music.somesound.pause();
                            }
                        }

                        if (stage2.currentstage) {
                            stage2.update(delta);
                            music2.update(delta);
                            protagonist.update(delta);

                            boss.update(delta);
                            if (music2.play2 && Gdx.input.isKeyJustPressed(Input.Keys.M)) {
                                music2.somesound2.pause();
                                music2.play2 = false;
                            } else if (!music.play && Gdx.input.isKeyJustPressed(Input.Keys.M)) {
                                music2.somesound2.play();
                                music2.play2 = true;
                            }

                            if ((protagonist.posx > 1920) && (stage2.currentstage)) {
                                stage2.currentstage = false;
                                stage3.currentstage = true;
                                protagonist.posx = -10;
                            }
                        }
                        if (stage3.currentstage) {
                            stage3.update(delta);
                            protagonist.update(delta);
                            herb.update(delta);
                            if (protagonist.posx == 300) {
                                herb.falling = true;
                            }
                            if (herb.posx == protagonist.posx + 290) {
                                herb.taken = true;
                            }
                            if (herb.taken) {
                                herb.falling = false;
                                gameClear.clear = true;
                                gameClear.update(delta);
                            }
                            if (protagonist.posx > 1920) {
                                stage3.currentstage = false;
                                music2.somesound2.pause();
                                Gdx.app.exit();
                            }
                        }
                        hud.update();
                    } else if (pausing.pause) {
                        if (pausing.returntomenu) {
                            titleScreen.start = false;
                            titleScreen.gameRunning = false;
                        } else if (pausing.gameexit) {
                            Gdx.app.exit();
                        }

                    }
                }
                for (Entity e : Entity.entities) {
                    if (protagonist.isCollide(e)) {
                        protagonist.handleCollision(e);
                        e.handleCollision(protagonist);

                    }
            }
        }
        }
        }
        }



            /*if (enemy[].isCollide(e)) {
                enemy[].handleCollision(e);
                e.handleCollision(enemy[]);
            }*/

    }
       //}

