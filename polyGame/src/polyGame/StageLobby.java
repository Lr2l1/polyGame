package polyGame;

public class StageLobby extends Stage {
	@Override
	public boolean update() {

		while (true) {
			System.out.println("=====[LOBBY]=====");
			System.out.println("[1. 전투] [2. 설정] [0. 종료]");
			int sel = Game.inputNumber("메뉴");
			if (sel == 1) {

			} else if (sel == 2) {

			}
			if (sel == 0)
				break;
		}

		return false;
	}

	@Override
	public void init() {

	}

}
