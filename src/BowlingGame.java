import java.util.Vector;

class BowlingGame
{
    private Vector<Frame> frames = new Vector<>();

    void addFrame(Frame frame)
    {
       frames.add(frame);
    }

    int getScore()
    {
        int score = 0;
        for( int currentFrame = 0; currentFrame < 10; ++currentFrame)
        {
            Frame frame = frames.get(currentFrame);
            if(isSpare(frame) && nextFrameInRange(currentFrame + 1))
            {
                Frame nextFrame = frames.get(currentFrame + 1);
                score += nextFrame.spareBonus();
            }
            if(isStrike(frame) && nextFrameInRange(currentFrame + 1))
            {
                Frame nextFrame = frames.get(currentFrame + 1);
                score += nextFrame.strikeBonus();
            }
            score += frame.getScore();
        }
        return score;
    }

    private boolean isSpare(Frame frame)
    {
        return frame instanceof Spare;
    }

    private boolean isStrike(Frame frame)
    {
        return frame instanceof Strike;
    }

    private boolean nextFrameInRange(int frameIndex)
    {
        return frameIndex < frames.size();
    }
}
