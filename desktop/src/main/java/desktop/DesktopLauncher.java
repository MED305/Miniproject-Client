package main.java.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import main.java.Main;
import main.java.Server.ConSocket;


import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class DesktopLauncher {

	public static void main (String[] arg) {

		// TODO: REMOVE THIS BEFORE RELEASE
		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.pot = true;
		settings.fast = true;
		settings.combineSubdirectories = true;
		settings.paddingX = 1;
		settings.paddingY = 1;
		settings.edgePadding = true;
		TexturePacker.process(settings, "textures", "./", "texture_atlas");

		ConSocket con = new ConSocket();
		con.start();
	}
}
