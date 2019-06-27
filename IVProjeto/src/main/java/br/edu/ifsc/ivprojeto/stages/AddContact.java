package br.edu.ifsc.ivprojeto.stages;

import br.edu.ifsc.ivprojeto.util.DB;
import br.edu.ifsc.ivprojeto.util.Strings;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AddContact {

	private TextField txtContactName;
	private TextField txtContactLastName;
	private TextField txtContactNumber;
	private Button btnAdd;
	//private Button btnDel;
	private Button btnCancel;

	public AddContact(Stage stage) throws Exception {

		// creating the classes hierarchy (pane -> scene -> stage)
		AnchorPane pane = new AnchorPane();
		pane.setPrefSize(170, 190);
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		txtContactName = new TextField();
		txtContactName.setLayoutX(10);
		txtContactName.setLayoutY(10);
		txtContactName.setPrefSize(150, 20);
		txtContactName.setPromptText(Strings.newContactName);

		pane.getChildren().add(txtContactName);

		txtContactLastName = new TextField();
		txtContactLastName.setLayoutX(10);
		txtContactLastName.setLayoutY(45);
		txtContactLastName.setPrefSize(150, 20);
		txtContactLastName.setPromptText(Strings.newContactLastName);

		pane.getChildren().add(txtContactLastName);

		txtContactNumber = new TextField();
		txtContactNumber.setLayoutX(10);
		txtContactNumber.setLayoutY(80);
		txtContactNumber.setPrefSize(150, 20);
		txtContactNumber.setPromptText(Strings.newContactNumber);

		pane.getChildren().add(txtContactNumber);

		btnAdd = new Button(Strings.btnAdd);
		btnAdd.setLayoutX(10);
		btnAdd.setLayoutY(120);
		btnAdd.setPrefSize(150, 20);

		btnAdd.setOnMouseClicked(e -> {
			if(txtContactName.getText() == null || txtContactLastName.getText() == null || txtContactNumber.getText() == null) {
				txtFieldError();
			}else {
				DB.contacts.addContact(txtContactName.getText(), txtContactLastName.getText(),
						txtContactNumber.getText());
				stage.close();
			}
		});

		pane.getChildren().add(btnAdd);
		

		btnCancel = new Button(Strings.btnCancel);
		btnCancel.setLayoutX(10);
		btnCancel.setLayoutY(150);
		btnCancel.setPrefSize(150, 20);

		btnCancel.setOnMouseClicked(e -> {
			stage.close();
		});
		pane.getChildren().add(btnCancel);

		stage.show();

	}

	private void txtFieldError() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(Strings.txtFieldError);
		alert.setHeaderText(Strings.txtFieldError);
		alert.showAndWait();
	}

}