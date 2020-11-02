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
<<<<<<< Updated upstream
            // Create a socket to connect to the server
            java.net.Socket connectToServer = new Socket("localhost", 6969);
            //Socket connectToServer = new Socket("192.168.43.26", 7000);
=======

            /*while (intConnect == 1){ //connecter til serveren
                System.out.println("Connect to IP here");
                System.out.println("If you are running server locally write: localhost");
                String IP = input.nextLine(); //vi inputter ip mm
                Socket connectToServer = new Socket(IP, 6969); // vi connecter
                if (connectToServer.isConnected()){ //checker om den er connectet
                    intConnect = 2; //går videre til ready fasen
                }
                else{
                    intConnect =3; //går videre til ikke connect fasen
                }

                // Create an input stream to receive data from the server

                isFromServer = new ObjectInputStream(connectToServer.getInputStream());
                // Create an output stream to send data to the server

                usToServer = new ObjectOutputStream(connectToServer.getOutputStream());

                if(intConnect == 2){
                    System.out.println("You are connected");
                    System.out.println("Write 'ready' to start the game");


                        boolean connect = true;
                        while (connect) {
                            try {
                                Scanner scan = null;
                                String message = scan.nextLine();
                                DataOutputStream output = null;
                                output.writeUTF(message);
                                // output.flush();

                                if (message.equalsIgnoreCase("ready")) {
                                    System.out.println("Game starting");
                                    connect = false;
                                }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                }

                if (intConnect == 3){
                    System.out.println("We didn't find your server.");
                    intConnect = 1;
                }
                }*/
            Socket connectToServer = new Socket("localhost", 6969);
            usToServer = new ObjectOutputStream(connectToServer.getOutputStream());


          /*

          if(connect = false){
                System.exit(-1);

            }*/

           /* Socket connectToServer = new Socket(IP, 6969);
>>>>>>> Stashed changes


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
<<<<<<< Updated upstream
        /*public void update(){
        while (connect = true){
            System.out.println(PlayerActor.netFloatX);
            }*/
}
=======


    public void serverUpdate(){
        try{

            usToServer.writeObject(player);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




>>>>>>> Stashed changes
