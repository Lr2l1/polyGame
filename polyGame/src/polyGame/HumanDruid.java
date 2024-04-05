package polyGame;

import java.util.Random;

public class HumanDruid extends Human {
	private Random ran = new Random();

	HumanDruid() {
		super("드루이드", 1, 600, 1000, 150);
		super.className = "HumanDruid";
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

	@Override
	void skill(Unit unit) {
		// TODO Auto-generated method stub
		
	}

}
