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
        for( int currentFrame = 0; currentFrame < frames.size(); ++currentFrame)
        {
            Frame frame = frames.get(currentFrame);
            if(frame instanceof Spare)
            {
                if (nextFrameInRange(currentFrame + 1))
                {
                    Frame nextFrame = frames.get(currentFrame + 1);
                    score += nextFrame.spareBonus();
                }
            }
            score += frame.getScore();
        }
        return score;
    }

    private boolean nextFrameInRange(int frameIndex)
    {
        return frameIndex < frames.size();
    }
}
