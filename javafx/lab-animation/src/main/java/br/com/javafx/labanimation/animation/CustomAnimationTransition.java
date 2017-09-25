package br.com.javafx.labanimation.animation;

import javafx.animation.Transition;
import javafx.scene.Node;
import javafx.util.Duration;

public class CustomAnimationTransition extends Transition {

	private Node component;
	private double minX;
	private double minY;
	private double maxX;
	private double maxY;
	private double difX;
	private double difY;

	public CustomAnimationTransition(Duration duration, Node component, double maxX, double maxY) {
		setCycleDuration(duration);
		this.component = component;
		this.maxX = maxX;
		this.maxY = maxY;

		minX = component.getTranslateX();
		minY = component.getTranslateY();

		difX = maxX - minX;
		difY = maxY - minY;
	}

	@Override
	protected void interpolate(double fraction) {
		if (fraction < 0.35) {
			double parcialFraction = fraction * 1 / 0.35;
			double addicion = difX * parcialFraction;
			component.setTranslateX(minX + addicion);
		} else if (fraction > 0.35 && fraction < 0.5) {
			double parcialFraction = (fraction - 0.35) * 1 / (0.5 - 0.35);
			double addicion = difY * parcialFraction;
			component.setTranslateY(minY + addicion);
		} else if (fraction > 0.5 && fraction < 0.85) {
			double parcialFraction = (fraction - 0.5) * 1 / (0.85 - 0.5);
			double removal = difX * parcialFraction;
			component.setTranslateX(maxX - removal);
		} else if (fraction > 0.85 && fraction < 1) {
			double parcialFraction = (fraction - 0.85) * 1 / (1 - 0.85);
			double removal = difY * parcialFraction;
			component.setTranslateY(maxY - removal);
		} else if (fraction == 1 || fraction == 0) {
			component.setTranslateX(minX);
			component.setTranslateY(minY);
		}
	}

}
