package main.java.Server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;
import main.java.Main;
import main.java.entity.*;


public class ConSocket{
    boolean connect = true;
    Scanner input = new Scanner(System.in);
    //String IP;
    boolean lobby = false;


    public void conection() {

        try {

            // Create a socket to connect to the server
            //Socket connectToServer = new Socket("localhost", 6969);
            //Socket connectToServer = new Socket("192.168.43.26", 7000);



            if(connect = true) {
                System.out.println("Connect to IP here");
                System.out.println("If you are running server locally write: localhost");
                String IP = input.nextLine();

                if (connect = true) {
                    Socket connectToServer = new Socket(IP, 6969);


                    // Create an input stream to receive data from the server
                    ObjectInputStream isFromServer = new ObjectInputStream(connectToServer.getInputStream());

                    // Create an output stream to send data to the server
                    ObjectOutputStream usToServer = new ObjectOutputStream(connectToServer.getOutputStream());
                }

                    else{
                        System.out.println("You are not connected");
                        connect = false;
                    }

            }

            if(connect = false){
                System.exit(-1);

            }

           /* Socket connectToServer = new Socket(IP, 6969);


            // Create an input stream to receive data from the server
            ObjectInputStream isFromServer = new ObjectInputStream(connectToServer.getInputStream());

            // Create an output stream to send data to the server
            ObjectOutputStream usToServer = new ObjectOutputStream(connectToServer.getOutputStream());*/

            if (connect = true) {
                System.out.println("you are connected");
            } else {
                System.out.println("you are not connected");
            }

            while(lobby = false){
                System.out.println("Protect the Hospital from the Zombies!");

            }

        } catch (
                IOException ex) {
            System.out.println(ex.toString() + '\n');
        }
    }
        /*public void update(){
        while (connect = true){
            System.out.println(PlayerActor.netFloatX);
            }*/
}