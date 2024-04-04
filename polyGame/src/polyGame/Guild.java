package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Guild {
	private Random ran = new Random();

	Game game = new Game();

	Map<Integer, Human> players;
	Map<Integer, Human> guild;
	String player[] = { "HumanWarrior", "HumanWizard", "HumanHealer" };
	String human[] = { "HumanArcher", "HumanThief", "HumanMonk", "HumanDruid" };

	private int count;

	public Guild() {
		players = new HashMap<>();
		guild = new HashMap<>();
		this.count = 0;

		players = setPlayer();
	}

	public Map<Integer, Human> setPlayer() {
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

	public void printMenu() {
		System.out.println("=====================");
		System.out.println("[1. 플레이어목록] [2. 대기중인 플레이어] [3. 플레이어 교체]");
		System.out.println("[0. 뒤로가기]");
		int sel = game.inputNumber("메뉴");
		if (sel == 1)
			printPlayers();
		else if (sel == 2)
			printGuild();
		else if (sel == 3)
			changePlayer();
		else if (sel == 0)
			return;
	}

	public void changePlayer() {
		printPlayers();
		int index = game.inputNumber("플레이어선택") - 1;
		if (index < 0 || index >= players.size()) {
			System.err.println("잘못된 번호입니다.");
			return;
		}

		printGuild();
		int idx = game.inputNumber("길드원") - 1;
		if (index < 0 || index >= guild.size()) {
			System.err.println("잘못된 번호입니다.");
			return;
		}

		Human temp = players.get(index);
		players.put(index, guild.get(idx));
		guild.put(idx, temp);
		System.out.println("플레이어가 교체되었어.");

	}

	public void guildDraw() {
		System.out.println("주사위 굴리기~");
		int dice = ran.nextInt(10);

		System.out.printf("주사위 숫자가 %d가 나왔어~", dice);

		if (dice < 4) {
			try {
				Class<?> clazz = Class.forName("polyGame." + human[0]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Human temp = (Human) obj;
				players.put(count, temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dice >= 4 && dice < 8) {
			try {
				Class<?> clazz = Class.forName("polyGame." + human[1]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Human temp = (Human) obj;
				players.put(count, temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dice == 8) {
			try {
				Class<?> clazz = Class.forName("polyGame." + human[2]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Human temp = (Human) obj;
				players.put(count, temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (dice == 9) {
			try {
				Class<?> clazz = Class.forName("polyGame." + human[3]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Human temp = (Human) obj;
				players.put(count, temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.printf("뽑힌 길드원은 %s~\n", guild.get(count));
		count++;
	}

	public void printPlayers() {
		for (int i = 0; i < players.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + players.get(i).getName() + "]");
//		      System.out.print(" [레벨 : " + players.get(i).getLevel()l + "]");
			System.out.print(" [체력 : " + players.get(i).getHp());
			System.out.println(" / " + players.get(i).MAX_HP + "]");
			System.out.print(" [마나 : " + players.get(i).getMp());
			System.out.println(" / " + players.get(i).MAX_MP + "]");
			System.out.print("[공격력 : " + players.get(i).getPower() + "]");
			System.out.println();
		}
	}

	public void printGuild() {
		for (int i = 0; i < guild.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guild.get(i).getName() + "]");
//		      System.out.print(" [레벨 : " + players.get(i).getLevel()l + "]");
			System.out.print(" [체력 : " + guild.get(i).getHp());
			System.out.println(" / " + guild.get(i).MAX_HP + "]");
			System.out.print(" [마나 : " + guild.get(i).getMp());
			System.out.println(" / " + guild.get(i).MAX_MP + "]");
			System.out.print("[공격력 : " + guild.get(i).getPower() + "]");
			System.out.println();
		}
	}

	public void printWornItem(int num) {
		if (players.get(num).getHelmet() == null) {
			System.out.println("[헬멧 : 없음 ]");
		} else {
			System.out.printf("[헬멧 : %s\n", players.get(num).getHelmet().name);
		}
		if (players.get(num).getArmor() == null) {
			System.out.println("[방어구 : 없음 ]");
		} else {
			System.out.printf("[방어구 : %s\n", players.get(num).getArmor().name);
		}
		if (players.get(num).getRing() == null) {
			System.out.println("[반지 : 없음 ]");
		} else {
			System.out.printf("[반지 : %s\n", players.get(num).getRing().name);
		}
	}

}
