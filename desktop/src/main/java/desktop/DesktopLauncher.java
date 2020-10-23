package main.java.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import main.java.Main;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Game Window";
		config.resizable = true;

		//Pack all textures
		// TODO: REMOVE THIS BEFORE RELEASE
		TexturePacker.Settings sets = new TexturePacker.Settings();
		sets.pot = true;
		sets.fast = true;
		sets.combineSubdirectories = true;
		sets.paddingX = 1;
		sets.paddingY = 1;
		sets.edgePadding = true;
		TexturePacker.process(sets, "textures", "./", "texture_atlas");

		new LwjglApplication(new Main(), config);
	}
}
