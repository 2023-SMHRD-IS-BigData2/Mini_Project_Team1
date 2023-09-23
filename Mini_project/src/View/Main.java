package View;

import java.util.ArrayList;
import java.util.Scanner;

import Controller.Controller;
import Controller.DAO;
import Model.DTO;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		view vw = new view();
		asci as = new asci();
		talk t = new talk();
		Controller con = new Controller();
		as.부장님();
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
				int row = dao.join(new DTO(name, pw, id));
				vw.row(row);
			} else if (n == 2) {
				String IId;
				String PPw;
				while (true) {
					System.out.println("id를 입력해주세요");
					String id = sc.next();
					IId = id;
					System.out.println("비밀번호를 입력해주세요");
					String pw = sc.next();
					PPw = pw;
					boolean isLogin = con.log(id, pw);
					if (isLogin) {
						break;
					} else {
						System.out.println("비밀번호가 틀렸습니다.");
					}
				}
				System.out.println("환영합니다!");
				con.setUser(IId, PPw);
				t.Synopsis();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("난이도를 결정해주세요.");
				System.out.println("1.상  2.중  3.하");
				int cls = sc.nextInt();
				con.setCls(cls);
				con.start();
				con.check();
				System.out.println("최종점수 : " + con.getSum());
				con.upd(con.getSum(), IId);
				System.out.println("1.메인 화면으로 돌아가기 2.다시 플레이하기 3.프로그램 종료");
				int a = sc.nextInt();
				if (a == 1) {
					as.부장님();
					continue;
				} else if (a == 2) {
					con.start();
				} else {
					break;
				}

			} else if (n == 3) {
				ArrayList<DTO> li = dao.rankAll();
				for (int i = 0; i < li.size(); i++) {
					System.out.print(i + 1 + "등 : " + li.get(i).getNickname() + "\t ");
					System.out.println(li.get(i).getScore()+"점");

				}
			}

			else {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
			}
		}
		System.out.println("프로그램 종료...");
	}

}
