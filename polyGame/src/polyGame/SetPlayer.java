package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class SetPlayer {
	private Scanner scan = new Scanner(System.in);
	private Random ran = new Random();

	Map<Integer, Human> players;
	Map<Integer, Human> guild;
	String player[] = { "HumanWarrior", "HumanWizard", "HumanHealer" };
	String human[] = { "HumanArcher", "HumanThief", "HumanMonk", "HumanDruid" };

	private int count;

	public SetPlayer() {
		players = new HashMap<>();
		guild = new HashMap<>();
		this.count = 0;

		players = setPlayer();
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

	public Map<Integer, Human> changePlayer() {
		for (int i = 0; i < 3; i++) {
			System.out.print(i + 1);
			System.out.println(players.get(i));
		}

		int index = inputNumber("플레이어선택") - 1;
		if (index < 0 || index >= players.size()) {
			System.err.println("잘못된 번호입니다.");
			return players;
		}

		for (int i = 0; i < guild.size(); i++) {
			System.out.println(guild.get(i));
		}
		int idx = inputNumber("길드원") - 1;
		if (index < 0 || index >= guild.size()) {
			System.err.println("잘못된 번호입니다.");
			return players;
		}

		players.put(index, guild.get(idx));
		System.out.println("플레이어가 교체되었어.");

		return players;
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

}
