package main.java.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.sun.tools.javac.comp.Todo;
import main.java.Main;
import main.java.Server.ConSocket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class DesktopLauncher {

<<<<<<< Updated upstream
	public static void main (String[] arg) {
		ConSocket con = new ConSocket();
		con.connection();
=======
>>>>>>> Stashed changes

	public static void main (String[] arg) {
		ConSocket con = new ConSocket();
		con.connection();


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

		
	}
}
