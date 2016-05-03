package mainFolder;

import java.util.Random;

public class powerUps {
	public static int adAttack;
	public static int adDefense;
	public static int adMaxHP;
	public static String gem;
	public static Random ran = new Random();
	public static int buff = ran.nextInt(5 + 1);
	
public powerUps(int adAttack, int adDefense, int adMaxHp){
	this.adAttack = adAttack;
   this.adDefense = adDefense;
   this.adMaxHP = adMaxHp;
	
}
public static void createGem(){
	
	int gemType = ran.nextInt(2 + 1);
	
	if (buff <= 0){
		buff = 1;
	}
	//System.out.println(gemType + " gemType");
	//System.out.println(buff + " buff");
if(gemType == 0){
	adAttack = buff;
	gem = "attack";
}
	else if(gemType == 1){
		adDefense = buff;
		gem = "defense";
}
	else {
		adMaxHP = buff;
		gem = "max hp";
}
powerUps gem = new powerUps(adAttack, adDefense, adMaxHP);
}
public static void main(String[] args){
	createGem();
	//powerUps test = new powerUps(10, 13, 15);
	System.out.println(adAttack + " attack");
	System.out.println(adDefense + " defense");
	System.out.println(adMaxHP + " maxHP");
	
}
}
