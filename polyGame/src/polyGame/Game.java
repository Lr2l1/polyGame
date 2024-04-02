package polyGame;

import java.util.Scanner;

public class Game {
	private final int SIZE = 4;
	
	private final int BATTLE = 1;
	private final int FINISH = 2;

	private final int ATTACK = 1;
	private final int SKILL = 1;

	private Scanner scan = new Scanner(System.in);
	private boolean isExit;

	Healer healer = new Healer();
	Warrior warrior = new Warrior();
	Wizard wizard = new Wizard();

	Bat bat = new Bat();
	Orc orc = new Orc();
	Wolf wolf = new Wolf();

	public Game() {
		isExit = false;
	}

	private int inputNumber(String message) {
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

	private int option() {
		return inputNumber("메뉴");
	}

	private void printMenu() {
		System.out.println("[1]전투");
		System.out.println("[2]종료");
	}

	private void runMenu(int select) {
		if (select == BATTLE) {
			printBattleMenu();
			runBattleMenu(option());
		} else if (select == FINISH)
			finish();
	}

	private void printBattleMenu() {
		System.out.println("[1]어택");
		System.out.println("[2]스킬");
	}

	private void runBattleMenu(int select) {
		if (select == ATTACK)
			attack();
		else if (select == SKILL)
			skill();
	}

	private void attack() {
		
	}

	private void skill() {

	}

	private void finish() {
		isExit = true;
	}

	private boolean isRun() {
		return isExit ? false : true;
	}
	
	private void printResult() {
		System.out.println("공주를 구출해냈어!");
	}

	public void run() {
		while (isRun()) {
			printMenu();
			int sel = inputNumber("메뉴");
			runMenu(sel);
		}

	}
}
