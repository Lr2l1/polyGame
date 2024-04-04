package polyGame;

public abstract class Human extends Unit implements Stunable, Silenceable, Recoverable {
	public final int MAX_MP;
	private int mp;
	private int level;
	private boolean isStun;
	private boolean isSilence;
	static int money;
	private Item helmet;
	private Item armor;
	private Item ring;

	Human(String name, int level, int hp, int mp, int power) {
		super(name, hp, power);
		this.mp = mp;
		this.MAX_MP = mp;
		this.level = level;
		this.isStun = false;
		this.isSilence = false;
		this.helmet = null;
		this.armor = null;
		this.ring = null;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
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

	public Item getHelmet() {
		return this.helmet;
	}

	public void setHelmet(Item helmet) {
		this.helmet = helmet;
	}

	public Item getArmor() {
		return this.armor;
	}

	public void setArmor(Item armor) {
		this.armor = armor;
	}

	public Item getRing() {
		return this.ring;
	}

	public void setRing(Item ring) {
		this.ring = ring;
	}

	abstract void skill(Unit unit);

	@Override
	public String toString() {
		String info = String.format("[%s] HP %d/%d MP %d/%d\n상태이상 : ", getName(), getHp(), MAX_HP, getMp(), MAX_MP);
		info += String.format("%s", isStun() ? " 스턴상태 /" : "X /");
		info += String.format("%s", isSilence() ? " 침묵상태" : " X");
		return info;
	}

}
