package polyGame;

import java.util.Scanner;

public class Game {

	private Scanner scan = new Scanner(System.in);

	SetUnit SetUnit = new SetUnit();

	public Game() {

	}

	public int inputNumber(String message) {
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

}
