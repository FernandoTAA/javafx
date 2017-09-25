package br.com.javafx.labwindow.window;

import javafx.scene.Node;
import javafx.stage.Stage;

public class WindowDraggable {
	
	private double xOffset = 0;
	private double yOffset = 0;

	public WindowDraggable(Stage stage, Node node) {
		node.setOnMousePressed(e -> {
			xOffset = e.getSceneX();
			yOffset = e.getSceneY();
		});
		node.setOnMouseDragged(e -> {
			stage.setX(e.getScreenX() - xOffset);
			stage.setY(e.getScreenY() - yOffset);
		});

	}
	
}
