package polyGame;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> items = new ArrayList<Item>();
	Inventory inventory = new Inventory();

	public Shop() {
		Item item = new Item();
		item.kind = Item.HELMET;
		item.name = "가죽투구";
		item.power = 5;
		item.price = 2500;
		items.add(item);
		
		item = new Item();
		item.kind = Item.HELMET;
		item.name = "철투구";
		item.power = 10;
		item.price = 5000;
		items.add(item);

		item = new Item();
		item.kind = Item.HELMET;
		item.name = "다이아 투구";
		item.power = 15;
		item.price = 8000;
		items.add(item);

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "가죽갑옷";
		item.power = 5;
		item.price = 2500;
		items.add(item);

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "철 갑옷";
		item.power = 10;
		item.price = 5000;
		items.add(item);

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "다이아 갑옷";
		item.power = 15;
		item.price = 8000;
		items.add(item);

		item = new Item();
		item.kind = Item.RING;
		item.name = "실반지";
		item.power = 7;
		item.price = 3000;
		items.add(item);

		item = new Item();
		item.kind = Item.RING;
		item.name = "금반지";
		item.power = 17;
		item.price = 6000;
		items.add(item);

		item = new Item();
		item.kind = Item.RING;
		item.name = "다이아반지";
		item.power = 35;
		item.price = 15000;
		items.add(item);
	}

	public void printMenu() {
		System.out.println("================");
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
			for (int i = 0; i < items.size(); i++) {
				if (items.get(i).kind == sel) {
					count += 1;
					if (count == selNum) {
						inventory.addItem(items.get(i));
						Human.money -= items.get(i).price;
						System.out.printf("[%s] 을 구입했습니다\n.", items.get(i).name);
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					}
				}
			}
		}
	}

	private void printItem(int sel) {
		int count = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).kind != sel)
				continue;
			System.out.printf("[ %s번] ", count + 1);
			System.out.printf("[이름 : %s] ", items.get(i).name);
			System.out.printf("[능력 : %s] ", items.get(i).power);
			System.out.printf("[가격 : %s] ", items.get(i).price);
			System.out.println();
			count++;
		}
	}

}
