package polyGame;

import java.util.HashMap;
import java.util.Map;

public class StageWin extends Stage {
	Map<Integer, Human> players = new HashMap<>();
	Guild guild = new Guild();

	@Override
	public boolean update() {
		System.out.println("승리~");
		
		for (int i = 0; i < Guild.players.size(); i++) {
			Guild.players.get(i).levelUp();
		}
		for (int i = 0; i < Guild.players.size(); i++)
			System.out.println(Guild.players.get(i));
		
		Game.nextStage = "LOBBY";
		return false;
	}

	@Override
	public void init() {
	
	}

}
