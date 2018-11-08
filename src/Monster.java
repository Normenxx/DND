class Monster{
	String name;

	double maxHp;
	double curHp;
	double str;
	double curStr;
	double as;
	double curAs;
	double shield;

	public Monster(int monsterArt){

		if (monsterArt == 1){
			name = "Slime";

			maxHp = 15;
			curHp = 15;
			str = 5;
			curStr = 5;
			as = 1;
			curAs = 1;
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
		}

	}
}