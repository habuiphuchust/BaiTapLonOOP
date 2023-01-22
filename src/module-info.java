module lsVN_nhom11 {
	exports view;
	exports model;
	exports crawl;

	requires com.google.gson;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires org.jsoup;
	requires java.compiler;
	requires java.xml;
	requires javafx.web;
	opens model to com.google.gson;
	opens view to javafx.fxml;

}
//module lsVN_nhom11 {
//	requires javafx.controls;
//	requires javafx.fxml;
//	requires org.jsoup;
//	requires java.compiler;
//	requires com.google.gson;
//	
//	opens view to javafx.graphics, javafx.fxml;
//}


