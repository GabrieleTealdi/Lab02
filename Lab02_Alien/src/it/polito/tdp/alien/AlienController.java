package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
    
    private AlienDictionary model;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String s = txtWord.getText();
    	String[] arr = s.split(" ");
    	if (arr.length==2) {
    		String aw = arr[0].substring(1, arr[0].length()-1).toLowerCase();
    		String t = arr[1].substring(1, arr[1].length()-1).toLowerCase();
    		if(!model.checkWord(aw, t)) {
    			model.addWord(aw, t);
    		} else {
    			this.txtResult.setText("la parola aliena è gia presente nel dizionario");
    		}
    		txtWord.clear();
    	}
    	if (arr.length==1) {
    		String aw = arr[0].substring(1, arr[0].length()-1).toLowerCase();
    		if(aw.indexOf("?")!=-1) {
    			String [] array = aw.split(Pattern.quote("?"));
    			txtResult.setText(model.findWord(array[0], array[1]));
    		}else {
    		txtResult.setText(model.translateWord(aw));
    		}
    		
    	}
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtWord.clear();
    	txtResult.clear();
    }


	public void setModel(AlienDictionary model) {
		this.model = model;
	}
    
}
