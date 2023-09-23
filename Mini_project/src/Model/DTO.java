package Model;

public class DTO {
	String nickname;
	String pw;
	String id;
	int score;
	
	public DTO(String nickname, String pw, String id) {
		this.nickname = nickname;
		this.pw = pw;
		this.id = id;
	}
	public DTO(int score, String name) {
		this.score = score;
		this.nickname = name;
	}
	public DTO(int score) {
		this.score = score;
	}
	
	public DTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
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
