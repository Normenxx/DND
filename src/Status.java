class Status
{
	String trenner = "------------------------------------";
	
	public void menu(String name, int gold, double curHp, double maxHp, double str, double as)
	{
		System.out.println("Status Spieler");
		System.out.println("Name:" + "\t"  + "\t" + "\t" + "\t" + "\t" + name);
		System.out.println("Gold:" + "\t"  + "\t" + "\t" + "\t" + "\t" + gold + "\n");
		System.out.println("HP:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + curHp + "/" + maxHp);
		System.out.println("Starke:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + str);
		System.out.println("Angriffsgeschwindigkeit: " + "\t" + as);
		System.out.println("\n" + trenner);
	}

	public void kampf(String namePlayer, double curHpPlayer, double maxHpPlayer, double shieldPlayer, double strPlayer, double asPlayer,String nameMonster, double curHpMonster, double maxHpMonster, double shieldMonster, double strMonster, double asMonster)
	{
		System.out.println("Status Spieler");
		System.out.println("Name:"  + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + namePlayer);
		System.out.println("HP:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + curHpPlayer + "/" + maxHpPlayer);
		System.out.println("Schild:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + shieldPlayer);
		System.out.println("Starke:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + strPlayer);
		System.out.println("Angriffsgeschwindigkeit: " + "\t" + asPlayer);

		System.out.println("\n"+ "Status Monster");
		System.out.println("Name:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + nameMonster);
		System.out.println("HP:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + curHpMonster + "/" + maxHpMonster);
		System.out.println("Schild:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + shieldMonster);
		System.out.println("Starke:" + "\t" + "\t" + "\t" + "\t" + "\t" + "\t" + strMonster);
		System.out.println("Angriffsgeschwindigkeit: " + "\t" + asMonster);

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