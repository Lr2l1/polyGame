package polyGame;

import java.util.Random;

public class Wizard extends Human {
	private Random ran = new Random();

	Wizard() {
		super("법사", 800, 400, 70);
	}

	@Override
	void attack(Unit enenmy) {
		Monster monster = (Monster) enenmy;
		int ranPower = ran.nextInt(super.MAX_POWER);

		setPower(ranPower);

		System.out.printf("%s가 %s를 %d의 데미지로 공격\n", getName(), monster.getName(), getPower());
		monster.setHp(monster.getHp() - getPower());

		if (monster.getHp() <= 0) {
			monster.setHp(0);
			monster.setIsDead();
		}

	}

	@Override
	void skill(Unit enenmy) {
		Monster monster = (Monster) enenmy;
		setMp(getMp() - 40);
		int ranPower = ran.nextInt(super.MAX_POWER);
		setPower(ranPower);
		System.out.printf("%s가 스킬을 사용하여 %d데미지\n", getName(), getPower());
		monster.setHp(monster.getHp() - getPower());

		if (enenmy.getHp() <= 0) {
			enenmy.setHp(0);
			enenmy.setIsDead();
		}
	}

	@Override
	public void stun() {
		System.out.println("한턴동안 스턴");
		setIsStun();
	}

	@Override
	public void silence() {
		System.out.println("한턴동안 침묵");
		setIsSilence();
	}

	@Override
	public void recover() {
		setHp(getHp() + 50);

	}
}