package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class StartController implements Initializable {
	@FXML
	private Button batdau;
	@FXML
	private Button ok;
	@FXML
	private Button skip;
	@FXML 
	private ProgressBar pbar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void clickedBD(ActionEvent e) throws IOException {
		Parent home = (Parent)FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(home,1080,700);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage st = (Stage)batdau.getScene().getWindow();
//		st.hide();
		st.setScene(scene);
		st.show();
	}

}
