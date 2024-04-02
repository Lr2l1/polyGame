package polyGame;

import java.util.Random;

public class Warrior extends Human {
	private Random ran = new Random();

	Warrior(String name, int hp, int power) {
		super("전사", 1000, 200, 80);

	}

	@Override
	void attack(Unit enenmy) {
		int ranPower = ran.nextInt(super.MAX_POWER);

		setPower(ranPower);

		System.out.printf("%s가 %s를 %d의 데미지로 공격\n", getName(), enenmy.getName(), getPower());
		enenmy.setHp(getHp() - getPower());

		if (enenmy.getHp() <= 0) {
			enenmy.setHp(0);
			enenmy.setIsDead();
		}

	}

	@Override
	void skill(Unit enenmy) {
		setMp(getMp() - 40);
		setPower(super.MAX_POWER * 2);
		setHp(getHp() + getPower());
		System.out.printf("%s가 스킬을 사용하여 %d데미지를 입히고 %d의 체력 회복\n", getName(), getPower(), getPower() / 2);

		if (enenmy.getHp() <= 0) {
			enenmy.setHp(0);
			enenmy.setIsDead();
		}
	}

	@Override
	public void stun() {
		setIsStun();
	}

	@Override
	public void silence() {
		setIsSilence();
	}

	@Override
	public void recover() {
		setHp(getHp() + 50);
	}

}
