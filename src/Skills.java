class Skills
{
	private String trenner = "------------------------------------";
	private int exit = 1;
	
	private int curHpAngreifer;
	private int maxHpAngreifer;
	private int shieldAngreifer;
	private int curStrAngreifer;
	private int curAsAngreifer;
	private String textAngreifer;
	
	private int curHpVerteidiger;
	private int maxHpVerteidiger;
	private int shieldVerteidiger;
	private int curStrVerteidiger;
	private int curAsVerteidiger;
	private String textVerteidiger;

	private int damage;
	private int heal;


	public void kampfobj (boolean Wer, String skillNr, Player player, Monster monster)
	{
		//Übersetzen in verallgemeinerte Form um das Schreiben von Skills zu ermöglichen
		if ( Wer == true) 	//Spieler greift an
		{
			curHpAngreifer = player.curHp;
			maxHpAngreifer = player.maxHp;
			shieldAngreifer = player.shield;
			curStrAngreifer = player.curStr;
			curAsAngreifer = player.curAs;
			textAngreifer = "Der Spieler";

			curHpVerteidiger = monster.curHp;
			maxHpVerteidiger = monster.maxHp;
			shieldVerteidiger = monster.shield;
			curStrVerteidiger = monster.curStr;
			curAsVerteidiger = monster.curAs;
			textVerteidiger = "Das Monster";
		}
		else if ( Wer == false) //Monster greift an
		{
			curHpAngreifer = monster.curHp;
			maxHpAngreifer = monster.maxHp;
			shieldAngreifer = monster.shield;
			curStrAngreifer = monster.curStr;
			curAsAngreifer = monster.curAs;
			textAngreifer = "Das Monster";

			curHpVerteidiger = player.curHp;
			maxHpVerteidiger =  player.maxHp;
			shieldVerteidiger =  player.shield;
			curStrVerteidiger =  player.curStr;
			curAsVerteidiger =  player.curAs;
			textVerteidiger = "Der Spieler";
		}

		//Benutzen von Skills

		//Leichter Angriff
		if (skillNr.equals("1")) {
			damage = curStrAngreifer * curAsAngreifer;

			if (damage > shieldVerteidiger )
			{
				curHpVerteidiger = curHpVerteidiger + shieldVerteidiger - damage;
				System.out.println(textAngreifer + " hat " + damage + " verursacht");
			}
			else {
				shieldVerteidiger -= damage;
				System.out.println(damage + " Schaden wurden vom Schild geblockt");
			}
		}
		//Leichter Block
		else if (skillNr.equals("2"))
		{
			shieldAngreifer = shieldAngreifer + 10;
			System.out.println(textAngreifer + " schutzt sich in der nachsten Runde vor " + shieldAngreifer + " schaden");
		}
		//Leichter Stärke Buff
		else if (skillNr.equals("3"))
		{
			curStrAngreifer = curStrAngreifer + 3;
			System.out.println(textAngreifer + " hat seine Starke um 1 erhoht");
		}
		//Leichter Heal
		else if (skillNr.equals("4"))
		{
			heal = 10;
			if ((curHpAngreifer + heal) > maxHpAngreifer)
			{
				curHpAngreifer = maxHpAngreifer;
				System.out.println(textAngreifer + " hat die Maximale HP erreicht");
			}
			else {
				curHpAngreifer = curHpAngreifer + heal;
				System.out.println(textAngreifer + " hat sich um " + heal+ " geheilt");
			}
		}
		//Der Spieler hat eine falsche Eingabe gemacht
		else {
			System.out.println("Du hast " + skillNr + " eingeben");
			System.out.println("Es wurde kein Skill in dieser Runde benutzt, aufgrund der flaschen Eingabe");
		}

		//Übersetzen in verallgemeinerte Form um das Schreiben von Skills zu ermöglichen
		if ( Wer == true) 	//Spieler greift an
		{
			player.curHp = curHpAngreifer;
			player.maxHp = maxHpAngreifer;
			player.shield = shieldAngreifer;
			player.curStr = curStrAngreifer;
			player.curAs = curAsAngreifer;

			monster.curHp = curHpVerteidiger;
			monster.maxHp = maxHpVerteidiger;
			monster.shield = shieldVerteidiger;
			monster.curStr = curStrVerteidiger;
			monster.curAs = curAsVerteidiger;
		}

		else if ( Wer == false) //Monster greift an
		{
			monster.curHp = curHpAngreifer;
			monster.maxHp = maxHpAngreifer;
			monster.shield = shieldAngreifer;
			monster.curStr = curStrAngreifer;
			monster.curAs = curAsAngreifer;

			player.curHp = curHpVerteidiger;
			player.maxHp = maxHpVerteidiger;
			player.shield = shieldVerteidiger;
			player.curStr = curStrVerteidiger;
			player.curAs = curAsVerteidiger;
		}

	}
}