package main.java.Server;

import java.io.*;
import java.net.DatagramPacket;
import java.net.Socket;

import java.util.Scanner;
import java.util.Vector;

import com.badlogic.gdx.math.Vector2;
import main.java.Main;
import main.java.entity.*;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.lwjgl.Sys;


public class ConSocket {
    boolean connect = false;
    Scanner input = new Scanner(System.in);
    //String IP;
    Socket connectToServer;
    ObjectOutputStream usToServer;
    ObjectInputStream player1;
    ObjectInputStream player2;
    FileOutputStream file;
    public Guest guest1;


    public void start() {
        System.out.println("Write 'ready' to start the game");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("ready")) {
            System.out.println("Game starting");
            //  The game starts here!
            LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

            config.title = "Game Window";
            config.resizable = true;
            config.width = 800;
            config.height = 800;

            new LwjglApplication(new Main(), config);
        }
    }


    public void connection() {

        try {
            System.out.println("Connect to IP here");
            System.out.println("If you are running server locally write: localhost");
            String IP = input.nextLine(); //vi inputter ip mm
            connectToServer = new Socket(IP, 6969); // vi connecter
            if (connectToServer.isConnected()) { //checker om den er connectet
                connect = true; //går videre til ready fasen
            }

            if (connect = true) {
                try {
                    System.out.println("You are connected");

                    usToServer = new ObjectOutputStream(connectToServer.getOutputStream());


                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Error, enter correct input");
                }
                if (connect = false) {
                    System.out.println("We didn't find your server.");
                }


            }
        } catch (
                IOException ex) {
            System.out.println(ex.toString() + '\n');
            System.out.println("you are not connected");
            System.exit(-1);
        }
    }

    public void serverSender(PlayerActor player) {

        try {
            usToServer.writeFloat(player.getxPosition());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverReceiver1() {

        if (player1 == null) {
            try {
                player1 = new ObjectInputStream(connectToServer.getInputStream());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            if (player1.available() > 0) {

                float test = player1.readFloat();
                System.out.println(test);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void serverReceiver2() {
        if (player2 == null) {
            try {
                player2 = new ObjectInputStream(connectToServer.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if (player2.available() < 0) {
                try {
                    float test = player2.readFloat();
                    System.out.println(test);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}






