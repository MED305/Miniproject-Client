package main.java.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;
import main.java.Main;
import main.java.entity.*;

public class ConSocket{
    boolean connect = false;
    Scanner input = new Scanner(System.in);
    String IP;
    boolean lobby = false;

    public void conection() {

        try {

            // Create a socket to connect to the server
            //Socket connectToServer = new Socket("localhost", 6969);
            //Socket connectToServer = new Socket("192.168.43.26", 7000);




            while(connect = false){
                System.out.println("Connect to IP here");
                String IP = input.nextLine();
                connect = true;

            }

            Socket connectToServer = new Socket("IP", 6969);

            // Create an input stream to receive data from the server
            DataInputStream isFromServer = new DataInputStream(connectToServer.getInputStream());

            // Create an output stream to send data to the server
            DataOutputStream usToServer = new DataOutputStream(connectToServer.getOutputStream());

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