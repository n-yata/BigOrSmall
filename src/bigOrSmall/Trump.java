package bigOrSmall;

import java.util.ArrayList;
import java.util.List;

public class Trump {
	List<Card> trumpList = new ArrayList<>();
	Card card;

	public void createDeck() {
		trumpList.clear();
		for (CardMark cm : CardMark.values()) {
			for (int j = 1; j < 14; j++) {
				card = new Card(cm, j);
				trumpList.add(card);
			}
		}
	}

	public Card draw() {
		int drawNum = new java.util.Random().nextInt(trumpList.size());
		return trumpList.remove(drawNum);
	}
}