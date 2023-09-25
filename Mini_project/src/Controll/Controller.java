package Controll;

import java.util.*;

import Model.DTO;
import Model.asci;
import Model.talk;
import javazoom.jl.player.MP3Player;

public class Controller {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> li = new ArrayList<>();
	DAO dao = new DAO();
	asci as = new asci();
	talk t = new talk();
	String id;
	String pw;
	String name;
	int cls;
	int sum = 0;

	String[] ssam = { "상추", "깻잎", "배추", "라이스페이퍼", "냅킨" };
	String[] meat = { "삼겹살", "소고기", "목살", "베이컨", "닭다리", "닭가슴살", "코다리", "돼지머리" };
	String[] other = { "마늘", "양파", "고추", "쌈무", "당근", "김치", "토하젓", "밥", "올리브", "파프리카", "대파", "콩나물", "오이", "소시지", "레몬",
			"먹태깡", "고수", "초코", "새우젓", "취두부", "생강", "토마토", "아보카도" };
	String[] source = { "쌈장", "된장", "고추장", "고추냉이", "겨자", "초장", "소금", "후추", "간장", "케챱", "데리야끼", "머스타드", "핫소스", "캡사이신" };
	String[] drink = { "소주", "맥주", "막걸리", "와인", "생수", "콜라/사이다/환타" };

	public int join(String id, String pw, String name) {
		return dao.join(id, pw, name);
	}

	public boolean log(String id, String pw) {
		return dao.log(id, pw);
	}

	public void setUser(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public void setCls(int n) {
		cls = n;
	}

	public void start() {
		
		if(cls==1) {
			t.Scenario(id);
			
		}else if(cls==2) {
			t.NormalScenario(id);
		}else {
			t.EasyScenario(id);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ssam();

	}

	public void ssam() {
		as.쌈();
		System.out.println("====1단계[쌈 고르기]====");
		int a = 1;
		for (String temp : ssam) {
			System.out.print(a++ + "." + temp + " ");
		}
		System.out.print(a + ".고기 고르기");
		System.out.println();
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 6) {
				break;
			} else if (n > 6) {
				System.out.println("잘못 입력하였습니다.");
			} else {
				System.out.println(ssam[n - 1]);
				arr[i] = (ssam[n - 1]);
				for (int j = 0; j < i; j++) {
					if (arr[i].equals(arr[j])) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			li.add(arr[i]);
		}
		meat();
	}

	public void meat() {
		as.고기();
		int a = 1;
		System.out.println("====2단계[고기 고르기]====");
		for (String temp : meat) {
			System.out.print(a++ + "." + temp + " ");
		}
		System.out.print(a + ".속재료 고르기");
		System.out.println();
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 9) {
				break;
			} else if (n > 9) {
				System.out.println("잘못 입력하였습니다.");
				i--;
			} else {
				System.out.println(meat[n - 1]);
				arr[i] = (meat[n - 1]);
				for (int j = 0; j < i; j++) {
					if (arr[i].equals(arr[j])) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			li.add(arr[i]);
		}
		other();
	}

	public void other() {
		as.고추();
		System.out.println("====3단계[속재료 고르기]====");
		int a = 1;
		for (String temp : other) {
			System.out.print(a++ + "." + temp + " ");
		}
		System.out.print(a + ".소스 고르기");
		System.out.println();
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 24) {
				break;
			} else if (n > 24) {
				System.out.println("잘못 입력하셨습니다.");
				i--;
			} else {
				System.out.println(other[n - 1]);
				arr[i] = (other[n - 1]);
				for (int j = 0; j < i; j++) {
					if (arr[i].equals(arr[j])) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			li.add(arr[i]);
		}
		source();
	}

	public void source() {
		as.소스();
		System.out.println("====4단계[소스 고르기]====");
		int a = 1;
		for (String temp : source) {
			System.out.print(a++ + "." + temp + " ");
		}
		System.out.print(a + ".음료 고르기");
		System.out.println();
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 15) {
				break;
			} else if (n > 15) {
				System.out.println("잘못 입력하였습니다.");
				i--;
			} else {
				System.out.println(source[n - 1]);
				arr[i] = (source[n - 1]);
				for (int j = 0; j < i; j++) {
					if (arr[i].equals(arr[j])) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			li.add(arr[i]);
		}
		drink();
	}

	public void drink() {
		as.유리컵();
		System.out.println("====5단계[같이 마실 음료 고르기]====");
		int a = 1;
		for (String temp : drink) {
			System.out.print(a++ + "." + temp + " ");
		}
		System.out.print(a + ".선택 종료");
		System.out.println();
		String[] arr = new String[3];
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 7) {
				break;
			} else if (n > 7) {
				System.out.println("잘못 입력하였습니다.");
			} else {
				System.out.println(drink[n - 1]);
				arr[i] = (drink[n - 1]);
				for (int j = 0; j < i; j++) {
					if (arr[i].equals(arr[j])) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			li.add(arr[i]);
		}
		sum = dao.sum(li);
	}

	public void sum() {
		System.out.println(sum);
	}

	public int getSum() {
		return sum;
	}

	public String getRank() {
		return dao.singleRank(id);
	}

	public void check() {
		if (cls == 1) {
			if (li.contains("상추") && li.contains("마늘") && li.contains("소주") && (sum > 3000)
					|| li.contains("상추") && li.contains("쌈장") && li.contains("생수") && (sum > 2500) || (sum > 3500)) {
				먹는소리();
				as.박수();
				성공노래();
				t.SucScenario(id);
			} else {
				먹는소리();
				as.Bad();
				실패노래();
				t.FailScenario(id);
				sum = 0;
			}
		} else if (cls == 2) {
			if (li.contains("상추") && li.contains("쌈장") && (sum > 2500)
					|| li.contains("배추") && li.contains("마늘") && (sum > 1500) || (sum >= 3000)) {
				먹는소리();
				as.GOOD();
				성공노래();
				t.NormalSucScenario(id);
			} else {
				먹는소리();
				as.Bad();
				실패노래();
				t.NormalFailScenario(id);
				sum = 0;
			}
		} else {
			if ((li.contains("상추") && (sum > 800)) || (li.contains("배추") && (sum > 1000)) || (sum >= 1500)) {
				먹는소리();
				as.GOOD();
				성공노래();
				t.EasySucScenario(id);
			} else {
				먹는소리();
				as.Bad();
				실패노래();
				t.EasyFailScenario(id);
				sum = 0;
			}

		}
	}

	public void update(int sum) {
		if (dao.getNum(id) < sum) {
			dao.setNum(sum, id);
		}
	}

	public ArrayList<DTO> rankAll() {
		return dao.rankAll();
	}
	
	MP3Player player;

	public void 시작노래() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("긴장감 브금.mp3");

	}

	public void 성공노래() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("호응+휘파람.mp3");

	}

	public void 실패노래() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("좌절 브금(두둥..).mp3");

	}

	public void 먹는소리() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("씹는 소리.mp3");

	}

}
