package application;



import java.util.Set;

import com.base.donnees.Etudiant;
import com.base.donnees.Filiere;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;




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
	
}
