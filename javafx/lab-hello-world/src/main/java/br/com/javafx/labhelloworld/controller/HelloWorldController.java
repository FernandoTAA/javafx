package br.com.javafx.labhelloworld.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloWorldController {

	@FXML
	private TextField txtName;

	@FXML
	private Label lblHello;

	@FXML
	private void dizerOla(ActionEvent event) {
		String nome = txtName.getText();
		lblHello.setText(String.format("Hello %s!", nome));
	}

}