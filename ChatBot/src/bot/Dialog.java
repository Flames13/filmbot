package bot;


public class Dialog 
{
	/* ��� ����� ���������� � ���������� ������� ��� �������� ������� ���������� ��������
	 * 
	 * ����� ����� � ������� �����, ����������� ������
	 * 
	 * ����� ��������� ��������� ������, �������� ����������� �������
	 * 
	 * ����� ��������� ����������
	 * 
	 * */
	
	static String HELLO_TEXT = "�������� ����, ����������";
	
	static String HELP_TEXT = "���� ��� ������ ���� �� ����� ��������.\n"
			+ "������ �����:\n"
			+ "/y ���\n"
			+ "/c ������\n"
			+ "\n"
			+ "����� ���� ������� ������ ���� �����\n"
			+ "/next ��� ���������� ������\n"			
			+ "����� �������: /help\n"
			+ "���������� ����� �� ���� � �����������: /exit\n";
	
	private int iYear = 0;
	private String sCountry = null;
	private String sName = null;
	
	private String sCurrentOpt = null;
	
	
	public String startDialog(String name)
	{
		if (name.equals(sName))
			return String.format("����� �� ��������, %s.", name);
		sName = name;
		return String.format("����� ����������, %s.\n%s", name, HELP_TEXT);
	}
	
	
	
 	public String processInput(String input)
	{
		/*����� ������� �� ���������, ��� ���� ����*/
		
		if (input.equals("/help"))
			return HELP_TEXT;
		
		if (input.equals("/next")) 		
			return tryGetNextFilm();			
		
		if (input.length() < 3)
			return "������� �������� �������, �� ���� ������ :�";
		
		String option = input.substring(0, 3);
		switch (option) {
		case "/y ":
			return getNextYear(input);
			
		case "/c ":
			return getNextCountry();
		
		default:	
			return "����������� �������, �������, ����������, � �������";
		}
	}
 	
 	private String getNextYear(String input) 
 	{
 		try {
			int year = Integer.parseInt(input.substring(3).trim());
		} catch (NumberFormatException e) {
		     return "�� ��� ���, ��� ������ ���� ������";
		}
		sCurrentOpt = "year";
		return "";
		// ����� �� ���� ��� ��������� ��� �� ����� ���� ������� � ���� ���
 	}
 	
 	private String getNextCountry()
 	{
 		sCurrentOpt = "country";
		return "";
		// ����� �� ������ ��� ��������� ��� �� ������ ������� � ���� ���
 	}
 	
 	private String tryGetNextFilm(){
 		if (sCurrentOpt == null)
			return "������, ������� ������ �����, � ����� ����� �����";
		if (sCurrentOpt == "year")
			return "";
		if (sCurrentOpt == "country")
			return "";
		return ""; // �� ��� ��� ��� �� �� ���� ����������� ����. �����	
		// � ������ ��������� ���� ������ ���������
 		
 	}

}
