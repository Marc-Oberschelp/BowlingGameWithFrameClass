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
}
