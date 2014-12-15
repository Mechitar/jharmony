package pl.jharmony.bowling.game;

import java.util.List;

public class BowlingGame {

	private List<? extends Frame> frames;

	public BowlingGame withPlayerResults(List<Frame> frames) {
		this.frames = frames;
		return this;
	}

	public int calculateScore() {
		int score = 0;
		int totalBonus = 0;
		for (int i = 0; i < frames.size(); i++) {
			Frame currentFrame = frames.get(i);
			Frame nextFrame = getNextFrame(i);
			score += currentFrame.firstAndSecondRollScore();
			totalBonus += currentFrame.calculateBonus(nextFrame, totalBonus);
		}
		return score + totalBonus;
	}

	private Frame getNextFrame(int i) {
		return i < frames.size() - 1 ? frames.get(i + 1) : null;
	}

}
