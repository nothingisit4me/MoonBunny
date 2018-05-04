package com.mygdx.game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import java.io.File;

public class HUD {
    Stage stage;
    Viewport viewport;
    Label Timer;
    long startTime = System.currentTimeMillis();
    long elapsedTime=0;

    public HUD(SpriteBatch batch) {
        viewport = new ScreenViewport(new OrthographicCamera());

        BitmapFont pixelFont = new BitmapFont(

                //File.separator acts as a / for distinguishing folders within folders
                Gdx.files.internal("font" + File.separator + "pixelOperatorHB.fnt"),
                false
        );

        stage = new Stage(viewport, batch);

        //Display Table (score)
        Table displayTable = new Table();
        //.top .center and such says where certain items should be displayed on screen
        displayTable.top();
        displayTable.setFillParent(true);


        //Test says what to display on screen
        //Color choices to display item
        //Requires pixelHB font file
        Timer = new Label("Timer: " + elapsedTime, new Label.LabelStyle(pixelFont, Color.YELLOW));

        //Size of text: (1-2 good)
        Timer.setFontScale(1.3F);


        //expandX makes all displayed things equidistant in certain area rather side by side
        //Value after padTop is distance from top of screen score should be (10 good)
        displayTable.add(Timer).expandX().padTop(10);
        displayTable.add(Timer).expandX().padLeft(1500);
        stage.addActor(displayTable);
    }
    public void update() {
        elapsedTime=System.currentTimeMillis() - startTime/100;
    }

}
