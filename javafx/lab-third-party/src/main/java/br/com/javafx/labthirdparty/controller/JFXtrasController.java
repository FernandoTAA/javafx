package br.com.javafx.labthirdparty.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jfxtras.scene.control.LocalDateTimeTextField;

public class JFXtrasController {

	@FXML
	private LocalDateTimeTextField textDateTime;

	@FXML
	private Label labelDateTime;

	@FXML
    public void showDateTime(ActionEvent event) {
		if (textDateTime.getLocalDateTime() != null) {
			LocalDateTime date = textDateTime.getLocalDateTime();
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd 'of' MMMM 'of' YYYY 'at' HH:mm:ss");
			String textDate = date.format(dateTimeFormatter);
			labelDateTime.setText(textDate);
		} else {
			labelDateTime.setText("");
		}
    }
	
}
