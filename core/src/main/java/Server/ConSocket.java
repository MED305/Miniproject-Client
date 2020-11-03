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


public class ConSocket{
    boolean connect = false;
    Scanner input = new Scanner(System.in);
    //String IP;
    ObjectOutputStream usToServer;
    ObjectInputStream isFromServer;
    PlayerActor player;



    public void connection() {

        try {


                System.out.println("Connect to IP here");
                System.out.println("If you are running server locally write: localhost");
                String IP = input.nextLine(); //vi inputter ip mm
                Socket connectToServer = new Socket(IP, 6869); // vi connecter
                if (connectToServer.isConnected()){ //checker om den er connectet
                    connect = true; //går videre til ready fasen
                }

                // Create an input stream to receive data from the server


                usToServer = new ObjectOutputStream(connectToServer.getOutputStream());

                isFromServer = new ObjectInputStream(connectToServer.getInputStream());
                // Create an output stream to send data to the server



                if(connect = true){
                    try {
                        System.out.println("You are connected");
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

                                /*while (connect == true) {
                                    serverSender();
                                    serverReceiver();
                                }*/

                            }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Error, enter correct input");

                    }

                }


                if (connect = false){
                    System.out.println("We didn't find your server.");
                }


                }
          //  Socket connectToServer = new Socket("localhost", 6969);
           // usToServer = new ObjectOutputStream(connectToServer.getOutputStream());





          /*

          if(connect = false){
                System.exit(-1);

            }*/

           /* Socket connectToServer = new Socket(IP, 6969);



            // Create an input stream to receive data from the server
            ObjectInputStream isFromServer = new ObjectInputStream(connectToServer.getInputStream());

            // Create an output stream to send data to the server
            ObjectOutputStream usToServer = new ObjectOutputStream(connectToServer.getOutputStream());*/

            /*if (connect = true) {
                System.out.println("you are connected");
            } else {
                System.out.println("you are not connected");
            }*/


         catch (
                IOException ex) {
            System.out.println(ex.toString() + '\n');
            System.out.println("you are not connected");
            System.exit(-1);
        }



    }

    public void serverSender(){
        try{

            usToServer = new ObjectOutputStream(new FileOutputStream("test.txt"));
            usToServer.writeObject(player);
            usToServer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serverReceiver() throws IOException {
        try {
            isFromServer = new ObjectInputStream(new FileInputStream("test.txt"));
            PlayerActor pl = (PlayerActor)isFromServer.readObject();
            System.out.println(pl);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}






