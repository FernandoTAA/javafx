package br.com.javafx.labspring.controller;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.javafx.labspring.dto.PersonDTO;
import br.com.javafx.labspring.service.ListService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

@Component
@Scope("prototype")
public class ListController {

	@FXML
	private TableView<PersonDTO> table;

	@FXML
	private TableColumn<PersonDTO, String> columnDateBirth;

	@FXML
	private TableColumn<PersonDTO, String> columnName;

	@FXML
	private TableColumn<PersonDTO, String> columnIdentification;

	@Autowired
	private ListService listService;

	@FXML
	private void initialize() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		columnName.setCellValueFactory(cellData -> cellData.getValue().getName());
		columnIdentification.setCellValueFactory(cellData -> cellData.getValue().getIdentification());
		columnDateBirth.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getDateBirth().get().format(dateTimeFormatter)));

		List<PersonDTO> list = listService.getPeople();
		ObservableList<PersonDTO> listObservavel = FXCollections.observableList(list);
		table.setItems(listObservavel);
	}

}