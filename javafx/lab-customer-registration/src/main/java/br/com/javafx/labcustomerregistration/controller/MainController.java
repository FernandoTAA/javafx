package br.com.javafx.labcustomerregistration.controller;

import java.time.format.DateTimeFormatter;

import br.com.javafx.labcustomerregistration.dto.CustomerDTO;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MainController {

	@FXML
	private Label labelIdentification;

	@FXML
	private Label labelGenre;

	@FXML
	private Label labelName;

	@FXML
	private Label labelPurchaseOften;

	@FXML
	private Label labelFormsPayment;

	@FXML
	private Label labelDateBirth;

	@FXML
	private Rectangle rectangleColor;

	@FXML
	private TableView<CustomerDTO> tableCustomer;

	@FXML
	private TableColumn<CustomerDTO, String> columnName;

	@FXML
	private TableColumn<CustomerDTO, String> columnIdentification;

	@FXML
	private void initialize() {
		columnName.setCellValueFactory(cellData -> cellData.getValue().getName());
		columnIdentification.setCellValueFactory(cellData -> cellData.getValue().getIdentification());
		
		tableCustomer.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	}

	@FXML
	private void include(ActionEvent event) {
		CustomerDTO customer = new CustomerDTO();
		EditionController.show(customer, c -> tableCustomer.getItems().add(c));
	}

	@FXML
	private void alter(ActionEvent event) {
		if (tableCustomer.getSelectionModel().getSelectedItem() != null) {
			CustomerDTO customer = tableCustomer.getSelectionModel().getSelectedItem();
			EditionController.show(customer);
		}
	}

	@FXML
	private void remove(ActionEvent event) {
		if (tableCustomer.getSelectionModel().getSelectedItem() != null) {
			CustomerDTO customer = tableCustomer.getSelectionModel().getSelectedItem();
			tableCustomer.getItems().remove(customer);
		}
	}

	@FXML
	private void exit(ActionEvent event) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("System Message");
		alert.setHeaderText("Are you sure you wish to leave the system?");
		alert.setContentText("Leaving the system, the system will close.");
		alert.showAndWait().ifPresent(rs -> {
			if (rs == ButtonType.OK) {
				Platform.exit();
			}
		});
	}

	private void showPersonDetails(CustomerDTO customer) {
		cleanCamponents();

		if (customer.getName() != null) {
			labelName.setText(customer.getName().get());
		}
		if (customer.getIdentification() != null) {
			labelIdentification.setText(customer.getIdentification().get());
		}
		if (customer.getDateBirth() != null) {
			String date = customer.getDateBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			labelDateBirth.setText(date);
		}
		
		if (customer.getGenre() != null) {
			labelGenre.setText(customer.getGenre().toString());
		}

		if (customer.getPurchaseOften() != null && customer.getPurchaseOften()) {
			labelPurchaseOften.setText("Yes");
		} else {
			labelPurchaseOften.setText("No");
		}

		if (customer.getFormsPayment() != null) {
			StringBuilder formsPayment = new StringBuilder();
			customer.getFormsPayment().forEach(fp -> formsPayment.append(" ").append(fp));
			labelFormsPayment.setText(formsPayment.toString());
		}

		if (customer.getFavouriteColor() != null) {
			Integer red = customer.getFavouriteColor() / 0x10000;
			Integer green = (customer.getFavouriteColor() - red * 0x10000) / 0x100;
			Integer blue = customer.getFavouriteColor() - red * 0x10000 - green * 0x100;
			
			Color color = Color.rgb(red, green, blue);
			rectangleColor.setFill(color);
		}
	}

	private void cleanCamponents() {
		labelName.setText("");
		labelIdentification.setText("");
		labelDateBirth.setText("");
		labelGenre.setText("");
		labelPurchaseOften.setText("");
		labelFormsPayment.setText("");
		rectangleColor.setFill(Color.DODGERBLUE);
	}
	
}
