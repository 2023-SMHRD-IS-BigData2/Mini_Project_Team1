package Model;

public class DTO {
	String id;
	int score;
	public DTO(String id, int score) {
		this.id = id;
		this.score = score;
	}
	public String getId() {
		return id;
	}
	public int getScore() {
		return score;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
