package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StageBattle extends Stage {
	private final int BATTLE = 1;
	private final int FINISH = 2;

	private final int ATTACK = 1;
	private final int SKILL = 2;

	private Random ran = new Random();
	private boolean isExit;
	private boolean isWin;
	SetMonster setMonseter = new SetMonster();
	Guild guild = new Guild();
	static Map<Integer, Monster> monsters = new HashMap<>();

	@Override
	public boolean update() {
		isWin = false;
		isExit = false;
		while (!isExit) {
			printMenu();
			int sel = Game.inputNumber("메뉴");
			runMenu(sel);
		}
		if (isWin)
			Game.nextStage = "WIN";
		else if (!isWin)
			Game.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {

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
			while (!isExit) {
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
		System.out.println("═══════════[BATTLE]════════════");
		System.out.println("=====[PLAYER]====");
		for (int i = 0; i < Guild.players.size(); i++)
			System.out.println(Guild.players.get(i));
		System.out.println("=====[MONSTER]====");
		for (int i = 0; i < monsters.size(); i++)
			System.out.println(monsters.get(i));
	}

	private void battle() {
		for (int i = 0; i < Guild.players.size(); i++) {
			int monDead = checkMonster();
			int playerDead = checkPlayer();
			if (monDead == monsters.size() || playerDead == 1) {
				isWin = true;
				isExit = true;
				return;
			}
			if (Guild.players.get(i).isSilence())
				System.err.println("침묵상태로 인한 스킬사용 불가능");
			if (!Guild.players.get(i).isStun()) {
				printBattleMenu();
				runBattle(option(), Guild.players.get(i));
			} else if (Guild.players.get(i).isStun()) {
				System.err.println("스턴상태에서는 행동이 불가능합니다.");
				Guild.players.get(i).setIsStun(false);
			}
		}
	}

	private void runBattle(int select, Human human) {
		if (select == ATTACK)
			attack(human);
		else if (select == SKILL && !human.isSilence())
			skill(human);
		if (human.isSilence())
			human.setIsSilence(false);
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
		human.skill();
	}

	private void attackMonster() {
		for (int i = 0; i < monsters.size(); i++) {
			int dice = ran.nextInt(Guild.players.size());
			if (!monsters.get(i).isDead())
				monsters.get(i).attack(Guild.players.get(dice));
		}
	}

	private void finish() {
		isExit = true;
	}

	private int checkMonster() {
		int count = 0;
		for (int i = 0; i < monsters.size(); i++) {
			if (monsters.get(i).isDead())
				count++;
		}
		return count;
	}

	private int checkPlayer() {
		int count = 0;
		for (int i = 0; i < Guild.players.size(); i++) {
			if (Guild.players.get(i).isDead())
				count++;
		}
		return count;
	}
}
