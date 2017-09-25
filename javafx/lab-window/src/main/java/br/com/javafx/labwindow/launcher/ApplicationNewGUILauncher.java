package br.com.javafx.labwindow.launcher;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import br.com.javafx.labwindow.window.WindowDraggable;
import br.com.javafx.labwindow.window.WindowResizeble;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ApplicationNewGUILauncher extends Application {
	
	public static Stage stage;
	public static ResourceBundle resourceBundle = java.util.ResourceBundle.getBundle("i18n.message", Locale.getDefault());

	@Override
	public void start(Stage stage) {
		ApplicationNewGUILauncher.stage = stage;
		try {
			URL url = ApplicationNewGUILauncher.class.getResource("/view/Main.fxml");
			FXMLLoader loader = new FXMLLoader();
			loader.setResources(ApplicationNewGUILauncher.resourceBundle);
			loader.setLocation(url);
			Parent fxmlObject = loader.load();
			BorderPane windowLayoutFxmlObject = addInWindow(fxmlObject);

			stage.initStyle(StageStyle.TRANSPARENT);
			Scene scene = new Scene(windowLayoutFxmlObject, 900, 500,
	                Color.TRANSPARENT);

			stage.setScene(scene);
			stage.setTitle("Customer Registration");
			stage.getIcons().add(new Image("/images/icon.png"));
			new WindowDraggable(stage, windowLayoutFxmlObject.getTop());
			new WindowResizeble(stage);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private BorderPane addInWindow(Parent fxmlObject) throws IOException {
		URL url = ApplicationNewGUILauncher.class.getResource("/view/WindowLayout.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setResources(ApplicationNewGUILauncher.resourceBundle);
		loader.setLocation(url);
		BorderPane windowLayoutFxmlObject = loader.load();
		windowLayoutFxmlObject.setCenter(fxmlObject);
		return windowLayoutFxmlObject;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
