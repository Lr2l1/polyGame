package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Game {
	private final int SIZE = 4;

	private final int BATTLE = 1;
	private final int FINISH = 2;

	private final int ATTACK = 1;
	private final int SKILL = 1;

	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private boolean isExit;

	Healer healer = new Healer();
	Warrior warrior = new Warrior();
	Wizard wizard = new Wizard();

	Bat bat = new Bat();
	Orc orc = new Orc();
	Wolf wolf = new Wolf();

	Map<Integer, Monster> monsters = new HashMap<>();
	String monster[] = { "Wolf", "Bat", "Orc" };

	public Game() {
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
		battle();
		System.out.println("[1]어택");
		System.out.println("[2]스킬");
	}

	private void runBattleMenu(int select) {
		if (select == ATTACK)
			battle();
		else if (select == SKILL)
			skill();
	}

	private void battle() {
		monsters = drawMonster();
		System.out.println("=====[BATTLE]====");
		System.out.println("=====[PLAYER]====");
		System.out.println(warrior);
		System.out.println(wizard);
		System.out.println(healer);
		System.out.println("=====[MONSTER]====");
		System.out.println(monsters.get(0));
		System.out.println(monsters.get(1));
		System.out.println(monsters.get(2));
		System.out.println(monsters.get(3));
	}

	private Map<Integer, Monster> drawMonster() {
		monsters = new HashMap<Integer, Monster>();
		for (int i = 0; i < SIZE; i++) {
			int dice = ran.nextInt(monster.length);
			try {
				Class<?> clazz = Class.forName("polyGame." + monster[dice]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Monster temp = (Monster) obj;
				monsters.put(i, temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return monsters;
	}

	private void attackMonster() {
		
	}

	private void attackHuman() {

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
