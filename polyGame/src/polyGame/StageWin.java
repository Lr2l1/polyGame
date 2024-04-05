package polyGame;

public class StageWin extends Stage {

	@Override
	public boolean update() {
		System.out.println("승리~");
		Game.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}

}
