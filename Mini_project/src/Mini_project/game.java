package Mini_project;

import java.util.ArrayList;

public class game {
	ArrayList<String> li = new ArrayList<>();//ArrayList 이름 : li
	asc2 as =new asc2();
	public void start() {
		//게임 시작
		ssam();
		
	}
	public void ssam() {//쌈 고르기 메소드
		//쌈 ascii 출력
		//쌈 종류 출력 + 다음으로 가기 버튼
		//while 문 내부
		//사용자가 뭘 넣을 건지 고르게,(가능하면 중복 불가하게)
		//고른거 하나하나 li에 저장
		//만약 다음으로 골랐다면 while문 break 하고 고기 메소드 호출
		
	}
	
	public void meat() {//고기고르기
		//고기 ascii 출력
		//고기 종류 출력 + 다음으로 가기 버튼
		//while 문 내부
		//사용자가 뭘 넣을 건지 고르게,(가능하면 중복 불가하게)
		//고른거 하나하나 li에 저장
		//만약 다음으로 골랐다면 while문 break 하고 속재료 메소드 호출
	}
	
	public void other() {//속재료
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
		//while 문 내부
		//사용자가 뭘 넣을 건지 고르게,(가능하면 중복 불가하게)
		//고른거 하나하나 li에 저장
		//만약 다음으로 골랐다면 while문 break 하고 음료 메소드 호출
	}
	public ArrayList<String> drink() {
		//음료 ascii 출력
		//음료 종류 출력 + 다음으로 가기 버튼
		//while 문 내부
		//사용자가 뭘 넣을 건지 고르게,(가능하면 중복 불가하게)
		//고른거 하나하나 li에 저장
		//만약 다음으로 골랐다면 while문 break 하고  메소드 호출
		return li;//li 리턴
	}
}
