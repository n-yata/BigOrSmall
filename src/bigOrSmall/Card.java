package bigOrSmall;

public class Card {
	private CardMark mark;
	private int number;

	public Card(CardMark mark, int number) {
		this.mark = mark;
		this.number = number;
	}

	public CardMark getMark() {
		return mark;
	}

	public int getNumber() {
		return number;
	}

	public String toString() {
		return "" + mark.getName() + number;
	}
}