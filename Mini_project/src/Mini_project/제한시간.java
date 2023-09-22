package Mini_project;

public class 제한시간 {
	public static void 하제한시간() {
		// 제한 시간 설정 (하: 90초)
        long timeoutMillis = 90000;
        
        // 현재 시간 기준으로 제한 시간 설정
        long startTimeMillis = System.currentTimeMillis();
        
        // 제한 시간 안에 작업을 수행하는 예제
        while (true) {
            // 여기서 게임실행 메소드를 실행합니다?
            
            // 현재 시간을 가져옵니다.
            long currentTimeMillis = System.currentTimeMillis();
            
            // 제한 시간을 초과하면 종료합니다.
            if (currentTimeMillis - startTimeMillis > timeoutMillis) {
            	TimeOutFail(); //제한시간 초과시 실패 시나리오 출력
                break;
            }
        }
    }
	static void TimeOutFail() {
		실패 TO = new 실패();
		TO.하();
	}
	}


