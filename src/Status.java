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
}