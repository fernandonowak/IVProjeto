package br.edu.ifsc.ivprojeto.stages;

import java.io.FileInputStream;
import java.util.ArrayList;

import br.edu.ifsc.ivprojeto.util.DB;
import br.edu.ifsc.ivprojeto.entities.Contact;
import br.edu.ifsc.ivprojeto.util.Strings;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ligar extends Application {

	public Button btnMainStage;
	public Button btnAddContact;
	public Button btnDel;
	public Label label1;
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
		btnMainStage.setLayoutX(850);
		btnMainStage.setLayoutY(600);
		btnMainStage.setPrefSize(50, 50);

		btnMainStage.setOnMouseClicked(e -> {
			try {
				new MainStage(new Stage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			stage.close();

		});

		pane.getChildren().add(btnMainStage);
		
		btnAddContact = new Button(Strings.btnAddContact);
		btnAddContact.setLayoutX(620);
		btnAddContact.setLayoutY(40);
		btnAddContact.setPrefSize(300, 50);
		
		btnAddContact.setOnMouseClicked(e -> {
			try {
				new AddContact(new Stage());
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

		
		pane.getChildren().add(btnAddContact);
		
		

		////////////// create contacts table////////

		TableView<Contact> table = new TableView<Contact>();
		table.setPrefSize(600, 550);
		table.setEditable(true);

		label1 = new Label(Strings.tableTitle);
		label1.setFont(new Font("Arial", 20));
		label1.setTextFill(Color.web("#0076a3"));

		TableColumn<Contact, String> firstNameCol = new TableColumn<>(Strings.firstNameTitle);
		TableColumn<Contact, String> lastNameCol = new TableColumn<>(Strings.lastNameTitle);
		TableColumn<Contact, String> numberCol = new TableColumn<>(Strings.numberTitle);

		firstNameCol.setPrefWidth(200);
		firstNameCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("firstName"));
		firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		table.getColumns().add(firstNameCol);

		lastNameCol.setPrefWidth(200);
		lastNameCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("lastName"));
		lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
		table.getColumns().add(lastNameCol);

		numberCol.setPrefWidth(200);
		numberCol.setCellValueFactory(new PropertyValueFactory<Contact, String>("number"));
		numberCol.setCellFactory(TextFieldTableCell.forTableColumn());
		table.getColumns().add(numberCol);


		vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));

		vbox.getChildren().addAll(label1, table);

		pane.getChildren().addAll(vbox);
		
		table.setItems(DB.contacts.getContact());

		stage.setScene(scene);

		stage.show();
		
		btnDel = new Button(Strings.btnDel);
		btnDel.setLayoutX(620);
		btnDel.setLayoutY(120);
		btnDel.setPrefSize(300, 50);
		
		btnDel.setOnMouseClicked(e -> {	
			table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
		});
		pane.getChildren().add(btnDel);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

	}

}
