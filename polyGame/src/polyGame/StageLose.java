package polyGame;

public class StageLose extends Stage {
	Guild guild = new Guild();

	@Override
	public boolean update() {
		System.out.println("전투에서 패배했어..");
		savePalyers();
		Game.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
	}

	private void savePalyers() {
		Human human = null;

		for (int i = 0; i < Guild.players.size(); i++) {
			if (Guild.players.get(i).isDead())
				human = Guild.players.get(i);
		}

		System.out.printf("5000골드를 사용해서 %s를 살릴거야?\n", human.getName());
		int sel = Game.inputNumber("예(1) 아니요(2)");

		if (sel == 1) {
			human.setHp(human.MAX_HP);
		} else if (sel == 2) {
			boolean isRun = true;
			while (isRun) {
				int count = 0;
				guild.printMenu();

				for (int i = 0; i < Guild.players.size(); i++) {
					if (!Guild.players.get(i).isDead())
						count++;
				}

				if (count == 3)
					isRun = false;
			}
		}
	}

}
