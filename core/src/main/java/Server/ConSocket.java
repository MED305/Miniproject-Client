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
    ObjectOutputStream usToServer;
    ObjectInputStream isFromServer;
    PlayerActor player;

    public void connection() {

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


    public void serverUpdate(){
try{
        usToServer.writeFloat((float) 1.3);
        //usToServer.writeFloat(player.PAFloatY);
} catch (IOException e) {
    e.printStackTrace();
}
    }
}




