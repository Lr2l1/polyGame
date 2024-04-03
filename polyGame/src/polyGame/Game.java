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
	String human[] = { "Healer", "Warrior", "Wizard" };

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
			monsters = drawMonster();
			while (isBattle()) {
				playerInfo();
				battle();
				attackMonster();
			}
		} else if (select == FINISH)
			finish();
	}

	private void printBattleMenu() {

		System.out.println("[1]어택");
		System.out.println("[2]스킬");
	}

	private void runBattleWarrior(int select) {
		if (select == ATTACK)
			attackWarrior();
		else if (select == SKILL)
			skillWarrior();
	}

	private void runBattleWizard(int select) {
		if (select == ATTACK)
			attackWizard();
		else if (select == SKILL)
			skillWizard();
	}

	private void runBattleHealer(int select) {
		if (select == ATTACK)
			attackHealer();
		else if (select == SKILL)
			skillHealer();
	}

	private void battle() {
		System.out.println("[전사]");
		printBattleMenu();
		runBattleWarrior(option());
		System.out.println("[법사]");
		printBattleMenu();
		runBattleWizard(option());
		System.out.println("[힐러]");
		printBattleMenu();
		runBattleHealer(option());
	}

	private void playerInfo() {
		System.out.println("=====[BATTLE]====");
		System.out.println("=====[PLAYER]====");
		System.out.println(warrior);
		System.out.println(wizard);
		System.out.println(healer);
		System.out.println("=====[MONSTER]====");
		for (int i = 0; i < SIZE; i++)
			System.out.println(monsters.get(i));
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
		for (int i = 0; i < SIZE; i++) {
			if (!warrior.isDead())
				monsters.get(i).attack(warrior);
			else {
				if (!wizard.isDead())
					monsters.get(i).attack(wizard);
				else {
					if (!healer.isDead())
						monsters.get(i).attack(healer);
					else
						return;
				}
			}
		}
	}

	private void attackWarrior() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		warrior.attack(monsters.get(index));
	}

	private void attackWizard() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		wizard.attack(monsters.get(index));
	}

	private void attackHealer() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		healer.attack(monsters.get(index));
	}

	private void skillWarrior() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		warrior.skill(monsters.get(index));

	}

	private void skillWizard() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		wizard.skill(monsters.get(index));

	}

	private void skillHealer() {
		healer.skill(warrior);

	}

	private void finish() {
		isExit = true;
	}

	private boolean isBattle() {
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				return true;
		}

		return false;
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
		printResult();
	}
}
