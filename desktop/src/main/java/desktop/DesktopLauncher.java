package main.java.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import main.java.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DesktopLauncher {
	public static void main(String[] arg) {

		Scanner input = new Scanner(System.in);
		boolean connect = true;

		try {
			// Create a socket to connect to the server
			Socket connectToServer = new Socket("192.168.1.11", 6969);

			// Create an input stream to receive data from the server
			DataInputStream isFromServer = new DataInputStream(connectToServer.getInputStream());

			// Create an output stream to send data to the server
			DataOutputStream osToServer = new DataOutputStream(connectToServer.getOutputStream());

			if (connect = true) {
				System.out.println("you are connected");
			} else {
				System.out.println("you are not connected");
			}

			while (connect) {
				// Enter annual interest rate
				System.out.print("Enter number to be calculated by server: ");
				double number = input.nextDouble();

				// Sends the number stored to the server
				osToServer.writeDouble(number);

				// The number gets calculated in the server, and returns a number which then
				// gets displayed
				double totalNumber = isFromServer.readDouble();

				System.out.println("Calculated number: " + totalNumber);
			}

		} catch (IOException ex) {
			System.out.println(ex.toString() + '\n');
		}

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
