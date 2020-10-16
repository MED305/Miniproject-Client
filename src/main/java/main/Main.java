package main;

import graphics.GameLauncher;

public class Main {
    public static void main(String[] args){
        ClientSocket clientSocket = new ClientSocket("localhost", 6969);
        clientSocket.connect();
        new GameLauncher();

    }

}
