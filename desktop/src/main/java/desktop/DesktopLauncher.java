package main.java.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import main.java.Main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class DesktopLauncher {
	//public static Socket socket;
	public static void main (String[] arg) {

		Scanner input = new Scanner(System.in);
		boolean connect = true;

		try {
			// Create a socket to connect to the server
			//Socket connectToServer = new Socket("localhost", 6969);
			Socket connectToServer = new Socket("192.168.43.26", 7000);


			// Create an input stream to receive data from the server
			DataInputStream isFromServer = new DataInputStream(connectToServer.getInputStream());

			// Create an output stream to send data to the server
			DataOutputStream osToServer = new DataOutputStream(connectToServer.getOutputStream());

			if (connect = true) {
				System.out.println("you are connected");

			}
			else{
				System.out.println("you are not connected");
			}
				while (connect) {
				// Enter annual interest rate
				System.out.print("Enter number to be calculated by server: ");
				double number = input.nextDouble();

				// Sends the number stored to the server
				osToServer.writeDouble(number);

				// The number gets calculated in the server, and returns a number which then gets displayed
				double totalNumber = isFromServer.readDouble();

				System.out.println("Calculated number: " + totalNumber);
			}

		} catch (IOException ex) {
			System.out.println(ex.toString() + '\n');
		}

		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);
	}
}
