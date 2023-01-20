package view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import model.LichSu;
import model.LuuTru;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class SampleController implements Initializable{
	@FXML
	private ListView<LichSu> hienthi;
	@FXML
	private TextArea textarea;
	@FXML
	private TextField textfield;
	
	private ObservableList<LichSu> oList;
	FilteredList<LichSu> filterData;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	    oList = FXCollections.observableList(LuuTru.getTrieuDai());
	    oList.addAll(LuuTru.getVua());
	    filterData = new FilteredList<>(oList, s -> true);
		hienthi.setItems(filterData);
		textfield.textProperty().addListener(obs -> {
			String filter = textfield.getText();
			filterData.setPredicate(filter.trim().isEmpty() ? s -> true : s -> s.chiTiet().toLowerCase().contains(filter.toLowerCase()));
		});
	}
	public void clickList (MouseEvent e) {
		LichSu td = hienthi.getSelectionModel().getSelectedItem();
		textarea.setText(td.chiTiet());
//		System.out.println(td.toString());
	}

}
