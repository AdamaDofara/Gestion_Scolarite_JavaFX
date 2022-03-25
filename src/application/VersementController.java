package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import com.base.donnees.Agentdescolarite;
import com.base.donnees.Etudiant;
import com.base.donnees.Versement;
import com.base.donnees.VersementId;
import com.gestion.dao.AgentdescolariteDao;
import com.gestion.dao.EtudiantDao;
import com.gestion.dao.VersementDao;

import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;

import javafx.scene.control.DatePicker;

public class VersementController implements Initializable {
	@FXML
	private AnchorPane versement;
	@FXML
	private TextField matricule;
	@FXML
	private TextField id_agent;
	@FXML
	private TextField montant;
	@FXML
	private Button valider;
	@FXML
	private DatePicker date_versement;

	// Event Listener on Button[#valider].onAction
	@FXML
	public void ValiderOnAction(ActionEvent event) {
		// TODO Autogenerated
		
		VersementId v= new VersementId(Integer.parseInt(id_agent.getText()), matricule.getText());
		Agentdescolarite agt = new Agentdescolarite();
		AgentdescolariteDao gg= new AgentdescolariteDao();
		agt=gg.getAgentScoById(Integer.parseInt(id_agent.getText()));
		Etudiant et = new Etudiant();
		EtudiantDao tt= new EtudiantDao();
		et=tt.getEtudiantByMatricule(matricule.getText());
		//System.out.println(matricule.getText()+" "+Integer.parseInt(id_agent.getText())+ " "+id_agent.getText());
		LocalDate jj1 = date_versement.getValue();
		Date dat= java.sql.Date.valueOf(jj1);
		// Ajout de differents valeurs de l'objet versement
		Versement versement = new Versement();
		versement.setId(v);
		versement.setDateVersement(dat);
		versement.setEtudiant(et);
		versement.setAgentdescolarite(agt);
		versement.setMontant(Double.parseDouble(montant.getText()));
		//Creation d'un objet de typer versement pour executer la methode qui permet d'enregistrer
		VersementDao execution = new VersementDao();
		execution.saveVersement(versement);
		//on remet le contenu des champs a vide
		montant.setText("");
		//ouverture d'une boite de dialogue pour dire que l'enregistrement a ete fait
		authentificationController auth = new authentificationController();
		auth.boiteDialogue(AlertType.INFORMATION, "Versement en registr� avec succ�ss !!!");
		AccueilController acc = new AccueilController();
		acc.chargementFonction("listeEtudiant.fxml");
		//jj= jj1.
		//Versement versee= new Versement(v, agt, et,null  , 0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void matriculeDefaut(String s) {
		
		matricule.setText(s);
		matricule.setEditable(false);
	}
	public void Id_agentdefaut(String s) {
		id_agent.setText(s);
		id_agent.setEditable(false);
	}
	public void id_agent(String s) {
		id_agent = new TextField();
		id_agent.setText(s);
		id_agent.setEditable(false);
	}
	
}
