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
	private final int SKILL = 2;

	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();
	private boolean isExit;
	private int count;

	Healer healer = new Healer();
	Warrior warrior = new Warrior();
	Wizard wizard = new Wizard();

	Bat bat = new Bat();
	Orc orc = new Orc();
	Wolf wolf = new Wolf();

	Map<Integer, Monster> monsters = new HashMap<>();
	String monster[] = { "Wolf", "Bat", "Orc" };

	public Game() {
		this.count = 0;
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
		if (select == ATTACK) {
			count++;
			attackWarrior();
		} else if (select == SKILL && !warrior.isSilence())
			skillWarrior();
	}

	private void runBattleWizard(int select) {
		if (select == ATTACK)
			attackWizard();
		else if (select == SKILL && !wizard.isSilence())
			skillWizard();
	}

	private void runBattleHealer(int select) {
		if (select == ATTACK)
			attackHealer();
		else if (select == SKILL && !healer.isSilence())
			skillHealer();
	}

	private void battle() {
		System.out.println("[전사]");
		if (!warrior.isStun()) {
			printBattleMenu();
			runBattleWarrior(option());
		} else if (warrior.isStun()) {
			System.err.println("스턴상태에서는 행동이 불가능합니다.");
			warrior.setIsStun();
		}
		System.out.println("[법사]");
		if (!wizard.isStun()) {
			printBattleMenu();
			runBattleWizard(option());
		} else if (wizard.isStun()) {
			System.err.println("스턴상태에서는 행동이 불가능합니다.");
			wizard.setIsStun();
		}
		System.out.println("[힐러]");
		if (!healer.isStun()) {
			printBattleMenu();
			runBattleHealer(option());
		} else if (healer.isStun()) {
			System.err.println("스턴상태에서는 행동이 불가능합니다.");
			healer.setIsStun();
		}
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
			if (!monsters.get(i).isDead()) {
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
	}

	private void attackWarrior() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		if (index != -1)
			warrior.attack(monsters.get(index));
	}

	private void attackWizard() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		if (index != -1)
			wizard.attack(monsters.get(index));
	}

	private void attackHealer() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		if (index != -1)
			healer.attack(monsters.get(index));
	}

	private void skillWarrior() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		if (index != -1)
			warrior.skill(monsters.get(index));
	}

	private void skillWizard() {
		int index = -1;
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				index = i;
		}
		if (index != -1)
			wizard.skill(monsters.get(index));
	}

	private void skillHealer() {
		healer.skill(warrior);
	}

	private void finish() {
		isExit = true;
	}

	private boolean isBattle() {
		if (warrior.isDead() || wizard.isDead() || healer.isDead()) {
			isExit = true;
			return false;
		}

		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				return true;
		}

		return false;
	}

	private boolean isRun() {
		return isExit || count == 5 ? false : true;
	}

	private void printResult() {
		if (warrior.isDead() || wizard.isDead() || healer.isDead()) {
			System.err.println("전투중에 사망했어..");
		} else
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
