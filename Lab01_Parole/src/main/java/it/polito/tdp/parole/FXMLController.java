package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	Parole elenco;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;
    
    @FXML
    private TextArea txtTempo;
    
    @FXML
    private Button btnCanc;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	txtResult.setText("");
    	
    	String parola = txtParola.getText();
    	
    	long startTime = System.nanoTime();
    	elenco.addParola(parola);
    	long time =   System.nanoTime()- startTime;
    	
    	List<String> daStampare = elenco.getElenco();
    	String stampa= "";
    	for(String s: daStampare) {
			stampa = stampa + s + "\n";
		}
    	txtResult.setText(stampa);
    	txtParola.setText("");
    	String tempo = "" + (time);
    	txtTempo.appendText("INSERT: "+tempo + "ns"+"\n");
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.setText("");
    	txtTempo.setText("");
    	elenco.reset();
    }

    @FXML
    void doCanc(ActionEvent event) {
    	
    	String parolaCanc = txtResult.getSelectedText();
    	
    	long startTime = System.nanoTime();
    	elenco.cancella(parolaCanc);
    	long time =   System.nanoTime()- startTime;
    	
    	List<String> daStampare = elenco.getElenco();
    	String stampa= "";
    	for(String s: daStampare) {
			stampa = stampa + s + "\n";
		}
    	
    	txtResult.setText(stampa);
    	txtParola.setText("");
    	String tempo = "" + (time);
    	txtTempo.appendText("CANC: " + tempo + "ns"+"\n");
    }
    
    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCanc != null : "fx:id=\"btnCanc\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole();
    }
    //getSelectedText()
}

