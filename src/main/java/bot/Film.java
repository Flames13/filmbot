package bot;

public class Film 
{
	private String m_sTitle;
	private Integer m_iYear;
	private String m_sCountry;
	
	public Film(String sTitle, int iYear, String sCountry)
	{
		m_sTitle = sTitle;
		m_iYear = iYear;
		m_sCountry = sCountry;
	}
	
    @Override
    public boolean equals(Object obj) {
    if (obj == this) {
        return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
        return false;
    }

    Film other = (Film) obj;
    return (m_sTitle == other.m_sTitle
            || (m_sTitle != null && m_sTitle.equals(other.getTitle()))) && (m_iYear == other.m_iYear
            || (m_iYear != null && m_iYear.equals(other.getYear())))&& (m_sCountry == other.m_sCountry
            || (m_sCountry != null && m_sCountry.equals(other.getCountry())));
    }
    
    @Override
    public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((m_sTitle == null) ? 0 : m_sTitle.hashCode());             
    result = prime * result + ((m_iYear == null) ? 0 : m_iYear.hashCode()); 
    result = prime * result + ((m_sCountry == null) ? 0 : m_sCountry.hashCode()); 
    return result;
    }
	
	public String getFilmInfo()
	{
		return String.format("title: %s, country: %s, year: %d", m_sTitle, m_sCountry, m_iYear);
	}
	
	public Integer getYear() 
	{
		return m_iYear;
	}
	
	public String getCountry()
	{
		return m_sCountry;
	}
	
	public String getTitle()
	{
		return m_sTitle;
	}
	

}
