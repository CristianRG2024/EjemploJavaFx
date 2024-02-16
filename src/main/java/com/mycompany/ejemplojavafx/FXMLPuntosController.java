/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.ejemplojavafx;



import Modelo.Puntos;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.net.URL;
import java.util.LinkedList;

import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONObject;
import org.json.JSONArray;



/**
 * FXML Controller class
 *
 * @author cristian_d.ramirez
 */
public class FXMLPuntosController implements Initializable {

   
    
    @FXML
    public Canvas idCanvas;
    
    @FXML 
    public TextArea idTextArea;
    
   
   @FXML
    public Label idLabel;
   
   @FXML 
   public MenuBar idMenuBar;
    
    GraphicsContext g;
    
    LinkedList<Puntos> listaP;
    public static Stage s;
   
   
    @FXML
    private void getCoordenadas(MouseEvent m) {
        
        listaP = new LinkedList<>();
        
        double x= m.getX();
        double y= m.getY();
        
        System.out.println("x"+ x + ",y"+ y);    
        listaP.add(new Puntos(x,y));
    }
    
    @FXML
    private void saveFile (ActionEvent a) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("GUARDAR ARCHIVO");
        fileChooser.getExtensionFilters().addAll(
                
                new FileChooser.ExtensionFilter("Archivos de texto", "*.json*"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*"));
                //new FileChooser.ExtensionFilter
                
                fileChooser.setInitialFileName("archivo.json");
        
        File file = fileChooser.showSaveDialog(s);
        if (file != null){
            System.out.println("Archivo guardado en:" + file.getPath());
             if (!file.getPath().endsWith(".json")) {
            file = new File(file.getPath() + ".json");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            JSONArray jsonArray = new JSONArray();

            // Convertir cada objeto Puntos en un objeto JSONObject y agregarlo al JSONArray
            for (Puntos punto : listaP) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("x", punto.getX());
                jsonObject.put("y", punto.getY());
                jsonArray.put(jsonObject);
            }

            // Convertir el JSONArray a una cadena de texto en formato JSON
            String jsonString = jsonArray.toString();
            
              // Escribir la cadena de texto en el archivo
            writer.write(jsonString);
        }catch (IOException e) {
            e.printStackTrace();
        }
        
         }
        }
    }   
    
    
    
    /**
     * 
     
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        g=idCanvas.getGraphicsContext2D();
        double h = idCanvas.getHeight();
        double w = idCanvas.getWidth();
        
        g.setStroke(Color.RED);
        g.setLineWidth(3);
        g.strokeRect(0, 0, w, h);
      
    }
    
     @FXML
    private void mostrarPuntos(ActionEvent a) {
        
        String mostrar = "";
      
         for (int i = 0; i < listaP.size(); i++) {
             Puntos get = listaP.get(i);
             mostrar += get.toString() + "\n";
             
             
         }
         idTextArea.setText(mostrar);
        
        
        
       
  
    }
}

