package polyGame;

public class Main {
	public static void main(String[] args) {
		boolean isRun = true;
		Game.instance.init();
		while (true) {
			isRun = Game.instance.changeStage();
			if (isRun == false) {
				break;
			}
		}
		System.out.println("게임 종료");
	}
}
