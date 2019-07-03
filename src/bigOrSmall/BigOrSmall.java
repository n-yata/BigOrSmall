package bigOrSmall;

import java.util.InputMismatchException;

public class BigOrSmall {
	Chip chip;
	Card prev; //先に引いたカード
	Card follow; //後に引いたカード
	Trump trump;
	private int bet;
	private int bs; //Big = 0, Small = 1
	private String bigSmall;
	private boolean doubleUp = false;

	public void start() {
		chip = new Chip(100);
		trump = new Trump();
		trump.createDeck();
		prev = trump.draw();
		while (true) {
			if (chip.getSum() <= 0) {
				System.out.println("チップが0枚になりました。 GAME OVER");
				System.exit(0);
			}
			if (!doubleUp) {
				bet = betChip();
				chip.subChip(bet);
			} else {
				prev = follow;
			}
			info();
			bs = choiseBigSmall();
			switch (bs) {
			case 0:
				bigSmall = "Big";
				break;
			case 1:
				bigSmall = "Small";
				break;
			}
			follow = trump.draw();
			if (result()) {
				System.out.println("Win!!");
				bet *= 2;
				System.out.println("チップ" + bet + "枚を獲得しました");
				if (choiseDoubleUp()) {
					doubleUp = true;
				} else {
					doubleUp = false;
					chip.addChip(bet);
					bet = 0;
					if (choiseContinue()) {
						trump.createDeck();
						prev = trump.draw();
					} else {
						info();
						System.out.println("END");
						System.exit(0);
					}
				}
			} else {
				System.out.println("Lose...");
				bet = 0;
				doubleUp = false;
				info();
				if (choiseContinue()) {
					trump.createDeck();
					prev = trump.draw();
				} else {
					info();
					System.out.println("END");
					System.exit(0);
				}
			}
		}
	}

	public void info() {
		System.out.println("*****チップ枚数とカード*****");
		System.out.println(chip);
		System.out.println("現在のカード: " + prev);
		System.out.println("*************************");
	}

	public int betChip() {
		while (true) {
			try {
				System.out.println("■BET枚数選択");
				System.out.println("BETするチップ枚数を入力してください(最低1〜最大20)");
				int input = new java.util.Scanner(System.in).nextInt();
				if (input > chip.getSum()) {
					System.out.println("BETするチップポイントは総計のチップポイント以下で入力してください");
				} else if (0 < input && input <= 20) {
					return input;
				} else {
					System.out.println("チップポイントは半角数字の1〜20を入力してください");
				}
			} catch (InputMismatchException e) {
				System.out.println("数字を正しく入力してください。");
			}
		}
	}

	public int choiseBigSmall() {
		while (true) {
			try {
				System.out.println("■Big or Small選択");
				System.out.println("現在のカード: " + prev);
				System.out.println("[Big or Small]: 0:Big 1:Small");
				int input = new java.util.Scanner(System.in).nextInt();
				if (0 <= input && input <= 1) {
					return input;
				} else {
					System.out.println("半角数字の0あるいは1のみ入力してください");
				}
			} catch (InputMismatchException e) {
				System.out.println("数字を正しく入力してください。");
			}
		}
	}

	public boolean result() {
		System.out.println("*******Big or Small*******");
		System.out.println("BET数: " + bet);
		System.out.println("あなたの選択: " + bigSmall);
		System.out.println("現在のカード: " + prev);
		System.out.println("引いたカード: " + follow);
		if (compare(prev, follow)) {
			System.out.println(follow + " は " + prev + " より Big");
		} else {
			System.out.println(follow + " は " + prev + " より Small");
		}
		System.out.println("**************************");
		if (compare(prev, follow)) {
			switch (bs) { // true = win, false = lose;
			case 0:
				return true;
			case 1:
				return false;
			}
		} else {
			switch (bs) {
			case 0:
				return false;
			case 1:
				return true;
			}
		}
		return false;
	}

	public boolean compare(Card prev, Card follow) { //result()の中で呼び出し
		if (prev.getNumber() == follow.getNumber()) {
			if (prev.getMark().getStrength() < follow.getMark().getStrength()) {
				return true;
			} else {
				return false;
			}
		}
		if (prev.getNumber() < follow.getNumber()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean choiseDoubleUp() {
		while (true) {
			try {
				System.out.println("[獲得したチップ" + bet + "枚でBig or Smallを続けますか？]: 0:Yes 1:No");
				int input = new java.util.Scanner(System.in).nextInt();
				switch (input) {
				case 0:
					return true;
				case 1:
					return false;
				default:
					System.out.println("半角数字の0あるいは1のみ入力してください");
				}
			} catch (InputMismatchException e) {
				System.out.println("数字を正しく入力してください。");
			}
		}
	}

	public boolean choiseContinue() {
		while (true) {
			try {
				System.out.println("[ゲームを続けますか？]: 0:Yes 1:No");
				int input = new java.util.Scanner(System.in).nextInt();
				switch (input) {
				case 0:
					return true;
				case 1:
					return false;
				default:
					System.out.println("半角数字の0あるいは1のみ入力してください");
				}
			} catch (InputMismatchException e) {
				System.out.println("数字を正しく入力してください。");
			}
		}
	}
}