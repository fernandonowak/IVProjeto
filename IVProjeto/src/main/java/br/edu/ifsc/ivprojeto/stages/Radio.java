package br.edu.ifsc.ivprojeto.stages;

import java.io.FileInputStream;

import br.edu.ifsc.ivprojeto.util.Strings;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

public class Radio extends Application{
	
	public Button btnMainStage;

	public Radio(Stage stage) throws Exception{
		// TODO Auto-generated constructor stub
	

		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(900, 650);
		Scene scene = new Scene(pane);
		FileInputStream input = new FileInputStream(
				"C:\\Users\\Fernando\\Documents\\GitHub\\IVProjeto\\IVProjeto\\src\\main\\java\\br\\edu\\ifsc\\ivprojeto\\stages\\imagem1.jpg");
		Image image = new Image(input);
		BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundimage);
		pane.setBackground(background);

		stage.setScene(scene);

		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);
		
		btnMainStage = new Button(Strings.btnMainStage);
		btnMainStage.setLayoutX(50);
		btnMainStage.setLayoutY(550);
		btnMainStage.setPrefSize(50, 50);
		
		btnMainStage.setOnMouseClicked(e -> {
			try {
				new MainStage(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			stage.close();

			//new AddUserStage(new Stage());

		});
		
		pane.getChildren().add(btnMainStage);
		
		
		stage.show();
		
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
	}



}
