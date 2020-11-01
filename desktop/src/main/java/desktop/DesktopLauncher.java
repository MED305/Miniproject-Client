package main.java.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.sun.tools.javac.comp.Todo;
import main.java.Main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class DesktopLauncher {

	public static void main (String[] arg) {
	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Game Window";
		config.resizable = true;
		config.width = 800;
		config.height = 800;

		// Pack all textures
		// TODO: REMOVE THIS BEFORE RELEASE
		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.pot = true;
		settings.fast = true;
		settings.combineSubdirectories = true;
		settings.paddingX = 1;
		settings.paddingY = 1;
		settings.edgePadding = true;
		TexturePacker.process(settings, "textures", "./", "texture_atlas");

		new LwjglApplication(new Main(), config);
		
	}
}
