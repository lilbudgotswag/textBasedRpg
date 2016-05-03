package mainFolder;

import java.util.Scanner;

public class buildings {
	
	

public static void shop(){
	Scanner input = new Scanner(System.in);
	powerUps.createGem();
	System.out.println("Welcome to the shop! You have " + player.token + " tokens to spend.\n\n");
	System.out.println("Type rattack to raise all attack stats by 3");
	System.out.println("Type rdefense to raise all defense stats by 3");
	System.out.println("Type rcritical to raise critical hit chances by 5");
	if (player.hasParalysis == false){
		System.out.println("Type buypar to buy the paralysis special attack");
	}
	if (player.hasBurn == false){
	System.out.println("Type buyburn to buy the burn special attack");
	}
	System.out.println("Type leave to leave shop");
	/*if (input.hasNext("leave")){
		System.out.println("You have left the shop\n");
	}*/
	
	if (player.token >= 1){
	 if (input.hasNext("rattack")){
		player.attackR[0] += 3;
		player.attackR[1] += 3;
		System.out.println("You raised your attack. Your minimum attack is now " + player.attackR[0]);
		System.out.println("You raised your attack. Your maximum attack is now " + player.attackR[1]);
		player.token -= 1;
		shop();
	}
	else if (input.hasNext("rdefense")){
		player.defenseR[0] += 3;
		player.defenseR[1] += 3;
		System.out.println("You raised your defense. Your minimum defense is now " + player.defenseR[0]);
		System.out.println("You raised your defense. Your maximum defense is now " + player.defenseR[1]);
		player.token -= 1;
		shop();
	}
	else if (input.hasNext("rcritical")){
		player.criticalChance += 5;
		System.out.println("You raised your critical hit chance. Your critical hit chance is now " + player.criticalChance);
		player.token -= 1;
		shop();
	}
	else if (input.hasNext("buyburn")){
		player.hasBurn = true; 
		System.out.println("You have bought the burn special attack");
		player.token -= 1;
		shop();
	}
	else if (input.hasNext("buypar")){
		player.hasParalysis = true;
		System.out.println("You have bought the paralysis special attack");
		player.token -= 1;
		shop();
	}
	else {
		System.out.println("Command typed wrong. Try again");
		shop();
	}
	/*else if (input.hasNext("leave")){
			System.out.println("You have left the shop\n");
		}*/
	
	}
	else if (input.hasNext("leave")){
		System.out.println("You have left the shop\n");
	}
	
	
	
	else {
		System.out.println("Command typed wrong. Try again");
		shop();
	}
	 
	
	
	/*System.out.println("Type Gem to buy a "+ powerUps.gem + " gem (+" + powerUps.buff + " " + powerUps.gem + ") You can only hae one gem!\n\n");
	if (input.hasNext("gem") || input.hasNext("Gem")){
		}*/
}
public static void main(String[] args){
	shop();
	System.out.println("test complete");
}
}
