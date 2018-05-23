class Frame
{
    public Frame(int firstThrow, int secondThrow)
    {
        m_firstThrow = firstThrow;
        m_secondThrow =  secondThrow;
    }

    public int getScore()
    {
        return m_firstThrow + m_secondThrow;
    }

    int m_firstThrow = 0;
    int m_secondThrow = 0;
}
