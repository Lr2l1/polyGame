		package polyGame;

public abstract class Unit {
	public final int MAX_HP;
	public final int MAX_POWER;
	private String name;
	private int hp;
	private int power;
	private boolean isDead;

	Unit(String name, int hp, int power) {
		this.name = name;
		this.hp = hp;
		this.power = power;
		this.MAX_HP = hp;
		this.MAX_POWER = power;
		this.isDead = false;
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

	public int getPower() {
		return this.power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isDead() {
		return this.isDead;
	}

	public void setIsDead() {
		this.isDead = !isDead;
	}

	abstract void attack(Unit enenmy);

	
}
