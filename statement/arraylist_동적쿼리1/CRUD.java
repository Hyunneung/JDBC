package statement.arraylist_��������1;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {

	static String menus[] = { "�����ȣ", "����̸�", "����", "�Ŵ���", "�Ի�����", "�޿�", "Ŀ�̼�", "�μ���ȣ", "����" };

	public static void main(String[] args) {
		String[] search_word = menuselect();
		search(search_word);
	}

	// �޴� ����
	private static String[] menuselect() {
		Scanner sc = new Scanner(System.in);
		String[] search = new String[8];

		int i = 0;
		for (String menu : menus) {
			System.out.println(++i + ". " + menu);
		}

		int menu = 0;
		do {
			System.out.print("��ȸ�� ������ �����ϼ���>");
			menu = inputNumber(sc);

			if (menu == 9) {
				sc.close();
				break;
			}

			search[menu - 1] = searchData(sc, menu);
		} while (true);
		sc.close();
		return search;
	}

	// �޴� ���� �˻�
	private static int inputNumber(Scanner sc) {
		int input = 0;
		int lowNum = 1;
		int highNum = menus.length; // 9
		while (true) {
			try {
				input = Integer.parseInt(sc.nextLine());

				if (lowNum <= input && input <= highNum) {
					break;
				} else {
					System.out.print("1~9������ ���ڸ� �Է��ϼ���>");
				}
			} catch (NumberFormatException nfe) {
				System.out.print("���ڷ� �Է��ϼ���>");
			}
		} // while ��
		return input;
	}

	// �÷� ���� ���� ����
	private static String input(int menu, Scanner sc) {
		String search_word = "";
		if (menu != 9)
			search_word = searchData(sc, menu);
		return search_word;
	}

	// �÷� ���� �޼ҵ�
	private static String searchData(Scanner sc, int menu) {
		System.out.print("��ȸ�� " + menus[menu - 1] + "��(��) �Է��ϼ���>");
		return sc.nextLine();
	}

	// ���ǿ� �´� ������ �˻� �޼ҵ�
	private static void search(String[] search_word) {
		DAO dao = new DAO();
		ArrayList<Emp> emplist = dao.search(search_word);

		if (emplist == null) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			System.out.printf("%s\t%s\t%s\t\t%s\t%s\t\t%s\t%s\t%s\t\n", menus[0], menus[1], menus[2], menus[3],
					menus[4], menus[5], menus[6], menus[7]);
			System.out.println("------------------------------------------------------------------------------");
			for (Emp e : emplist) {
				System.out.println(e.toString());
			}
		} // if-else ��
	}

}
