package polyGame;

public abstract class Unit {
	public final int MAX_HP;
	public final int MAX_POWER;
	private String name;
	private int hp;
	private int power;

	Unit(String name, int hp, int power) {
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.MAX_HP = hp;
		this.MAX_POWER = power;
	}

	public String getName() {
		return this.name;
	}

	public int getHp() {
		return this.hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower(int power) {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	abstract void attack(Unit enenmy);

	@Override
	public String toString() {
		return String.format("[%s HP] %d/%d", name, hp, MAX_HP);
	}
}
