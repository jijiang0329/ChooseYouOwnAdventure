package com.techelevator.rooms;

import com.techelevator.Player;
import com.techelevator.constants.GameConstants;
import com.techelevator.menu.MenuDisplay;

public class YellowRoom {

    private static final String INTRO = "You are now in the yellow room. There is another door in the room with a" +
            "strange sound coming m it.";

    private static final String OPTION_OPEN = "Try to open door.";
    private static final String OPTION_YELL = "Yell that you hate the color red";
    private static final String OPTION_LOBBY = "Go back to the lobby";
    private static final String[] OPTIONS = {OPTION_OPEN, OPTION_YELL, OPTION_LOBBY};

    private YellowRoom yellowRoom = new YellowRoom();

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

            System.out.println("The door opens, and you enter the purple room");


    }

    private void onYell(Player player){
        System.out.println("You yell that you hate the color red. You hear a voice from far away tell you to get over it.");
    }
}
