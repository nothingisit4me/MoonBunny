package com.mygdx.game.desktop;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {

		//Borderless Window
		//System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");

		//Configurations for Desktop Version
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable=true; //if screen is resizable
		//Sets values more values for width and height
		config.height = MyGdxGame.V_HEIGHT;
		config.width = MyGdxGame.V_WIDTH;
		//FPS setting. Increasing likely won’t increase game quality. But decreasing makes it worse.
		config.foregroundFPS=60;
		//VSync stuffs.
		config.vSyncEnabled=true;

		//Names the window it runs it
		config.title = "MoonBunny";
		//Makes the window image icon desired image
		config.addIcon("rme.png", Files.FileType.Internal);

		new LwjglApplication(new MyGdxGame(),config);

	}
}



