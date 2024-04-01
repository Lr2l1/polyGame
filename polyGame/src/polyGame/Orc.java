package polyGame;

import java.util.Random;

public class Orc extends Monster {
	private Random ran = new Random();

	Orc() {
		super("오크", 100, 20);

	}

	// 데미지 두배 + 기절
	@Override
	void attack(Unit enenmy) {
		Human human = (Human) enenmy;
		int ranPower = ran.nextInt(super.MAX_POWER) + super.MAX_POWER;
		setPower(ranPower);
		human.setHp(human.getHp() - getPower());
		System.out.printf("%s가 %s를 %d의 데미지로 공격\n", getName(), human.getName(), getPower());
		human.stun();
		if (human.getHp() <= 0) {
			human.setHp(0);
			human.setIsDead();
		}
	}
}
