package Mini_project;

public class talk {
MiniDTO dto = new MiniDTO("TESTER1", "1234", "A1");
	
	public void Synopsis() {
		System.out.println("6개월간의 긴 스인재 과정을 마치고 마침내 취업에 성공한" + dto.getNickname() + "씨");
		System.out.println("아직은 어리숙하긴해도 그래도 꾸역꾸역 사회생활을 해가고 있는" + dto.getNickname() + "씨");
		System.out.println("그런" + dto.getNickname() + "씨는 인생 처음 회사회식을 가게 되는데");
	}
	
	public void Scenario() {
		System.out.println("마부장 : 오" + dto.getNickname() + "씨 회사생활은 할 만해 우리 회사 참 좋지?");
		System.out.println(dto.getNickname() + "씨 : 하하 네 그렇습니다.(부장님이 프로젝트 반려만 안하시면 말이죠)");
		System.out.println("마부장 : 하하하하 우리" + dto.getNickname() + "씨 회사회식도 처음인데 우리회사 전통의 쌈싸주기 한번 해볼까");
		System.out.println("회사 사람들 : 헉... " + dto.getNickname() + "씨 어떡해 어떡해");
		System.out.println("양과장 : 저 부장님 요즘 시대도 시댄데 그건 조금");
		System.out.println("마부장 : 걱정마 걱정마 내가 뭐 나쁜짓하는것도 아니고 겨우 쌈싸주긴데 뭐 어때 그러니 " + dto.getNickname() + "씨 쌈 한번 야무지게 싸봐");
		System.out.println(dto.getNickname() + "씨 : 제가요?");
		System.out.println("마부장 : 제가요? 하하하하 우리 " + dto.getNickname() + "아주 mz해 하하하 그런 " + dto.getNickname() + "씨는 나 먹을 쌈도 아주 mz하게 싸주겠지"
		+ "나 기대할께");
		System.out.println(dto.getNickname() + "씨 : 하하하 (아x발 x됐다)");
		
	}
	
	public void SucScenario() {
		System.out.println("마부장 : 오 우리 " + dto.getNickname() + "씨 쌈 잘싸는데 내 취향에 완벽 부합한 다시 없을 쌈이었어");
		System.out.println(dto.getNickname() + "씨 정말 맘에 드는구만 그래 하하하하");
		System.out.println(dto.getNickname() + "씨 : 이정도는 기본이죠 하하하(휴~~~~~)");
		
	}
	
	public void FailScenario() {
		System.out.println("마부장 : 에잇 퉤 " + dto.getNickname() + "씨 이걸 지금 쌈이라고 싼거야? " + dto.getNickname() + "씨 정말 안되겠네 이거");
		System.out.println("회사 사람들 : 아이고 또 시작이네");
		System.out.println(dto.getNickname() + "씨 : (그럼 부장님이 직접 싸시든가요!!!!!!!!!!!) ");
		System.out.println("마부장 : 요즘 mz들이 이래서 문제야 문제 쌈하나 싸는것도 못하면 앞으로 회사생활을 어떻게해");
	}
}
