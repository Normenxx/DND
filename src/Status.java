class Status
{
	String trenner = "------------------------------------";
	
	public void menu(Player player)
	{
		System.out.println("Status Spieler");
		System.out.println("Name:" + "\t"  + "\t" + "\t" + "\t" + "\t" + player.name);
		System.out.println("Gold:" + "\t"  + "\t" + "\t" + "\t" + "\t" + player.gold + "\n");
		System.out.println("HP:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + player.curHp + "/" + player.maxHp);
		System.out.println("Starke:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + player.str);
		System.out.println("Angriffsgeschwindigkeit: " + "\t" + player.as);
		System.out.println("\n" + trenner);
	}

	public void kampf(Player player, Monster monster)
	{
		System.out.println("Status Spieler");
		System.out.println("Name:"  + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + player.name);
		System.out.println("HP:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + player.curHp + "/" + player.maxHp);
		System.out.println("Mana:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + player.mana);
		System.out.println("Schild:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + player.shield);
		System.out.println("Starke:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + player.curStr);
		System.out.println("Angriffsgeschwindigkeit: " + "\t" + player.curAs);

		System.out.println("\n"+ "Status Monster");
		System.out.println("Name:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + monster.name);
		System.out.println("HP:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + monster.curHp + "/" + monster.maxHp);
		System.out.println("Schild:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + monster.shield);
		System.out.println("Starke:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + monster.curStr);
		System.out.println("Angriffsgeschwindigkeit: " + "\t" + monster.curAs);

		System.out.println("\n" + trenner);

	}

	public void monsterSkill(int skill)
	{
		if (skill == 1){
			System.out.print("einen Angriff");
		}
		else if (skill == 2){
			System.out.print("seine Verteidigung fur nachste Runde vorzubereiten");
		}
		else if (skill == 3){
			System.out.print("sich zu Starken");
		}
		else if (skill == 4){
			System.out.print("sich zu heilen");
		}
	}

	public void hilfe()
	{
		System.out.println("Der Spieler muss sich durch verschiedene Level Kaempfen. Wenn er in den nächsten Raum geht, besteht die Moeglichkeit einen Monsterraum zu betreten.");
		System.out.println("Beim betreten eines Monsterraums erscheint ein zufaelliges Monster und ein Kampf beginnt.");
		System.out.println("\n" + "Das Kampfsystem ist Rundenbasiert und hat mehrere Phasen!");
		System.out.println("Phase 0: Status vom Monster und Spieler wird ausgegeben. Außerdem zeigt das Monster an, welche Faehigkeit es in der Phase 2 einsetzen möchten. ");
		System.out.println("Phase 1: Der Spieler sucht eine Faehigkeit aus und verwendet diese Faehigkeit.");
		System.out.println("Phase 2: Das Monster fuehrt eine Faehigkeit aus. (Hinweis: Falls das Monster blockt giltet dieser Schild erst für die naechste Runde)");

		System.out.println("\n" + "Das Schild (Blockt Skill) vom Spieler wird erst auf 0 verfallen wenn er wieder am Zug ist (Phase 1). ");
		System.out.println("Das gleiche gilt auch fuer das Monster, somit wird sein Schild in der Phase 2 ablaufen.");

		System.out.println("\n" + "Es ist auch moeglich einen Shop zu finden. In diesem sind Tranke die den Schaden des Spielers erhoehen oder das Leben des Spielers wiederherstellen herstellen zu finden");
	}
}