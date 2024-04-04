package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StageBattle extends Stage {
	private final int SIZE = 4;

	private final int BATTLE = 1;
	private final int FINISH = 2;

	private final int ATTACK = 1;
	private final int SKILL = 2;

	private Random ran = new Random();
	private boolean isExit;
	private int count;
	SetMonster setMonseter = new SetMonster();
	Guild guild = new Guild();
	Map<Integer, Monster> monsters = new HashMap<>();
	Map<Integer, Human> players = new HashMap<>();

	@Override
	public boolean update() {
		while (isRun()) {
			printMenu();
			int sel = Game.inputNumber("메뉴");
			runMenu(sel);
		}
		return false;
	}

	@Override
	public void init() {
		players = guild.setPlayer();
		monsters = setMonseter.drawMonster();
	}

	private int option() {
		return Game.inputNumber("메뉴");
	}

	private void printMenu() {
		System.out.println("[1]전투");
		System.out.println("[2]종료");
	}

	private void runMenu(int select) {
		if (select == BATTLE) {

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

	private void playerInfo() {
		System.out.println("=====[BATTLE]====");
		System.out.println("=====[PLAYER]====");
		for (int i = 0; i < players.size(); i++)
			System.out.println(players.get(i));
		System.out.println("=====[MONSTER]====");
		for (int i = 0; i < SIZE; i++)
			System.out.println(monsters.get(i));
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

	private void runBattle(int select, Human human) {
		if (select == ATTACK)
			attack(human);
		else if (select == SKILL && !human.isSilence())
			skill(human);
	}

	private void attack(Human human) {

		while (true) {
			int dice = ran.nextInt(monsters.size());
			if (!monsters.get(dice).isDead()) {
				human.attack(monsters.get(dice));
				return;
			}

		}
	}

	private void skill(Human human) {
		if (human.equals(players.get(0))) {
			int dice = ran.nextInt(SIZE);
			human.skill(monsters.get(dice));
		} else if (human.equals(players.get(1))) {
			for (int i = 0; i < SIZE; i++) {
				if (!monsters.get(i).isDead())
					human.skill(monsters.get(i));
			}
		} else if (human.equals(players.get(2))) {
			for (int i = 0; i < 3; i++)
				human.skill(players.get(i));
		}
	}

	private void attackMonster() {
		for (int i = 0; i < SIZE; i++) {
			int dice = ran.nextInt(players.size());
			if (!monsters.get(i).isDead())
				monsters.get(i).attack(players.get(dice));
		}
	}

	private void finish() {
		isExit = true;
	}

	private boolean isBattle() {
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).isDead())
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

}
