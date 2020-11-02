package main.java.Server;

import java.io.*;
import java.net.DatagramPacket;
import java.net.Socket;
import java.util.Scanner;
import main.java.Main;
import main.java.entity.*;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;




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


           /* while (intConnect == 1){ //connecter til serveren
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

                                try {
                                    Scanner scanner = null;
                                    String input = scanner.nextLine();
                                    if (input.equals("ready")) {
                                        System.out.println("Game starting");
                                      //  The game starts here! --> vent til alle klar
                                        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

                                        config.title = "Game Window";
                                        config.resizable = true;
                                        config.width = 800;
                                        config.height = 800;
                                        new LwjglApplication(new Main(), config);

                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                    System.out.println("Error, enter correct input");

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


    public void serverSender(){
try{
        usToServer.writeObject(player);
} catch (IOException e) {
    e.printStackTrace();
}
    }

    public void serverReciever(){
    }
    }
}




