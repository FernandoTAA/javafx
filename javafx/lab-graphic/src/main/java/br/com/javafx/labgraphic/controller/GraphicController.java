package br.com.javafx.labgraphic.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

public class GraphicController {

    @FXML
    private LineChart<String, Number> graphic;
    
	@FXML
	private void initialize() {
		XYChart.Series<String, Number> good = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> regular = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> bad = new XYChart.Series<String, Number>();
		XYChart.Series<String, Number> didNotAnswer = new XYChart.Series<String, Number>();

		good.setName("Good");
		regular.setName("Regular");
		bad.setName("Bad");
		didNotAnswer.setName("Who did not answer");
		

	    good.getData().add(new XYChart.Data<String, Number>("06/2016", 13));
	    good.getData().add(new XYChart.Data<String, Number>("09/2016", 14));
	    good.getData().add(new XYChart.Data<String, Number>("12/2016", 13));
	    good.getData().add(new XYChart.Data<String, Number>("03/2017", 10));
	    good.getData().add(new XYChart.Data<String, Number>("07/2017", 5));
	    regular.getData().add(new XYChart.Data<String, Number>("06/2016", 36));
	    regular.getData().add(new XYChart.Data<String, Number>("09/2016", 34));
	    regular.getData().add(new XYChart.Data<String, Number>("12/2016", 35));
	    regular.getData().add(new XYChart.Data<String, Number>("03/2017", 31));
	    regular.getData().add(new XYChart.Data<String, Number>("07/2017", 21));
	    bad.getData().add(new XYChart.Data<String, Number>("06/2016", 39));
	    bad.getData().add(new XYChart.Data<String, Number>("09/2016", 39));
	    bad.getData().add(new XYChart.Data<String, Number>("12/2016", 46));
	    bad.getData().add(new XYChart.Data<String, Number>("03/2017", 55));
	    bad.getData().add(new XYChart.Data<String, Number>("07/2017", 70));
	    didNotAnswer.getData().add(new XYChart.Data<String, Number>("06/2016", 13));
	    didNotAnswer.getData().add(new XYChart.Data<String, Number>("09/2016", 12));
	    didNotAnswer.getData().add(new XYChart.Data<String, Number>("12/2016", 6));
	    didNotAnswer.getData().add(new XYChart.Data<String, Number>("03/2017", 4));
	    didNotAnswer.getData().add(new XYChart.Data<String, Number>("07/2017", 3));
		
	    graphic.getData().add(good);
		graphic.getData().add(regular);
		graphic.getData().add(bad);
		graphic.getData().add(didNotAnswer);
	}

}