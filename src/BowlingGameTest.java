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
        RollBalls(0, 0);
        assertEquals(0, g.getScore());
    }

    @Test
    public void ThrowAllFramesOnes()
    {
        RollBalls(1, 0);
        assertEquals(10, g.getScore());
    }

    private void RollBalls(int firstThrow, int secondThrow)
    {
        for (int i = 0; i < 10; ++i)
        {
            Frame frame = new NormalFrame(firstThrow, secondThrow);
            g.addFrame(frame);
        }
    }

    @Test
    public void ThrowASpare()
    {
        Spare frame = new Spare();
        g.addFrame(frame);
        assertEquals(10, g.getScore());
    }

    private BowlingGame g;
}
