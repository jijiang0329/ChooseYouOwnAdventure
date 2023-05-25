package com.techelevator.rooms;

import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;
import com.techelevator.constants.GameConstants;

public class RedRoom {

    private static final String INTRO = "You are now in the red room. There is another door but it is locked.";

    private static final String OPTION_OPEN = "Try to open door.";
    private static final String OPTION_YELL = "Yell that you hate the color red";
    private static final String OPTION_LOBBY = "Go back to the lobby";
    private static final String[] OPTIONS = {OPTION_OPEN, OPTION_YELL, OPTION_LOBBY};

    private PurpleRoom purpleRoom = new PurpleRoom();

    public void onEnterRoom(Player player) {

        while(true) {

            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if(selectedOption.equals(OPTION_OPEN)){
                onOpenDoor(player);
            }else if(selectedOption.equals(OPTION_YELL)){
                onYell(player);
            }else if(selectedOption.equals(OPTION_LOBBY)){
                System.out.println("You leave the room");
                break;
            }


        }

    }

    private void onOpenDoor(Player player) {
        if(player.hasItem(GameConstants.RED_KEY)){
            System.out.println("The door opens, and you enter the purple room");
            purpleRoom.onEnterRoom(player);
        } else {
            System.out.println("Hmm, looks like the door requires a key");
        }
    }

    private void onYell(Player player){
        System.out.println("You yell that you hate the color red. You hear a voice from far away tell you to get over it.");
    }
}
