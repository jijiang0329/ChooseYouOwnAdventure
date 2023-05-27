package com.techelevator.rooms;


import com.techelevator.Game;
import com.techelevator.Robot;
import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;

import javax.print.StreamPrintServiceFactory;
import java.sql.SQLOutput;
import java.util.Scanner;

import static com.techelevator.constants.GameConstants.*;


public class GreenRoom {


    private static final String INTRO = "Welcome to the green room! There is a robot powered by " +
            "ChatGPT guarding a door. It appears the robot wants to fight you. What do you do?";

    public static final String FIGHT_MENU_INTRO = RED + "The robot is preparing an attack! What do " +
            "you want to do?" + RESET;
    private static final String OPTION_FIGHT = GREEN + "Fight the robot" + RESET;
    private static final String OPTION_LEAVE = GREEN + "Leave room" + RESET;
    private static final String ENGAGE_ROBOT = RED + "You engage the robot in combat!" + RESET;
    public static final String OPTION_CONSUME_BAR = "2. Replenish health by eating an energy bar";
    public static final String OPTION_ATTACK = "1. Attack the Robot";
    public static final String NO_BAR =  "You don't have a bar to consume!!!";
    public static final int ATTACK = 1;
    public static final int CONSUME_BAR = 2;
    public static final String ROBOT_WON = RED + "Unfortunately, ChatGPT destroyed you. GAME OVER!" + RESET;
    public static final String BEAT_ROBOT = RED + "You destroyed the robot! Take that AI!" + RESET;
    private static final String[] OPTIONS = {OPTION_FIGHT, OPTION_LEAVE};
    private static final int LINES_TO_CLEAR = 65;


    public void onEnterRoom(Player player, Robot robot) {

        while(true) {


            System.out.println(INTRO);


            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if (selectedOption.equals(OPTION_FIGHT)){
                onFightRobot(player, robot);
            } else if (selectedOption.equals(OPTION_LEAVE)){
                System.out.println("You exit the room");
                break;
            }

            if (player.getHealth() <= 0) {
                System.out.println(ROBOT_WON);
                System.exit(0);
            }

            if (robot.getHealth() <= 0) {
                System.out.println(BEAT_ROBOT);
                System.exit(0);
            }

        }

    }

    private void onFightRobot(Player player, Robot robot) {

        clearScreen();

        System.out.println(ENGAGE_ROBOT);

        while (player.getHealth() > 0 && robot.getHealth() > 0) {
            int fightChoice = fightMenu();
            if (fightChoice == ATTACK) {
                attack(player, robot);
            }
            if (fightChoice == CONSUME_BAR && player.hasItem(ENERGY_BAR)) {
                consumeBar(player);
            }if (fightChoice == CONSUME_BAR && !player.hasItem(ENERGY_BAR)) {
                System.out.println(NO_BAR);
            }


            System.out.printf(GREEN + "Your Health: %d " + RED + " Robot's Health: %d \n" +
                    RESET , player.getHealth(), robot.getHealth());
        }
    }
    private void consumeBar(Player player) {


        player.setHealth(player.getMAX_HEALTH());
        System.out.println("WOOHUA! Your health back to 100%: " + player.getMAX_HEALTH());

        System.out.println("You are reborn!");

    }

    private void clearScreen(){
        for (int i = 0; i < LINES_TO_CLEAR; i++) {
            System.out.println();
        }
    }

    private int fightMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(FIGHT_MENU_INTRO);
        System.out.println(OPTION_ATTACK);
        System.out.println(OPTION_CONSUME_BAR);
        System.out.println("> ");
        String strInput = scanner.nextLine();
        int fightChoice = Integer.parseInt(strInput);
        return fightChoice;
    }

    private void attack(Player player, Robot robot) {
        boolean robotWins = ((int) (Math.random() * 10)) <= 5;
        int attack = (int) (Math.random() * 60);


        if (robotWins) {
            player.setHealth(player.getHealth() - attack);
            System.out.println(RED + "Oh no! The robot is too fast. He attacks you for " + attack + " damage!" + RESET);
        } else {
            robot.setHealth(robot.getHealth() - attack);
            System.out.println(RED + "You savagely attack the robot and deal " + attack + " damage!" + RESET);
        }
        if (player.getHealth() <= 0) {
            player.setHealth(0);
        }
        if (robot.getHealth() <= 0) {
            robot.setHealth(0);
        }
    }

    }

