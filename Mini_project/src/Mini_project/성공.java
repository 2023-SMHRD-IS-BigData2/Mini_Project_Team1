package Mini_project;

import java.util.Scanner;

public class 성공 {
	
	talk t = new talk();
	Controller con = new Controller();
	MiniDAO dao = new MiniDAO();
	MiniDTO dto = new MiniDTO();

	public void 상() {

		t.SucScenario();

	}

	public void 중() {

		t.NormalSucScenario();

	}

	public void 하() {

		t.EasySucScenario();

	}

	private void success() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("1.종료 2.재시작 3.랭킹확인");
			System.out.println("번호 입력 >> ");
			int n = sc.nextInt();

			if (n == 1) {

				System.out.println("게임 종료");

			} else if (n == 2) {

			} else if (n == 3) {

				String id = dto.getId();

				int num = rankSingle(id);

			} else {

				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");

			}
		}
	}

}
