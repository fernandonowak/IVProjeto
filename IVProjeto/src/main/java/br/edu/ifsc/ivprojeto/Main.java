package br.edu.ifsc.ivprojeto;

import br.edu.ifsc.ivprojeto.stages.MainStage;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new MainStage(primaryStage);
	}
}
