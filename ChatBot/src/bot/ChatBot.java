package bot;
import java.util.Scanner;


public class ChatBot {
	
	public static void main(String[] args) {
		// ������� ���� ������������� 
		
		Scanner scan = new Scanner(System.in);
		System.out.println(bot.Dialog.HELLO_TEXT);
		String name = scan.nextLine();
		bot.Dialog dialog = null;
		if (false) // name in base		
			dialog = null; // ��������� ������ �� ����		
		else 
			dialog = new bot.Dialog();
		System.out.println(dialog.startDialog(name));
		while (true) {
			String req = scan.nextLine();
			dialog.startDialog(req);
			if ("/exit".equals(req)) // <- �������� ���������� ������-���� � ����
				break;
			String answer = dialog.processInput(req);
			System.out.println(answer);

		}
	}

}
