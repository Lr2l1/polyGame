package polyGame;

public class StageTitle extends Stage {

	@Override
	public boolean update() {
		System.out.println("                       -|             |-");
		System.out.println("   -|                  [-_-_-_-_-_-_-_-]                  |-");
		System.out.println("   [-_-_-_-_-]          |             |          [-_-_-_-_-]");
		System.out.println("    | o   o |           [  0   0   0  ]           | o   o |");
		System.out.println("     |     |    -|       |           |       |-    |     |");
		System.out.println("     |     |_-___-___-___-|         |-___-___-___-_|     |");
		System.out.println("     |  o  ]              [    0    ]              [  o  |");
		System.out.println("     |     ]   o   o   o  [ _______ ]  o   o   o   [     | ----");
		System.out.println("---- |     ]              [ ||||||| ]              [     |");
		System.out.println("     |     ]              [ ||||||| ]              [     |");
		System.out.println(" _-_-|_____]--------------[_|||||||_]--------------[_____|-_-_");
		System.out.println("( (__________------------_____________-------------_________)");
		System.out.println("\t├┬┴┬┴┬┴┬┴┬┴┬┴┬┴┬┴┤TETX  RPG├┬┴┬┴┬┴┬┴┬┴┬┴┬┴┬┴┬┴┬┤");
		System.out.println("화면에 숫자를 입력해주세요.");
		Game.inputNumber("");
		Game.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

	}
}
