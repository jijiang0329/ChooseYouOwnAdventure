package com.techelevator.rooms;

import com.techelevator.Player;
import com.techelevator.constants.GameConstants;
import com.techelevator.menu.MenuDisplay;

public class YellowRoom {

    private static final String INTRO = "You are now in the yellow room. You see the exit door but it is locked" +
            " with an electronic lock that requires a 4 digit pin. You also see a desk with a computer and piece" +
            "of paper on it.";

    private static final String OPTION_OPEN = "Try to open door.";
    private static final String OPTION_LOBBY = "Go back to the lobby.";
    public static final String OPTION_READ_PAPER = "Read the piece of paper.";
    private static final String[] OPTIONS = {OPTION_OPEN, OPTION_READ_PAPER, OPTION_LOBBY};



    public void onEnterRoom(Player player) {

        while (true) {

            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS, player);
            if (selectedOption.equals(OPTION_OPEN)){
                onOpenDoor(player);
            } else if (selectedOption.equals(OPTION_READ_PAPER)){

            } else if (selectedOption.equals(OPTION_LOBBY)){
                System.out.println("You leave the room");
                break;
            }


        }

    }

    private void onOpenDoor(Player player) {

            System.out.println("After defeating the robot, you step through the doorway" +
                    " and enter the yellow room.");


    }

    private void onYell(Player player){
        System.out.println("You yell that you hate the color red. You hear a voice from far away tell you to get over it.");
    }
}
