package br.edu.ifsc.ivprojeto.stages;

import java.io.FileInputStream;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;
import br.edu.ifsc.ivprojeto.util.Strings;

public class MainStage {

	public Button btnGPS;
	public Button btnCAM;

	public MainStage(Stage stage) throws Exception {

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

		// GPS button
		btnGPS = new Button(Strings.btnGPS);
		btnGPS.setLayoutX(50);
		btnGPS.setLayoutY(300);
		btnGPS.setPrefSize(200, 100);

		pane.getChildren().add(btnGPS);

		// câmera button
		btnCAM = new Button(Strings.btnCAM);
		btnCAM.setLayoutX(50);
		btnCAM.setLayoutY(450);
		btnCAM.setPrefSize(200, 100);

		pane.getChildren().add(btnCAM);

		stage.show();
	}

}
