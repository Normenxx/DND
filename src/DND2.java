import java.awt.Point;
import java.util.*;
class DND2
{
   public static void main(String[] args) 
   {
	
	//Variablen
	int charExit = 1;
	int combatExit = 1;
	int event = 1;
	int runde = 1;
	int monsterArt;
	int alterSkill =  100;
	Integer monsterSkill;

	
	//Men� Objekte
	String hauptMenu,combatMenu,eingabeKampf;
	String trenner = "------------------------------------";
	
	//Objekte
	Scanner scan = new Scanner(System.in);
	Player player = new Player();
	Status status = new Status();
	Skills skills = new Skills();
	Random rand = new Random();
	
	
	System.out.println("Willkommen zum Dungeon");
	// Spieler wahlt Klasse
	while ( charExit > 0)
		{
		System.out.println("W�hlen Sie ihren Namen: ");
		player.name = scan.nextLine();

		System.out.println("\n W�hlen Sie ihre Klasse :" + "\n 1. Krieger " + "2. Work in progress");
		player.klasse = scan.nextLine();
		
		if (player.klasse.equals("1")) 
			{
			player.maxHp = 20;
			player.curHp = player.maxHp;
			player.str = 5;
			player.as = 1;
			charExit = 0;
			}
		}
	
	// Spieler ist am Leben und im Hauptmen�
	while ( player.curHp > 0) {
		System.out.println("\n" + "Du bist im Hauptmenu");
		
		//Auswahl der Optionen
		System.out.println("\n" + "1. Status");
		System.out.println("2. Nachster Raum" + "\n");
		
		hauptMenu = scan.nextLine();
		System.out.println("\n" + trenner);
		
		// Status
		if (hauptMenu.equals("1"))
		{
		    status.menu(player.name, player.gold, player.curHp, player.maxHp, player.str, player.as);
		    player.bild();
		}
		
		// Nachster Raum
		else if (hauptMenu.equals("2"))
		{
			//Monsterraum
			if (event == 1)
			{
			    System.out.println("\n" + "Es erscheint ein Monster!" + "\n" );

				//Spieler
				player.curStr = player.str;
				player.curAs = player.as;
				
				//Erstellung des Monster
				monsterArt = rand.nextInt(2)+1;
                Monster monster = new Monster(monsterArt);
				
				// Kampf
				while (combatExit > 0 && !(monster.curHp <= 0) && !(player.curHp <= 0))
				{
					//Monster wahlt Skill aus
					do
					{
							monsterSkill = rand.nextInt(3) + 1;
							// 1 Angriff
							// 2 Block
							// 3 Buff
					}
					while
					(		monsterSkill == 2 && alterSkill == 2 ||  				 			// Das Monster darf nicht 2 mal hintereinander Blocken
							monsterSkill == 3 && !(alterSkill == 2)							// Das Monster darf sich nicht Buffen ohne Verteidigung
					);

					alterSkill = monsterSkill;

					//Status Kampf
					status.kampf(player.name,player.curHp, player.maxHp, player.shield, player.curStr, player.curAs,monster.name,monster.curHp, monster.maxHp, monster.shield, monster.curStr, monster.curAs);
					//------------------------------
					System.out.println("Runde: " + runde++);
					System.out.print("Das Monster plant ");
					status.monsterSkill(monsterSkill);

					//Spieler such Angriff aus
					System.out.println("\n" + "\n" + "1. Schwacher Angriff" + "\n" + "2. Block" + "\n" + "3. Starke Buff" +  "\n" + "4. leichter Heal" +"\n" + "5. Karpador uses Splash");
					eingabeKampf = scan.nextLine();

					System.out.println(trenner);
					//Spieler greift an
					System.out.println("\n" + "Der Spieler verwendet einen Skill");
					skills.kampf(true , eingabeKampf, player.curHp , player.maxHp , player.shield, player.curStr , player.curAs , monster.curHp , monster.maxHp , monster.shield, monster.str , monster.as);
					
							//Spieler Werte �nderung
							player.curHp = skills.PlayerCurHp();
							player.maxHp = skills.PlayerMaxHp();
							player.shield = skills.PlayerShield();
							player.curStr = skills.PlayerCurStr();
							player.curAs = skills.PlayerCurAs();
							
							//Monster Werte �nderung
							monster.curHp = skills.MonsterCurHp();
							monster.maxHp = skills.MonsterMaxHp();
							monster.shield = skills.MonsterShield();
							monster.curStr = skills.MonsterCurStr();
							monster.curAs = skills.MonsterCurAs();

					monster.shield = 0;

					//Monster greift an
					System.out.println("\n" + "Das Monster verwendet einen Skill");
					skills.kampf(false , monsterSkill.toString(),player.curHp , player.maxHp , player.shield, player.curStr , player.curAs , monster.curHp , monster.maxHp , monster.shield, monster.str , monster.as);
					
							//Spieler Werte �nderung
							player.curHp = skills.PlayerCurHp();
							player.maxHp = skills.PlayerMaxHp();
							player.shield = skills.PlayerShield();
							player.curStr = skills.PlayerCurStr();
							player.curAs = skills.PlayerCurAs();
							
							//Monster Werte �nderung
							monster.curHp = skills.MonsterCurHp();
							monster.maxHp = skills.MonsterMaxHp();
                           monster.shield = skills.MonsterShield();
							monster.curStr = skills.MonsterCurStr();
							monster.curAs = skills.MonsterCurAs();

					System.out.println("\n" + trenner + "\n");

					player.shield = 0;
				}

                //Reset vom Kampf
                combatExit = 1;
				runde = 1;
			}
		}
		
	}

	System.out.println("\n" + "Du bist gestorben" +  "\n" + "Viel Gluck beim nachsten mal");
   }
}