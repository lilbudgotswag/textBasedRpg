package mainFolder;

import java.util.Random;

public class mercy {
	public static int trucedEnemies = 0;
	public static int mercy = 0;
 public static Random ran = new Random();
 public static int bonus = 0;
	
	public static void tokenChance(){
		int rtoken = 0;
		rtoken = (trucedEnemies * 5) + 15;
		int probablity = ran.nextInt(100);
		if (probablity <= rtoken){
			player.token += 1;
			System.out.println("You got a token");
		}
		System.out.println("You now have " + player.token + " tokens");
	}
	
	public static void truce(){
		
		
		int chance = ran.nextInt((enemy.run[1] - enemy.run[0]) + enemy.run[0]);
		chance = chance + bonus;
		mercy = ran.nextInt(100);
		/*int instaMercy = ran.nextInt(10);
		if (instaMercy == 5){
			
		}*/
		if (mercy <= chance){
			
			System.out.println( enemy.name + " has accepted your truce.");
			tokenChance();
			mercy = 0;
			trucedEnemies =+ 1;
			playerTravel.interact();
		}
		else {
			System.out.println("You tried to mercy with the " + enemy.name + " but it didn't work :'(");
			bonus += 5;
		}
		
		
	}
	
	
	public static void main(String[] args) {


	}

}
