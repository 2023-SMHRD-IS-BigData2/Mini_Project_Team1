package Mini_project;

public class 점수기준에따른결과값 {

	public static void main(String[] args) {
boolean result = Operation();
		
		if(result) {
			//성공결과 메소드 출력
		}else {
			//실패결과 메소드 출력
		}
		
		boolean nresult = NormalOperation();
		
		if(nresult) {
			//성공결과 메소드 출력
		}else {
			//실패결과 메소드 출력
		}
		
		boolean hresult = HardOperation();
		
		if(hresult) {
			//성공결과 메소드 출력
		}else {
			//실패결과 메소드 출력
		}

	}
	
	public static boolean Operation() {
		String[] needs = {"상추","배추"};//무조건 포함해야 할 재료들
		int num = 0;//최종 점수
		boolean EasyResult = true;
		EasyResult = needs[0].contains("상추")&&(num>800)||needs[1].contains("배추")&&(num>1000)||(num>=1500);
		return EasyResult;
	}
	
	
	
	
	public static boolean NormalOperation() {
		String[] needs = {"상추","배추","쌈장","마늘"};
		int num = 0;
		boolean NormalResult = true;
		NormalResult = needs[0].contains("상추")&&needs[2].contains("쌈장")&&(num>2500)||needs[1].contains("배추")&&needs[3].contains("마늘")||(num>2000)||(num>=3000);
		return NormalResult;
	}
	
	public static boolean HardOperation() {
		String[] needs = {"상추","배추","쌈장","마늘","소주","생수"};
		int num = 0;
		boolean HardResult = true;
		HardResult = needs[0].contains("상추")&&needs[3].contains("마늘")&&needs[4].contains("소주")&&(num>3000)||needs[0].contains("상추")&&needs[2].contains("쌈장")&&needs[5].contains("생수")&&(num>2500)||(num>3500);
		return HardResult;
	}

}
