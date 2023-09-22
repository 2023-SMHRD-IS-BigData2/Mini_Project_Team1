package Mini_project;

import java.util.Scanner;

public class 실패 {

<<<<<<< HEAD






=======
>>>>>>> branch 'master' of https://github.com/2023-SMHRD-IS-BigData2/Mini_Project_Team1.git
talk t = new talk();
Controller con = new Controller();
MiniDAO dao = new MiniDAO();
MiniDTO dto = new MiniDTO();

	public void 상() {

		t.FailScenario();

	}

	public void 중() {

		t.NormalFailScenario();

	}

	public void 하() {

		t.EasyFailScenario();

	}

	private void fail () {

		Scanner sc = new Scanner(System.in);

		System.out.println("1.종료 2.재시작 3.랭킹확인");
		System.out.println("번호 입력 >> ");
		int n = sc.nextInt();
		

		
		if (n == 1) {
			System.out.println("게임을 종료합니다.");
		} else if (n == 2) {
			
		} else if (n == 3) {

			String id = dto.getId();

			int num = rankSingle(id);
				
			} else {
			System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
			}

	}

}