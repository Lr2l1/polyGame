package polyGame;

public abstract class Human extends Unit implements Stunable, Silenceable, Recoverable {
	public final int MAX_MP;
	private int mp;
	private boolean isStun;
	private boolean isSilence;

	Human(String name, int hp, int mp, int power) {
		super(name, hp, power);
		this.mp = mp;
		this.MAX_MP = mp;
		this.isStun = false;
		this.isSilence = false;
	}

	public int getMp() {
		return this.mp;
	}
	
	public void setMp(int mp) {
		this.mp = mp;
	}

	public boolean isStun() {
		return this.isStun;
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
	
	@Override
	public String toString() {
		String info = String.format("[%s] %d/%d", getName(), getHp(), getMp());
//		info += String.format("%s" , isStun() ? " 스턴상태" : "");
//		info += String.format("%s" , isSilence() ? " 침묵상태" : "");
		return info;
	}

}
