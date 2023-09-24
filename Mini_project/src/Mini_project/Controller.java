package Mini_project;

import javazoom.jl.player.MP3Player;

public class Controller {

	MP3Player player;

	public void 시작노래() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("긴장감 브금.mp3");

	}

	public void 성공노래() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("호응+휘파람.mp3");

	}

	public void 실패노래() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("좌절 브금(두둥..).mp3");

	}

	public void 먹는소리() {

		if (player.isPlaying()) {
			player.stop();
		}

		player.play("씹는 소리.mp3");

	}
}
