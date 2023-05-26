package com.techelevator.menu;

import java.util.Scanner;

public class MenuDisplay {

    private static Scanner input = new Scanner(System.in);

    public static String prompt(String[] options) {

        //default value, no option selected yet
        int selectedOption = -1;
        String checkStatusOption = "";

        //keep prompting the user until we call break
        while(true) {

            //don't worry about try-catch for now, we will cover these later in module-1
            try {

                //display the options to the user (see method below)
                printOptions(options);

                //get the input and convert it to an integer
                selectedOption = Integer.parseInt(input.nextLine());

                //subtract 1 to get the right index
                selectedOption--;

                //verify the selected option is valid, if so break out of the loop
                if(selectedOption >= 0 && selectedOption < options.length) {
                    break;
                }
                if(checkStatusOption == "H" && checkStatusOption == "I") {
                    break;
                }

            } catch(Exception ex){
                //nothing for now
            }
            try {
                printOptions(options);

                //verify the selected option is valid, if so break out of the loop

            } catch(Exception ex){
                //nothing for now
            }

            System.out.println("Invalid option >:0 ");
        }

        return options[selectedOption];
    }

    private static void printOptions(String[] options) {

        System.out.println("Please select an option:");
        for(int i = 0;  i < options.length; i++){

            int optionNum = i + 1;
            System.out.println( "(" + optionNum + ") " + options[i] );

        }

    }

}
