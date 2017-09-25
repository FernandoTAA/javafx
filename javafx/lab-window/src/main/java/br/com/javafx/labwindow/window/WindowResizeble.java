package br.com.javafx.labwindow.window;

import java.awt.Dimension;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class WindowResizeble {

	private Dimension minSize = new Dimension(100, 50);
	private double border = 5;
	private double dx;
	private double dy;
	private double deltaX;
	private double deltaY;
	private boolean moveH;
	private boolean moveV;
	private boolean resizeH = false;
	private boolean resizeV = false;

	public WindowResizeble(Stage stage) {
		Scene scene = stage.getScene();
		if (scene != null) {
			scene.setOnMouseMoved(this::onMouseMoved);
			scene.setOnMousePressed(e -> onMousePressed(e, stage));
			scene.setOnMouseDragged(e -> onMouseDragged(e, stage));
		}
	}

	private void onMouseMoved(MouseEvent t) {
		Scene scene = (Scene) t.getSource();
		if (t.getX() < border && t.getY() < border) {
			scene.setCursor(Cursor.NW_RESIZE);
			resizeH = true;
			resizeV = true;
			moveH = true;
			moveV = true;
		} else if (t.getX() < border && t.getY() > scene.getHeight() - border) {
			scene.setCursor(Cursor.SW_RESIZE);
			resizeH = true;
			resizeV = true;
			moveH = true;
			moveV = false;
		} else if (t.getX() > scene.getWidth() - border && t.getY() < border) {
			scene.setCursor(Cursor.NE_RESIZE);
			resizeH = true;
			resizeV = true;
			moveH = false;
			moveV = true;
		} else if (t.getX() > scene.getWidth() - border && t.getY() > scene.getHeight() - border) {
			scene.setCursor(Cursor.SE_RESIZE);
			resizeH = true;
			resizeV = true;
			moveH = false;
			moveV = false;
		} else if (t.getX() < border || t.getX() > scene.getWidth() - border) {
			scene.setCursor(Cursor.E_RESIZE);
			resizeH = true;
			resizeV = false;
			moveH = (t.getX() < border);
			moveV = false;
		} else if (t.getY() < border || t.getY() > scene.getHeight() - border) {
			scene.setCursor(Cursor.N_RESIZE);
			resizeH = false;
			resizeV = true;
			moveH = false;
			moveV = (t.getY() < border);
		} else {
			scene.setCursor(Cursor.DEFAULT);
			resizeH = false;
			resizeV = false;
			moveH = false;
			moveV = false;
		}
	}

	private void onMousePressed(MouseEvent t, Stage stage) {
		dx = stage.getWidth() - t.getX();
		dy = stage.getHeight() - t.getY();
	}

	private void onMouseDragged(MouseEvent t, Stage stage) {
		if (resizeH) {
			if (stage.getWidth() <= minSize.width) {
				if (moveH) {
					deltaX = stage.getX() - t.getScreenX();
					if (t.getX() < 0) {// if new > old, it's permitted
						stage.setWidth(deltaX + stage.getWidth());
						stage.setX(t.getScreenX());
					}
				} else {
					if (t.getX() + dx - stage.getWidth() > 0) {
						stage.setWidth(t.getX() + dx);
					}
				}
			} else if (stage.getWidth() > minSize.width) {
				if (moveH) {
					deltaX = stage.getX() - t.getScreenX();
					stage.setWidth(deltaX + stage.getWidth());
					stage.setX(t.getScreenX());
				} else {
					stage.setWidth(t.getX() + dx);
				}
			}
		} 
		if (resizeV) {
			if (stage.getHeight() <= minSize.height) {
				if (moveV) {
					deltaY = stage.getY() - t.getScreenY();
					if (t.getY() < 0) {// if new > old, it's permitted
						stage.setHeight(deltaY + stage.getHeight());
						stage.setY(t.getScreenY());
					}
				} else {
					if (t.getY() + dy - stage.getHeight() > 0) {
						stage.setHeight(t.getY() + dy);
					}
				}
			} else if (stage.getHeight() > minSize.height) {
				if (moveV) {
					deltaY = stage.getY() - t.getScreenY();
					stage.setHeight(deltaY + stage.getHeight());
					stage.setY(t.getScreenY());
				} else {
					stage.setHeight(t.getY() + dy);
				}
			}
		}
	}

}
