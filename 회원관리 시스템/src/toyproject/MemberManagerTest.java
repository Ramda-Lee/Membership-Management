package toyproject;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberManagerTest {

	public static void main(String[] args) throws IOException {

		System.out.println("#############################");
		System.out.println("### ȸ�� ���� ���α׷� START ##");
		System.out.println("#############################");

		MemberManager mm = new MemberManager();

		while (true) {

			mm.readMenu();

			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();

			try {
				if (!(n >= 0 && n < 6)) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.println("�Էµ� ���� �߸��Ǿ����ϴ�.");
			}
			
			if (n == 1) {
				mm.MemberAllprint();
			} else if (n == 2) {
				mm.MemberInsert();
			} else if (n == 3) {
				mm.MemberUpdate();
			} else if (n == 4) {
				mm.MemberDelete();

			} else {
				mm.ExitProgram();
				
				sc.close();
				break;

			}
		}
	}
}
