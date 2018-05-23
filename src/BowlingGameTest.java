import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest
{
    @Test
    public void SimpleFrameScore()
    {
        Frame frame = new Frame(4,5);
        assertEquals(9,frame.getScore());
    }

    @Test
    public void ThrowAllZeros()
    {
        BowlingGame g =  new BowlingGame();
        for(int i = 0; i<10;++i)
        {
            Frame frame = new Frame(0, 0);
            g.addFrame(frame);
        }
        assertEquals(0, g.getScore());
    }

    @Test
    public void ThrowAllFramesOnes()
    {
        BowlingGame g = new BowlingGame();
        for(int i = 0; i<10;++i)
        {
            Frame frame = new Frame(1, 0);
            g.addFrame(frame);
        }
        assertEquals(10, g.getScore());
    }
}
