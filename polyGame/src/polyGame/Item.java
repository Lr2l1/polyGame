package polyGame;

public class Item {
	static final int HELMET = 1;
	static final int ARMOR = 2;
	static final int RING = 3;
	public int kind;
	public String name;
	public int power;
	public int price;

	public void setItem(int kind, String name, int power, int price) {
		this.kind = kind;
		this.name = name;
		this.power = power;
		this.price = price;
	}
}
