package polyGame;

import java.util.Random;

public class StageWin extends Stage {
	Random ran = new Random();

	@Override
	public boolean update() {
		System.out.println("승리~");
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
	}
}
