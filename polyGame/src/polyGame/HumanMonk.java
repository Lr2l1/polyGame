package polyGame;

import java.util.Random;

public class HumanMonk extends Human {
	private Random ran = new Random();

	HumanMonk() {
		super("뭉크", 1, 800, 800, 100);
		super.className = "HumanMonk";
	}

	@Override
	void attack(Unit enenmy) {
		Monster monster = (Monster) enenmy;
		int ranPower = ran.nextInt(super.MAX_POWER);

		setPower(ranPower);

		System.out.printf("%s가 %s를 %d의 데미지로 공격\n", getName(), monster.getName(), getPower());
		monster.setHp(monster.getHp() - getPower());
		// 기본공격에 흡혈
		setHp(getHp() + getPower() / 2);

		if (monster.getHp() <= 0) {
			monster.setHp(0);
			monster.setIsDead(true);
		}

	}

	@Override
	void skill(Unit enenmy) {
		Monster monster = (Monster) enenmy;
		setMp(getMp() - 40);
		int ranPower = ran.nextInt(super.MAX_POWER) + super.MAX_POWER * 2;
		setPower(ranPower);
		System.out.printf("%s가 스킬을 사용하여 %d데미지\n", getName(), getPower());
		monster.setHp(monster.getHp() - getPower());
		setHp(getHp() + getPower() / 2);

		if (enenmy.getHp() <= 0) {
			enenmy.setHp(0);
			enenmy.setIsDead(true);
		}
	}
	
	@Override
	void skill() {
	}

	@Override
	public void stun() {
		System.out.println("한턴동안 스턴");
		setIsStun(true);
	}

	@Override
	public void silence() {
		System.out.println("한턴동안 침묵");
		setIsSilence(true);
	}

	@Override
	public void recover() {
		setHp(getHp() + 50);

	}
}
