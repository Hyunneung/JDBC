package preparedstatement;

import java.util.ArrayList;

public class CRUD {

	static String menus[] = { "�����ȣ", "����̸�", "����", "�Ŵ���", "�Ի�����", "�޿�", "Ŀ�̼�", "�μ���ȣ", "����" };

	public static void main(String[] args) {
		 selectALL();
	}
	
	private static void selectALL() {
		DAO dao = new DAO();
		ArrayList<Emp> emplist = dao.selectAll();
		
		if(emplist == null) {
			System.out.println("�˻� ����� �����ϴ�.");
		} else {
			System.out.printf("%s\t%s\t%s\t\t%s\t%s\t\t%s\t%s\t%s\t\n", 
					menus[0], menus[1], menus[2], menus[3], menus[4], menus[5], menus[6], menus[7]);
			System.out.println("------------------------------------------------------------------------------");
			for (Emp e : emplist) {
				System.out.println(e.toString());
			}
		} // if-else ��
	} // selectALL() ��
}
