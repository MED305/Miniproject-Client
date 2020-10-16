package main;

import graphics.GameLauncher;

public class Main {
    ClientSocket clientSocket = new Clientsocket("localhost", 6969);
    clientSocket.connect();
    
    public static void main(String[] args) {

        new GameLauncher();

    }

}
