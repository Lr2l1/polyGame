package polyGame;

public abstract class Monster extends Unit {

	Monster(String name, int hp, int power) {
		super(name, hp, power);

	}

	@Override
	public String toString() {
		return String.format("[%s HP] %d/%d", getName(), getHp(), MAX_HP);
	}
}
