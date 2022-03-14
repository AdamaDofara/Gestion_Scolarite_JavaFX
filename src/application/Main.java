package application;
	
import java.util.List;
import java.util.ResourceBundle;

import com.base.donnees.Directeur;
import com.base.donnees.Filiere;
import com.gestion.dao.DirecteurDao;
import com.gestion.dao.FiliereDao;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			primaryStage.initStyle(StageStyle.UNDECORATED);
			root = FXMLLoader.load(Main.class.getResource("authentification.fxml"));
			//Parent root = new FXMLLoader().load(getClass().getResource("authentification.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
		List<Filiere> filiere = null;
		FiliereDao dd = new FiliereDao();
		try {
			filiere = dd.getAllFiliere();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (Filiere filiere1 : filiere) {
        	 //System.out.println(filiere1.getLibelle());
		}
        


	}
	
	
//	public void start(Stage primaryStage) {
//		try {
//			
//			Parent root;
//			root = FXMLLoader.load(getClass().getResource("authentification.fxml"));
//			Scene scene = new Scene(root);
//			primaryStage.show();
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
