package polyGame;

import java.util.Random;

public class MonsterBat extends Monster {
	private Random ran = new Random();
	
	MonsterBat() {
		super("박쥐", 100, 20);

	}

	@Override
	void attack(Unit enenmy) {
		Human human = (Human) enenmy;
		int ranPower = ran.nextInt(super.MAX_POWER) + super.MAX_POWER;
		setPower(ranPower);
		human.setHp(human.getHp() - getPower());
		System.out.printf("%s가 %s를 %d의 데미지로 공격\n", getName(), human.getName(), getPower());
		human.silence();
		
		if (human.getHp() <= 0) {
			human.setHp(0);
			human.setIsDead();
		}

	}
}
