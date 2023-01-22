package view;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import model.LichSu;
import model.LuuTru;
import model.TrieuDai;
import model.VuaVN;
import utility.LowerCaseReplace;
import utility.Search;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebView;

public class MainController implements Initializable{
	@FXML
	private ListView<LichSu> hienthi;
	@FXML
	private TextArea textarea;
	@FXML
	private TextField textfield;
	@FXML 
	private ChoiceBox<String> choicebox;
	@FXML 
	private WebView webview;
	
	private ObservableList<LichSu> oList;
	FilteredList<LichSu> filterData = null;
	//khoi tao bo tim kiem
	String all = "Tất cả", td = "Triều Đại", vua = "Vua";
	
	private Predicate<LichSu> listView;
	private Predicate<LichSu> trieudai;
	private Predicate<LichSu> vu;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// khoi tao bo loc
		trieudai = s -> (s instanceof TrieuDai);
		vu = s -> (s instanceof VuaVN);
		
		//tao loc
		InvalidationListener chon = new InvalidationListener() {
			
			@Override
			public void invalidated(Observable arg0) {
				// TODO Auto-generated method stub
				String text = choicebox.getSelectionModel().getSelectedItem();
				listView = textfield.getText().trim().isEmpty() ? s -> true : s -> 	s.chiTiet().toLowerCase().contains(textfield.getText().toLowerCase());
				filterData.setPredicate(listView);
				if (text == vua)
					filterData.setPredicate(listView.and(vu));
				if (text == td)
					filterData.setPredicate(listView.and(trieudai));
			}
		};
		// khoi tao listview
	    oList = FXCollections.observableList(LuuTru.getTrieuDai());
	    oList.addAll(LuuTru.getVua());
	    filterData = new FilteredList<>(oList, s -> true);
		hienthi.setItems(filterData);
		textfield.textProperty().addListener(chon);
				
		// khoi tao choicebox
		ObservableList<String> itemChoicebox = 		FXCollections.observableArrayList(all, td, vua);
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
			text = text.replaceAll("(.{1,80})\\s+", "$1<br>");
			String tk = textfield.getText().trim();
			//to mau tim kiem
			if (!tk.isEmpty()) 
				text = Search.search(text, tk, "yellow");
			
			webview.getEngine().loadContent(text);
		}
		
	}

}
