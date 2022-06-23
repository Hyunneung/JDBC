package statement.arraylist_동적쿼리1;

import java.util.ArrayList;
import java.util.Scanner;

public class CRUD {

	static String menus[] = { "사원번호", "사원이름", "직급", "매니저", "입사일자", "급여", "커미션", "부서번호", "종료" };

	public static void main(String[] args) {
		String[] search_word = menuselect();
		search(search_word);
	}

	// 메뉴 선택
	private static String[] menuselect() {
		Scanner sc = new Scanner(System.in);
		String[] search = new String[8];

		int i = 0;
		for (String menu : menus) {
			System.out.println(++i + ". " + menu);
		}

		int menu = 0;
		do {
			System.out.print("조회할 조건을 선택하세요>");
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

	// 메뉴 숫자 검사
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
					System.out.print("1~9사이의 숫자를 입력하세요>");
				}
			} catch (NumberFormatException nfe) {
				System.out.print("숫자로 입력하세요>");
			}
		} // while 끝
		return input;
	}

	// 컬럼 종료 여부 결정
	private static String input(int menu, Scanner sc) {
		String search_word = "";
		if (menu != 9)
			search_word = searchData(sc, menu);
		return search_word;
	}

	// 컬럼 선택 메소드
	private static String searchData(Scanner sc, int menu) {
		System.out.print("조회할 " + menus[menu - 1] + "을(를) 입력하세요>");
		return sc.nextLine();
	}

	// 조건에 맞는 데이터 검색 메소드
	private static void search(String[] search_word) {
		DAO dao = new DAO();
		ArrayList<Emp> emplist = dao.search(search_word);

		if (emplist == null) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.printf("%s\t%s\t%s\t\t%s\t%s\t\t%s\t%s\t%s\t\n", menus[0], menus[1], menus[2], menus[3],
					menus[4], menus[5], menus[6], menus[7]);
			System.out.println("------------------------------------------------------------------------------");
			for (Emp e : emplist) {
				System.out.println(e.toString());
			}
		} // if-else 끝
	}

}
