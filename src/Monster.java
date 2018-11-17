class Monster{
	String name;

	int maxHp;
	int curHp;
	int str;
	int curStr;
	int as;
	int curAs;
	int shield;
	int mana;
	int gold;

	public Monster(int monsterArt){

		if (monsterArt == 1){
			name = "Slime";

			maxHp = 15;
			curHp = 15;
			str = 5;
			curStr = 5;
			as = 1;
			curAs = 1;
			gold = 15;
			mana = 1000;
		}
		if (monsterArt == 2)
		{
			name = "Skelett";

			maxHp = 10;
			curHp = 10;
			str = 5;
			curStr = 5;
			as = 1;
			curAs = 1;
			gold = 10;
			mana = 1000;
		}

	}
}