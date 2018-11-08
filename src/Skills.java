class Skills
{
	private String trenner = "------------------------------------";
	private int exit = 1;
	
	private double curHpAngreifer;
	private double maxHpAngreifer;
	private double shieldAngreifer;
	private double curStrAngreifer;
	private double curAsAngreifer;
	private String textAngreifer;
	
	private double curHpVerteidiger;
	private double maxHpVerteidiger;
	private double shieldVerteidiger;
	private double curStrVerteidiger;
	private double curAsVerteidiger;
	private String textVerteidiger;
	
	private double tempCurHpPlayer;
	private double tempMaxHpPlayer;
	private double tempShieldPlayer;
	private double tempCurStrPlayer;
	private double tempCurAsPlayer;
	
	private double tempCurHpMonster;
	private double tempMaxHpMonster;
	private double tempShieldMonster;
	private double tempCurStrMonster;
	private double tempCurAsMonster;
	
	private double damage;
	private double heal;
	//Methoden zum Zurückgeben von Werten
	
		//Spieler
		public double PlayerCurHp()
		{
			return  tempCurHpPlayer;
		}
		
		public double PlayerMaxHp()
		{
			return  tempMaxHpPlayer;
		}

		public double PlayerShield()
	{
		return  tempShieldPlayer;
	}
		
		public double PlayerCurStr()
		{
			return  tempCurStrPlayer;
		}
		
		public double PlayerCurAs()
		{
			return  tempCurAsPlayer;
		}
		
		//Monster
		public double MonsterCurHp()
		{
			return  tempCurHpMonster;
		}
		
		public double MonsterMaxHp()
		{
			return  tempMaxHpMonster;
		}

		public double MonsterShield()
		{
		return  tempShieldMonster;
		}

		public double MonsterCurStr()
		{
			return  tempCurStrMonster;
		}
		
		public double MonsterCurAs()
		{
			return  tempCurAsMonster;
		}
	
	
	public void kampf(boolean Wer , String skillNr, double curHpPlayer, double maxHpPlayer, double shieldPlayer, double curStrPlayer, double curAsPlayer, double curHpMonster, double maxHpMonster, double shieldMonster, double curStrMonster, double curAsMonster)
	{
		//Übersetzen in verallgemeinerte Form um das Schreiben von Skills zu ermöglichen
		if ( Wer == true) 	//Spieler greift an
		{
			 curHpAngreifer = curHpPlayer;
			 maxHpAngreifer = maxHpPlayer;
			 shieldAngreifer = shieldPlayer;
			 curStrAngreifer = curStrPlayer;
			 curAsAngreifer = curAsPlayer;
			 textAngreifer = "Der Spieler";
			
			 curHpVerteidiger = curHpMonster;
			 maxHpVerteidiger = maxHpMonster;
			 shieldVerteidiger = shieldMonster;
			 curStrVerteidiger = curStrMonster;
			 curAsVerteidiger = curAsMonster;
			 textVerteidiger = "Das Monster";
		}
		else if ( Wer == false) //Monster greift an
		{
			 curHpAngreifer = curHpMonster;
			 maxHpAngreifer = maxHpMonster;
			 shieldAngreifer = shieldMonster;
			 curStrAngreifer = curStrMonster;
			 curAsAngreifer = curAsMonster;
			 textAngreifer = "Das Monster";
			
			 curHpVerteidiger = curHpPlayer;
			 maxHpVerteidiger = maxHpPlayer;
			 shieldVerteidiger = shieldPlayer;
			 curStrVerteidiger = curStrPlayer;
			 curAsVerteidiger = curAsPlayer;
			 textVerteidiger = "Der Spieler";
		}
		
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
			curStrAngreifer = curStrAngreifer + 1;
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

		//Rückübersetzung und Speicherung der Werte in Lokalen variablen für getMethoden
		if ( Wer == true) 	//Spieler greift an
		{
			tempCurHpPlayer = curHpAngreifer;
			tempMaxHpPlayer = maxHpAngreifer;
			tempShieldPlayer = shieldAngreifer;
			tempCurStrPlayer = curStrAngreifer;
			tempCurAsPlayer = curAsAngreifer;
	
			tempCurHpMonster = curHpVerteidiger;
			tempMaxHpMonster = maxHpVerteidiger;
			tempShieldMonster = shieldVerteidiger;
			tempCurStrMonster = curStrVerteidiger;
			tempCurAsMonster = curAsVerteidiger;
		}
		else if ( Wer == false) //Monster greift an
		{
			tempCurHpPlayer = curHpVerteidiger;
			tempMaxHpPlayer = maxHpVerteidiger;
			tempShieldPlayer = shieldVerteidiger;
			tempCurStrPlayer = curStrVerteidiger;
			tempCurAsPlayer = curAsVerteidiger;
	
			tempCurHpMonster = curHpAngreifer;
			tempMaxHpMonster = maxHpAngreifer;
			tempShieldMonster = shieldAngreifer;
			tempCurStrMonster = curStrAngreifer;
			tempCurAsMonster = curAsAngreifer;
		}
	}
	
}