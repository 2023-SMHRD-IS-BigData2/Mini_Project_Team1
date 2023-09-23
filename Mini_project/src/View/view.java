package View;
import java.util.Scanner;

import Controller.DAO;
public class view {
	Scanner sc = new Scanner(System.in);
	DAO dao = new DAO();
	

	
	public void row(int r) {
		if(r>0) {
			System.out.println("완료");
		}else {
			System.out.println("실패");
		}
	}
	
	public void log(boolean l) {
		if(l==true) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
	}
	public void ssam() {
		System.out.println("[1]상추 [2]꺳잎 [3]배추 [4]라이스페이퍼 [5]냅킨 [6]고기고르기");
	}
	
	public void mt() {
		System.out.println("[1]삼겹살 [2]소고기 [3]목살 [4]베이컨 [5]닭다리 [6]닭가슴살 [7]코다리 [8]돼지머리 [9]속재료 고르기");
	}
	
	public void ssok() {
		System.out.println("[1]마늘 [2]양파 [3]고추 [4]쌈무 [5]당근 [6]김치 \n[7]토하젓 [8]밥 [9]올리브 [10]파프리카 \n [11]대파 [12] 콩나물 \n[13]오이 [13]소세지 [14]레몬 [15]먹태깡 [16]고수 [17]초코 [18]새우젓 \n [19]취두부 [20]생강 [21]토마토 [22]아보카도 [23]소스 고르기");
	}
	
	public void sos() {
		System.out.println("[1]쌈장 [2]된장 [3]고추장 [4]고추냉이 [5]겨자 [6]초장 [7]소금 [8]후추 [9]간장 [10]음료고르기");

	}
	
	public void glass() {
		System.out.println("[1]소주 [2]맥주 [3]막걸리 [4]와인 [5]생수 [6]콜라/사이다/환타 [7]선택 종료");

	}
	
	public void same() {
		System.out.println("중복선택하였습니다. 다시 골라주세요");

	}
	
	public void rk() {
		System.out.println("최종 랭킹 : ");
	}
}
