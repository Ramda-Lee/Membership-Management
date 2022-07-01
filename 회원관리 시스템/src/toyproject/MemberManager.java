package toyproject;

import java.util.Scanner;

public class MemberManager {

	int n = 0;
	Scanner sc = new Scanner(System.in);
	Member mb = new Member();
	MemberDAO dao = new MemberDAO();

	public void readMenu() {

		System.out.println("����� ���Ͻø� 1���� �Է��ϼ���.");
		System.out.println("����� ���Ͻø� 2���� �Է��ϼ���.");
		System.out.println("������ ���Ͻø� 3���� �Է��ϼ���.");
		System.out.println("������ ���Ͻø� 4���� �Է��ϼ���.");
		System.out.println("������ ���Ͻø� 0���� �Է��ϼ���.");

	}

	public void MemberAllprint() {
		dao.getMemberList();
	}

	public void MemberInsert() {

		System.out.print("���̵� �Է��ϼ��� (���� M-00001) : ");
		String Member_ID = sc.next();
		System.out.print("�̸��� �Է��ϼ��� : ");
		String Name = sc.next();
		System.out.print("��ȭ��ȣ�� �Է��ϼ��� : ");
		String Phone_number = sc.next();

		mb.setMember_ID(Member_ID);
		mb.setName(Name);
		mb.setPhone_number(Phone_number);
		dao.insertMember(Member_ID, Name, Phone_number);

	}

	public void MemberUpdate() {
		System.out.print("������ ���̵� �Է��ϼ��� (���� M-00001) : ");
		String Member_ID = sc.next();
		System.out.print("������ ��ȭ��ȣ�� �Է��ϼ��� : ");
		String Phone_number = sc.next();
		System.out.println("---> ȸ�������� �����Ͽ����ϴ�.");

		mb.setMember_ID(Member_ID);
		mb.setPhone_number(Phone_number);
		dao.updateMember(Phone_number, Member_ID);
	}

	public void MemberDelete() {
		System.out.println("������ ���̵� �Է��ϼ��� : ");
		String Member_ID = sc.next();
		System.out.println(Member_ID + "ȸ�� ������ �����ϼ̽��ϴ�.");

		mb.setMember_ID(Member_ID);
		dao.deleteMember(Member_ID);

	}

	public void ExitProgram() {

		System.out.println("#############################");
		System.out.println("### GOOD-BYE ���α׷� ���� ###");
		System.out.println("#############################");

	}

}
