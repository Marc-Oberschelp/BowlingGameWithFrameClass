import java.util.Vector;

class BowlingGame
{
    private Vector<Frame> frames = new Vector<>();

    void addFrame(Frame frame)
    {
       frames.add(frame);
    }

    int getFirstScoreOfFrame()
    {
        int score = 0;
        for( int currentFrame = 0; currentFrame < 10; ++currentFrame)
        {
            Frame frame = frames.get(currentFrame);
            if(isSpare(frame) && nextFrameInRange(currentFrame + 1))
            {
                score += getFirstScoreOfFrame(currentFrame + 1);
            }
            if(isStrike(frame) && nextFrameInRange(currentFrame + 1))
            {
                Frame nextFrame = frames.get(currentFrame + 1);
                if (isStrike(nextFrame) && nextFrameInRange(currentFrame + 2))
                {
                    score += getFirstScoreOfFrame(currentFrame + 2);
                }
                score += nextFrame.getScore();
            }
            score += frame.getScore();
        }
        return score;
    }

    private int getFirstScoreOfFrame(int frameIndex)
    {
        Frame nextFrame = frames.get(frameIndex);
        return nextFrame.getFirstScore();
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
