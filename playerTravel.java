package mainFolder;

import java.util.Random;
import java.util.Scanner;

public class playerTravel {
public static int movement = 0;
public static int chance = 0;
public static int totalMove = 0;
public static final int END = 40;
public static Random r = new Random();  
	
	public static void interact(){
		Scanner input = new Scanner(System.in);
		wonGame();
		System.out.println("Type forward to move forward by 1");
		System.out.println("Type heal to heal " + player.heal + " health points (You don't move though!)");
		/*System.out.println("Type right to move to the right");
		System.out.println("Type left to move to the left");*/
		if (input.hasNext("forward")){
			movement = movement + 1;
			totalMove = totalMove + 1;
			//System.out.println("You have moved a total of " + totalMove + " times");
			System.out.println("You need " + (END - totalMove) + " more moves to win");
			randomEncounter();
		}
		else if (input.hasNext("heal")){
			player.hp[0] += player.heal; //+ player.level;
			if (player.hp[0] > player.hp[1]){
				player.hp[0] = player.hp[1];
			}
			System.out.println("You now have " + player.hp[0] + " health");
			movement = movement + 1;
			randomEncounter();
		}
		else {
			System.out.println("Command typed wrong. Try again");
			interact();
		}
	}
	public static void randomEncounter(){
		//wonGame();
		if (totalMove == END - 1){
			battle.battleTime();
		}
		else {
		chance = movement + 6;
		int y = r.nextInt(chance); 
		//System.out.println(y);
		if (y <= 5){
			System.out.println("Continue");
		interact();
		}
		else if(y == 6){
			System.out.println("You stumbled upon a shop");
			buildings.shop();
			randomEncounter();
		}
		else {
		        System.out.println("Battle");
		        movement = 0;
		        
				battle.battleTime();
		}
		}
	}
	public static void wonGame(){
		if (totalMove >= END){
			if (mercy.trucedEnemies >= 5){
				System.out.println("You won the game and truced " + mercy.trucedEnemies + " enemies.");
				System.out.println("GOOD JOB YOU SEXY SON OF A TINY FEMALE DOG");
			}
			else{
			System.out.println("GOOD JOB YOU WON THE GAME\n\n\n");
			
			}
			System.out.println("Game created by Evan Samuel Mickelson\n\n BBBBBBYYYYYEEEEEE");
			System.exit(0);
		}
		
	}
	
}
