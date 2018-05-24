class Spare implements Frame
{
    Spare(int firstThrow)
    {
        m_firstThrow = firstThrow;
    }

    @Override
    public int getScore()
    {
        return 10;
    }

    @Override
    public int getFirstScore()
    {
        return m_firstThrow;
    }

    private int m_firstThrow;
}
