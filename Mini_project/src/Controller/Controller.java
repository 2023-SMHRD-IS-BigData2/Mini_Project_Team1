package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.DTO;
import View.asci;
import View.talk;
import View.view;

public class Controller {
	int cls;
	String id;
	String pw;
	String nick;
	asci as = new asci();
	view vw = new view();
	Scanner sc = new Scanner(System.in);
	DAO dao = new DAO();
	DTO dto = new DTO(id, pw);
	talk t = new talk();
	
	ArrayList<String> li = new ArrayList<>();// ArrayList 이름 : li
	int sum = 0;
	String[] ssam = { "상추", "깻잎", "배추", "라이스페이퍼", "냅킨" };
	String[] meat = { "삼겹살", "소고기", "목살", "베이컨", "닭다리", "닭가슴살", "코다리", "돼지머리" };
	String[] other = { "마늘", "양파", "고추", "쌈무", "당근", "김치", "토하젓", "밥", "올리브", "파프리카", "대파", "콩나물", "오이", "소시지", "레몬",
			"먹태깡", "고수", "초코", "새우젓", "취두부", "생강", "토마토", "아보카도" };
	String[] source = { "쌈장", "된장", "고추장", "고추냉이", "겨자", "초장", "소금", "후추", "간장", "케챱", "데리야끼", "머스타드", "핫소스", "캡사이신" };
	String[] drink = { "소주", "맥주", "막걸리", "와인", "생수", "콜라/사이다/환타" };
	
	
	public void setUser(String id, String pw) {
		this.id = id;
		this.pw = pw;
		nick = dao.getNick(id);
	}
	
	
	
	
	public void setCls(int Cls) {
		this.cls = Cls;
	}
	//난이도 결정
	
	
	public void start() {//시작
		// 게임 시작
		t.Scenario();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ssam();
		
	}
	
	public int getSum() {
		return sum;
	}
	public void ssam() {// 쌈 고르기 메소드
		// 쌈 ascii 출력
		as.쌈();
		// 쌈 종류 출력 + 다음으로 가기 버튼
		vw.ssam();

		String[] arr = new String[3];
		// while 문 내부
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 6) {
				break;
			}
			arr[i] = (ssam[n - 1]);
			for (int j = 0; j < i; j++) {
				if (arr[i].equals(arr[j])) {
					vw.same();
					i--;

				}
			}

		}
		for(int i=0; i<arr.length; i++) {
			li.add(arr[i]);
		}
		meat();
	}

	public void meat() {// 고기고르기
		as.고기();
		vw.mt();
		
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 9) {
				break;
			}
			arr[i] = (ssam[n - 1]);
			for (int j = 0; j < i; j++) {
				if (arr[i].equals(arr[j])) {
					vw.same();
					i--;

				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			li.add(arr[i]);
		}
		other();
	}

	public void other() {// 속재료
		as.양파();
		vw.ssok();
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 23) {
				break;
			}
			arr[i] = (ssam[n - 1]);
			for (int j = 0; j < i; j++) {
				if (arr[i].equals(arr[j])) {
					vw.same();
					i--;

				}
			}
			
		}
		for(int i=0; i<arr.length; i++) {
			li.add(arr[i]);
		}
		source();
	}

	public void source() {//소스
		as.소스();
		vw.sos();
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 10) {
				break;
			}
			arr[i] = (ssam[n - 1]);
			for (int j = 0; j < i; j++) {
				if (arr[i].equals(arr[j])) {
					vw.same();
					i--;

				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			li.add(arr[i]);
		}
		drink();
	}

	public void drink() {//음료
		as.유리컵();
		vw.glass();
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 7) {
				break;
			}
			arr[i] = (ssam[n - 1]);
			for (int j = 0; j < i; j++) {
				if (arr[i].equals(arr[j])) {
					vw.same();
					i--;

				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			li.add(arr[i]);
		}
		
		
	}
	
	public void top() {
		int osum = dao.getUser(dto.getId());
		if(sum>osum) {
			dao.setUser(sum, dto.getId());
		}
	}
	
	public boolean log(String id, String pw) {
		return dao.login(id, pw);
	}
	
	public void check() {
		sum = dao.sum(li);
		if(cls==1) {//상
			if(li.contains("상추")&&li.contains("마늘")&&li.contains("소주")&&(sum>3000)||li.contains("상추")&&li.contains("쌈장")&&li.contains("생수")&&(sum>2500)||(sum>3500)) {
				
				as.박수();
				t.SucScenario();
				
				//성공 메소드 출력
			}else{
				//실패 메소드 출력
				as.Bad();
				t.FailScenario();
				sum=0;
			}
		}else if(cls==2){//중
			if(li.contains("상추")&&li.contains("쌈장")&&(sum>2500)||li.contains("배추")&&li.contains("마늘")&&(sum>1500)||(sum>=3000)) {
				//성공 메소드 출력
				as.GOOD();
				t.NormalSucScenario();
			}else{
				//실패 메소드 출력
				as.Bad();
				t.NormalFailScenario();
				sum=0;
			}
		}else {//하
			if((li.contains("상추")&&(sum>800))||(li.contains("배추")&&(sum>1000))||(sum>=1500)) {
				//성공 메소드 출력
				as.GOOD();
				t.EasySucScenario();
			}else{
				//실패 메소드 출력
				as.Bad();
				t.EasyFailScenario();
			}
		}
		vw.rk();
		dao.rankSingle(id);
		
		
	}
	public void upd(int n, String id) {
		dao.setUser(n, id);
	}

}
