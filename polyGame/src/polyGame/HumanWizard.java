package polyGame;

import java.util.Random;

public class HumanWizard extends Human {
	private Random ran = new Random();

	HumanWizard() {
		super("법사", 1, 800, 400, 70);
		super.className = "HumanWizard";
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
	void skill(Unit enenmy) {

	}

	@Override
	void skill() {
		for (int i = 0; i < StageBattle.monsters.size(); i++) {
			Monster monster = StageBattle.monsters.get(i);
			setMp(getMp() - 40);
			setPower(super.MAX_POWER);
			System.out.printf("%s가 스킬을 사용하여 %d데미지\n", getName(), getPower());
			monster.setHp(monster.getHp() - getPower());

			if (monster.getHp() <= 0) {
				monster.setHp(0);
				monster.setIsDead(true);
			}
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