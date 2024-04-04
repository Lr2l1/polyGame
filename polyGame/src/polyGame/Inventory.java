package polyGame;

import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> items = new ArrayList<Item>();

	Guild guild = new Guild();

	public void printMenu() {
		System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
		int sel = Game.inputNumber("메뉴");
		if (sel == 0)
			return;
		else if (sel == 1)
			wearItem();
		else if (sel == 2)
			sellItem();
	}

	public void printItem() {
		System.out.println("========== 인벤토리 =========");
		for (int i = 0; i < items.size(); i++) {
			System.out.print("[" + (i + 1) + "번] ");
			System.out.printf("[이름 : %s]", items.get(i).name);
			System.out.printf("[능력 : %s]", items.get(i).power);
			System.out.printf("[가격 : %s]", items.get(i).price);
			System.out.println();
		}
	}

	public void wearItem() {
		int sel = Game.inputNumber("플레이어번호");
		guild.printWornItem(sel);
		
	}

	public void sellItem() {
		printItem();
	}

	public void addItem(Item item) {
		items.add(item);
	}
}
