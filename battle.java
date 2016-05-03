package mainFolder;

import java.util.Random;

public class battle {
	public static Random ran = new Random();
	public static int noAttackChance = ran.nextInt(100);
	
	
	
	public static void battleEnd(){
		int xpGained;
		if (enemy.hp <= 0){
			player.battack = 0;
			player.bdefense = 0;
			enemy.burn = false;
			enemy.paralysis = false;
			xpGained = enemy.xpGained();
			System.out.println("Good job you have killed the enemy");
			player.xp[0] += xpGained;
			System.out.println("You gained " + xpGained + " xp and now have " + player.xp[0] + " xp");
			player.levelUP();
			System.out.println("You have " + player.hp[0] + " health left");
			playerTravel.interact();
			
		}
		else if (player.hp[0] <= 0){
			System.out.println("Game Over. You died at level " + player.level);
			System.exit(0);
		}
			
	}
	
	public static void isBurned(){
		if (enemy.burn == true){
			enemy.hp -= 2; 
			System.out.println(enemy.name  + " got hurt by the burn and now has " + enemy.hp + " left");
			
		}
		
	}
	
	
	public static void battleTime(){
		//boolean foughtBoss1 = false;
		if (playerTravel.totalMove <= 25 && playerTravel.totalMove >= 20 ||
				playerTravel.totalMove == 39){
			enemy.createBoss();
		}
		else {
		enemy.createEnemy();
		}
		System.out.println("A " + enemy.name + " appeared, what will you do?");
		player.playerTurn();
		//enemy.enemyTurn();
		
		
		
	}
	
	
}
