package main.java;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Lobby {


    private List<SubLobby> subLobbies = new ArrayList<SubLobby>();

    private String playerID;
    private String[] OtherPlayers = {};
    private boolean isHost;
    private String currentLobby;
    private LobbySender sender;

    Scanner scanner = new Scanner(System.in);


    Lobby() throws IOException {
        System.out.println("Protect the Hospital from the Zombies!");



        System.out.println("Write your name");
        String id = scanner.nextLine();
        this.playerID = id;
        sender = new LobbySender(id);
        sender.setPlayerID(id);
        sender.sendPlayerID();
        options();
    }

    public String PlayerID(){
        return playerID;
    }

    void createLobby(String code) throws IOException {
        SubLobby subLobby = new SubLobby(code, this.playerID);
        this.subLobbies.add(subLobby);
        sender.sendSubLobby(subLobby);
    }


    void updateLobbies(List<SubLobby> s) throws IOException{
        System.out.println("1");
        System.out.println(s.size());
        for (SubLobby subLobby : s) {
            System.out.println("2");

            if (subLobbies.size() == 0) {
                subLobbies.add(subLobby);
                System.out.println("New lobby: " + subLobby.getLobbyName());
                break;
            }

            for (int j = 0; j < subLobbies.size(); j++) {
                System.out.println("3");
                if (subLobby.getLobbyName().equals(subLobbies.get(j).getLobbyName())) {
                    System.out.println("4");
                    break;
                } else if (j == subLobbies.size() - 1) {
                    subLobbies.add(subLobby);
                    System.out.println("New lobby: " + subLobby.getLobbyName());
                }
            }

        }
    }
    void joinLobby(String lobbyName) throws IOException {
        updateLobbies(sender.requestLobbyList());

        for (SubLobby subLobby : subLobbies) {
            if (subLobby.getLobbyName().equals(lobbyName)) {
                subLobby.addToPlayers(this.playerID);
            }
        }
    }

    void checkDuplicate() {
    }


    void startGame(String lobby) {
        String[] arguments = new String[]{playerID};
    }

    void removeFromLobby(String lobbyName) {
        this.isHost = false;
        this.currentLobby = null;

        for (int i = 0; i < subLobbies.size(); i++) {
            if (subLobbies.get(i).getLobbyName().equals(lobbyName)) {
                subLobbies.get(i).getPlayers().remove(playerID);
                if(subLobbies.get(i).getPlayers().size() == 0) {
                    subLobbies.remove(i);
                }
            }
        }


        options();
    }

    void playerOptions(String lobbyName) {
        System.out.println("Write \"list\" to see player list.");
        System.out.println("Write \"exit\" to leave lobby");
        try {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                removeFromLobby(lobbyName);
            } else if (input.equals("list")) {

                for (SubLobby subLobby : subLobbies) {
                    if (subLobby.getLobbyName().equals(lobbyName)) {
                        subLobby.printPlayers();
                    }
                }
                playerOptions(lobbyName);
            } else {
                System.out.println("Error, enter correct input");
                playerOptions(lobbyName);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error, enter correct input");
            hostOptions(lobbyName);
        }

    }


    void hostOptions(String lobbyName) {
        System.out.println("Write \"start\" and the game will start, or write \"list\" to see the player list.");
        System.out.println("Write \"exit\" to leave the lobby");

        try {
            String input = scanner.nextLine();
            if (input.equals("start")) {
                System.out.println("Game starting");
                startGame(lobbyName); //Start ny instance af et game!
            } else if (input.equals("list")) {

                for (SubLobby subLobby : subLobbies) {
                    if (subLobby.getLobbyName().equals(lobbyName)) {
                        subLobby.printPlayers();
                    }
                }


                hostOptions(lobbyName);
            } else if (input.equals("exit")) {
                removeFromLobby(lobbyName);
            } else {
                System.out.println("Error, enter correct input");
                hostOptions(lobbyName);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error, enter correct input");
            hostOptions(lobbyName);
        }

    }

    void options() {
        System.out.println("Write \"create\" to create a new game, or write \"join\" to see the list of available games to join");
        String option = scanner.nextLine();
        try {
            if (option.equals("create")) {
                System.out.println("Creating the Lobby. Give the Lobby a name");
                String lobbyName = scanner.nextLine();
                createLobby(lobbyName);
                this.currentLobby = lobbyName;
                isHost = true;
            } else if (option.equals("join")) {
                updateLobbies(sender.requestLobbyList());

                if (subLobbies.size() == 0) {
                    System.out.println("No available games :(");
                    options();
                }

                System.out.println("Join a Lobby. List of available games");
                for (int i = 0; i < subLobbies.size(); i++) {
                    System.out.println(subLobbies.get(i).getLobbyName() + " (" + subLobbies.get(i).getPlayers().size() + "/5)");
                }
                String lobbyName = scanner.nextLine();
                this.currentLobby = lobbyName;
                isHost = false;

                joinLobby(lobbyName);
            } else {
                System.out.println("Enter a valid option please");
                options();
            }
        } catch (
                Exception e) {
            System.out.println(e);
            System.out.println("Enter a valid option please");
            options();
        }

        if (this.isHost) {
            hostOptions(this.currentLobby);
        } else {
            playerOptions(this.currentLobby);
        }
    }


    public static void main(String[] args) throws IOException {
        Lobby l = new Lobby();
    }

    class SubLobby {
        public SubLobby(String code, String playerID) {
        }

        public String getLobbyName() {
            return null;
        }

        public void addToPlayers(String playerID) {
        }

        public List getPlayers() {
            return null;
        }

        public void printPlayers() {
        }
    }
}






