package polyGame;

import java.util.Random;

public class HumanWarrior extends Human {
	private Random ran = new Random();

	HumanWarrior() {
		super("전사", 1, 1000, 200, 80);
		super.className = "HumanWarrior";
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
			monster.setIsDead(true);
		}
	}

	@Override
	void skill() {
		int ranNum = ran.nextInt(StageBattle.monsters.size());
		Monster monster = StageBattle.monsters.get(ranNum);
		
		setMp(getMp() - 40);
		setPower(super.MAX_POWER * 2);

		if (getHp() + getPower() / 2 > MAX_HP) {
			setHp(MAX_HP);
		} else
			setHp(getHp() + getPower() / 2);

		System.out.printf("%s가 스킬을 사용하여 %d데미지를 입히고 %d의 체력 회복\n", getName(), getPower(), getPower() / 2);
		monster.setHp(monster.getHp() - getPower());

		if (monster.getHp() <= 0) {
			monster.setHp(0);
			monster.setIsDead(true);
		}
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
