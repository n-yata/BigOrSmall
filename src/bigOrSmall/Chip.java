package bigOrSmall;

public class Chip {
	private int chip_10;
	private int chip_1;
	private int sum;

	public Chip(int sum) {
		this.sum = sum;
		this.chip_10 = sum / 10;
		this.chip_1 = sum % 10;
	}

	public int getChips_10() {
		return chip_10;
	}

	public int getChips_1() {
		return chip_1;
	}

	public int getSum() {
		return sum;
	}

	public void addChip(int bet) {
		this.sum += bet;
		this.chip_10 = sum / 10;
		this.chip_1 = sum % 10;
	}

	public void subChip(int bet) {
		this.sum -= bet;
		this.chip_10 = sum / 10;
		this.chip_1 = sum % 10;
	}

	public String toString() {
		return "保有点" + sum + "([10]:" + chip_10 + "枚" + "[1]:" + chip_1 + "枚)";
	}
}