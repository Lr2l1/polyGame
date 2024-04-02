package polyGame;

public abstract class Human extends Unit implements Stunable, Silenceable, Recoverable {
	public final int MAX_MP;
	private int mp;
	private boolean isStun;
	private boolean isSilence;

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

	public boolean isStun() {
		return this.isStun();
	}

	public void setIsStun() {
		this.isStun = !isStun;
	}

	public boolean isSilence() {
		return this.isSilence;
	}
	
	public void setIsSilence() {
		this.isSilence = !isSilence;
	}

	abstract void skill(Unit unit);

}
