package br.edu.ifsc.ivprojeto.stages;

import java.io.FileInputStream;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import br.edu.ifsc.ivprojeto.util.Strings;

public class MainStage {

	public Button btnGPS;
	public Button btnCAM;
	public Button btnLIG;
	public Button btnAPP;
	public Button btnPREF;
	public Button btnRAD;
	public Button btnTV;
	public Button btnDVD;
	public Button btnUSB;
	public Button btnBt;
	public Button btnAUX;
	public Button btnGPS1;
	public Label dataMainStage;
	public Label relogioMainStage;
	

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
		btnGPS.setLayoutY(350);
		btnGPS.setPrefSize(200, 100);

			btnGPS.setOnMouseClicked(e -> {
				try {
					new GPS(new Stage());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				stage.close();
			});

		pane.getChildren().add(btnGPS);

		// cam button
		btnCAM = new Button(Strings.btnCAM);
		btnCAM.setLayoutX(50);
		btnCAM.setLayoutY(500);
		btnCAM.setPrefSize(200, 100);

		pane.getChildren().add(btnCAM);

		// Ligar button
		btnLIG = new Button(Strings.btnLIG);
		btnLIG.setLayoutX(350);
		btnLIG.setLayoutY(200);
		btnLIG.setPrefSize(200, 100);

		pane.getChildren().add(btnLIG);

		// App button
		btnAPP = new Button(Strings.btnAPP);
		btnAPP.setLayoutX(350);
		btnAPP.setLayoutY(350);
		btnAPP.setPrefSize(200, 100);

		pane.getChildren().add(btnAPP);

		// Pref button
		btnPREF = new Button(Strings.btnPREF);
		btnPREF.setLayoutX(350);
		btnPREF.setLayoutY(500);
		btnPREF.setPrefSize(200, 100);

		pane.getChildren().add(btnPREF);

		// Radio button
		btnRAD = new Button(Strings.btnRAD);
		btnRAD.setLayoutX(650);
		btnRAD.setLayoutY(60);
		btnRAD.setPrefSize(200, 100);

		pane.getChildren().add(btnRAD);

		// TV button
		btnTV = new Button(Strings.btnTV);
		btnTV.setLayoutX(650);
		btnTV.setLayoutY(200);
		btnTV.setPrefSize(100, 100);

		pane.getChildren().add(btnTV);

		// DVD button
		btnDVD = new Button(Strings.btnDVD);
		btnDVD.setLayoutX(750);
		btnDVD.setLayoutY(200);
		btnDVD.setPrefSize(100, 100);

		pane.getChildren().add(btnDVD);

		// USB button
		btnUSB = new Button(Strings.btnUSB);
		btnUSB.setLayoutX(650);
		btnUSB.setLayoutY(350);
		btnUSB.setPrefSize(200, 100);

		pane.getChildren().add(btnUSB);

		// Bluetooth button
		btnBt = new Button(Strings.btnBt);
		btnBt.setLayoutX(650);
		btnBt.setLayoutY(500);
		btnBt.setPrefSize(100, 100);

		pane.getChildren().add(btnBt);

		// AUX button
		btnAUX = new Button(Strings.btnAUX);
		btnAUX.setLayoutX(750);
		btnAUX.setLayoutY(500);
		btnAUX.setPrefSize(100, 100);

		pane.getChildren().add(btnAUX);

		Date hoje = new Date();
		SimpleDateFormat tipoDate;
		tipoDate = new SimpleDateFormat("dd/MM/yyyy");
		Label data = new Label(tipoDate.format(hoje));
		Font font = Font.font("Arial", FontWeight.EXTRA_BOLD, 40);
		data.setTextFill(Color.web("#0076a3"));
		data.setEffect(new DropShadow(10, Color.RED));
		data.setFont(font);
		dataMainStage = data;
		dataMainStage.setLayoutX(50);
		dataMainStage.setLayoutY(200);

		pane.getChildren().add(dataMainStage);

		Label lblRelogio = new Label();
		relogioMainStage = lblRelogio;
		SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss a");
		Font fonte = Font.font("Arial", FontWeight.EXTRA_BOLD, 40);
		lblRelogio.setTextFill(Color.web("#0076a3"));
		lblRelogio.setFont(fonte);
		lblRelogio.setEffect(new DropShadow(10, Color.RED));
		Date agora = new Date();
		lblRelogio.setText(formatador.format(agora)); 
		KeyFrame frame = new KeyFrame(Duration.millis(1000));
		Timeline timeline = new Timeline(frame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
		relogioMainStage.setLayoutX(50);
		relogioMainStage.setLayoutY(250);

		pane.getChildren().add(relogioMainStage);

	
		stage.setTitle(Strings.appTitle);
		stage.setResizable(false);
		stage.show();
	}

}
