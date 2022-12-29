module GestionBanque {
	requires javafx.fxml;
	requires javafx.controls;
	requires java.base;
	requires transitive javafx.graphics;
	
	
	requires jdk.compiler;
	requires javafx.base;
	exports modeles;
	exports Application;
	opens modeles;
	opens controleurs;
	exports controleurs;
	exports DAO;
	opens DAO;
	exports Services;
	opens Services;
	requires transitive java.sql;
}