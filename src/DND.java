import java.util.*;
class DND
{
   public static void main(String[] args) 
   {
	Scanner scan = new Scanner( System.in );
	Random rand = new Random(5);
	int charExit = 1;
	int combatExit = 1;
	int shopExit = 1;
	int combatMenu = 1;
	int event = 0;
	String klasse,menuInput,combatMenuInput,shopInput;
	String gegnerAngriffText = "platzhalter";
	String Name = "platzhalter";
	String trenner = "------------------------------------";

	double	hp 				= 1;
	double 	hpTemp 			= 1;
	double 	stk 			= 0;
	double 	stkTemp			= 0;
	double 	intel 			= 0;
	double 	intelTemp		= 0;
	double 	as				= 1;
	double 	asTemp			= 1;
	double	shield			= 1;
	double	damagePlayer	= 0;
	double	gold			= 0;

	double	monsterHpMax	= 15;
	double	monsterHpTemp 	= 15;
	double	monsterStk 		= 5;
	double	monsterAs		= 1;
	double	monsterShield	= 0;
	double	damageMonster	= 0;
	int	gegnerAngriff	= 0;

	System.out.println("Willkommen zum Dungeon");
	
	// Spieler wahlt Klasse
	while ( charExit > 0)
		{
		System.out.println("Wählen Sie ihren Namen: ");
		Name = scan.nextLine();

		System.out.println("\n Wählen Sie ihre Klasse :" + "\n 1. Krieger" + "\n 2. Magier");
		klasse = scan.nextLine();
		
		if (klasse.equals("1")) 
			{
			hp = 20;
			hpTemp = hp;
			stk = 10;
			System.out.println("\n" + "Sie sind ein Krieger");
			charExit = 0;
			
			}

		else if (klasse.equals("2")) 
			{
			hp = 15;
			hpTemp = hp;
			intel = 15;
			System.out.println("\n" + "Sie sind ein Magier");

			charExit = 0;
			}
			
		else {
			System.out.println("\n" + "Bitte immer die Zahlen verwenden");
		     }
		}
	
	System.out.println(trenner + "\n");
	
	// Spieler ist am Leben und im Hauptmenü
	while ( hpTemp > 0	) {
	System.out.println("\n" + "Du bist im Hauptmenu");
	System.out.println(	"\n" + "1. Status" +
				"\n" + "2. Nachster Raum" +
				"\n"
			   );

	//Auswahl der Optionen
	menuInput = scan.nextLine();
	System.out.println("\n" + trenner);
	
		// Status
		if (menuInput.equals("1")) {
		System.out.println("\n");
		System.out.println("Status Spieler");
		System.out.println("Name:" + "\t" + "\t" + "\t" + "\t" + Name);
		System.out.println("Gold:" + "\t" + "\t" + "\t" + "\t" + gold + "\n");
		System.out.println("HP:" + "\t" + "\t" + "\t" + "\t" + hpTemp + "/" + hp);
		System.out.println("Starke:" + "\t" + "\t" + "\t" + "\t" + stk);
		System.out.println("Intelligenz:" + "\t" + "\t" + "\t" + intel);
		System.out.println("Angriffsgeschwindigkeit: " + "\t" + as);
		System.out.println("\n" + trenner);
		}
		
		// Nachster Raum
		else if (menuInput.equals("2")){
		
		event = (rand.nextInt(2) + 1);
			
			//Monsterraum
			if (event == 1) {
			
			//Kampf
			System.out.println("\n" + "Es erscheint ein Monster");
			stkTemp		= stk;
			intelTemp	= intel;
			asTemp		= as;

				while (combatExit > 0 && !(monsterHpTemp < 0) && !(hpTemp < 0)) {
					
					//Bestimmung des Skills vom Monster
					gegnerAngriff = (rand.nextInt(2) + 1);
					
					if 	(gegnerAngriff == 1)
					{
						gegnerAngriffText = "ANGRIFF !";
					}

					else if (gegnerAngriff == 2)
					{
						gegnerAngriffText = "BLOCK !";
					}

					// Status vom Kampf
					System.out.println(trenner);
					System.out.println("Status Spieler");
					System.out.println("Name:" + "\t" + "\t" + "\t" + "\t" + Name + "\n");
					System.out.println("HP:" + "\t" + "\t" + "\t" + "\t" + hpTemp + "/" + hp);
					System.out.println("Shield:" + "\t" + "\t" + "\t" + "\t" + shield);
					System.out.println("Starke:" + "\t" + "\t" + "\t" + "\t" + stkTemp);
					System.out.println("Intelligenz:" + "\t" + "\t" + "\t" + intelTemp);
					System.out.println("Angriffsgeschwindigkeit: " + "\t" + asTemp);
					
					System.out.println("\n" + "Status Gegner");
					System.out.println("HP:" + "\t" + "\t" + "\t" + "\t" + monsterHpTemp);
					System.out.println("Shield:" + "\t" + "\t" + "\t" + "\t" + monsterShield);
					System.out.println("Starke:" + "\t" + "\t" + "\t" + "\t" + monsterStk);
					System.out.println("Angriffsgeschwindigkeit: " + "\t" + monsterAs);
					System.out.println("\n" + "Der Gegner plant den Skill " + gegnerAngriffText + " zu benutzen");
					System.out.println(trenner);

					// Menu im Kampf
					while (combatMenu > 0 ) 
					{

						System.out.println("\n" + "1. Schwacher Angriff" + "\n" + "2. Block" + "\n" + "3. Karpador uses Splash");

						combatMenuInput = scan.nextLine();
						System.out.println("\n"+ "\n" + "\n" + "\n"+ "\n" + "\n" + "\n" + "\n");
						if (combatMenuInput.equals("1"))
							{
							damagePlayer = (((stk + intel) * 0.5) * as);
							System.out.println("\n" + "Du hast mit einem schwachem Angriff angegriffen" + "\n");

								if (damagePlayer > monsterShield)
								{
								monsterHpTemp = monsterHpTemp + monsterShield - damagePlayer;
								System.out.println("Du machst dem Monster " + (monsterShield - damagePlayer) + " Schaden");
								}
							combatMenu = 0;
							}

						else if (combatMenuInput.equals("2"))
							{
							shield = hp * 0.5;
							System.out.println("\n" + "Du Blocks " + shield + " Schaden");
							combatMenu = 0;
							}
							
						else if (combatMenuInput.equals("3"))
							{
							System.out.println("\n" + "Nichts geschieht");
							combatMenu = 0;
							}
					}

					// Reset vom Monster Schild 
					monsterShield = 0;
					System.out.println("Der Gegner bewegt sich!");

					// Gegner Angriffsphase
						if 	(gegnerAngriff == 1)
							{
							damageMonster = (monsterStk * 0.5) * as;
							System.out.println("Das Monster greift mit " + damageMonster + " Schaden an");
							
								if (damageMonster > shield) 
								{
								hpTemp = hpTemp + shield - damageMonster;
								}
							}

						else if (gegnerAngriff == 2)
							{
							monsterShield = monsterHpMax * 0.5;
							System.out.println("Das Monster Blockt beim nächsten Angriff " + monsterShield + " Schaden");
							} 
						else {
							System.out.println("\n" + "Fehler bei Gegner Angriffsphase");
						}
					
					// Reset für nachste Runde
					combatMenu = 1;
					shield = 0;
				}
			
			// Ende des Kampes

			//Monster Reset
			monsterHpTemp 	= 15;
			monsterStk 		= 5;
			monsterAs		= 1;
			monsterShield	= 0;
			damageMonster	= 0;
			gegnerAngriff	= 0;
			
			//Belohnung
			gold = gold + 10;
			}
			
			//Shop
			else if (event == 2) {
				System.out.println("\n" + "Willkommen zum Shop" + "\n");
				System.out.println(trenner);
				while(shopExit > 0) {
					System.out.println("Du hast " + gold + " Gold");
					System.out.println("\n" + "1. Staerke Trank (5 G)" + "\n" + "2. Intelligenz Trank (5 G)" + "\n" + "3. Lebens Trank (5 G)" + "\n" + "4. Exit");
					shopInput = scan.nextLine();
					System.out.println(trenner);
					
					if (shopInput.equals("1")) {
						if (gold >= 5) {
						gold = gold - 5;
						stk = stk + 1;
						System.out.println("Du fuhlst dich Starker");
						}
						else {
						System.out.println("Du hast nicht genug Gold" + "\n");
						}
					}
				
					else if (shopInput.equals("2")) {
						if (gold >= 5) {
						gold = gold - 5;
						intel = intel + 1;
						System.out.println("Du fuhlst dich Kluger");
						}
						else {
						System.out.println("Du hast nicht genug Gold");
						}
					}
				
					else if (shopInput.equals("3")) {
						if (gold >= 5 && !(hp == hpTemp)) {
						gold = gold - 5;
						
								if ( (hpTemp + 10) > hp) {
								hpTemp = hp;
								System.out.println("Du hast deine Maximale Lebenspunktanzahl erreicht");
								}
								else {
								hpTemp = hpTemp + 10;
								System.out.println("Du wurdest um 10 Lebenspunkte geheilt");
								}
								
							
						}	
						
						else {
						System.out.println("Du hast nicht genug Gold oder deine Maximalen Lebenspunkte bereits erreicht");
						}
					}
					else if (shopInput.equals("4")) {
					shopExit = 0;
					}
				
				}
				shopExit = 1;
			}
		
		}
	}
	
	System.out.println("\n" + "Du bist gestorben" +  "\n" + "Viel Gluck beim nachsten mal");
	

   }
}