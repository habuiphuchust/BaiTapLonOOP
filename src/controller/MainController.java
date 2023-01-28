package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import model.LayDuLieu;
import model.LeHoi;
import model.LichSu;
import model.SuKien;
import model.TrieuDai;
import model.VuaVN;
import utility.Search;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainController implements Initializable{
	@FXML
	private ListView<LichSu> hienthi;
	@FXML
	private TextField textfield;
	@FXML 
	private ChoiceBox<String> choicebox;
	@FXML 
	private WebView webview;
	@FXML
	private Button back;
	
	private ObservableList<LichSu> oList;
	FilteredList<LichSu> filterData = null;
	//khoi tao item choicebox
	String all = "Tất cả", td = "Triều Đại", vua = "Vua", lehoi = "Lễ Hội", sukien = "Sự Kiện";
	//bo loc
	private Predicate<LichSu> listView;
	private Predicate<LichSu> trieudai, vu, leho, sk;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// khoi tao bo loc
		trieudai = s -> (s instanceof TrieuDai);
		vu = s -> (s instanceof VuaVN);
		leho = s -> (s instanceof LeHoi);
		sk = s -> (s instanceof SuKien);
		
		//tao xu ly su kien tim kiem choicebox + textfield
		InvalidationListener chon = new InvalidationListener() {		
			@Override
			public void invalidated(Observable arg0) {
				// TODO Auto-generated method stub
				String text = choicebox.getSelectionModel().getSelectedItem();
				listView = textfield.getText().trim().isEmpty() ? s -> true : s -> 	s.chiTiet().toLowerCase().contains(textfield.getText().toLowerCase());
				filterData.setPredicate(listView);
				if (text == vua)
					filterData.setPredicate(listView.and(vu));
				else if (text == td)
					filterData.setPredicate(listView.and(trieudai));
				else if (text == lehoi)
					filterData.setPredicate(listView.and(leho));
				else if (text == sukien)
					filterData.setPredicate(listView.and(sk));
			}
		};
		// khoi tao listview va them du lieu
		//them du lieu
	    oList = FXCollections.observableList(LayDuLieu.getTrieuDai());
	    oList.addAll(LayDuLieu.getVua());
	    oList.addAll(LayDuLieu.getLeHoi());
	    oList.addAll(LayDuLieu.getSuKien());
	    
	    //tao listview
	    filterData = new FilteredList<>(oList, s -> true);
		hienthi.setItems(filterData);
		textfield.textProperty().addListener(chon);
				
		// khoi tao choicebox
		ObservableList<String> itemChoicebox = FXCollections.observableArrayList(all, td, vua, lehoi, sukien);
		choicebox.setItems(itemChoicebox);
		choicebox.getSelectionModel().selectFirst();
		choicebox.getSelectionModel().selectedItemProperty().addListener(chon);
		
		
	}
	//hien thi len webview
	public void clickList (MouseEvent e) {
		LichSu td = hienthi.getSelectionModel().getSelectedItem();
		if (td != null) {
			String text = td.chiTiet();
			//tu dong xuong dong
//			text = text.replaceAll("(.{1,80})\\s+", "$1<br>");
			text = text.replaceAll("\n", "<br>");
			String tk = textfield.getText().trim();
			//to mau tim kiem
			if (!tk.isEmpty()) 
				text = Search.search(text, tk, "yellow");
			
			webview.getEngine().loadContent(text);
		}
		
	}
	public void clickedBack (ActionEvent e) throws IOException {
		Parent home = (Parent)FXMLLoader.load(getClass().getResource("/view/start.fxml"));
		Scene scene = new Scene(home,1080,700);
		scene.getStylesheets().add(getClass().getResource("/view/application.css").toExternalForm());
		Stage st = (Stage)back.getScene().getWindow();
//		st.hide();
		st.setScene(scene);
		st.show();
	}

}
