package br.com.javafx.labcustomerregistration.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import br.com.javafx.labcustomerregistration.enums.FormPayment;
import br.com.javafx.labcustomerregistration.enums.Genre;
import javafx.beans.property.StringProperty;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = -5808242588038421260L;

	private StringProperty name;
	private StringProperty identification;
	private LocalDate dateBirth;
	private Genre genre;
	private Boolean purchaseOften;
	private List<FormPayment> formsPayment;
	private Integer favouriteColor;

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

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Boolean getPurchaseOften() {
		return purchaseOften;
	}

	public void setPurchaseOften(Boolean purchaseOften) {
		this.purchaseOften = purchaseOften;
	}

	public List<FormPayment> getFormsPayment() {
		return formsPayment;
	}

	public void setFormsPayment(List<FormPayment> formsPayment) {
		this.formsPayment = formsPayment;
	}

	public Integer getFavouriteColor() {
		return favouriteColor;
	}

	public void setFavouriteColor(Integer favouriteColor) {
		this.favouriteColor = favouriteColor;
	}

}
