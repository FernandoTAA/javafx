package br.com.javafx.labspring.dto;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PersonDTO {

	private StringProperty name;
	private StringProperty identification;
	private ObjectProperty<LocalDate> dateBirth;
	
	

	public PersonDTO(String name, String identification, LocalDate	 dateBirth) {
		super();
		this.name = new SimpleStringProperty(name);
		this.identification = new SimpleStringProperty(identification);
		this.dateBirth = new SimpleObjectProperty<LocalDate>(dateBirth);
	}

	public StringProperty getName() {
		return name;
	}

	public void setName(StringProperty name) {
		this.name = name;
	}

	public StringProperty getIdentification() {
		return identification;
	}

	public void setIdentification(StringProperty identification) {
		this.identification = identification;
	}

	public ObjectProperty<LocalDate> getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(ObjectProperty<LocalDate> dateBirth) {
		this.dateBirth = dateBirth;
	}

}
