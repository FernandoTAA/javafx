package br.com.javafx.labjavafxswing.launcher;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.com.javafx.labjavafxswing.controller.JavaFXWithSwingController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SwingApplicationLauncher {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Swing with JavaFX");
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		JLabel label = new JLabel();
		frame.add(label, BorderLayout.SOUTH);

		JFXPanel jfxPanel = initFXML(label);
		frame.add(jfxPanel, BorderLayout.CENTER);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Platform.exit();
				e.getWindow().dispose();
			}
		});
		frame.setVisible(true);
	}

	private static JFXPanel initFXML(JLabel label) {
		try {
			JFXPanel jfxPanel = new JFXPanel();

			URL url = SwingApplicationLauncher.class.getResource("/view/JavaFXWithSwing.fxml");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(url);
			Parent fxmlObject = loader.load();
			Scene scene = new Scene(fxmlObject, 600, 100);
			jfxPanel.setScene(scene);

			JavaFXWithSwingController controller = loader.getController();
			controller.setConsumer(s -> label.setText(s));
			return jfxPanel;
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		return null;
	}

}
