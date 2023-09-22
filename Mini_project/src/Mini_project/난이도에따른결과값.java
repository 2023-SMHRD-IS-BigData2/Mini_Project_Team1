package Mini_project;

public class 난이도에따른결과값 {

	public static void main(String[] args) {
		boolean result = Opresult();
		if(result) {
			EasySuccess();
		}else {
			EasyFail();
		}// 하 난이도의 결과
		
		boolean nresult = Opresult2();
		if(nresult) {
			NormalSuccess();
		}else {
			NormalFail();
		}//중 난이도의 결과
		
		boolean hresult = Opresult3();
		if(hresult) {
			HardSuccess();
		}else {
			HardFail();
		}//상 난이도의 결과

	}
	public static boolean Opresult() {
		boolean EasyResult = true;//아직 결과값 받은게 없어서 true로 설정해 놓음
		return EasyResult;
	}
	
	static void EasySuccess() {
		성공 ES = new 성공();
		ES.하();
	}//하 난이도 성공 시 출력 메소드
	
	static void EasyFail() {
		실패 EF = new 실패();
		EF.하();
	}//하 난이도 실패 시 출력 메소드
	
	
	public static boolean Opresult2() {
		boolean NormalResult = true;
		return NormalResult;
	}
	
	static void NormalSuccess() {
		성공 NS = new 성공();
		NS.중();
	}// 중 난이도 성공 시 출력 메소드 
	static void NormalFail() {
		실패 NF = new 실패();
		NF.중();
	}// 중 난이도 실패 시 출력 메소드
	
	public static boolean Opresult3() {
		boolean HardResult = true;
		return HardResult;
	}
	
	static void HardSuccess() {
	   성공 HS = new 성공();
	   HS.상();
	}//상 난이도 성공 시 출력 메소드
	
	static void HardFail() {
		실패 HF = new 실패();
		HF.상();
	}// 상 난이도 실패 시 출력 메소드


	}


