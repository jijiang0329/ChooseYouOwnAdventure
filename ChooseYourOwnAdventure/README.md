# Choose Your Own Adventure

Now that you know variables, if-statements, loops, and how to create your own classes, you can bring these skills together in creative ways. We will start with a base project to demonstrate how to create a choose your own adventure game. 

There are a handful of classes to familiarize yourself with beforehand:

   * `Game.java`
   * `Player.java`
   * `MenuDisplay.java`
   * `GameConstants.java`
   * `BlueRoom.java`, `GreenRoom.java`, etc.

## But First Play The Game

* Right click on Game.java and run
* In the console, enter the number corresponding to the choice you want to make
* Go to the red room, try to open the locked door. It says you need a key.
* Go back to the lobby
* Go to the blue room and open the box. You find a key.
* Now return to the red room, and unlock the door. You will now enter the purple room and can get a health boost. 
* Go back to the red room, then back to the lobby.
* Enter the green room.
* Fight the robot several times. Sometimes you win. Other times your health is reduced. 


## Game.java

Look at the `Game.java` file. At the top of the file there are some descriptive constants that introduce the room and then define what optons are available. The options are then put into an array. Look through the file and see how the constants are being used. We pass the array of options to the `MenuDisplay` class, which will prompt the user with the options and return their selection. We then use conditional statements to determine what action to take based on their choice. 

At the top of `Game.java` just under the constants, notice we declared some private variables that represent what rooms we can travel to. We call these rooms based on what option the user selects. 

Finally notice that we declare a new Player object. We will pass this player to each room. We can keep track of changes that happen to the player in any of the rooms because objects are passed by reference, so each room will reference this same player.


## Player.java

In `Player.java` notice we have declared two constants to define the lower and upper bounds of a player's health: `MAX_HEALTH` and `MIN_HEALTH`.

We have also created two properties: `health` and `items`

Note how in `setHealth` we confine the range the value to never go above `MAX_HEALTH` and never fall below `MIN_HEALTH`

```java
    public void setHealth(int health) {
        if(health > MAX_HEALTH) {
            this.health = MAX_HEALTH;
        } else if (health < MIN_HEALTH){
            this.health = MIN_HEALTH;
        } else {
            this.health = health;
        }
    }
```
Also notice how we can add an item to our list of items, and also check for what items we already have.

## MenuDisplay.java

Under the `menu` package, open up the `MenuDisplay.java` class.  Note how to `prompt` method receives a generic String[] and displays them with numbers to the user. The number will correspond to the index (after we subtract 1). Whatever option the user selects is the option that gets returned.

## GameConstants.java

This is a file that we can reference from any other class. It contains shared constants so that we can confidently use the same values across files.  For instance, in the `BlueRoom.java` notice how there is code to add the red key to the player's items: 

```java
    private void onOpenBox(Player player) {
        System.out.println("Congratulations! You found a red key!");
        player.addItem(GameConstants.RED_KEY);
    }
```
And we can check for that same value later when we are in the red room:

```java
    private void onOpenDoor(Player player) {
        if(player.hasItem(GameConstants.RED_KEY)){
            System.out.println("The door opens, and you enter the purple room");
            purpleRoom.onEnterRoom(player);
        } else {
            System.out.println("Hmm, looks like the door requires a key");
        }
    }
```

## The Rooms

Notice how in each room we declare constants similar to what we saw in `Game.java` which we use to introduce the room and then present the user with options. 

Each room has different examples. 

`BlueRoom.java` will add a key to the player's list of items.

`RedRoom.java` will check the player's items to see if they have a key to open a door.

`PurpleRoom.java` will increase the player's health if they eat cake

`GreenRoom.java` can increase or decrease a player's health depending on if the player or the robot wins the fight. There are a few things to call out here. First, we are using the `Math.random` method to add some randomness to the game. The documentation for `Math.random` reads as follows:
    
    Returns a double value with a positive sign, greater than or equal to 0.0 and less than 1

We can multiply this random number by 10 to get a number between 1-10. Then we say if the number is less than or equal to 5, the robot wins. 
```java
boolean robotWins = ((int)(Math.random() * 10)) <= 5;
```

If the robot wins, we also randomly decide how much damage is done to our health.

```java
if(robotWins) {
    int healthDeduction = (int) (Math.random() * 20);
    player.setHealth(player.getHealth() - healthDeduction);
    System.out.println("Oh no! The robot is too fast. Your health is down to " + player.getHealth());
}
```

A code smell you may notice across each of these rooms is that we are creating a similar method `onEnterRoom` in each one. Keep this in mind as we get into inheritance and polymorphism in the coming week.

## Objectives

Try some of these game enhancements:

* Add two new rooms and collect a coin from each one. Use the coins to buy something from your friends in the purple room.

* In the same way that we have a `Player.java` add a `Robot.java` and keep track of the robot's health as well - until ultimately only one of you is a victor!

* Change the `MenuDisplay.java` to accept the `Player` and anytime a user types `H`it will display the player's current health. You could also type `I` and have it display the player's items. 

* Ultimately, follow your own creativity here. If you want to modify this project so that instead of rooms you are Dr. Strange visiting different universes ... go for it. Or you could modify this to be similar to Oregon Trail - instead of rooms you would reach rivers or hunting grounds. Make this something fun for you.
