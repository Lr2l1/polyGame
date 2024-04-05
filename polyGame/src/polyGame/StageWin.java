package polyGame;

import java.util.Random;

public class StageWin extends Stage {
	Random ran = new Random();

	@Override
	public boolean update() {
		System.out.println("전투에서 승리하였어.");
		levelUp();
		dropItem();

		Game.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}

	public void levelUp() {
		for (int i = 0; i < Guild.players.size(); i++) {
			Guild.players.get(i).levelUp();
		}
		for (int i = 0; i < Guild.players.size(); i++)
			System.out.println(Guild.players.get(i));
	}

	public void dropItem() {
		int dice = ran.nextInt(Shop.itemList.size());

		Inventory.addItem(Shop.itemList.get(dice));

		System.out.printf("주사위가 %d가 나왔어! 보상으로 %s를 획득했어~\n", dice, Shop.itemList.get(dice).name);		
	}
}