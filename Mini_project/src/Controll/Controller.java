package Controll;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Model.DTO;
import Model.asci;
import Model.talk;
import javazoom.jl.player.MP3Player;

public class Controller {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	ArrayList<String> li = new ArrayList<>();
	ArrayList<String> arr = new ArrayList<>();
	DAO dao = new DAO();
	asci as = new asci();
	talk t = new talk();
	String id;
	String pw;
	String name;
	int cls;
	int plus1= 0;
	int plus2= 0;
	int plus3= 0;
	int sum = 0;
	String[] hint = {"부장 취향 힌트!!", "추가점수!!", "속재료 선택 +1","고기 선택 +1","소스 선택 +1","-100"};
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
		as.찬스();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("두구두구...찬스는!!!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int n = rd.nextInt(hint.length);
		if(n==0) {
			if(cls==1) {
				as.부장입맛힌트();
				t.hardBujang();
			}else if(cls==2) {
				as.부장입맛힌트();
				t.nomalBujang();
			}else {
				as.부장입맛힌트();
				t.easyBujang();
			}
		}else if(n==1) {
			as.추가점수();
			t.plusScore();
			sum+=300;
		}else if(n==2) {
			as.재료추가();
			t.plusOther();
			plus1+=1;
		}else if(n==3) {
			as.재료추가();
			t.plusMeat();
			plus2+=1;
		}else if(n==4) {
			as.재료추가();
			t.plusSource();
			plus3+=1;
		}else if(n==5) {
			as.마이너스();
			t.minScore();
			sum-=100;
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 6) {
				break;
			} else if (n > 6) {
				System.out.println("잘못 입력하였습니다.");
			} else {
				System.out.println(ssam[n - 1]);
				arr.add(ssam[n-1]);
				for (int j = 0; j < i; j++) {
					if (arr.get(i).equals(arr.get(j))) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			li.add(arr.get(i));
		}
		li.clear();
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
		for (int i = 0; i < 3+plus2; i++) {
			int n = sc.nextInt();
			if (n == 9) {
				break;
			} else if (n > 9) {
				System.out.println("잘못 입력하였습니다.");
				i--;
			} else {
				System.out.println(meat[n - 1]);
				arr.add(meat[n-1]);
				for (int j = 0; j < i; j++) {
					if (arr.get(i).equals(arr.get(j))) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			li.add(arr.get(i));
		}
		arr.clear();
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
		for (int i = 0; i < 3+plus1; i++) {
			int n = sc.nextInt();
			if (n == 24) {
				break;
			} else if (n > 24) {
				System.out.println("잘못 입력하셨습니다.");
				i--;
			} else {
				System.out.println(other[n - 1]);
				arr.add(other[n-1]);
				for (int j = 0; j < i; j++) {
					if (arr.get(i).equals(arr.get(j))) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			li.add(arr.get(i));
		}
		arr.clear();
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
		for (int i = 0; i < 3+plus3; i++) {
			int n = sc.nextInt();
			if (n == 15) {
				break;
			} else if (n > 15) {
				System.out.println("잘못 입력하였습니다.");
				i--;
			} else {
				System.out.println(source[n - 1]);
				arr.add(source[n-1]);
				for (int j = 0; j < i; j++) {
					if (arr.get(i).equals(arr.get(j))) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			li.add(arr.get(i));
		}
		arr.clear();
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
		for (int i = 0; i < 3; i++) {
			int n = sc.nextInt();
			if (n == 7) {
				break;
			} else if (n > 7) {
				System.out.println("잘못 입력하였습니다.");
			} else {
				System.out.println(drink[n - 1]);
				arr.add(drink[n-1]);
				for (int j = 0; j < i; j++) {
					if (arr.get(i).equals(arr.get(j))) {
						System.out.println("중복 선택 하셨습니다.");
						i--;
					}
				}
			}
		}
		for (int i = 0; i < arr.size(); i++) {
			li.add(arr.get(i));
		}
		arr.clear();
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
			if (li.contains("상추") && li.contains("마늘") && li.contains("소주") && (sum >= 4000)
					|| li.contains("상추") && li.contains("쌈장") && li.contains("생수") && (sum > 3000) || (sum >= 5000)) {
				if(li.contains("배추")||li.contains("고추")||li.contains("목살")||li.contains("된장")||li.contains("맥주")) {
					먹는소리();
					as.Bad();
					실패노래();
					t.FailScenario(id);
					sum = 0;
				} else {
					먹는소리();
					as.GOOD();
					성공노래();
					t.SucScenario(id);
				}
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
	
	
	 MP3Player player = new MP3Player();
	 

	public void 시작노래() {

		if (player.isPlaying()) {
			player.stop();
		}
		
		player.play("./효과음/긴장감 브금.mp3");
		

	}

	public void 성공노래() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("./효과음/호응+휘파람.mp3");

	}

	public void 실패노래() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("./효과음/좌절 브금(두둥..).mp3");

	}

	public void 먹는소리() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("./효과음/씹는 소리.mp3");

	}
	
	public void 끝남() {

		if (player.isPlaying()) {
			player.stop();
		}

	}
	

	public static boolean containsString(String input,String...substrings) {
		for(String substring:substrings) {
			if(input.contains(substring)) {
				return true;
			}
		}
		return false;
	}


}
