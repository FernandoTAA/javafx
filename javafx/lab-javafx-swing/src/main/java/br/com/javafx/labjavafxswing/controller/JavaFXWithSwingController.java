package br.com.javafx.labjavafxswing.controller;

import java.util.function.Consumer;

import javax.swing.JButton;

import javafx.application.Platform;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class JavaFXWithSwingController {

	@FXML
	private SwingNode swing;

	@FXML
	private TextField textName;

	@FXML
	private Label message;

	private JButton buttonMessage = new JButton("Message");

	private Consumer<String> consumer;

	@FXML
	private void initialize() {
		buttonMessage.addActionListener(e -> Platform.runLater(() -> {
			String text = String.format("Hello %s!", textName.getText());
			message.setText(text);
			if (consumer != null) {
				consumer.accept(text);
			}
		}));
		swing.setContent(buttonMessage);
	}

	public void setConsumer(Consumer<String> consumer) {
		this.consumer = consumer;
	}

}
