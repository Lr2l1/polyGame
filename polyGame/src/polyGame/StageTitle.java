package polyGame;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("==== TEXT RPG ====");
		System.out.println("화면에 아무숫자나 입력하세요");
		Game.inputNumber("");
		Game.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}

}
