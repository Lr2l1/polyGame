package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SetMonter {
	private final int SIZE = 4;
	
	private Random ran = new Random();
	Map<Integer, Monster> monsters = new HashMap<Integer, Monster>();
	String monster[] = { "Wolf", "Bat", "Orc" };
	
	private void drawMonster() {
		for (int i = 0 ; i < SIZE ; i ++) {
			int dice = ran.nextInt(monster.length);
			
			try {
				Class<?> clazz = Class.forName(monster[dice]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Monster temp = (Monster) obj;
				monsters.put(i,temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
