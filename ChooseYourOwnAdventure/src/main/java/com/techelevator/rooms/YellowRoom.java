package com.techelevator.rooms;

import com.techelevator.Player;
import com.techelevator.constants.GameConstants;
import com.techelevator.menu.MenuDisplay;

import java.util.Scanner;

public class YellowRoom {

    private static final String INTRO = "You are now in the yellow room. You see the exit door but it is locked" +
            " with an electronic lock that requires a 4 digit pin. You also see a desk with a computer and piece" +
            "of paper on it.";

    private static final String OPTION_OPEN = "Try to open door.";
    private static final String OPTION_LOBBY = "Go back to the lobby.";
    private static final String OPTION_READ_PAPER = "Read the piece of paper.";
    private static final String OPTION_ACCESS_COMPUTER = "Access the computer.";
    private static final String OPTION_ENTER_CODE = "Enter the door code.";
    private static final String[] OPTIONS = {OPTION_OPEN, OPTION_READ_PAPER, OPTION_ACCESS_COMPUTER, OPTION_ENTER_CODE, OPTION_LOBBY};

    public void onEnterRoom(Player player) {
        while (true) {
            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS, player);
            if (selectedOption.equals(OPTION_OPEN)) {
                onOpenDoor(player);
            } else if (selectedOption.equals(OPTION_READ_PAPER)) {
                onReadPaper();
            } else if (selectedOption.equals(OPTION_ACCESS_COMPUTER)) {
                onAccessComputer();
            } else if (selectedOption.equals(OPTION_ENTER_CODE)) {
                onEnterCode();
            } else if (selectedOption.equals(OPTION_LOBBY)) {
                System.out.println("You leave the room");
                break;
            }
        }
    }

    private void onOpenDoor(Player player) {
        System.out.println("After defeating the robot, you step through the doorway" +
                " and enter the yellow room.");
    }

    private void onReadPaper() {
        System.out.println("The paper says: 'door pin in personal folder'.");
    }

    private void onEnterCode() {
        System.out.println("Enter the 4 digit pin code: ");
        Scanner scanner = new Scanner(System.in);
        String pinCode = scanner.nextLine();
        if (pinCode.equals("0320")) {
            System.out.println("The door opens. Congratulations, you have escaped and won the game!");
            System.exit(0);
        } else {
            System.out.println("Poisonous gas blasts from the vents, and before you can run backwards, you suffocate and die.");
            System.exit(0);
        }
    }

    private void onAccessComputer() {
        System.out.println("You see a bash prompt. (type 'exit' to stop using the computer)");
        Scanner scanner = new Scanner(System.in);
        boolean inPersonalFolder = false;

        while (true) {
            System.out.print("$ ");
            String command = scanner.nextLine();

            if (command.equals("ls")) {
                if (inPersonalFolder) {
                    System.out.println("passwords.txt\nnotes.txt");
                } else {
                    System.out.println("documents\npersonal\nsystem\nmusic");
                }
            } else if (command.equals("cd personal") && !inPersonalFolder) {
                inPersonalFolder = true;
                System.out.println("You are now in the personal folder.");
            } else if (command.equals("cat passwords.txt") && inPersonalFolder) {
                System.out.println("FB: 1234\nIG: 5678\ndoor pin: 0320\nemail: 9101");
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Unknown command.");
            }
        }
    }
}