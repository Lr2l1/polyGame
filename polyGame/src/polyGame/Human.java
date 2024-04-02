package polyGame;

public abstract class Human extends Unit implements Stunable, Silenceable, Recoverable {
	public final int MAX_MP;
	private int mp;

	Human(String name, int hp, int mp, int power) {
		super(name, hp, power);
		this.MAX_MP = mp;
	}
	
	public int getMp() {
		return this.mp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}

	abstract void skill();

}
