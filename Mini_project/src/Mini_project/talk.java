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
	
	public void EasyScenario() {
		System.out.println("마부장 : " + dto.getNickname() + "씨 회사생활은 할만해 아직 많이 힘들고 버겁고 그러지");
		System.out.println(dto.getNickname() + "씨 : 괜찮습니다. 과장님도 부장님도 정말로 잘 대해주고 정말이지 이곳에 들어온게 행운이라 생각합니다");
		System.out.println("마부장 : 그렇다면 다행이네 언제든 힘든 일 있으면 이야기 해주고 많이는 못 도와주지만 해볼 수 있는 곳까지는 도와줄께");
		System.out.println(dto.getNickname() + "씨 : 감사합니다 마부장님 혹시 제가 쌈 한번 싸드려도 되겠습니까? 너무 고마워서 그렇습니다.");
		System.out.println("마부장 : 하하 아우 뭔 쌈이여 ㅋㅋㅋ 그럼 어디 " + dto.getNickname() + "씨 성의도 있는데 한 쌈 받아볼까?");
	}
	
	public void EasySucScenario() {
		System.out.println("마부장 : 하하 " + dto.getNickname() + "씨 맛있는데 하하 쌈 잘싸는데 " + dto.getNickname() + "씨");
		System.out.println(dto.getNickname() + "씨 : 하하 뭘 이정도 가지고 제가 한 쌈 할줄 압니다. 하하하");
	}
	
	public void EasyFailScenario() {
		System.out.println("마부장 : " + dto.getNickname() + "씨.... 맛있네.. 그치만 어디 가서 쌈 싸준다고 말하고 다니지 않았으면 좋겠어");
		System.out.println(dto.getNickname() + "씨 : .....");
	}
	
	public void NormalScenario() {
		System.out.println("마부장 : " + dto.getNickname() + "씨 회사생활은 괜찮어?");
		System.out.println(dto.getNickname() + "씨 : 하하 뭐 그럭저럭 할 만 합니다.");
		System.out.println("마부장 : 흐음... 그렇다면 뭐 다행이구만 그나저나 " + dto.getNickname() + "씨 저번에 반려된 프로젝트는 잘 되가?");
		System.out.println(dto.getNickname() + "씨 : 하하 뭐 거의 마무리 단계입니다.");
		System.out.println("마부장 : 이봐...자네...(갑자기 말이 끊기며) 회사 사람들 : 자 자 지금부터 쌈 싸주기 게임을 시작합니다!!!!");
		System.out.println("(룰렛 결과 " + dto.getNickname() + "씨가 마부장님의 쌈을 싸주기로 결과가 나오는데");
		System.out.println(dto.getNickname() + "씨 : 헉....");
		System.out.println("마부장 : 흠흠... 기대할께 " + dto.getNickname() + "씨 맛없으면 알지???");
	}
	
	public void NormalSucScenario() {
		System.out.println("마부장 : 하하하 " + dto.getNickname() + "씨 맛있어 자네 아주 그냥 쌈의 달인이구만 그 프로젝트는 천천히 기다리지 크하하하");
		System.out.println(dto.getNickname() + "씨 : 감사합니다. 마부장님");
	}
	
	public void NormalFailScenario() {
		System.out.println("마부장 : 퉤퉤" + dto.getNickname() + "씨 이걸 지금 사람 먹으라고 싼 쌈이야? 나랑 싸우자는 거지");
		System.out.println("마부장 : 남은 프로젝트 3일 내로 제출하도록 해 기대해 아주 철저하게 검토하고 확인해줄테니까!!!!!");
		System.out.println(dto.getNickname() + "씨 : 아 부장님 죄송합니다 부장님!!!!!!!");
	}
}
