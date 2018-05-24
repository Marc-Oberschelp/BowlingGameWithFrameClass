import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest
{
    @Before
    public void setUp()
    {
        g = new BowlingGame();
    }

    @Test
    public void SimpleFrameScore()
    {
        Frame frame = new NormalFrame(4,5);
        assertEquals(9,frame.getScore());
    }

    @Test
    public void ThrowAllZeros()
    {
        RollBalls(10,0, 0);
        assertEquals(0, g.getFirstScoreOfFrame());
    }

    @Test
    public void ThrowAllFramesOnes()
    {
        RollBalls(10,1, 0);
        assertEquals(10, g.getFirstScoreOfFrame());
    }

    private void RollBalls(int frameCount, int firstThrow, int secondThrow)
    {
        for (int i = 0; i < frameCount; ++i)
        {
            Frame frame = new NormalFrame(firstThrow, secondThrow);
            g.addFrame(frame);
        }
    }

    @Test
    public void ThrowASpare()
    {
        g.addFrame(new Spare(5));
        RollBalls(9,0,0);
        assertEquals(10, g.getFirstScoreOfFrame());
    }

    @Test
    public void ThrowASimpleFrameAfterASpare()
    {
        g.addFrame(new Spare(5));
        g.addFrame(new NormalFrame(8,0));
        RollBalls(8,0,0);
        assertEquals(26, g.getFirstScoreOfFrame());
    }

    @Test
    public void ThrowAPerfectSpareGame()
    {
        for (int i = 0; i<11;++i)
        {
            g.addFrame(new Spare(5));
        }
        assertEquals(150, g.getFirstScoreOfFrame());
    }

    @Test
    public void ThrowAStrike()
    {
        g.addFrame(new Strike());
        RollBalls(9,0,0);
        assertEquals(10, g.getFirstScoreOfFrame());
    }

    @Test
    public void ThrowASimpleFrameAfterAStrike()
    {
        g.addFrame(new Strike());
        g.addFrame(new NormalFrame(8,1));
        RollBalls(8,0,0);
        assertEquals(28, g.getFirstScoreOfFrame());
    }

    @Test
    public void ThrowAPerfectGame()
    {
        for (int i = 0; i<12;++i)
        {
            g.addFrame(new Strike());
        }
        assertEquals(300, g.getFirstScoreOfFrame());
    }

    @Test
    public void ThrowAStrikeStrikeSimpleFrameSequence()
    {
        g.addFrame(new Strike());
        g.addFrame(new Strike());
        g.addFrame(new NormalFrame(4,0));
        RollBalls(7,0,0);
        assertEquals(42,g.getFirstScoreOfFrame());
    }

    private BowlingGame g;
}
