package main.java;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
//import com.sun.security.ntlm.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Socket;
import java.util.Scanner;


public class Main extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	//public static Socket socket;
	//@Override

	/*public static void Main() {

		Scanner input = new Scanner(System.in);
		boolean connect = true;

			try {
				// Create a socket to connect to the server
				//Socket connectToServer = new Socket("localhost", 8000);
				socket = new Socket("192.168.1.11", 6969);


				// Create an input stream to receive data from the server
				DataInputStream isFromServer = new DataInputStream(socket.getInputStream());

				// Create an output stream to send data to the server
				DataOutputStream osToServer = new DataOutputStream(socket.getOutputStream());

				if (connect = true) {
					System.out.println("you are connected");
				}
				while (connect) {
					System.out.print("Enter annual interest rate, for example, 8,25: ");
					double annualInterestRate = input.nextDouble();
				}
			} catch (IOException ex) {
				System.out.println(ex.toString() + '\n');
			}


		}*/
		public void create () {

		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
