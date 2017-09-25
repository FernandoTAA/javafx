package br.com.javafx.labcustomerregistration.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.function.Consumer;

import br.com.javafx.labcustomerregistration.dto.CustomerDTO;
import br.com.javafx.labcustomerregistration.enums.FormPayment;
import br.com.javafx.labcustomerregistration.enums.Genre;
import br.com.javafx.labcustomerregistration.launcher.ApplicationLauncher;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditionController {

	@FXML
	private ToggleGroup groupPurchaseOften;

	@FXML
	private RadioButton radioPurchaseOftenYes;

	@FXML
	private RadioButton radioPurchaseOftenNo;

	@FXML
	private CheckBox checkCard;

	@FXML
	private TextField textName;

	@FXML
	private CheckBox checkCash;

	@FXML
	private CheckBox checkCheck;

	@FXML
	private ColorPicker colorFavouriteColor;

	@FXML
	private DatePicker dateBirth;

	@FXML
	private TextField textIdentification;

	@FXML
	private ComboBox<Genre> comboGenre;

	private Stage dialogStage;

	private CustomerDTO customer;

	private Consumer<CustomerDTO> consumerSaveAction;

	public static void show(final CustomerDTO customer) {
		show(customer, null);
	}

	public static void show(final CustomerDTO customer, final Consumer<CustomerDTO> consumerSaveAction) {
		try {
			URL url = ApplicationLauncher.class.getResource("/view/Edition.fxml");
			FXMLLoader loader = new FXMLLoader();
			loader.setResources(ApplicationLauncher.resourceBundle);
			loader.setLocation(url);
			Parent root = loader.load();
			EditionController controller = (EditionController) loader.getController();

			Stage stage = new Stage();
			stage.setTitle("Customer Edition");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(ApplicationLauncher.stage);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.getIcons().add(new Image("/images/icon.png"));
			stage.setOnCloseRequest(e -> controller.cancel(null));

			controller.setDialogStage(stage);
			controller.setCustomer(customer);
			controller.setConsumerSaveAction(consumerSaveAction);

			stage.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void initialize() {
		comboGenre.setItems(FXCollections.observableArrayList(Genre.MALE, Genre.FEMALE));
	}

	@FXML
	void cancel(ActionEvent event) {
		dialogStage.close();
	}

	@FXML
	void save(ActionEvent event) {
		fillCustomer();
		if (consumerSaveAction != null) {
			consumerSaveAction.accept(customer);
		}
		dialogStage.close();
	}

	private void fillCustomer() {
		if (customer.getName() == null) {
			customer.setName(new SimpleStringProperty());
		}
		if (customer.getIdentification() == null) {
			customer.setIdentification(new SimpleStringProperty());
		}
		
		customer.getName().set(textName.getText());;
		customer.getIdentification().set(textIdentification.getText());;
		customer.setDateBirth(dateBirth.getValue());
		customer.setGenre(comboGenre.getValue());
		customer.setPurchaseOften(radioPurchaseOftenYes.equals(groupPurchaseOften.getSelectedToggle()));
		
		customer.setFormsPayment(new ArrayList<FormPayment>());
		if (checkCash.isSelected()) {
			customer.getFormsPayment().add(FormPayment.CASH);
		}
		if (checkCard.isSelected()) {
			customer.getFormsPayment().add(FormPayment.CREDIT_DEBIT_CARD);
		}
		if (checkCheck.isSelected()) {
			customer.getFormsPayment().add(FormPayment.CHECK);
		}

		Color cor = colorFavouriteColor.getValue();
		Integer corHexa = (int) (cor.getRed() * 0xFF0000 + cor.getGreen() * 0xFF00 + cor.getBlue() * 0xFF);
		customer.setFavouriteColor(corHexa);
	}

	private void prepareComponents(CustomerDTO customer) {
		clearComponents();

		if (customer.getName() != null) {
			textName.setText(customer.getName().get());
		}
		if (customer.getIdentification() != null) {
			textIdentification.setText(customer.getIdentification().get());
		}
		dateBirth.setValue(customer.getDateBirth());
		comboGenre.setValue(customer.getGenre());

		if (customer.getPurchaseOften() != null && customer.getPurchaseOften()) {
			groupPurchaseOften.selectToggle(radioPurchaseOftenYes);
		}

		if (customer.getFormsPayment() != null) {
			for (FormPayment formsPayment : customer.getFormsPayment()) {
				switch (formsPayment) {
				case CASH:
					checkCash.setSelected(true);
					break;
				case CREDIT_DEBIT_CARD:
					checkCard.setSelected(true);
					break;
				case CHECK:
					checkCheck.setSelected(true);
					break;
				default:
				}
			}
		}

		if (customer.getFavouriteColor() != null) {
			Integer red = customer.getFavouriteColor() / 0x10000;
			Integer green = (customer.getFavouriteColor() - red * 0x10000) / 0x100;
			Integer blue = customer.getFavouriteColor() - red * 0x10000 - green * 0x100;
			
			Color color = Color.rgb(red, green, blue);
			colorFavouriteColor.setValue(color);
		}

	}

	private void clearComponents() {
		textName.setText("");
		textIdentification.setText("");
		dateBirth.setValue(null);
		comboGenre.setValue(null);
		groupPurchaseOften.selectToggle(radioPurchaseOftenNo);
		checkCash.setSelected(false);
		checkCard.setSelected(false);
		checkCheck.setSelected(false);
		colorFavouriteColor.setValue(Color.WHITE);
	}

	public void setCustomer(CustomerDTO cliente) {
		this.customer = cliente;
		prepareComponents(cliente);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setConsumerSaveAction(Consumer<CustomerDTO> consumerAcaoSalvar) {
		this.consumerSaveAction = consumerAcaoSalvar;
	}

}
