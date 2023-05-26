package com.techelevator.rooms;

import com.techelevator.constants.GameConstants;
import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;

public class PurpleRoom {

    private static final String INTRO = "You enter a purple room. You see your friends. There is cake. You have won at life.";

    private static final String OPTION_CAKE = "Eat the cake";
    private static final String OPTION_TALK = "Talk to your friend";
    private static final String OPTION_LEAVE = "Leave room";
    private static final String[] OPTIONS = {OPTION_CAKE, OPTION_LEAVE};

    public void onEnterRoom(Player player) {

        while(true) {

            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if(selectedOption.equals(OPTION_CAKE)){
                onEatCake(player);
            } else if (selectedOption.equals(OPTION_TALK)) {
                System.out.println("Here is the KIND energy bar. Cost one coin");
                getBar(player);
            } else if(selectedOption.equals(OPTION_LEAVE)){
                System.out.println("You exit the room");
                break;
            }


        }

    }

    private void getBar(Player player) {
        if(player.hasItem(GameConstants.COIN)){
            System.out.println("Congratulations! You get a Chocolate Kind bar!");
            player.addItem(GameConstants.ENERGY_BAR);
            player.removeItem(GameConstants.COIN);
        } else {
            System.out.println("hey dude, you have no coin!");
        }
    }





    private void onEatCake(Player player) {
        System.out.println("Congratulations! You eat cake and restore your health!");
        player.setHealth( player.getHealth() + 20);
    }
}
