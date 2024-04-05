package polyGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileData {
	static public void save() {
		try {
			String fileName = "polyGame";
			File file = new File(fileName);
			FileWriter fw = new FileWriter(file);

			String gameData = "";
			gameData += Human.money + "\n";
			gameData += Guild.players.size()+"\n";
			for (int i = 0; i < Guild.players.size(); i++) {
				gameData += Guild.players.get(i).getName() + " / ";
				gameData += Guild.players.get(i).getHp() + " / ";
				gameData += Guild.players.get(i).MAX_HP + " / ";
				gameData += Guild.players.get(i).getPower() + " / ";
				gameData += Guild.players.get(i).MAX_POWER + " / ";
				gameData += Guild.players.get(i).isDead() + " / ";
				gameData += Guild.players.get(i).getLevel() + " / ";
				gameData += Guild.players.get(i).getMp() + " / ";
				gameData += Guild.players.get(i).isStun() + " / ";
				gameData += Guild.players.get(i).isSilence() + " / ";
				gameData += Guild.players.get(i).getHelmet() + " / ";
				gameData += Guild.players.get(i).getArmor() + " / ";
				gameData += Guild.players.get(i).getRing();
				gameData += "\n";
			}

			gameData += Guild.guild.size()+"\n";
			for (int i = 0; i < Guild.guild.size(); i++) {
				gameData += Guild.guild.get(i).getName() + " / ";
				gameData += Guild.guild.get(i).getHp() + " / ";
				gameData += Guild.guild.get(i).MAX_HP + " / ";
				gameData += Guild.guild.get(i).getPower() + " / ";
				gameData += Guild.guild.get(i).MAX_POWER + " / ";
				gameData += Guild.guild.get(i).isDead() + " / ";
				gameData += Guild.guild.get(i).getLevel() + " / ";
				gameData += Guild.guild.get(i).getMp() + " / ";
				gameData += Guild.guild.get(i).isStun() + " / ";
				gameData += Guild.guild.get(i).isSilence() + " / ";
				gameData += Guild.guild.get(i).getHelmet() + " / ";
				gameData += Guild.guild.get(i).getArmor() + " / ";
				gameData += Guild.guild.get(i).getRing();
				gameData += "\n";
			}

			gameData += Inventory.items.size()+"\n";

			for (int i = 0; i < Inventory.items.size(); i++) {
				gameData += Inventory.items.get(i).kind + " / ";
				gameData += Inventory.items.get(i).name + " / ";
				gameData += Inventory.items.get(i).power + " / ";
				gameData += Inventory.items.get(i).price + "\n";
			}

			fw.write(gameData);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static public void load() {
		try {
			String fileName = "polyGame";
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			fr.close();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}