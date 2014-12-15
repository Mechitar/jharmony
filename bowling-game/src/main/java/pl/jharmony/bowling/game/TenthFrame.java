package pl.jharmony.bowling.game;

public class TenthFrame extends Frame {

	private int thirdRoll;

	public TenthFrame(int firstRoll, int secondRoll, int thirdRoll) {
		super(firstRoll, secondRoll);
		this.thirdRoll = thirdRoll;
	}

	@Override
	public int calculateBonus(Frame nextOne, int totalBonus) {
		return totalBonus > 0 ? thirdRoll : 0;
	}
}
