// package src;

import java.util.Random;
import java.util.Scanner;

public class Main1{
    public static void main(String[] args) 
    {
        //System objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        //Game variables
        String[] enemies = {"Skeleton", "Zombie", "Lich", "Vampire", "Lamia"};
        int maxEnemyHealth =  75;
        int enemyAttackDamage = 25;

        //Player variables
        int health = 100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;        //Percentage

        boolean running = true;     //Declaring a boolean value for main loop
        
        //Introduction Line
        System.out.println("\n\t\t!!! Welcome to the Dungeon !!!\n");

        //Start of the Game

        GAME:               //This is a 'GAME' label named to the while loop. So that we can iterate back when needed.
        while(running)      //This is the loop which will keep iterating to keep the game going.
        {
            System.out.println("------------------------------------------------------------\n"); //Added dashed line for better UI

            //Introducing a random enemy
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t#\tA "+ enemy + " has appeared!      #\n");

            //Loop till the enemy's HP is 0 
            while(enemyHealth > 0)
            {
                //Platform Details and Choices to play game
                System.out.println("\t\tPlayer HP: " + health);
                System.out.println("\t\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t 1. Attack!!!");
                System.out.println("\t 2. Drink Health Potion");
                System.out.println("\t 3. Run! :( ");

                //Taking Input from User and implementing accordingly
                String input = in.nextLine();
                if (input.equals("1")) 
                {
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("> You striked the "+enemy+" for "+damageDealt+" damage.");
                    System.out.println("> You received the "+damageTaken+" damage in retaliation.\n");

                    if (health < 1) 
                    {
                     System.out.println("\t>You have taken too much damage, you are too weak to go on!"); 
                     break;  
                    }
                }
                else if (input.equals("2")) 
                {
                    if (numHealthPotions > 0) {
                        health += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drink a health potion , healing yourself for "+healthPotionHealAmount+" HP.");      //Printing Received HP
                        System.out.println("n\t> You now have "+health+" HP.");     //Printing Total HP
                        System.out.println("\n\t> You have "+numHealthPotions+" health potions left.\n");       //Printing Health Potions Left
                    }
                    else
                    {
                        System.out.println("\n\t> You have no health potions left! \n\t>Defeat enemies for a chance to get one!!\n");       //Printing Health Potions Left
                    }
                }
                else if (input.equals("3")) 
                {
                    System.out.println("\n\t> You run away from the "+enemy+" !");
                    continue GAME;
                }
                else
                {
                    System.out.println("\n\t    #       Invalid Command     #");
                }
            }
            
            if(health< 1)
            {
                System.out.println("\t You limp out of the dungeon, weak from battle.");
                break;
            } 

            System.out.println("------------------------------------------------------------\n"); //Added dashed line for better UI
            
            System.out.println("\t# "+enemy+" was DEFEATED !! \t#");
            System.out.println("\n\t# You have "+health+" HP left ! #");
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println("\t# The "+enemy+" dropped a health potion! #");
                System.out.println("\t# you now have "+numHealthPotions+" health potion(s)");
            }

            //Continuing the Game
            System.out.println("------------------------------------------------------------\n"); //Added dashed line for better UI
            System.out.println("\n\tWhat would you like to do now?");
            System.out.println("\t 1. Continue Fighting!");
            System.out.println("\t 2. Exit the Dungeon");
            
            //Taking User's Choice in Input for continution 
            String input = in.nextLine();
            while (!input.equals("1") && !input.equals("2")) //loop for negating Invalid Input
            {
                System.out.println("\n\t# Invalid Command #");
                input = in.nextLine();
            }

            if (input.equals("1")) {
                System.out.println("> You continue on your adventure.");
            }
            else if (input.equals("2")) {
                System.out.println("> You exit the Dungeon, successfully from your adventures!!\n");
                break;
            }
        }

        //Closure Line
        System.out.println("\t########################");
        System.out.println("\t# THANKS FOR PLAYING ! #");
        System.out.println("\t########################");
        
        //Adding Loop for 'Try Again'

        in.close();

    }    
}