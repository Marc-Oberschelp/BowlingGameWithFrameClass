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
        for( Frame frame : frames) score += frame.getScore();
        return score;
    }
}
