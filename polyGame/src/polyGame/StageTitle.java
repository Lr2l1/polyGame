package polyGame;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("├┬┴┬┴┬┴┤TETX  RPG├┬┴┬┴┬┴┬┤");
		System.out.println("├   화면에 숫자를 입력하세요  ┤");
		System.out.println("├┬┴┬┴┬┴┬┴┬┴┬┴┬┴┬┴┬┴┬┴┬┴┬┴┤");
		Game.inputNumber("");
		
		Game.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}
}
