package net.ent.etrs.ultramp3.start;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import net.ent.etrs.ultramp3.commons.utils.jxf.AlerteUtils;

public class LanceurMp3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            System.setProperty("http.proxyHost", "172.16.0.1");
            System.setProperty("http.proxyPort", "8080");
            System.setProperty("https.proxyHost", "172.16.0.1");
            System.setProperty("https.proxyPort", "8080");

            primaryStage.setTitle("Teaser");

//            WebView webview = new WebView();
//            WebEngine webEngine = webview.getEngine();
//            webEngine.load("https://youtu.be/uyP70r9PS6A");
//            webview.setPrefSize(640, 390);
//            // Update the stage title when a new web page title is available
//            webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
//                public void changed(ObservableValue<? extends Worker.State> ov, Worker.State oldState, Worker.State newState) {
//                    if (newState == Worker.State.SUCCEEDED) {
//                        //stage.setTitle(webEngine.getLocation());
//                        primaryStage.setTitle(webEngine.getTitle());
//                    }
//                }
//            });

//            ProgressBar progressBar = new ProgressBar();
//            // A Worker load the page
//            Worker<Void> worker = webEngine.getLoadWorker();
//            // Bind the progress property of ProgressBar
//            // with progress property of Worker
//            progressBar.progressProperty().bind(worker.progressProperty());


            Media pick = new Media(LanceurMp3.class.getResource("/Lio_Le_banana_split.mp3").toExternalForm()); // replace this with your own audio file
            MediaPlayer player = new MediaPlayer(pick);

            Label titre = new Label("Lio_Le_banana_split");

            Button btnPlay = new Button("Play");
            Button btnPause = new Button("Pause");
            Button btnStop = new Button("Stop");
            btnPlay.setOnAction(event -> {
                if(player.getStatus() != MediaPlayer.Status.PLAYING){
                    player.play();
                    btnPause.setVisible(true);
                }
            });

            btnPause.setOnAction(event -> {
                if(player.getStatus() != MediaPlayer.Status.PAUSED){
                    player.pause();
                }
                if (player.getStatus() == MediaPlayer.Status.PAUSED){
                    player.play();
                }
            });

            btnStop.setOnAction(event -> {
                if(player.getStatus() != MediaPlayer.Status.STOPPED){
                    player.stop();
                    btnPause.setVisible(false);
                }
            });

            // Add a mediaView, to display the media. Its necessary !
            // This mediaView is added to a Pane
            MediaView mediaView = new MediaView(player);
// Add to scene
//            Group root = new Group(mediaView);

            HBox root2 = new HBox();
            root2.getChildren().addAll(btnPlay, btnPause, btnStop);
            VBox root = new VBox();
            root.getChildren().addAll(mediaView, titre, root2);

            Scene scene = new Scene(root, 500, 200);

//            // Create the VBox
//            VBox root = new VBox();
////             Add the WebView to the VBox
//            root.getChildren().addAll(webview, progressBar);
            // Set the Style-properties of the VBox
            root.setStyle("-fx-padding: 10;" +
                    "-fx-border-style: solid inside;" +
                    "-fx-border-width: 2;" +
                    "-fx-border-insets: 5;" +
                    "-fx-border-radius: 5;" +
                    "-fx-border-color: blue;");
//Scene scene = new Scene(root, 800, 600);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            AlerteUtils.afficherExceptionDansAlerte(e, Alert.AlertType.ERROR);
        }

    }

}
