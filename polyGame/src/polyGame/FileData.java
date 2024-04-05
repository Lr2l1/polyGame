package polyGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileData {
	static public void save() {
		try {
			String fileName = "polyGame";
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file);

			String gameData = "";
			gameData += Human.money + "\n";
			gameData += Guild.players.size() + "\n";
			for (int i = 0; i < Guild.players.size(); i++) {
				gameData += Guild.players.get(i).className + "/";
				gameData += Guild.players.get(i).getHp() + "/";
				gameData += Guild.players.get(i).MAX_HP + "/";
				gameData += Guild.players.get(i).getPower() + "/";
				gameData += Guild.players.get(i).MAX_POWER + "/";
				gameData += Guild.players.get(i).isDead() + "/";
				gameData += Guild.players.get(i).getLevel() + "/";
				gameData += Guild.players.get(i).getMp() + "/";
				gameData += Guild.players.get(i).MAX_MP + "/";
				gameData += Guild.players.get(i).isStun() + "/";
				gameData += Guild.players.get(i).isSilence() + "/";

				if (Guild.players.get(i).getHelmet() != null) {
					gameData += Guild.players.get(i).getHelmet().kind + ",";
					gameData += Guild.players.get(i).getHelmet().name + ",";
					gameData += Guild.players.get(i).getHelmet().power + ",";
					gameData += Guild.players.get(i).getHelmet().price + "/";
				} else if (Guild.players.get(i).getHelmet() == null)
					gameData += Guild.players.get(i).getHelmet() + "/";
				if (Guild.players.get(i).getArmor() != null) {
					gameData += Guild.players.get(i).getArmor().kind + ",";
					gameData += Guild.players.get(i).getArmor().name + ",";
					gameData += Guild.players.get(i).getArmor().power + ",";
					gameData += Guild.players.get(i).getArmor().price + "/";
				} else if (Guild.players.get(i).getArmor() == null)
					gameData += Guild.players.get(i).getArmor() + "/";
				if (Guild.players.get(i).getRing() != null) {
					gameData += Guild.players.get(i).getRing().kind + ",";
					gameData += Guild.players.get(i).getRing().name + ",";
					gameData += Guild.players.get(i).getRing().power + ",";
					gameData += Guild.players.get(i).getRing().price;
				} else if (Guild.players.get(i).getRing() == null)
					gameData += Guild.players.get(i).getRing();
				gameData += "\n";
			}

			gameData += Guild.guild.size() + "\n";
			for (int i = 0; i < Guild.guild.size(); i++) {
				gameData += Guild.guild.get(i).className + "/";
				gameData += Guild.guild.get(i).getHp() + "/";
				gameData += Guild.guild.get(i).MAX_HP + "/";
				gameData += Guild.guild.get(i).getPower() + "/";
				gameData += Guild.guild.get(i).MAX_POWER + "/";
				gameData += Guild.guild.get(i).isDead() + "/";
				gameData += Guild.guild.get(i).getLevel() + "/";
				gameData += Guild.guild.get(i).getMp() + "/";
				gameData += Guild.guild.get(i).MAX_MP + "/";
				gameData += Guild.guild.get(i).isStun() + "/";
				gameData += Guild.guild.get(i).isSilence() + "/";
				if (Guild.guild.get(i).getHelmet() != null) {
					gameData += Guild.guild.get(i).getHelmet().kind + ",";
					gameData += Guild.guild.get(i).getHelmet().name + ",";
					gameData += Guild.guild.get(i).getHelmet().power + ",";
					gameData += Guild.guild.get(i).getHelmet().price + "/";
				} else if (Guild.guild.get(i).getHelmet() == null)
					gameData += Guild.guild.get(i).getHelmet() + "/";
				if (Guild.guild.get(i).getArmor() != null) {
					gameData += Guild.guild.get(i).getArmor().kind + ",";
					gameData += Guild.guild.get(i).getArmor().name + ",";
					gameData += Guild.guild.get(i).getArmor().power + ",";
					gameData += Guild.guild.get(i).getArmor().price + "/";
				} else if (Guild.guild.get(i).getArmor() == null)
					gameData += Guild.guild.get(i).getArmor() + "/";
				if (Guild.guild.get(i).getRing() != null) {
					gameData += Guild.guild.get(i).getRing().kind + ",";
					gameData += Guild.guild.get(i).getRing().name + ",";
					gameData += Guild.guild.get(i).getRing().power + ",";
					gameData += Guild.guild.get(i).getRing().price;
				} else if (Guild.guild.get(i).getRing() == null)
					gameData += Guild.guild.get(i).getRing();
				gameData += "\n";
			}

			gameData += Inventory.items.size() + "\n";

			for (int i = 0; i < Inventory.items.size(); i++) {
				gameData += Inventory.items.get(i).kind + "/";
				gameData += Inventory.items.get(i).name + "/";
				gameData += Inventory.items.get(i).power + "/";
				gameData += Inventory.items.get(i).price + "\n";
			}

			fw.write(gameData);
			fw.close();
			System.out.println("데이터 저장 성공~");
		} catch (Exception e) {
			System.err.println("데이터 저장 실패");
		}
	}

	static public void load() {
		String fileName = "polyGame";
		File file = new File(fileName);
		if (file.exists()) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				String money = br.readLine();
				Human.money = Integer.parseInt(money);

				int playerSize = Integer.parseInt(br.readLine());
				Guild.players.clear();

				for (int i = 0; i < playerSize; i++) {
					String playerData = br.readLine();
					String[] playerArr = playerData.split("/");
					try {
						Class<?> clazz = Class.forName("polyGame." + playerArr[0]);
						Object obj = clazz.getDeclaredConstructor().newInstance();
						Human temp = (Human) obj;
						Guild.players.put(i, temp);
					} catch (Exception e) {
						e.printStackTrace();
					}
					Guild.players.get(i).setHp(Integer.parseInt(playerArr[1]));
					Guild.players.get(i).MAX_HP = Integer.parseInt(playerArr[2]);
					Guild.players.get(i).setPower(Integer.parseInt(playerArr[3]));
					Guild.players.get(i).MAX_POWER = Integer.parseInt(playerArr[4]);
					String data = playerArr[5];
					boolean isDead = data.equals("false") ? false : true;
					Guild.players.get(i).setIsDead(isDead);
					Guild.players.get(i).setLevel(Integer.parseInt(playerArr[6]));
					Guild.players.get(i).setMp(Integer.parseInt(playerArr[7]));
					Guild.players.get(i).MAX_MP = Integer.parseInt(playerArr[8]);
					data = playerArr[9];
					boolean isStun = data.equals("false") ? false : true;
					Guild.players.get(i).setIsStun(isStun);
					data = playerArr[10];
					boolean isSilence = data.equals("false") ? false : true;
					Guild.players.get(i).setIsSilence(isSilence);

					if (!playerArr[11].equals("null")) {
						String playerItem[] = playerArr[11].split(",");
						Item item = new Item();
						int itemKind = Integer.parseInt(playerItem[0]);
						String itemName = playerItem[1];
						int itemPower = Integer.parseInt(playerItem[2]);
						int itemPrice = Integer.parseInt(playerItem[3]);

						item.kind = itemKind;
						item.name = itemName;
						item.power = itemPower;
						item.price = itemPrice;
						Guild.players.get(i).setHelmet(item);
					}

					if (!playerArr[12].equals("null")) {
						String playerItem[] = playerArr[12].split(",");
						Item item = new Item();
						int itemKind = Integer.parseInt(playerItem[0]);
						String itemName = playerItem[1];
						int itemPower = Integer.parseInt(playerItem[2]);
						int itemPrice = Integer.parseInt(playerItem[3]);

						item.kind = itemKind;
						item.name = itemName;
						item.power = itemPower;
						item.price = itemPrice;
						Guild.players.get(i).setArmor(item);
					}

					if (!playerArr[13].equals("null")) {
						String playerItem[] = playerArr[13].split(",");
						Item item = new Item();
						int itemKind = Integer.parseInt(playerItem[0]);
						String itemName = playerItem[1];
						int itemPower = Integer.parseInt(playerItem[2]);
						int itemPrice = Integer.parseInt(playerItem[3]);

						item.kind = itemKind;
						item.name = itemName;
						item.power = itemPower;
						item.price = itemPrice;
						Guild.players.get(i).setRing(item);
					}
				}

				Guild.guild.clear();
				int guildSize = Integer.parseInt(br.readLine());

				for (int i = 0; i < guildSize; i++) {
					String guildData = br.readLine();
					String[] guildArr = guildData.split("/");
					try {
						Class<?> clazz = Class.forName("polyGame." + guildArr[0]);
						Object obj = clazz.getDeclaredConstructor().newInstance();
						Human temp = (Human) obj;
						Guild.guild.put(i, temp);
					} catch (Exception e) {
						e.printStackTrace();
					}
					Guild.guild.get(i).setHp(Integer.parseInt(guildArr[1]));
					Guild.guild.get(i).MAX_HP = Integer.parseInt(guildArr[2]);
					Guild.guild.get(i).setPower(Integer.parseInt(guildArr[3]));
					Guild.guild.get(i).MAX_POWER = Integer.parseInt(guildArr[4]);
					String data = guildArr[5];
					boolean isDead = data.equals("false") ? false : true;
					Guild.guild.get(i).setIsDead(isDead);
					Guild.guild.get(i).setLevel(Integer.parseInt(guildArr[6]));
					Guild.guild.get(i).setMp(Integer.parseInt(guildArr[7]));
					Guild.guild.get(i).MAX_MP = Integer.parseInt(guildArr[8]);
					data = guildArr[9];
					boolean isStun = data.equals("false") ? false : true;
					Guild.guild.get(i).setIsStun(isStun);
					data = guildArr[10];
					boolean isSilence = data.equals("false") ? false : true;
					Guild.guild.get(i).setIsSilence(isSilence);

					if (!guildArr[11].equals("null")) {
						String playerItem[] = guildArr[11].split(",");
						Item item = new Item();
						int itemKind = Integer.parseInt(playerItem[0]);
						String itemName = playerItem[1];
						int itemPower = Integer.parseInt(playerItem[2]);
						int itemPrice = Integer.parseInt(playerItem[3]);

						item.kind = itemKind;
						item.name = itemName;
						item.power = itemPower;
						item.price = itemPrice;
						Guild.guild.get(i).setHelmet(item);
					}

					if (!guildArr[12].equals("null")) {
						String playerItem[] = guildArr[12].split(",");
						Item item = new Item();
						int itemKind = Integer.parseInt(playerItem[0]);
						String itemName = playerItem[1];
						int itemPower = Integer.parseInt(playerItem[2]);
						int itemPrice = Integer.parseInt(playerItem[3]);

						item.kind = itemKind;
						item.name = itemName;
						item.power = itemPower;
						item.price = itemPrice;
						Guild.guild.get(i).setArmor(item);
					}

					if (!guildArr[13].equals("null")) {
						String playerItem[] = guildArr[13].split(",");
						Item item = new Item();
						int itemKind = Integer.parseInt(playerItem[0]);
						String itemName = playerItem[1];
						int itemPower = Integer.parseInt(playerItem[2]);
						int itemPrice = Integer.parseInt(playerItem[3]);

						item.kind = itemKind;
						item.name = itemName;
						item.power = itemPower;
						item.price = itemPrice;
						Guild.guild.get(i).setRing(item);
					}
				}

				Inventory.items.clear();
				int itemSize = Integer.parseInt(br.readLine());
				for (int i = 0; i < itemSize; i++) {
					String itemData = br.readLine();
					String[] itemArr = itemData.split("/");
					Item item = new Item();
					int itemKind = Integer.parseInt(itemArr[0]);
					String itemName = itemArr[1];
					int itemPower = Integer.parseInt(itemArr[2]);
					int itemPrice = Integer.parseInt(itemArr[3]);

					item.kind = itemKind;
					item.name = itemName;
					item.power = itemPower;
					item.price = itemPrice;
					Inventory.items.add(item);

				}

				fr.close();
				br.close();
				System.out.println("게임 불러오는중..");
				System.out.println("게임 로드 성공");
			} catch (Exception e) {
				System.err.println("데이터 로드 실패");
			}
		}

	}
}