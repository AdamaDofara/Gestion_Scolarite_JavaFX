package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.base.donnees.Agentdescolarite;
import com.base.donnees.Etudiant;
import com.gestion.dao.AgentdescolariteDao;
import com.gestion.dao.EtudiantDao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;

public class SupprimerEtudiantController implements Initializable {
	@FXML
	private AnchorPane border;
	@FXML
	private ComboBox matricule;
	@FXML
	private Button supprimer;

	// Event Listener on Button[#supprmer].onAction
	@FXML
	public void SupprimerOnAction(ActionEvent event) {
		
		// TODO Autogenerated
		
		String mat= new String();
		mat=matricule.getSelectionModel().getSelectedItem().toString();
		EtudiantDao etd = new EtudiantDao();
		etd.deleteEtudiant(mat);
		authentificationController auth = new authentificationController();
		auth.boiteDialogue(AlertType.INFORMATION, "Etudiant suppprim? avec succ?s!!!");
		//affichage de la liste apres suppression
		AccueilController acc = new AccueilController();
		acc.chargementFonction("listeEtudiant.fxml");
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//Remplissage du comboBox avec les elemenst de la classe agent
		 List < Etudiant > etudiants = null;
		 EtudiantDao etd = new EtudiantDao();
		 etudiants=etd.getAllEtudiant();
			ObservableList<Object> listeEtudiant = FXCollections.observableArrayList();
			
			for (Etudiant etudiant : etudiants) {
				listeEtudiant.add(etudiant.getMatricule()/* +"- "+etudiant.getNom()+" "+etudiant.getPrenom() */);
				
			}
			
			matricule.setItems(listeEtudiant);
	}
}
