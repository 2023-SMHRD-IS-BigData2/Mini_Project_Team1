package Main;
import java.util.ArrayList;
import java.util.Scanner;

import Controll.Controller;
import Model.DTO;
import Model.asci;
import Model.talk;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller con = new Controller();
		asci as = new asci();
		talk t = new talk();
		as.title();
		as.부장님();//부장님 얼굴 표현
		while(true) {
			System.out.println("1.회원가입 2.로그인 3.전체랭크 확인");
			int n = sc.nextInt();
			if(n==1) {
				System.out.print("id 입력 : ");
				String id = sc.next();
				System.out.print("pw 입력 : ");
				String pw = sc.next();
				System.out.print("이름 입력 : ");
				String name = sc.next();
				con.toString();
				if(con.join(id, pw, name)>0) {
					System.out.println("회원가입 완료");
				}else {
					System.out.println("회원가입 실패");
				}
				
			}else if(n==2) {
				String id;
				String pw;
				while(true) {
					System.out.println("id 를 입력해주세요");
					id = sc.next();
					System.out.println("비밀번호를 입력해주세요");
					pw = sc.next();
					if(con.log(id, pw)) {
						System.out.println("로그인 성공");
						break;
					}else {
						System.out.println("로그인 실패");
					}
					
				}
				con.setUser(id, pw);
				t.Synopsis(id);
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
				int sum = con.getSum();
				System.out.println("최종 점수 : "+sum);
				System.out.println("최종 랭킹 : "+con.getRank());
				con.update(sum);
				System.out.println("1.메인메뉴로 돌아가기 2.한번더 하기 3.종료하기");
				
				int a = sc.nextInt();
				if(a==1) {
					as.부장님();
					continue;
				}else if(a==2) {
					con.start();
				}else if(a==3) {
					break;
				}
			}else if(n==3) {
					ArrayList<DTO> al = con.rankAll();
					for(int i=0; i<al.size(); i++) {
						System.out.printf("%-2d등 : %15s  %6d 점",i+1,al.get(i).getId(),al.get(i).getScore());
						System.out.println();
				
				}
			}else {
				System.out.println("입력이 잘못되었습니다.");
			}
		}
		System.out.println("프로그램 종료...");
	}

}
