package polyGame;

import java.util.Random;

public class HumanHealer extends Human {
	private Random ran = new Random();

	HumanHealer() {
		super("힐러", 500, 500, 50);
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
	void skill(Unit unit) {
		Human human = (Human) unit;
		setMp(getMp() - 50);
		System.out.printf("%s가 스킬을 사용하여 아군의 체력 50을 회복\n", getName());

		human.setHp(human.getHp() + 50);
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
