package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {

	private static Scanner scan = new Scanner(System.in);

	static Game instance = new Game();
	static String nextStage = "";

	String curStage = "";

	Map<String, Stage> stageList = new HashMap<String, Stage>();

	Game() {
		Human.money = 100000;
	}

	void init() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("SETTING", new StageSetting());
		stageList.put("WIN", new StageWin());
		nextStage = "TITLE";
	}

	boolean changeStage() {

		System.out.println("curStage : " + curStage);
		System.out.println("nextStage : " + nextStage);

		if (curStage.equals(nextStage))
			return true;

		curStage = nextStage;
		Stage stage = stageList.get(curStage);
		stage.init();

		boolean run = true;
		while (run) {
			run = stage.update();
			if (run == false)
				break;
		}
		if (nextStage.equals(""))
			return false;
		else
			return true;
	}

	static public int inputNumber(String message) {
		int number = -1;
		System.out.print(message + " : ");
		try {
			String input = scan.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.out.println("숫자만 입력해주세요");
		}
		return number;
	}

}
