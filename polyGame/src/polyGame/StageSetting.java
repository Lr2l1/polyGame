package polyGame;

public class StageSetting extends Stage {
	Shop shop = new Shop();
	Guild guild = new Guild();
	Inventory inventory = new Inventory();

	@Override
	public boolean update() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("=============== [메인메뉴] ================");
			System.out.println("[1.길드관리]\t\t[2.상점]\t\t[3.인벤토리]");
			System.out.println("[4.저장]\t\t[5.로드]\t\t[0.뒤로가기]");
			int sel = Game.inputNumber("메뉴");
			if (sel == 1) {
				guild.printMenu();
			} else if (sel == 2) {
				shop.printMenu();
			} else if (sel == 3) {
				inventory.printMenu();
			} else if (sel == 4) {
				FileData.save();
			} else if (sel == 5) {
				FileData.load();
			} else if (sel == 0) {
				Game.nextStage = "LOBBY";
				isRun = false;
			}
		}
		return false;
	}

	@Override
	public void init() {

	}

}
