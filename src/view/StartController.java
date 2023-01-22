package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import crawl.Crawl;
import crawl.CrawlTD;
import crawl.CrawlTask;
import crawl.CrawlVuaVN;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class StartController implements Initializable {
	@FXML
	private Button batdau;
	@FXML
	private Button Start;
	@FXML
	private Button Cancel;
	@FXML 
	private ProgressBar pbar;
	@FXML
	private WebView webview;
	@FXML
	private ProgressIndicator pIndicator;
	@FXML
	private Label lb1;
	
	private CrawlTask task;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void clickedBD(ActionEvent e) throws IOException {
		Parent home = (Parent)FXMLLoader.load(getClass().getResource("Main.fxml"));
		Scene scene = new Scene(home,1080,700);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage st = (Stage)batdau.getScene().getWindow();
		st.setScene(scene);
		st.show();
	}
	public void clickedStart(ActionEvent e) {
		Start.setDisable(true);
		Cancel.setDisable(false);
		batdau.setDisable(true);
		task = new CrawlTask();
		pbar.progressProperty().bind(task.progressProperty());
		pIndicator.progressProperty().bind(task.progressProperty());
		lb1.textProperty().bind(task.messageProperty());
		//khi hoan thanh
		task.addEventHandler(WorkerStateEvent.WORKER_STATE_SUCCEEDED, new EventHandler<WorkerStateEvent>() {

			@Override
			public void handle(WorkerStateEvent arg0) {
				// TODO Auto-generated method stub
				batdau.setDisable(false);
				Cancel.setDisable(true);
				
			}
		});
		new Thread(task).start();

	}
	public void clickedCancel (ActionEvent e) {
		Start.setDisable(false);
		Cancel.setDisable(true);
		batdau.setDisable(false);
		pbar.progressProperty().unbind();
		pIndicator.progressProperty().unbind();
		lb1.textProperty().unbind();
		if (task != null)
			task.cancel(true);
		lb1.setText("đã hủy lấy dữ liệu");
	}

}
