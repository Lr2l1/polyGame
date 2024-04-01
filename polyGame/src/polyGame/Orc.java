package polyGame;

import java.util.Random;

public class Orc extends Monster {

	Orc() {
		super("오크", 100, 20);
		
	}

	//데미지 두배 + 기절
	@Override
	void attack(Unit enenmy) {
		Random ran = new Random();
	}
}
