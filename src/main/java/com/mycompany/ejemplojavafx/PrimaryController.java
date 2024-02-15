package com.mycompany.ejemplojavafx;

import Modelo.Puntos;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PrimaryController {
    
  @FXML 
    public TextArea idTextArea1;
    
    @FXML 
    public TextArea idTextArea2;
    
    @FXML
    public Canvas canvasPuntos;
    
    @FXML
    
    private void actionBotonInicio() throws IOException {
                  System.out.println("Action S");
                  
                  
        //App.setRoot("secondary");
    }
    @FXML
    
    private void actionBotonFinal() throws IOException{
                System.out.println("Action B");
                
    }
    @FXML
    private void actionBotonRemoverInicio() throws IOException{

    }
    @FXML
    private void actionBotonRemoverFinal() throws IOException{
        
    }
    @FXML
    private void actionBotonOrdenarAscendente() throws IOException{
        
    }
    @FXML
    private void actionBotonOrdenarDescendente() throws IOException{
        
    }
    @FXML
    private void actionBotonMostrar() throws IOException {
        
    }
    @FXML
    private void actionBotonInvertir() throws IOException{
        
    }
    @FXML
    private void getCoordenadas(MouseEvent event) {
    double x = event.getX();
    double y = event.getY();
    System.out.printf("Coordenadas del clic: %s%n", new Puntos(x, y));
    // Crear un objeto Punto con las coordenadas del clic
    Puntos puntoClic = new Puntos(x, y);
    // Mostrar las coordenadas en los TextArea
    idTextArea1.setText(Double.toString(puntoClic.getX()));
    idTextArea2.setText(Double.toString(puntoClic.getY()));
}
    
    /**
     * 
     
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) { 
        // TODO
    
        canvasPuntos.setOnMouseClicked(this::getCoordenadas); 
    }    
}
