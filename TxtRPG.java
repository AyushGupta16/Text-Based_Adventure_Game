import java.util.Random;
import java.util.Scanner;

public class TxtRPG
{
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
        String name = "Player";
        int health = 100;
        int score = 0;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;        //Percentage

        boolean play = true;
        while (play) 
        {
            
            boolean running = true;     //Declaring a boolean value for main loop
            
            //Introduction Line
            System.out.println("\n\t\t!!! Welcome to the Dungeon !!!\n");
            
            //Start of the Game
            System.out.println("------------------------------------------------------------\n"); //Added dashed line for better UI
            System.out.print("Enter Player's Name: \t");
            name = in.nextLine();
            
            //Main loop
            GAME:               //This is a 'GAME' label named to the while loop. So that we can iterate back when needed.
            while(running)      //This is the loop which will keep iterating to keep the game going.
            {
                System.out.println("\n------------------------------------------------------------\n"); //Added dashed line for better UI
                
                //Introducing a random enemy
                int enemyHealth = rand.nextInt(maxEnemyHealth);
                String enemy = enemies[rand.nextInt(enemies.length)];
                System.out.println("\t#\tA "+ enemy + " has appeared!      #\n");
                
                //generates random score number
                int genscore = rand.nextInt(1,enemies.length); 
                // System.out.println(genscore);
                
                //Loop till the enemy's HP is 0 
                while(enemyHealth > 0)
                {
                    //Platform Details and Choices to play game
                    System.out.println("\n\t\t"+name+"'s HP: " + health);
                    System.out.println("\t\t" + enemy + "'s HP: " + enemyHealth);
                    System.out.println("\n\tWhat would you like to do?");
                    System.out.println("\t 1. ATTACK!!!");
                    System.out.println("\t 2. Drink Health Potion");
                    System.out.println("\t 3. Evade! :| ");
                    
                    //Taking Input from User and implementing accordingly
                    String input = in.nextLine();
                    if (input.equals("1")) 
                    {
                        int damageDealt = rand.nextInt(attackDamage);       //Generating random attack damge of player
                        int damageTaken = rand.nextInt(enemyAttackDamage);      //Generating random attack damge of enemy
                        
                        //Reducing both HPs accordingly
                        enemyHealth -= damageDealt;
                        health -= damageTaken;

                        //Printing post-fight details
                        System.out.println("------------------------------------------------------------"); //Added dashed line for better UI
                        System.out.println("> You striked the "+enemy+" for "+damageDealt+" damage.");
                        System.out.println("> You received the "+damageTaken+" damage in retaliation.");
                        System.out.println("------------------------------------------------------------"); //Added dashed line for better UI
                        
                        //Breaking loop at Low Health alert
                        if (health < 1) 
                        {
                            System.out.print("\n\t\tLOW HEALTH\t\t\n");
                            System.out.println(">You have taken too much damage, you are too weak to go on!"); 
                            break;  
                        }
                    }
                    else if (input.equals("2")) 
                    {
                        //Applying available Health Boost
                        if (numHealthPotions > 0) {
                            health += healthPotionHealAmount;
                            numHealthPotions--;
                            System.out.println("------------------------------------------------------------"); //Added dashed line for better UI
                            System.out.println("\n\t> You drink a health potion , healing yourself for "+healthPotionHealAmount+" HP.");      //Printing Received HP
                            System.out.println("\t> You now have "+health+" HP.");     //Printing Total HP
                            System.out.println("\t> You have "+numHealthPotions+" health potions left.\n");       //Printing Health Potions Left
                            System.out.println("------------------------------------------------------------"); //Added dashed line for better UI
                        }
                        //Health Boost Unavailable
                        else
                        {
                            System.out.println("\n\t> You have no health potions left! \n\t>Defeat enemies for a chance to get one!!\n");       //Printing Health Potions Left
                        }
                    }
                    else if (input.equals("3")) 
                    {
                        //Printing Evade from enemy
                        System.out.println("\n\t> You evaded away from the "+enemy+" !");
                        continue GAME;          //recurses back to Main loop
                    }
                    else
                    {
                        //Default for negating Invalid Input
                        System.out.println("\n\t    #       Invalid Command     #");
                    }
            }
            
            if(health< 1)
            {
                System.out.println("\n\t You limp out of the dungeon, weak from battle.");
                break;
            } 
            
            // System.out.println("------------------------------------------------------------\n"); //Added dashed line for better UI
            
            //Printing Player's Stats
            System.out.println("\n\t#   "+enemy+" was DEFEATED !!\t#");
            System.out.println("\n\t#   You have "+health+" HP left !\t#");
            score += genscore;      //Incrensing Score
            System.out.println("\n\t#   Your Score is : "+score+"\t#\n");
            
            //Health Potion Drop
            if (rand.nextInt(100) < healthPotionDropChance) {
                numHealthPotions++;
                System.out.println("\t# The "+enemy+" dropped a health potion! #");
                System.out.println("\t# you now have "+numHealthPotions+" health potion(s)");
            }
            
            //Continuing the Game
            System.out.println("\n\t#   Your Score is : "+score+"\t#\n");
            System.out.println("------------------------------------------------------------\n"); //Added dashed line for better UI
            System.out.println("\n\tWhat would you like to do now?");
            System.out.println("\t 1. Continue Fighting!");
            System.out.println("\t 2. Exit the Dungeon");
            
            //Taking User's Choice in Input for continution 
            String input = in.nextLine();
            while (!input.equals("1") && !input.equals("2"))        //Loop for negating Invalid Input
            {
                System.out.println("\n\t# Invalid Command #");
                input = in.nextLine();
            }
            
            //Implementing according to User's Input
            if (input.equals("1")) {
                System.out.println("> You continue on your adventure.");
            }
            else if (input.equals("2")) {
                System.out.println("> You exit the Dungeon, successfully from your adventures!!\n");
                System.out.println("\n\t#   Your HighScore is : "+score+"\t#\n");
                break;
            }
            }
        
            //Closure Line
            System.out.println("\t\t########################");
            System.out.println("\t\t# THANKS FOR PLAYING ! #");
            System.out.println("\t\t########################");
            
            System.out.println("------------------------------------------------------------\n"); //Added dashed line for better UI
            
            //Adding Loop for 'Try Again'
            System.out.println("\tWould you like to try again?\n");
            System.out.println("\t\tTRY AGAIN [Y/N]\t\t\n");
            // "y" will set 'play' to 'true', anything else will set it to 'false'
            play = in.nextLine().trim().equalsIgnoreCase("y");      
        }
        
        if (play == false ) 
        {
            System.out.println("\t\t#####################");
            System.out.println("\t\t# COME BACK AGAIN ! #");
            System.out.println("\t\t#####################");
            
        }
        System.out.println("Press any key to continue..................................................................................");
        in.nextLine();
        in.close();
    }    
}
