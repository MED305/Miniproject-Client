import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ConSocket{
    boolean connect = true;
    Scanner input = new Scanner(System.in);

    public void conection() {

        try {
            // Create a socket to connect to the server
            java.net.Socket connectToServer = new java.net.Socket("localhost", 6969);
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

            while (connect) {
                //Todo: Here the send functions will be called, but are created in the Main

                // Enter annual interest rate
                // System.out.print("Enter number to be calculated by server: ");
                //double number = input.nextDouble();

                // Sends the number stored to the server
                //usToServer.writeDouble(number);

                // The number gets calculated in the server, and returns a number which then gets displayed
                //double totalNumber = isFromServer.readDouble();

                //System.out.println("Calculated number: " + totalNumber);
            }

        } catch (
                IOException ex) {
            System.out.println(ex.toString() + '\n');

        }
    }
        }