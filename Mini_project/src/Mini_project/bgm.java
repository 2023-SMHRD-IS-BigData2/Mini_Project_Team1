package Mini_project;

public class bgm {
	import javafx.application.Application;
	import javafx.scene.media.Media;
	import javafx.scene.media.MediaPlayer;
	import javafx.stage.Stage;

	public class bgm extends Application {

	    @Override
	    public void start(Stage primaryStage) {
	        // 배경음악 파일 경로 설정 (여기서는 예시로 사용할 음악 파일 경로를 넣어주세요)
	        String musicFile = "path/to/your/background_music.mp3";
	        Media sound = new Media("file:" + musicFile);
	        MediaPlayer mediaPlayer = new MediaPlayer(sound);

	        // 배경음악을 반복 재생하려면 아래 라인을 추가합니다.
	        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

	        // 배경음악 재생 시작
	        mediaPlayer.play();

	        // 창을 닫으면 배경음악 재생도 종료합니다.
	        primaryStage.setOnCloseRequest(event -> mediaPlayer.stop());

	        // 애플리케이션 창을 화면에 표시
	        primaryStage.setTitle("Background Music Player");
	        primaryStage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	}



