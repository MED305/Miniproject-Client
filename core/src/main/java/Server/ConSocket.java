package main.java.Server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import main.java.Main;
import main.java.entity.*;


public class ConSocket{
    boolean connect = false;
    int testvariable = 10;
    Scanner input = new Scanner(System.in);
    //String IP;
    boolean lobby = false;
    int intConnect = 1; // denne int leder til forskellige seneraier 1 er join, 2 er ready fasen, 3 er hvis den failer at connecte og 4 starter spillet.


    public void conection() {

        try {


            while (intConnect == 1){ //connecter til serveren
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
                DataInputStream isFromServer = new DataInputStream(connectToServer.getInputStream());
                // Create an output stream to send data to the server
                DataOutputStream usToServer = new DataOutputStream(connectToServer.getOutputStream());

                if(intConnect == 2){
                    System.out.println("i am nr. 2");

                    System.out.println("det er dumt");

                }

                if (intConnect == 3){
                    System.out.println("we didn't find your server.");
                    intConnect = 1;
                }
                }




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

        } catch (
                IOException ex) {
            System.out.println(ex.toString() + '\n');
            System.out.println("you are not connected");
            System.exit(-1);
        }
    }
        /*public void update(){
        while (connect = true){
            System.out.println(PlayerActor.netFloatX);
            }*/
}




/* ------------
boolean connect;

            if (intConnect == 1, connect = false){
                    System.out.println("Connect to IP here");
                    System.out.println("If you are running server locally write: localhost");
                    String IP = input.nextLine();
                        Socket connectToServer = new Socket(IP, 6969); --> needs to turn connect true or false
                        if (connectToServer.isConnected())
                        Sytem.out.println("i am connected");
                        // Create an input stream to receive data from the server
                        ObjectInputStream isFromServer = new ObjectInputStream(connectToServer.getInputStream());
                        // Create an output stream to send data to the server
                        ObjectOutputStream usToServer = new ObjectOutputStream(connectToServer.getOutputStream());
                        System.out.println("You are not connected");

                        if (connect = true){
                        intconnect == 2
                        }
                        else{
                        intconnect == 3
                        }

                    }

            if (intConnect ==2) {
                System.out.println("You are connected to a lobby, type ready to begin.");


            }

            if (intConnect == 3) {
            System.out.println("failed to find server");
            intconnect = 1;
            }
 */



