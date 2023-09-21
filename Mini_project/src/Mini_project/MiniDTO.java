package Mini_project;

public class MiniDTO {
	String nickname;
	String pw;
	String id;
	int score;
	public MiniDTO(String nickname, String pw, String id) {
		this.nickname = nickname;
		this.pw = pw;
		this.id = id;
	}
	public MiniDTO(int score, String id) {
		this.score = score;
		this.id = id;
	}
	public MiniDTO(int score) {
		this.score = score;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPw() {
		return pw;
	}
	public String getId() {
		return id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
