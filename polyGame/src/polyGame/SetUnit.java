package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SetUnit {
	private final int SIZE = 4;
	private Random ran = new Random();

	Map<Integer, Monster> monsters = new HashMap<>();
	String monster[] = { "MonsterWolf", "MonsterBat", "MonsterOrc" };
	Map<Integer, Human> players = new HashMap<>();
	String player[] = { "HumanWarrior", "HumanWizard", "HumanHealer" };

	public Map<Integer, Monster> drawMonster() {
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

	public Map<Integer, Human> setPlayer() {
		players = new HashMap<Integer, Human>();

		for (int i = 0; i < 3; i++) {
			try {
				Class<?> clazz = Class.forName("polyGame." + player[i]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Human temp = (Human) obj;
				players.put(i, temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return players;
	}
}
