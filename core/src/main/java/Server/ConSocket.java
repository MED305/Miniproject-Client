package main.java.Server;

import java.io.*;
import java.net.Socket;

import java.util.Scanner;

import java.lang.Integer;

import com.badlogic.gdx.math.Vector2;
import main.java.Main;
import main.java.entity.*;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class ConSocket {
    boolean connect = false;
    Scanner input = new Scanner(System.in);
    int port = 6969;
    Socket connectToServer;
    ObjectOutputStream usToServer;
    ObjectInputStream inputStream;

    // position vectors for the guests.
    public Vector2 g1Pos;
    public Vector2 g2Pos;
    public Vector2 g3Pos;
    public int playerinfo;

    public void start() { // lobby
        System.out.println("Write 'start' to start the game");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("start")) {
            System.out.println("Game starting");
            // The game starts here!
            LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

            config.title = "Game Window";
            config.resizable = true;
            config.width = 800;
            config.height = 800;

            new LwjglApplication(new Main(), config);
            scanner.close();
        }
    }

    public void connection() {
        // position vectors for the guests.
        g1Pos = new Vector2();
        g2Pos = new Vector2();
        g3Pos = new Vector2();

        try {
            System.out.println("Connect to IP here");
            System.out.println("If you are running server locally write: localhost");
            String IP = input.nextLine(); // vi inputter ip mm
            connectToServer = new Socket(IP, port); // vi connecter

            if (connectToServer.isConnected()) { // checker om den er connectet
                connect = true; // går videre til ready fasen
            }

            System.out.println("If all players are connected then write 'ready' - To close game write 'close'");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            if (input.equals("close")) {
                System.out.println("game closing");
                System.exit(0);

            }

            if (input.equals("ready")) {
                if (connect = true) {
                    try {
                        System.out.println("You are connected");

                        usToServer = new ObjectOutputStream(connectToServer.getOutputStream());
                        inputStream = new ObjectInputStream(connectToServer.getInputStream());
                        scanner.close();

                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Error, enter correct input");

                    }
                }

                if (connect = false) {
                    System.out.println("We didn't find your server.");
                }
            }

        } catch (IOException ex) {
            System.out.println(ex.toString() + '\n');
            System.out.println("you are not connected");
            System.exit(-1);
        }

    }

    // the method for which we send our position
    public void serverSender(PlayerActor player) {

        try {
            usToServer.writeFloat(player.getXPosition());
            usToServer.writeFloat(player.getYPosition());
            // usToServer.writeFloat(bullet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // server reciever is the method of which we receive our data
    public void serverReceiver() {

        try {
            // To ensure the program is not caught on waiting for data, so we check whether
            // there is any incoming data.
            if (inputStream.available() > 0) {
                // We receive data as a String, and convert that to an array of Strings.
                String[] info = inputStream.readUTF().split("-");
                // player info could also be thought as a user name, this i the place of the
                // connection in an array on the server side
                playerinfo = Integer.parseInt(info[0]);

                switch (playerinfo) {
                    case 0:
                        g1Pos.x = Float.parseFloat(info[1]);
                        g1Pos.y = Float.parseFloat(info[2]);
                        break;

                    case 1:
                        g2Pos.x = Float.parseFloat(info[1]);
                        g2Pos.y = Float.parseFloat(info[2]);
                        break;

                    case 2:
                        g3Pos.x = Float.parseFloat(info[1]);
                        g3Pos.y = Float.parseFloat(info[2]);
                        break;
                }
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

}
