package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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

public class ModifierEtudiantController implements Initializable {
	@FXML
	private AnchorPane contenu;
	@FXML
	private TextField matricule;
	@FXML
	private TextField nom;
	@FXML
	private TextField prenom;
	@FXML
	private DatePicker date;
	@FXML
	private TextField mail;
	@FXML
	private RadioButton masculin;
	@FXML
	private ToggleGroup genre;
	@FXML
	private RadioButton feminin;
	@FXML
	private ComboBox filiere;
	@FXML
	private ComboBox niveau;
	@FXML
	private Button modifier;

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
	// Event Listener on Button[#modifier].onAction
	@FXML
	public void modifierOnAction(ActionEvent event) {
		// TODO Autogenerated
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//ObservableList< String> liste = FXCollections.observableArrayList("java","php","C","python");
		//filiere.setItems(liste);
		
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
}
