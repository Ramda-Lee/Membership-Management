package toyproject;

import java.util.Scanner;

public class MemberManager {

	int n = 0;
	Scanner sc = new Scanner(System.in);
	Member mb = new Member();
	MemberDAO dao = new MemberDAO();

	public void readMenu() {

		System.out.println("목록을 원하시면 1번을 입력하세요.");
		System.out.println("등록을 원하시면 2번을 입력하세요.");
		System.out.println("수정을 원하시면 3번을 입력하세요.");
		System.out.println("삭제을 원하시면 4번을 입력하세요.");
		System.out.println("종료을 원하시면 0번을 입력하세요.");

	}

	public void MemberAllprint() {
		dao.getMemberList();
	}

	public void MemberInsert() {

		System.out.print("아이디를 입력하세요 (형식 M-00001) : ");
		String Member_ID = sc.next();
		System.out.print("이름을 입력하세요 : ");
		String Name = sc.next();
		System.out.print("전화번호를 입력하세요 : ");
		String Phone_number = sc.next();

		mb.setMember_ID(Member_ID);
		mb.setName(Name);
		mb.setPhone_number(Phone_number);
		dao.insertMember(Member_ID, Name, Phone_number);

	}

	public void MemberUpdate() {
		System.out.print("수정할 아이디를 입력하세요 (형식 M-00001) : ");
		String Member_ID = sc.next();
		System.out.print("수정할 전화번호를 입력하세요 : ");
		String Phone_number = sc.next();
		System.out.println("---> 회원수정에 성공하였습니다.");

		mb.setMember_ID(Member_ID);
		mb.setPhone_number(Phone_number);
		dao.updateMember(Phone_number, Member_ID);
	}

	public void MemberDelete() {
		System.out.println("삭제할 아이디를 입력하세요 : ");
		String Member_ID = sc.next();
		System.out.println(Member_ID + "회원 삭제에 성공하셨습니다.");

		mb.setMember_ID(Member_ID);
		dao.deleteMember(Member_ID);

	}

	public void ExitProgram() {

		System.out.println("#############################");
		System.out.println("### GOOD-BYE 프로그램 종료 ###");
		System.out.println("#############################");

	}

}
