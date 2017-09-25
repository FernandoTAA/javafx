package br.com.javafx.labcustomerregistration.launcher;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ApplicationLauncher extends Application {
	
	public static Stage stage;
	public static ResourceBundle resourceBundle = java.util.ResourceBundle.getBundle("i18n.message", Locale.getDefault());

	@Override
	public void start(Stage stage) {
		ApplicationLauncher.stage = stage;
		try {
			URL url = ApplicationLauncher.class.getResource("/view/Main.fxml");
			FXMLLoader loader = new FXMLLoader();
			loader.setResources(ApplicationLauncher.resourceBundle);
			loader.setLocation(url);
			Parent fxmlObject = loader.load();
			Scene scene = new Scene(fxmlObject, 900, 500);
			stage.setScene(scene);
			stage.setTitle("Customer Registration");
			stage.getIcons().add(new Image("/images/icon.png"));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
