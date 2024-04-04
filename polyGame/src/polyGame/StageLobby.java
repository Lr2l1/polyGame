package polyGame;

public class StageLobby extends Stage {
	@Override
	public boolean update() {
		System.out.println("=====[LOBBY]=====");
		System.out.println("[1. 전투] [2. 설정] [0. 종료]");
		int sel = Game.inputNumber("메뉴");
		if (sel == 1)
			Game.nextStage = "BATTLE";
		else if (sel == 2)
			Game.nextStage = "SETTING";
		else if (sel == 0)
			Game.nextStage = "";

		return false;
	}

	@Override
	public void init() {
	}
}
