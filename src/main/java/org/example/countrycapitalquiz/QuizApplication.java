package org.example.countrycapitalquiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class QuizApplication extends Application {
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(QuizApplication.class.getResource("Quiz-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 410, 200);
        stage.setTitle("Länderquiz");
        stage.setScene(scene);
        stage.show();
    }
}
