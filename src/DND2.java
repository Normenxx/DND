import java.util.*;
class DND2
{
   public static void main(String[] args) 
   {

	//Variablen
	int charExit = 1;
	int combatExit = 1;
	int shopExit = 1;
	int event;
	int runde = 1;
	int monsterArt;
	int alterSkill =  100; //Speichert den zuletzt verwendeten Angriff um Regeln zu benutzen
	Integer monsterSkill;
	int score = 0; //Zahlt die besiegten Monster

	//Menu Objekte
	String hauptMenu,eingabeKampf, shopInput; // Hauptgrund wieso String verwendet wird ist um das Beenden des Programmes ungewollt durch eine falsche Eingabe zu Beenden (Fehlermeldung) zu verhindern.
	String trenner = "------------------------------------";
	
	//Objekte
	Scanner scan = new Scanner(System.in);
	Player player = new Player();
	Status status = new Status();
	Skills skills = new Skills();
	Random rand = new Random();
	
	
	System.out.println("Willkommen zum Dungeon");
	// Spieler wahlt eine Klasse
	while ( charExit > 0)
	{
		System.out.println("Wahlen Sie ihren Namen: ");
		player.name = scan.nextLine();

		System.out.println("\n Wahlen Sie ihre Klasse :" + "\n 1. Krieger " + "2. Ritter");
		player.klasse = scan.nextLine();
		
		if (player.klasse.equals("1")) {
			player.maxHp = 20;
			player.curHp = player.maxHp;
			player.str = 8;
			player.as = 1;
			player.mana = 100;
			charExit = 0;
		}
		else if (player.klasse.equals("2"))
		{
			player.maxHp = 25;
			player.curHp = player.maxHp;
			player.str = 4;
			player.as = 1;
			player.mana = 100;
			charExit = 0;
		}
	}
	
	// Spieler ist am Leben und im Hauptmenu
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
		    status.menu(player);
		    player.bild();
		}
		
		// Nachster Raum
		else if (hauptMenu.equals("2"))
		{
			//Ein zufalliges Event wird generiert
		    event = rand.nextInt(2)+1;

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
					while	//Regeln fuer das Monster zum Auswaehlen von Skills
					(		(monsterSkill == 2 && alterSkill == 2) ||  				 			// Das Monster darf nicht 2 mal hintereinander Blocken
							(monsterSkill == 3 && (!(alterSkill == 2) || runde==0))			   // Das Monster darf sich nicht Buffen ohne Verteidigung
					);

					alterSkill = monsterSkill;

					//Status Kampf
					status.kampf(player, monster);
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
					skills.kampfobj(true , eingabeKampf, player, monster);
					monster.shield = 0;

					//Monster greift an
					System.out.println("\n" + "Das Monster verwendet einen Skill");
					skills.kampfobj(false , monsterSkill.toString(), player, monster);
					System.out.println("\n" + trenner + "\n");

					player.shield = 0;
				}

                //Reset vom KampfcombatExit
				combatExit = 1;
				runde = 1;
				player.gold += monster.gold;
				score = score +1;
			}

			//Shop
			else if (event == 2) {
				System.out.println("\n" + "Willkommen zum Shop" + "\n");
				System.out.println(trenner);
				while(shopExit > 0) {
					System.out.println("Du hast " + player.gold + " Gold");
					System.out.println("\n" + "1. Staerke Trank (5 G)" + "\n" + "2. Lebens Trank (5 G)" + "\n" + "3. Exit");
					shopInput = scan.nextLine();
					System.out.println(trenner);

					if (shopInput.equals("1")) {
						if (player.gold >= 5) {
							player.gold = player.gold - 5;
							player.str = player.str + 1;
							System.out.println("Du fuhlst dich Starker");
						}
						else {
							System.out.println("Du hast nicht genug Gold" + "\n");
						}
					}

					else if (shopInput.equals("2")) {
						if (player.gold >= 5 && !(player.maxHp == player.curHp)) {
							player.gold = player.gold - 5;

							if ( (player.curHp + 10) > player.maxHp) {
								player.curHp = player.maxHp;
								System.out.println("Du hast deine Maximale Lebenspunktanzahl erreicht");
							}
							else {
								player.curHp = player.curHp + 10;
								System.out.println("Du wurdest um 10 Lebenspunkte geheilt");
							}

						}
						else {
							System.out.println("Du hast nicht genug Gold oder deine Maximalen Lebenspunkte bereits erreicht");
						}
					}
					else if (shopInput.equals("3")) {
						shopExit = 0;
					}

				}
				shopExit = 1;
			}
		}

		else if (hauptMenu.equals("3"))
		{
			status.hilfe();
		}
	}

	System.out.println("\n" + "Du bist gestorben" +  "\n" + "Du hast " + score + " Monster getoetet." +"\n" +"Viel Gluck beim nachsten mal");
   }
}