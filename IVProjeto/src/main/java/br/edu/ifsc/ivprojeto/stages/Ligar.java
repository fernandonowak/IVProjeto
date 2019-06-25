package br.edu.ifsc.ivprojeto.stages;

import java.io.FileInputStream;

import br.edu.ifsc.ivprojeto.util.Strings;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ligar extends Application {

	public Button btnMainStage;
	public TableView table;
	public Label label1;
	public TableColumn firstNameCol;
	public TableColumn lastNameCol;
	public TableColumn numberCol;
	public VBox vbox;

	public Ligar(Stage stage) throws Exception {
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

			// new AddUserStage(new Stage());

		});

		pane.getChildren().add(btnMainStage);

		////////////// criando tabela de contatos//////

		table = new TableView();
		table.setPrefSize(600, 550);

		label1 = new Label(Strings.tableTitle);
		label1.setFont(new Font("Arial", 20));

		table.setEditable(true);

		firstNameCol = new TableColumn(Strings.firstNameTitle);
		firstNameCol.setPrefWidth(200);
		lastNameCol = new TableColumn(Strings.lastNameTitle);
		lastNameCol.setPrefWidth(200);
		numberCol = new TableColumn(Strings.numberTitle);
		numberCol.setPrefWidth(200);

		table.getColumns().addAll(firstNameCol, lastNameCol, numberCol);

		vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		
		vbox.getChildren().addAll(label1, table);

		pane.getChildren().addAll(vbox);

		stage.setScene(scene);

		stage.show();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

}
