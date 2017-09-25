package br.com.javafx.labspring.launcher;

import java.io.IOException;
import java.net.URL;

import br.com.javafx.labspring.spring.SpringFXMLLoader;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationLauncher  extends Application {

	@Override
	public void start(Stage stage) {
		try {
			URL url = ApplicationLauncher.class.getResource("/view/JavaFXWithSpring.fxml");
			FXMLLoader loader = new SpringFXMLLoader();
			loader.setLocation(url);
			Parent fxmlObject = loader.load();
			Scene scene = new Scene(fxmlObject, 600, 400);
			stage.setScene(scene);
			stage.setTitle("JavaFX with Spring");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	  launch(args);
	}

}
