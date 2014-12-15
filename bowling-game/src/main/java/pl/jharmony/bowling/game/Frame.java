package pl.jharmony.bowling.game;

public class Frame {
	
	protected int firstRoll;
	protected int secondRoll;

	public Frame(int firstRoll, int secondRoll) {
		this.firstRoll = firstRoll;
		this.secondRoll = secondRoll;
	}

	public int firstAndSecondRollScore() {
		return firstRoll + secondRoll;
	}

	public boolean hasSpare() {
		return firstRoll + secondRoll == 10;
	}

	public boolean hasStrike() {
		return firstRoll == 10;
	}

	public int calculateBonus(Frame nextOne, int totalBonus) {
		int bonus = 0;
		if (hasStrike()) {
			bonus = nextOne.firstAndSecondRollScore();
		} else if (hasSpare()) {
			bonus = nextOne.firstRoll;
		}
		return bonus;
	}
}
