class NormalFrame implements Frame
{
    NormalFrame(int firstThrow, int secondThrow)
    {
        m_firstThrow = firstThrow;
        m_secondThrow =  secondThrow;
    }

    @Override
    public int getScore()
    {
        return m_firstThrow + m_secondThrow;
    }

    @Override
    public int spareBonus()
    {
        return m_firstThrow;
    }

    @Override
    public int strikeBonus()
    {
        return getScore();
    }

    private int m_firstThrow;
    private int m_secondThrow;
}
