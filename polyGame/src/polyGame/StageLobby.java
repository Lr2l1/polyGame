package polyGame;

public class StageLobby extends Stage {
	Game game = new Game();

	@Override
	public boolean update() {

		while (true) {
			int select = game.inputNumber("메뉴");

			if (select == 0)
				break;
		}

		return false;
	}

	@Override
	public void init() {

	}

}
