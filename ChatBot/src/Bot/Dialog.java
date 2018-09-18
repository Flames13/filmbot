package Bot;


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
	
	static String help_text = "���� ��� ������ ���� �� ����� ��������.\n"
			+ "������ �����:\n"
			+ "/y ���\n"
			+ "/c ������\n"
			+ "\n"
			+ "����� ���� ������� ������ ���� �����\n"
			+ "/next ��� ���������� ������\n"			
			+ "����� �������: /help\n";
	
	private int iYear = 0;
	private String sCountry = null;
	
	private String sCurrentOpt = null;
	
	
	public String process_input(String input)
	{
		/*����� ������� �� ���������, ��� ���� ����*/
		
		if (input.equals("/help"))
			return help_text;
		if (input.equals("/next")) 
		{
			if (sCurrentOpt == null)
				return "������, ������� ������ �����, � ����� ����� �����";
			if (sCurrentOpt == "year")
				return "";
			if (sCurrentOpt == "country")
				return "";
			return ""; // �� ��� ��� ��� �� �� ���� ����������� ����. �����	
			// � ������ ��������� ���� ������ ���������
		}
		String option = input.substring(0, 3);
		if (option.equals("/y ")) 
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
		if (option.equals("/c "))
		{
			sCurrentOpt = "country";
			return "";
			// ����� �� ������ ��� ��������� ��� �� ������ ������� � ���� ���
		}
		return "����������� �������, �������, ����������, � �������";
	}

}
