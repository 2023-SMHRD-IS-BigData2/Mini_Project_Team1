package Mini_project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// view
		Scanner sc = new Scanner(System.in);
		Controller con = new Controller();
		MiniDAO dao = new MiniDAO();

		while (true) {
			System.out.println("1.회원가입 2.로그인 3.전체랭크확인");
			int n = sc.nextInt();
			if (n == 1) {
				System.out.print("id 입력 : ");
				String id = sc.next();
				System.out.print("pw 입력 : ");
				String pw = sc.next();
				System.out.print("이름 입력 : ");
				String name = sc.next();

				int row = dao.join(new MiniDTO(name, pw, id));
				if (row > 0) {
					System.out.println("완료");
				} else {
					System.out.println("실패");
				}
			} else if (n == 2) {
				System.out.println("id를 입력해주세요");
				String id = sc.next();
				System.out.println("비밀번호를 입력해주세요");
				String pw = sc.next();
				boolean isLogin = dao.login(id, pw);
				if (isLogin == true) {
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패");
				}
			} else if (n == 3) {
				ArrayList<MiniDTO> li = con.returnRankAll();
				for (int i = 0; i < li.size(); i++) {
					System.out.print(i + 1 + "등 : " + li.get(i).getId() + " ");
					System.out.println(li.get(i).getScore());
				}
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}

	}
	
	

}
