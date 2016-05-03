package mainFolder;



import java.util.Random;
import java.util.Scanner;

public class player {
public static int[] hp = new int[2];
//hp[1] is max hp while hp[0] is current hp
public static boolean burn = false; 
public static boolean hasBurn = false;
public static boolean hasParalysis = false; 
public static int[] attackR = new int[2];
public static int battack = 0; // b stands for bonus
public static boolean raiseAttack = false; 
public static int[] defenseR = new int[2];
public static int bdefense = 0;
public static boolean raiseDefense = false;
public static Random ran = new Random();
public static int level = 1;
public static int xp[] = new int[2];
public static int heal = 4;
public static int criticalChance;
public static int pickedClass;
public static int token = 0;
//public static int mercyC;

public player(int pickClass, int attackMin, int attackMax, int defenseMin, 
		int defenseMax, int maxHP, int curhp, int chc, int xp1){
	pickedClass = pickClass; // 1 is tank 2 is knight 3 is wizard
	attackR[0] = attackMin;
	attackR[1] = attackMax;
	defenseR[0] = defenseMin;
	defenseR[1] = defenseMax;
	hp[0] = curhp;
	hp[1] = maxHP;
	xp[0] = xp1;
	criticalChance = chc;
	//mercyC = mercyChance;
 }

public static void createPlayer(){
	Scanner classpick = new Scanner(System.in);
	//pickclass, attackmin, attackmax, defensemin, defensemax, maxhp, curhp, chc, xp1
	System.out.println("HELLO AND WELCOME TO THE GAME\n\n\n");
	System.out.println("Pick a class");
	System.out.println("- Type tank to pick the tank class\n- Type knight to pick the knight class");
	System.out.println("- Type wizard to pick the wizard class\n\n");
	if (classpick.hasNext("tank")){
		player tank = new player(1, 5, 7, 8, 12, 30, 30, 5, 0);
		displayStats();
	}
	else if (classpick.hasNext("knight")){
		player knight = new player(2, 7, 10, 4, 10, 20, 20, 5, 0);
		displayStats();
	}
	
	else if (classpick.hasNext("wizard")){
		player wizard = new player(3, 5, 8, 4, 8, 25, 25, 15, 0);
		displayStats();
	}
	else {
		System.out.println("Command typed wrong. Try again");
		createPlayer();
	}
	//player test = new player(10, 10, 3, 7, 50, 1);
	
}

public static void raiseAttack(){

	battack += 3;
	System.out.println("You raised your attack by 3 ");
	System.out.println("Your minimum attack is now " + (attackR[0] + battack));
	System.out.println("Your minimum attack is now " + (attackR[1] + battack));
}

public static void raiseDefense(){
	bdefense += 3;
	System.out.println("You raised your defense by 3 ");
	System.out.println("Your minimum defense is now " + (defenseR[0] + bdefense));
	System.out.println("Your minimum defense is now " + (defenseR[1] + bdefense));
}

public static void burnAttack(){
	enemy.burn = true; 
	System.out.println("You have burned the enemy. The enemy now has " + enemy.hp);
	
}

public static void paralyzeAttack(){
	enemy.paralysis = true; 
	System.out.println("You have paralyzed the enemy. The enemy now has a chance to not attack");
	
}


public static void displayStats(){
	Scanner YN = new Scanner(System.in);
	String classp = null;
	if (pickedClass == 1){
		classp = "tank";
	}
	else if (pickedClass == 2){
		classp = "knight";
	}
	else if (pickedClass == 3){
		classp = "wizard";
	}
	
	
	System.out.println("Here are the " + classp +" stats\n");
	System.out.println(attackR[0] + " Attack Minimum");
	System.out.println(attackR[1] + " Attack Maximum");
	System.out.println(defenseR[0] + " Defense Minimum");
	System.out.println(defenseR[1] + " Defense Maximum");
	System.out.println(hp[1] + " MaxHP");
	System.out.println(criticalChance + " Critical hit chance (out of 100)");
	System.out.println("\nare you still sure you want to pick this class?\nType y for yes and n for no");
	if (YN.hasNext("Y") || YN.hasNext("y")){
		System.out.println("Class selected");
	}
	else {
		createPlayer();
	}
}




public static void attack(){
	/*attackR[1] = 10;
	attackR[0] = 5;*/
			
	int attackPower;
	 int attack;
	 int enemyDefend;
	 int criticalHit;
	 criticalHit = ran.nextInt(100 + 0);
	 
    attackPower = ran.nextInt((attackR[1] + battack) - (battack + attackR[0])) + (attackR[0] + battack);
    //attackPower += 
   // System.out.println(attackPower + " attack power");
    if (criticalHit <= criticalChance){
    	attackPower = attackPower * 2;
    	System.out.println("Critical Hit!");
    }
    enemyDefend = ran.nextInt((enemy.defenseR[1] - enemy.defenseR[0]) + enemy.defenseR[0]);
    
    //System.out.println(enemyDefend + " enemy defend");
    if (enemyDefend >= attackPower || attackPower - enemyDefend == 1){
    	attack = 2;
    }
    else {
    	
        attack = attackPower - enemyDefend;
    }
    mercy.mercy = 0;
    enemy.hp -= attack;
    System.out.println("The enemy now has " + enemy.hp);
    //enemy.hp = enemy.hp - attack;
    
    
    //System.out.println(attack + " attack");
    //enemy.hp = enemy.hp - attack;
   
}

public static void check(){
	System.out.println("Enemy's minimum defense " + enemy.defenseR[0]);
	System.out.println("Enemy's maximum defense " + enemy.defenseR[1]);
	System.out.println("Enemy's minimum attack " + enemy.attackR[0]);
	System.out.println("Enemy's maximum attack " + enemy.attackR[1]);
	System.out.println("Enemy's hp " + enemy.hp);
}

public static void playerTurn(){
	Scanner playerInput = new Scanner(System.in);
	System.out.println("Raising stats only lasts the battle not the entire game!");
	System.out.println("Type attack to attack the enemy.");
	System.out.println("Type mercy to try and truce with the enemy");
	//if (raiseAttack == true){
		System.out.println("Type rattack to raise your attack by 3 ");
		System.out.println("Type rdefense to raise your defense by 3");
		
	//}
		if (hasParalysis == true && enemy.paralysis == false){
			System.out.println("Type par to paralyze enemy");
		}
		if (hasBurn == true && enemy.burn == false){
			System.out.println("Type burn to burn enemy");
		}
	
		
	System.out.println("Type check to see enemy stats");
	if (playerInput.hasNext("attack")){
		attack();
	}
	
	//if (raiseAttack == true){
	else if (playerInput.hasNext("rattack")){
			//System.out.println("test complete");
			raiseAttack();
		}
	else if (playerInput.hasNext("rdefense")){
		raiseDefense();
	}
	
	//}
	else if (hasBurn == true && playerInput.hasNext("burn") && enemy.burn == false){
			burnAttack();
	}
	else if (hasParalysis == true && playerInput.hasNext("par") && enemy.paralysis == false){
		paralyzeAttack();
}
	else if (playerInput.hasNext("check")){
		check();
		playerTurn(); 
	}
	else if (playerInput.hasNext("mercy")){
		mercy.truce();
	}
	/*else if(playerInput.hasNext("heal")){
		hp[0] = hp[0] + heal;
		if (hp[0] > hp[1]){
			hp[0] = hp[1];
		}
		System.out.println("You healed and now have " + hp[0]);
		
	}*/
	else {
		System.out.println("Command typed wrong. Try again");
		playerTurn();
	}	
	battle.battleEnd();
	
	//this is checking if the enemy will be paralyzed
	battle.noAttackChance = ran.nextInt(100);
	if (enemy.paralysis == true && battle.noAttackChance <= 33){
	 System.out.println("The enemy is paralyzed. The enemy did not attack");
	 playerTurn();
	}
	enemy.enemyTurn();
}
public static void levelUP(){
	xp[1] = level * 10; 
	
	if (xp[0] >= xp[1]){
	xp[0] = 0;
	token = token + 1;
	level = level + 1;
	System.out.println("You've leveled up! You are now level " + level + " and have " + token + " tokens");
	}
	else {
	System.out.println("You have " + xp[0] + " xp you need " + (xp[1] - xp[0]) + " xp to level up");
		
	}
}



public static void main(String[] args){
	//raiseAttack();
/*System.out.println(attackR[0]);
	System.out.println(attackR[1]);
	enemy.createEnemy();
	System.out.println(enemy.defenseR[0]);
	System.out.println(enemy.defenseR[1]);*/
	playerTurn();
	//levelUP();
	
}
}
