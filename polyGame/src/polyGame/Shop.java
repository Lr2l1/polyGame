package polyGame;

import java.util.ArrayList;

public class Shop {
	ArrayList<Item> items = new ArrayList<Item>();
	Game game = new Game();
	Inventory inventory = new Inventory();

	public Shop() {
		Item item = new Item();
		item.kind = Item.HELMET;
		item.name = "가죽투구";
		item.power = 5;
		item.price = 2500;

		item = new Item();
		item.kind = Item.HELMET;
		item.name = "철투구";
		item.power = 10;
		item.price = 5000;

		item = new Item();
		item.kind = Item.HELMET;
		item.name = "다이아 투구";
		item.power = 15;
		item.price = 8000;

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "가죽갑옷";
		item.power = 5;
		item.price = 2500;

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "철 갑옷";
		item.power = 10;
		item.price = 5000;

		item = new Item();
		item.kind = Item.ARMOR;
		item.name = "다이아 갑옷";
		item.power = 15;
		item.price = 8000;

		item = new Item();
		item.kind = Item.RING;
		item.name = "실반지";
		item.power = 7;
		item.price = 3000;

		item = new Item();
		item.kind = Item.RING;
		item.name = "금반지";
		item.power = 17;
		item.price = 6000;

		item = new Item();
		item.kind = Item.RING;
		item.name = "다이아반지";
		item.power = 35;
		item.price = 15000;
	}

	private void shopMenu() {
		System.out.println("================");
		System.out.println("[1]투구 [2]갑옷 [3]반지");
		int kind = game.inputNumber("메뉴");

		while (true) {
			if (kind == Item.HELMET) {
				System.out.println("=========== [헬멧 ============");
			} else if (kind == Item.ARMOR) {
				System.out.println("========== [방어구] ===========");
			} else if (kind == Item.RING) {
				System.out.println("=========== [반지] ============");
			}
			printItem(kind);
			System.out.println("------------------------------------");
			System.out.println("[골드 : ]");
			System.out.println("구입할 아이템 번호를 입력하세요 [0.뒤로가기]");
			int selNum = game.inputNumber("메뉴");
			if (selNum == 0)
				break;
			int count = 0;
			for (int i = 0; i < items.size(); i++) {

				if (items.get(i).kind == kind) {
					count += 1;

					if (count == selNum) {
						inventory.addItem(items.get(i));
						Human.money -= items.get(i).price;
						System.out.println("[" + items.get(i).name + "] 을 구입했습니다.");
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

	private void printItem(int kind) {
		int count = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).kind != kind)
				continue;
			System.out.print("[" + (count + 1) + "번] ");
			System.out.print("[이름 : " + items.get(i).name + "] ");
			System.out.print("[능력 : " + items.get(i).power + "] ");
			System.out.print("[가격 : " + items.get(i).price + "] ");
			System.out.println();
			count++;
		}
	}

}
