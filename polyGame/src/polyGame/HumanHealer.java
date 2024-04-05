package polyGame;

import java.util.Random;

public class HumanHealer extends Human {
	private Random ran = new Random();

	HumanHealer() {
		super("힐러", 1, 500, 500, 50);
		super.className = "HumanHealer";
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
	void skill(Unit unit) {
		
	}
	
	@Override
	void skill() {
		for (int i = 0; i < Guild.players.size(); i++) {
			Human human = Guild.players.get(i);
			setMp(getMp() - 50);
			System.out.printf("%s가 스킬을 사용하여 아군의 체력 50을 회복\n", getName());

			human.recover();

			if (human.getHp() >= human.MAX_HP) {
				human.setHp(human.MAX_HP);
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
