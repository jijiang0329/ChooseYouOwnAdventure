package com.techelevator.rooms;


import com.techelevator.Robot;
import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;


public class GreenRoom {


    private static final String INTRO = "Welcome to the green room! There is a robot powered by ChatGPT guarding a door." +
            "It appears the robot wants to fight you. What do you do?";


    private static final String OPTION_FIGHT = "Fight the robot";
    private static final String OPTION_LEAVE = "Leave room";
    private static final String[] OPTIONS = {OPTION_FIGHT, OPTION_LEAVE};


    public void onEnterRoom(Player player, Robot robot) {


        while(true) {


            System.out.println(INTRO);


            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if (selectedOption.equals(OPTION_FIGHT)){
                onFightRobot(player, robot);
            }else if(selectedOption.equals(OPTION_LEAVE)){
                System.out.println("You exit the room");
                break;
            }
            if (player.getHealth() <= 0) {
                System.out.println("Unfortunately, ChatGPT destroyed you. GAME OVER!");
                System.exit(0);
            }
            if (robot.getHealth() <= 0) {
                System.out.println("You destroyed the robot! Take that AI!");
                System.exit(0);
            }

        }

    }


    private void onFightRobot(Player player, Robot robot) {


        while (player.getHealth() > 0 && robot.getHealth() > 0) {
            boolean robotWins = ((int) (Math.random() * 10)) <= 5;
            int attack = (int) (Math.random() * 60);


            if (robotWins) {
                player.setHealth(player.getHealth() - attack);
                System.out.println("Oh no! The robot is too fast. He attacks you for " + attack + " damage!");
            } else {
                robot.setHealth(robot.getHealth() - attack);
                System.out.println("You savegely attack the robot and deal " + attack + " damage!");
            }
            if (player.getHealth() <= 0) {
                player.setHealth(0);


            }
            if (robot.getHealth() <= 0) {
                robot.setHealth(0);


            }
            System.out.printf("Your Health: %d  Robot's Health: %d \n" , player.getHealth(), robot.getHealth());
        }
    }
    private void consumeBar(Player player) {


        player.setHealth(player.getMAX_HEALTH());
        System.out.println("WOOHUA! Your health back to 100%: " + player.getMAX_HEALTH());

        System.out.println("You are reborn!");

    }
}
