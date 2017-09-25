package br.com.javafx.labanimation.launcher;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationLauncher  extends Application {

	@Override
	public void start(Stage stage) {
		try {
			URL url = ApplicationLauncher.class.getResource("/view/Animation.fxml");
			Parent fxmlObject = FXMLLoader.load(url);
			Scene scene = new Scene(fxmlObject, 600, 400);
			stage.setScene(scene);
			stage.setTitle("Animation");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	  launch(args);
	}

}
