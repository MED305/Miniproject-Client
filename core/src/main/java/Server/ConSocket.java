package main.java.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.io.IOException;
import java.util.Scanner;
import main.java.Main;
import main.java.entity.*;

public class ConSocket{
    boolean connect = true;
    //Scanner input = new Scanner(System.in);

    public void conection() {

        try {
            // Create a socket to connect to the server
            java.net.Socket connectToServer = new Socket("localhost", 6969);
            //Socket connectToServer = new Socket("192.168.43.26", 7000);


            // Create an input stream to receive data from the server
            DataInputStream isFromServer = new DataInputStream(connectToServer.getInputStream());

            // Create an output stream to send data to the server
            DataOutputStream usToServer = new DataOutputStream(connectToServer.getOutputStream());

            if (connect = true) {
                System.out.println("you are connected");
            } else {
                System.out.println("you are not connected");
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