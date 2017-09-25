package br.com.javafx.labspring.spring;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.util.BuilderFactory;
import javafx.util.Callback;

public class SpringFXMLLoader extends FXMLLoader {

	public SpringFXMLLoader() {
		setControllerFactory(getControllerFactory());
	}

	public SpringFXMLLoader(URL location) {
		super(location);
		setControllerFactory(getControllerFactory());
	}

	public SpringFXMLLoader(URL location, ResourceBundle resources) {
		super(location, resources);
		setControllerFactory(getControllerFactory());
	}

	public SpringFXMLLoader(URL location, ResourceBundle resources, BuilderFactory builderFactory) {
		super(location, resources, builderFactory, null);
		setControllerFactory(getControllerFactory());
	}

	public SpringFXMLLoader(Charset charset) {
		super(charset);
		setControllerFactory(getControllerFactory());
	}

	@Override
	public Callback<Class<?>, Object> getControllerFactory() {
		return clazz -> SpringConfiguration.APPLICATION_CONTEXT.getBean(clazz);
	}

}
