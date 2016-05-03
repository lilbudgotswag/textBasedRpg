package mainFolder;

import java.util.Random;

public class enemy {
public static boolean burn = false;
public static boolean paralysis = false;
public static int hp;
public static int[] attackR = new int[2];
public static int[] defenseR = new int[2];
public static int[] xp = new int[2];
public static int[] run = new int[2];
public static Random ran = new Random();
public static String name;


public enemy(String name, int attack1, int attack2, int defense1, int defense2, int xpMin, int xpMax, int hp,
		int minRun, int maxRun){
	attackR[0] = attack1;
 attackR[1] = attack2;
 defenseR[0] = defense1;
 defenseR[1] = defense2;
 xp[0] = xpMin;
 xp[1] = xpMax;
 this.hp = hp;
 this.name = name;
 run[0] = minRun;
 run[1] = maxRun;
 
}


public static void createEnemy(){
	int randomEnemy = ran.nextInt(20 + 0);
	//System.out.println(randomEnemy);
	//if ()
	//name, attackmin, attackmax, defensemin, attackmax, xpmin, xpmax, hp, minrun, maxrun
	if (randomEnemy < 5){
	enemy HeavyHitter = new enemy("Heavy Hitter", 7, 8, 1, 5, 15, 25, 20, 25, 30);
	}
	else if (randomEnemy == 1){
		enemy tankBuster = new enemy("Tank Buster", 7, 12, 3, 7, 17, 23, 15, 10, 15);
	}
	else if (randomEnemy <= 7 && randomEnemy >= 5){
		enemy Patrick = new enemy("Patrick", 5, 8, 4, 6, 20, 25, 10, 5, 10);
		}
		else if (randomEnemy >= 9 && randomEnemy <= 8){
			enemy agnarock = new enemy("Agnarock", 6, 8, 8, 12, 25, 30, 15, 15, 20);
			}
	else{
	enemy Grunt = new enemy("Grunt", 3, 6, 4, 6, 10, 20, 20, 30, 35);
	}
	
	//System.out.println(hp);
}

public static void createBoss(){
	//name, attackmin, attackmax, defensemin, attackmax, xpmin, xpmax, hp, mercymin, mercymax
	int randomBoss = ran.nextInt(5);
	if (randomBoss >= 0){
		enemy boss1 = new enemy("Rock Golem", 8, 15, 8, 15, 25, 35, 17, 1, 10);
	}
	else{
		enemy boss2 = new enemy("Ska Robot", 8, 15, 6, 12, 25, 35, 17, 1, 10);
	}
}
public static int xpGained(){
	int xpDropped = ran.nextInt((xp[1] - xp[0]) + xp[0]);
	return xpDropped;
}

public static void attack(){
	
	attackR[1] = 10;
	attackR[0] = 5;
			
	int attackPower;
	 int attack;
	 int playerDefend;
    attackPower = ran.nextInt(attackR[1] - attackR[0]) + attackR[0];
    
    //System.out.println(attackPower + " attack power");
    
    playerDefend = ran.nextInt((player.defenseR[1] - player.defenseR[0]) + player.defenseR[0]);
    
    //System.out.println(playerDefend + " enemy defend");
    if (playerDefend >= attackPower || attackPower - playerDefend == 1){
    	attack = 2;
    }
    else {
    	
        attack = attackPower - playerDefend;
}
    player.hp[0] -= attack;
    System.out.println("You now have " + player.hp[0] + " hp");
    //System.out.println(attack);
    
    
    
}

public static void enemyTurn(){
	/*int choice = ran.nextInt(10);
	System.out.println(choice);*/
	
	attack();
	battle.isBurned();
	battle.battleEnd();
	player.playerTurn();
}
public static void main(String[] args){
	//System.out.print
	//player.createPlayer();
	//attack();
	createEnemy();
}
}
