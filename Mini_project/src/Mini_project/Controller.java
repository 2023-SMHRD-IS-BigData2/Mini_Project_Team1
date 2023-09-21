package Mini_project;

import java.util.ArrayList;

public class Controller {
	MiniDAO dao = new MiniDAO();
	public ArrayList<MiniDTO> returnRankAll() {
		ArrayList<MiniDTO> li = new ArrayList<>();
		li = dao.rankAll();
		return li;
	}
	
}
