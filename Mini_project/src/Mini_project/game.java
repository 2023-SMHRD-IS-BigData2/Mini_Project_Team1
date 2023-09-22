package Mini_project;

import java.util.ArrayList;
import java.util.Scanner;

public class game {
	Scanner sc = new Scanner(System.in);
	ArrayList<String> li = new ArrayList<>();//ArrayList 이름 : li
	String[]ssam = {"상추","깻잎","배추","라이스페이퍼","냅킨"};
	String[]meat = {"삼겹살","소고기","목살","베이컨","닭다리","닭가슴살","코다리","돼지머리"};
	String[]other = {"마늘","양파","고추","쌈무","당근","김치","토하젓","밥","올리브","파프리카","대파","콩나물","오이","소시지","레몬","먹태깡","고수","초코","새우젓","취두부","생강","토마토","아보카도"};
	String[]source = {"쌈장","된장","고추장","고추냉이","겨자","초장","소금","후추","간장","케챱","데리야끼","머스타드","핫소스","캡사이신"};
	String[]drink = {"소주","맥주","막걸리","와인","생수","콜라/사이다/환타"}; 
	public void start() {
		//게임 시작
		ssam();
		
	}

	public void ssam() {//쌈 고르기 메소드
		//쌈 ascii 출력
		
		//쌈 종류 출력 + 다음으로 가기 버튼
		System.out.println("[1]상추 [2]꺳잎 [3]배추 [4]라이스페이퍼 [5]냅킨");
		//while 문 내부
		for(int i=0;i<3;i++) {
			int n=sc.nextInt();
			li.add(ssam[n-1]);
			for(int j=0;j<i;j++) {
				if(li.get(i).equals(li.get(j))) {
					System.out.println("중복선택하였습니다. 다시골라주세요");
					li.remove(i);
					i--;
				
				}
			}
			
		}
		
		//사용자가 뭘 넣을 건지 고르게,(가능하면 중복 불가하게)
		//고른거 하나하나 li에 저장
		//만약 다음으로 골랐다면 while문 break 하고 고기 메소드 호출
		
	}
	
	public void meat() {//고기고르기
		//고기 ascii 출력
		//고기 종류 출력 + 다음으로 가기 버튼
		System.out.println("[1]삼겹살 [2]소고기 [3]목살 [4]베이컨 [5]닭다리 [6]닭가슴살 [7]코다리 [8]돼지머리");
		//while 문 내부
		for(int i=0;i<3;i++) {
			int n = sc.nextInt();
			li.add(ssam[n-1]);
			for(int j=0;j<i;j++) {
				if(li.get(i).equals(li.get(j))) {
					System.out.println("중복선택하였습니다. 다시 골라주세요");
					li.remove(i);
					i--;
				}
				
			}
		}
		//사용자가 뭘 넣을 건지 고르게,(가능하면 중복 불가하게)
		//고른거 하나하나 li에 저장
		//만약 다음으로 골랐다면 while문 break 하고 속재료 메소드 호출
	}
	
	public void other() {//속재료
		System.out.println("[1]마늘 [2]양파 [3]고추 [4]쌈무 [5]당근 [6]김치 [7]토하젓 [8]밥 [9]올리브 [10]파프리카 [11]대파 [12] 콩나물 [13]오이 [13]소세지 [14]레몬 [15]먹태깡 [16]고수 [17]초코 [18]새우젓 [19]취두부 [20]생강 [21]토마토 [22]아보카도");
		for(int i=0;i<3;i++) {
			int n = sc.nextInt();
			li.add(other[n-1]);
			for(int j=0;j<i;j++) {
				if(li.get(i).equals(li.get(j))) {
					System.out.println("중복선택하였습니다. 다시 골라주세요");
				}
			}
		}
		//속재료 ascii 출력
		//속재료 종류 출력 + 다음으로 가기 버튼
		//while 문 내부
		//사용자가 뭘 넣을 건지 고르게,(가능하면 중복 불가하게)
		//고른거 하나하나 li에 저장
		//만약 다음으로 골랐다면 while문 break 하고 소스 메소드 호출
	}
	public void source() {
		//소스 ascii 출력
		
		//소스 종류 출력 + 다음으로 가기 버튼
		System.out.println("[1]쌈장 [2]된장 [3]고추장 [4]고추냉이 [5]겨자 [6]초장 [7]소금 [8]후추 [9]간장");
		for(int i=0;i<3;i++) {
			int n = sc.nextInt();
			li.add(source[n-1]);
			for(int j=0;j<i;j++) {
				if(li.get(i).equals(li.get(j))) {
					System.out.println("중복선택하였습니다. 다시 골라주세요");
				}
				
			}
		}
		//while 문 내부
		//사용자가 뭘 넣을 건지 고르게,(가능하면 중복 불가하게)
		//고른거 하나하나 li에 저장
		//만약 다음으로 골랐다면 while문 break 하고 음료 메소드 호출
	}
	public ArrayList<String> drink() {
		System.out.println("[1]소주 [2]맥주 [3]막걸리 [4]와인 [5]생수 [6]콜라/사이다/환타");
		for(int i=0;i<3;i++) {
			int n = sc.nextInt();
			li.add(drink[n-1]);
			for(int j=0;j<i;j++) {
				if(li.get(i).equals(li.get(j))) {
					System.out.println("중복선택하였습니다. 다시 골라주세요");
				}
			}
			
		}
		//음료 ascii 출력
		//음료 종류 출력 + 다음으로 가기 버튼
		//while 문 내부
		//사용자가 뭘 넣을 건지 고르게,(가능하면 중복 불가하게)
		//고른거 하나하나 li에 저장
		//만약 다음으로 골랐다면 while문 break 하고  메소드 호출
		return li;//li 리턴
	}
}
