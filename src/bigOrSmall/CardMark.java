package bigOrSmall;

public enum CardMark {
	CLUB("クラブ", 0), DIAMOND("ダイヤ", 1), HEART("ハート", 2), SPADE("スペード", 3);

	private final String name;
	private final int strength;

	private CardMark(String name, int strength) {
		this.name = name;
		this.strength = strength;
	}

	public String getName() {
		return name;
	}

	public int getStrength() {
		return strength;
	}
}