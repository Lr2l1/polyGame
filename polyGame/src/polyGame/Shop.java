package polyGame;

import java.util.ArrayList;

public class Shop {
	static ArrayList<Item> itemList = new ArrayList<Item>();

	public Shop() {
		Item item = new Item();
		item.kind = Item.HELMET;
		item.name = "가죽투구";
		item.power = 5;
		item.price = 2500;
		itemList.add(item);

		item = new Item();
		item.kind = Item.HELMET;
		item.name = "철투구";
		item.power = 10;
		item.price = 5000;
		itemList.add(item);

		item = new Item();
		item.kind = Item.HELMET;
		item.name = "다이아 투구";
		item.power = 15;
		item.price = 8000;
		itemList.add(item);

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "가죽갑옷";
		item.power = 5;
		item.price = 2500;
		itemList.add(item);

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "철 갑옷";
		item.power = 10;
		item.price = 5000;
		itemList.add(item);

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "다이아 갑옷";
		item.power = 15;
		item.price = 8000;
		itemList.add(item);

		item = new Item();
		item.kind = Item.RING;
		item.name = "실반지";
		item.power = 7;
		item.price = 3000;
		itemList.add(item);

		item = new Item();
		item.kind = Item.RING;
		item.name = "금반지";
		item.power = 17;
		item.price = 6000;
		itemList.add(item);

		item = new Item();
		item.kind = Item.RING;
		item.name = "다이아반지";
		item.power = 35;
		item.price = 15000;
		itemList.add(item);
	}

	public void printMenu() {
		if (Human.money<=0) {
			System.err.println("보유한 골드가 부족합니다!");
			return;
		}
		
		System.out.println("═══════════[상점]════════════");
		System.out.printf("[ 보유골드 :  %d ]\n", Human.money);
		System.out.println("[1]투구 [2]갑옷 [3]반지");
		int sel = Game.inputNumber("메뉴");

		while (true) {
			if (sel == Item.HELMET) {
				System.out.println("=========== [헬멧] ============");
			} else if (sel == Item.ARMOR) {
				System.out.println("========== [방어구] ===========");
			} else if (sel == Item.RING) {
				System.out.println("=========== [반지] ============");
			}
			printItem(sel);
			System.out.println("------------------------------------");
			System.out.printf("[골드 : %d]\n", Human.money);
			System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int selNum = Game.inputNumber("메뉴");
			if (selNum == 0)
				break;
			int count = 0;
			for (int i = 0; i < itemList.size(); i++) {
				if (itemList.get(i).kind == sel) {
					count += 1;
					if (count == selNum) {
						Inventory.addItem(itemList.get(i));
						Human.money -= itemList.get(i).price;
						System.out.printf("[%s] 을 구입했습니다\n.", itemList.get(i).name);
						break;
					}
				}
			}
		}
	}

	private void printItem(int sel) {
		int count = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).kind != sel)
				continue;
			System.out.printf("[ %s번] ", count + 1);
			System.out.printf("[이름 : %s] ", itemList.get(i).name);
			System.out.printf("[능력 : %s] ", itemList.get(i).power);
			System.out.printf("[가격 : %s] ", itemList.get(i).price);
			System.out.println();
			count++;
		}
	}
}
