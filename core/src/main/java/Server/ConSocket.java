package main.java.Server;

import java.io.*;
import java.net.DatagramPacket;
import java.net.Socket;

import java.util.Scanner;
import java.util.Vector;
import java.lang.Integer;

import com.badlogic.gdx.math.Vector2;
import main.java.Main;
import main.java.entity.*;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.lwjgl.Sys;


public class ConSocket {
    boolean connect = false;
    Scanner input = new Scanner(System.in);
    int port = 6969;
    Socket connectToServer;
    ObjectOutputStream usToServer;
    ObjectInputStream inputStream;



    public Vector2 g1Pos;
    public Vector2 g2Pos;
    public Vector2 g3Pos;
    public int playerinfo;



    public void start() {
        System.out.println("Write 'start' to start the game");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals("start")) {
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

        g1Pos = new Vector2();

        try {
            System.out.println("Connect to IP here");
            System.out.println("If you are running server locally write: localhost");
            String IP = input.nextLine(); //vi inputter ip mm
            connectToServer = new Socket(IP, port); // vi connecter
            if (connectToServer.isConnected()) { //checker om den er connectet
                connect = true; //går videre til ready fasen
            }
            System.out.println("If all players are connected then write 'ready' to launch game");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("ready")) {
                if (connect = true) {
                    try {
                        System.out.println("You are connected");

                        usToServer = new ObjectOutputStream(connectToServer.getOutputStream());
                        inputStream = new ObjectInputStream(connectToServer.getInputStream());

                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Error, enter correct input");


                    }

                    if (connect = false) {
                        System.out.println("We didn't find your server.");
                    }

                }
            }
            } catch(
                    IOException ex){
                System.out.println(ex.toString() + '\n');
                System.out.println("you are not connected");
                System.exit(-1);
            }

    }
    public void serverSender(PlayerActor player) {

        try {
            usToServer.writeFloat(player.getxPosition());
            usToServer.writeFloat(player.getyPosition());
            //usToServer.writeFloat(bullet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverReceiver() {

        try {
            if (inputStream.available() > 0) {
                String[] info = inputStream.readUTF().split("-");
                playerinfo = Integer.parseInt(info[0]);
                switch (playerinfo){
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

