package com.techelevator.rooms;

import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;

public class GreenRoom {

    private static final String INTRO = "Welcome to the green room! There is a robot powered by ChatGPT and it wants to fight you. What do you do?";

    private static final String OPTION_FIGHT = "Fight the robot";
    private static final String OPTION_LEAVE = "Leave room";
    private static final String[] OPTIONS = {OPTION_FIGHT, OPTION_LEAVE};

    public void onEnterRoom(Player player) {

        while(true) {

            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if(selectedOption.equals(OPTION_FIGHT)){
                onFightRobot(player);
            }else if(selectedOption.equals(OPTION_LEAVE)){
                System.out.println("You exit the room");
                break;
            }


        }

    }

    private void onFightRobot(Player player) {

        boolean robotWins = ((int)(Math.random() * 10)) <= 5;
        boolean almostDie = player.getHealth() <= 10;

        if(robotWins) {
            if (almostDie) consumeBar(player);
            int healthDeduction = (int) (Math.random() * 20);
            player.setHealth(player.getHealth() - healthDeduction);
            System.out.println("Oh no! The robot is too fast. Your health is down to " + player.getHealth());
        } else {
            System.out.println("You damaged the robot!");
        }
    }

    private void consumeBar(Player player) {


        player.setHealth(player.getMAX_HEALTH());
        System.out.println("WOOHUA! Your health back to 100%: " + player.getMAX_HEALTH());

        System.out.println("You are reborn!");

    }
}
