package com.techelevator;

import com.techelevator.menu.MenuDisplay;
import com.techelevator.rooms.*;


public class Game {

    private static final String INTRO = "You are in the lobby of a haunted mansion!";

    private static final String OPTION_RED = "Go to red room";
    private static final String OPTION_BLUE = "Go to blue room";
    private static final String OPTION_GREEN = "Go to green room";
    private static final String OPTION_VIOLET = "Go to violet room";
    private static final String OPTION_DISPLAY_MAP = "Display the Map";
    private static final String OPTION_EXIT = "Exit";
    private static final String DISPLAY_HEALTH = "";
    private static final String DISPLAY_ITEMS = "";
    private static final int LINES_TO_CLEAR = 140;
    private static final String[] OPTIONS = {OPTION_RED, OPTION_BLUE, OPTION_GREEN, OPTION_VIOLET, OPTION_EXIT};


    private BlueRoom blueRoom = new BlueRoom();
    private RedRoom redRoom = new RedRoom();
    private GreenRoom greenRoom = new GreenRoom();
    private VioletRoom violetRoom = new VioletRoom();


    public static void main(String[] args) {


        Game game = new Game();
        game.beginGame();

    }

    public void beginGame() {

        Player player = new Player();
        Robot robot = new Robot();
        Map map = new Map();

        while(true) {
            clearScreen();
            map.drawMap();
            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if(selectedOption.equals(OPTION_RED)){
                redRoom.onEnterRoom(player);
            }else if(selectedOption.equals(OPTION_BLUE)){
                blueRoom.onEnterRoom(player);
            }else if(selectedOption.equals(OPTION_GREEN)){
                greenRoom.onEnterRoom(player, robot);
            } else if (selectedOption.equals(OPTION_VIOLET)) {
                violetRoom.onEnterRoom(player);
            } else {
                System.out.println("Goodbye!");
                break;
            }

        }

    }

    public void clearScreen(){
        for (int i = 0; i < LINES_TO_CLEAR; i++) {
            System.out.println();
        }
    }

}
