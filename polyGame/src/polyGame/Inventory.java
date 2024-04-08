package polyGame;

import java.util.ArrayList;

public class Inventory {
	static ArrayList<Item> items = new ArrayList<Item>();

	Guild guild = new Guild();

	public void printMenu() {
		System.out.println("[1.착용] [2.해제] [3.판매] ");
		System.out.println("[0.뒤로가기]");
		int sel = Game.inputNumber("메뉴");
		if (sel == 0)
			return;
		else if (sel == 1)
			wearItem();
		else if (sel == 2)
			removeItem();
		else if (sel == 3)
			sellItem();
	}

	public void printItem() {
		System.out.println("========== 인벤토리 =========");
		for (int i = 0; i < items.size(); i++) {
			System.out.printf("[ %d번] ", i + 1);
			System.out.printf("[이름 : %s]", items.get(i).name);
			System.out.printf("[능력 : %s]", items.get(i).power);
			System.out.println();
		}
	}

	public void wearItem() {
		if (items.size() < 1) {
			System.out.println("인벤토리가 비어있어");
			return;
		}

		guild.printPlayers();
		int num = Game.inputNumber("플레이어 번호") - 1;
		guild.printWornItem(num);
		printItem();

		int itemNum = Game.inputNumber("아이템 번호") - 1;
		if (items.get(itemNum).kind == Item.HELMET && Guild.players.get(num).getHelmet() == null) {
			Guild.players.get(num).setHelmet(items.get(itemNum));
			items.remove(itemNum);
			System.out.printf("%s 착용완료\n", Guild.players.get(num).getHelmet().name);
		} else if (items.get(itemNum).kind == Item.ARMOR && Guild.players.get(num).getArmor() == null) {
			Guild.players.get(num).setArmor(items.get(itemNum));
			items.remove(itemNum);
			System.out.printf("%s 착용완료\n", Guild.players.get(num).getArmor().name);
		} else if (items.get(itemNum).kind == Item.RING && Guild.players.get(num).getRing() == null) {
			Guild.players.get(num).setRing(items.get(itemNum));
			items.remove(itemNum);
			System.out.printf("%s 착용완료\n", Guild.players.get(num).getRing().name);
		} else {
			System.out.println("이미 아이템을 착용하고 있는 부위야!");
			return;
		}
	}

	public void removeItem() {
		guild.printPlayers();
		int num = Game.inputNumber("플레이어 번호") - 1;
		guild.printWornItem(num);
		int itemNum = Game.inputNumber("착용 해제 할 아이템 [1. 헬멧] [2. 갑옷] [3. 반지]");
		if (itemNum == Item.HELMET && Guild.players.get(num).getHelmet() != null) {
			items.add(Guild.players.get(num).getHelmet());
			Guild.players.get(num).removeHelmet();
		} else if (itemNum == Item.ARMOR && Guild.players.get(num).getArmor() != null) {
			items.add(Guild.players.get(num).getArmor());
			Guild.players.get(num).removeHelmet();
		} else if (itemNum == Item.RING && Guild.players.get(num).getRing() != null) {
			items.add(Guild.players.get(num).getRing());
			Guild.players.get(num).removeHelmet();
		} else {
			System.out.println("아이템을 착용하고 있지 않아!");
			return;
		}
	}

	public void sellItem() {
		if (items.size() < 1) {
			System.out.println("인벤토리가 비어있어");
			return;
		}

		printItem();
		int num = Game.inputNumber("상품번호") - 1;
		if (num < 0 || num >= items.size())
			return;

		System.out.printf("%s 아이템을 판매했어.\n", items.get(num).name);

		Human.money += items.get(num).price / 2;
		items.remove(num);
		System.out.println("보유골드 : " + Human.money);

	}

	static public void addItem(Item item) {
		items.add(item);
	}
}
