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

	HumanHealer healer = new HumanHealer();
	HumanWarrior warrior = new HumanWarrior();
	HumanWizard wizard = new HumanWizard();

	SetUnit SetUnit = new SetUnit();

	Map<Integer, Monster> monsters = new HashMap<>();
	Map<Integer, Human> players = new HashMap<>();

	public Game() {
		this.count = 0;
		players = SetUnit.setPlayer();

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
			monsters = SetUnit.drawMonster();
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

	private void runBattle(int select, Human human) {
		if (select == ATTACK)
			attack(human);
		else if (select == SKILL && !healer.isSilence())
			skill(human);
	}

	private void attack(Human human) {
		int dice = ran.nextInt(monsters.size());
		human.attack(monsters.get(dice));
	}

	private void skill(Human human) {
		int dice = ran.nextInt(SIZE);
		human.skill(monsters.get(dice));
	}

	private void battle() {
		for (int i = 0; i < players.size(); i++) {
			if (!players.get(i).isStun()) {
				printBattleMenu();
				runBattle(option(), players.get(i));
			} else if (players.get(i).isStun()) {
				System.err.println("스턴상태에서는 행동이 불가능합니다.");
				players.get(i).setIsStun();
			}
		}
	}

	private void playerInfo() {
		System.out.println("=====[BATTLE]====");
		System.out.println("=====[PLAYER]====");
		for (int i = 0; i < players.size(); i++)
			System.out.println(players.get(i));
		System.out.println("=====[MONSTER]====");
		for (int i = 0; i < SIZE; i++)
			System.out.println(monsters.get(i));
	}

	private void attackMonster() {
		for (int i = 0; i < SIZE; i++) {
			int dice = ran.nextInt(players.size());
			if (!monsters.get(i).isDead())
				monsters.get(i).attack(players.get(dice));
		}
	}

	private void skillWarrior() {
		int dice = ran.nextInt(SIZE);
		warrior.skill(monsters.get(dice));
	}

	private void skillWizard() {
		for (int i = 0; i < SIZE; i++) {
			if (!monsters.get(i).isDead())
				wizard.skill(monsters.get(i));
		}
	}

	private void skillHealer() {
		for (int i = 0; i < 3; i++) {
			healer.skill(players.get(i));
		}
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
