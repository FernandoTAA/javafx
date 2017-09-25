package br.com.javafx.labanimation.controller;

import br.com.javafx.labanimation.animation.CustomAnimationTransition;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class AnimationController {

	@FXML
	private ProgressBar progressBar;

	@FXML
	private Rectangle rectangle;

	private double currentProgress = 0;

	private Runnable progressBarTask = () -> {
		currentProgress = 0;
		for (int i = 0; i <= 100; i++) {
			Platform.runLater(() -> progressBar.setProgress(currentProgress));
			currentProgress += 0.01;
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	};

	@FXML
	void executeAnimation(ActionEvent event) {
		new Thread(progressBarTask).start();

		CustomAnimationTransition customAnimationTransition = new CustomAnimationTransition(Duration.millis(10000),
				rectangle, 450.0, 200.0);

		RotateTransition rotateTransition = new RotateTransition(Duration.millis(1000), rectangle);
		rotateTransition.setByAngle(360f);
		rotateTransition.setCycleCount(10);

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), rectangle);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.1);
		fadeTransition.setCycleCount(10);
		fadeTransition.setAutoReverse(true);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), rectangle);
		scaleTransition.setToX(2f);
		scaleTransition.setToY(2f);
		scaleTransition.setCycleCount(10);
		scaleTransition.setAutoReverse(true);

		ParallelTransition parallelTransition = new ParallelTransition();
		parallelTransition.getChildren().addAll(customAnimationTransition, rotateTransition, fadeTransition,
				scaleTransition);
		parallelTransition.setCycleCount(1);
		parallelTransition.play();
	}

}