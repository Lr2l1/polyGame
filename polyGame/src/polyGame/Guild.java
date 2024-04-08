package polyGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Guild {
	private Random ran = new Random();

	static Map<Integer, Human> players;
	static Map<Integer, Human> guild;
	String player[] = { "HumanWarrior", "HumanWizard", "HumanHealer" };
	String human[] = { "HumanArcher", "HumanThief", "HumanMonk", "HumanDruid" };

	private int count;

	public Guild() {
		players = new HashMap<>();
		guild = new HashMap<>();
		this.count = guild.size();

		players = setPlayer();
	}

	public Map<Integer, Human> setPlayer() {
		if (players.size() == 0) {
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
		} else
			return players;
	}

	public void printMenu() {
		System.out.println("═══════════[길드관리]════════════");
		System.out.println("[1. 플레이어목록] [2. 대기중인 플레이어] [3. 플레이어 교체]");
		System.out.println("[4. 길드원 뽑기] [0. 뒤로가기]");
		int sel = Game.inputNumber("메뉴");
		if (sel == 1)
			printPlayers();
		else if (sel == 2)
			printGuild();
		else if (sel == 3)
			changePlayer();
		else if (sel == 4)
			guildDraw();
		else if (sel == 0)
			return;
	}

	public void changePlayer() {
		printPlayers();
		int index = Game.inputNumber("플레이어선택") - 1;
		if (index < 0 || index >= players.size()) {
			System.err.println("잘못된 번호입니다.");
			return;
		}

		printGuild();
		int idx = Game.inputNumber("길드원") - 1;
		if (idx < 0 || idx >= guild.size()) {
			System.err.println("잘못된 번호입니다.");
			return;
		}

		Human temp = players.get(index);
		players.put(index, guild.get(idx));
		guild.put(idx, temp);
		System.out.println("플레이어가 교체되었어.");

	}

	public void guildDraw() {
		if (Human.money < 5000) {
			System.err.println("보유골드가 부족해서 길드원을 뽑을 수 없어!");
			return;
		}

		System.out.println("5000골드를 사용하여 길드원을 뽑을꺼야?");
		int sel = Game.inputNumber("예(1) 아니요(2)");

		if (sel == 1) {
			Human.money -= 5000;
			System.out.println("주사위 굴리기~");
			int dice = ran.nextInt(10)+1;

			System.out.printf("주사위 숫자가 %d가 나왔어~", dice);

			if (dice <= 4) {
				try {
					Class<?> clazz = Class.forName("polyGame." + human[0]);
					Object obj = clazz.getDeclaredConstructor().newInstance();
					Human temp = (Human) obj;
					guild.put(count, temp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (dice > 4 && dice <= 8) {
				try {
					Class<?> clazz = Class.forName("polyGame." + human[1]);
					Object obj = clazz.getDeclaredConstructor().newInstance();
					Human temp = (Human) obj;
					guild.put(count, temp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (dice == 9) {
				try {
					Class<?> clazz = Class.forName("polyGame." + human[2]);
					Object obj = clazz.getDeclaredConstructor().newInstance();
					Human temp = (Human) obj;
					guild.put(count, temp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (dice == 10) {
				try {
					Class<?> clazz = Class.forName("polyGame." + human[3]);
					Object obj = clazz.getDeclaredConstructor().newInstance();
					Human temp = (Human) obj;
					guild.put(count, temp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			System.out.printf("뽑힌 길드원은 %s~\n", guild.get(count).getName());
			count++;
		} else if (sel == 2)
			return;
	}

	public void printPlayers() {
		for (int i = 0; i < players.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + players.get(i).getName() + "]");
			System.out.print(" [레벨 : " + players.get(i).getLevel() + "]");
			System.out.println("[공격력 : " + players.get(i).getPower() + "]");
			System.out.print("\t[체력 : " + players.get(i).getHp());
			System.out.print(" / " + players.get(i).MAX_HP + "]");
			System.out.print(" [마나 : " + players.get(i).getMp());
			System.out.println(" / " + players.get(i).MAX_MP + "]");
		}
	}

	public void printGuild() {
		for (int i = 0; i < guild.size(); i++) {
			System.out.print("[" + (i + 1) + "번]");
			System.out.print(" [이름 : " + guild.get(i).getName() + "]");
			System.out.print(" [레벨 : " + players.get(i).getLevel() + "]");
			System.out.println("[공격력 : " + guild.get(i).getPower() + "]");
			System.out.print("[체력 : " + guild.get(i).getHp());
			System.out.print(" / " + guild.get(i).MAX_HP + "]");
			System.out.print(" [마나 : " + guild.get(i).getMp());
			System.out.println(" / " + guild.get(i).MAX_MP + "]");
		}
	}

	public void printWornItem(int num) {
		System.out.printf("[%s] 착용 아이템\n", players.get(num).getName());
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
