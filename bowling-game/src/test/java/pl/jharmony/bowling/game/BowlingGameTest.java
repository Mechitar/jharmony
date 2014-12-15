package pl.jharmony.bowling.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class BowlingGameTest 
{
	@Test
	public void calculateScoreForOneFrame() throws Exception {
		assertEquals(8, new BowlingGame().withPlayerResults(createFrames(3,5)).calculateScore());
	}

	@Test
	public void calculateTwoFramesScore() throws Exception {
		assertEquals(10, new BowlingGame().withPlayerResults(createFrames(1,0,4,5)).calculateScore());
	}

	
	@Test
	public void calculateBonusForAStrike() throws Exception {
		assertEquals(28, new BowlingGame().withPlayerResults( createFrames(10,0,5,4)).calculateScore());
	}
	
	@Test
	public void calculateBonusForASpare() throws Exception {
		assertEquals(23, new BowlingGame().withPlayerResults(createFrames(5,5,4,5)).calculateScore());
	}
	
	@Test
	public void calculateOnesScore() throws Exception {
		assertEquals(1, new BowlingGame().withPlayerResults(createFrames(1)).calculateScore());
	}

	@Test
	public void considerThirdRollOfTheTenthFrame() throws Exception {
		assertEquals(22, new BowlingGame().withPlayerResults(createFrames(new TenthFrame(0,5,5), 10,0,1)).calculateScore());
	}
	
	@Test
	public void skipThirdRollOfTheTenthFrameIfThereWasNoBonus() throws Exception {
		assertEquals(7, new BowlingGame().withPlayerResults(createFrames(new TenthFrame(0,5,5), 1,0,1)).calculateScore());
	}
	
	private List<Frame> createFrames( TenthFrame lastFrame, int... pins) {
		List<Frame> frames = new ArrayList<Frame>();
		for (int i = 0; i < 18; i=i+2) {
			frames.add(new Frame(getPins(i, pins),getPins(i+1, pins)));
		}
		frames.add(lastFrame);
		return frames;
	}

	private List<Frame> createFrames(int... pins) {
		List<Frame> frames = new ArrayList<Frame>();
		for (int i = 0; i < 20; i=i+2) {
			frames.add(new Frame(getPins(i, pins),getPins(i+1, pins)));
		}
		return frames;
	}
	private int getPins(int i, int... pins) {
		return i < pins.length ? pins[i] : 0;
	}
}
