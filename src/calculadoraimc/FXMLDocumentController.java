/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraimc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author daw
 */
public class FXMLDocumentController implements Initializable {
    Double altura;
    Double alturaCm;
    Double peso;
    Double imc;
    private Label label;
    @FXML
    private ScrollBar ScrollPeso;
    @FXML
    private Slider SlideAltura;
    @FXML
    private RadioButton Delgadez;
    @FXML
    private RadioButton Normal;
    @FXML
    private RadioButton SobrePreso;
    @FXML
    private RadioButton Obesidad;
    @FXML
    private TextField Resultado;
    @FXML
    private Label ResultadoLabel;
    @FXML
    private Button BotonIMC;
    @FXML
    private TextField Peso;
    @FXML
    private TextField Estatura;
    @FXML
    private Label PesoLabel;
    @FXML
    private Label AlturaLabel;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SlideDeAltura(MouseEvent event) {
        this.Estatura.setText(String.valueOf(this.SlideAltura.getValue()));
    }

    @FXML
    private void ActionDelgadez(ActionEvent event) {
    }

    @FXML
    private void ActionNormal(ActionEvent event) {
    }

    @FXML
    private void ActionSobrepeso(ActionEvent event) {
    }

    @FXML
    private void ActionObesidad(ActionEvent event) {
    }

    @FXML
    private void IMC(ActionEvent event) {
    }

    @FXML
    private void CalcularIMC(ActionEvent event) {
         try{
            alturaCm = Double.parseDouble(this.Estatura.getText());
        }catch(Exception e){
           this.Estatura.setText("Datos no validos");
           this.Estatura.setStyle("-fx-border-color: #fb0000 ; -fx-text-inner-color: #fb0000");
       } 
       altura=alturaCm/100;
       try{
       peso=Double.parseDouble(this.Peso.getText());
       }catch(Exception e){
           this.Peso.setText("Datos no validos");
           this.Peso.setStyle("-fx-border-color: #fb0000 ; -fx-text-inner-color: #fb0000");
       } 
       imc=peso/(Math.pow(altura, 2));
       color(imc);
       this.Resultado.setText(""+imc);
        if (imc>30) {
       this.SobrePreso.setSelected(false);
       this.Normal.setSelected(false);
       this.Delgadez.setSelected(false);
            this.Obesidad.setSelected(true);
        }
        if(imc<29.9 && imc>25){
             this.Obesidad.setSelected(false);
       this.Normal.setSelected(false);
       this.Delgadez.setSelected(false);
            this.SobrePreso.setSelected(true);
          }
        if (imc<24.9 && imc>18.5) {
             this.Obesidad.setSelected(false);
       this.SobrePreso.setSelected(false);
       this.Delgadez.setSelected(false);
              this.Normal.setSelected(true);
        }
        if(imc<18.5){
             this.Obesidad.setSelected(false);
       this.SobrePreso.setSelected(false);
       this.Normal.setSelected(false);
           this.Delgadez.setSelected(true);
        }
    }
    public void color(double color){
        if(color > 30 || color < 18.4){
            this.Resultado.setStyle("-fx-background-color: #fb0000 ; -fx-text-inner-color: #fbec00");
            
        }else if (color<29.9 && color>25){
            this.Resultado.setStyle("-fx-background-color: #fbec00 ; -fx-text-inner-color: #656565");
        }else{
         this.Resultado.setStyle("-fx-background-color: #48fb00 ; -fx-text-inner-color: #ffffff");
        }
    }

    @FXML
    private void IntroducirPeso(ActionEvent event) {
    }

    @FXML
    private void IntroducirAltura(ActionEvent event) {
    }

    @FXML
    private void ScrollDePeso(MouseEvent event) {
        this.Peso.setText(String.valueOf(this.ScrollPeso.getValue()));
    }

    
}
