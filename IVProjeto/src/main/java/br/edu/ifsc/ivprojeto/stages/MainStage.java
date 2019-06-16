package br.edu.ifsc.ivprojeto.stages;

import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainStage {

	public MainStage(Stage stage) throws Exception {
		
			// creating the classes hierarchy (pane -> scene -> stage)
			AnchorPane pane = new AnchorPane();
			pane.setPrefSize(170, 190);
			Scene scene = new Scene(pane);
			stage.setScene(scene);
	}

}
