 package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import com.base.donnees.Etudiant;
import com.base.donnees.Filiere;
import com.base.donnees.Niveau;
import com.gestion.dao.FiliereDao;
import com.gestion.dao.NiveauDao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.RadioButton;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class AjouterEtudiantController implements Initializable {
	@FXML
	private AnchorPane ajouterEtudiant;
	@FXML
	private TextField matricule;
	@FXML
	private TextField nom;
	@FXML
	private TextField prenom;
	@FXML
	private DatePicker date;
	@FXML
	private RadioButton masculin;
	@FXML
	private ToggleGroup genre;
	@FXML
	private RadioButton feminin;
	@FXML
	private TextField mail;
	@FXML
	private ComboBox filiere;
	@FXML
	private ComboBox niveau;
	@FXML
	private Button valider;
	@FXML
	private Label id_agent;

	// Event Listener on ComboBox[#filiere].onAction
	@FXML
	public void filiereOnAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on ComboBox[#niveau].onAction
	@FXML
	public void niveauOnAction(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#valider].onAction
	@FXML
	public void validerOnAction(ActionEvent event) {
		// TODO Autogenerated
		try {	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Versement.fxml"));
			AnchorPane pane = (AnchorPane) loader.load();
			ajouterEtudiant.getChildren().setAll(pane);
			VersementController versement= loader.getController();
			versement.matriculeDefaut(matricule.getText());
			versement.Id_agentdefaut(id_agent.getText());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		fonctionDeChargementComboBox();
		
	}
	
	
	
	public  void fonctionDeChargementComboBox() {
		//Remplissage du comboBox avec les elemenst de la classe Niveau
		 List < Niveau > niveaux = null;
			NiveauDao dd = new NiveauDao();
			niveaux=dd.getAllNiveau();
			ObservableList<String> listeNiveau = FXCollections.observableArrayList();
			
			for (Niveau niveau : niveaux) {
				
				listeNiveau.add(niveau.getLibelle());
			}
			
			niveau.setItems(listeNiveau);
		
		//Remplissage du comboBox avec leselemenst de la classe Filiere
			List<Filiere> filieres = null;
			FiliereDao kk = new FiliereDao();
			filieres=kk.getAllFiliere();

			ObservableList<String> listeFiliere = FXCollections.observableArrayList();
				for (Filiere filiere : filieres) {
								
								listeFiliere.add(filiere.getLibelle())	;
							}
				filiere.setItems(listeFiliere);
	}
	
	//Fonction pour recupperer le id de l'agent en ligne
	public void setidAgent(String s) {
		id_agent= new Label();
		id_agent.setVisible(false);
		id_agent.setText(s);
		
	}
}
