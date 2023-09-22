package Mini_project;

import java.util.ArrayList;
import Controller.MusicVO;
import javazoom.jl.player.MP3Player;
import Controller.MP3Play;

public class Controller {
	MiniDAO dao = new MiniDAO();
	private MuseicVO[] music;
	private MP3Player player;

	private int currentIndex;

	public Controller() {
		music = new MusicVO[4];
	}

	music[0]=new MusicVO("긴장감 브금.mp3");music[1]=new MusicVO("호응+휘파람.mp3");music[2]=new MusicVO("좌절 브금(두둥..).mp3");music[3]=new MusicVO("씹는 소리.mp3");

	player=new MP3Player();currentIndex=0;

}

	}

	public void play() {
		if (player.isPlaying()) {
			player.stop();
		}
		player.play(music[currentIndex].getWay());
	}

	public void next() {
		currentIndex = (currentIndex == music.length - 1) ? 0 : currentIndex + 1;
		play();
	}

	public void stop() {
		player.stop();

	}

	public void pre() {
		// 방법 1
		currentIndex = (currentIndex == 0) ? music.length - 1 : currentIndex - 1;
		play();

	}

	public String nowplay() {
		return music[currentIndex].toString();
	}

	public ArrayList<MiniDTO> returnRankAll() {
		ArrayList<MiniDTO> li = new ArrayList<>();
		li = dao.rankAll();
		return li;
	}

}
