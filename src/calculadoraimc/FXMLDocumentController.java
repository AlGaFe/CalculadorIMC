/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraimc;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.StageStyle;

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
        
    }    

    @FXML
    private void SlideDeAltura(MouseEvent event) {
        this.Estatura.setText(String.valueOf(this.SlideAltura.getValue()).substring(0, 6));
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
       String iMc=""+imc;
       
      this.Resultado.setText(iMc.substring(0, 6));
        if (imc>30) {
       this.SobrePreso.setSelected(false);
       this.Normal.setSelected(false);
       this.Delgadez.setSelected(false);
            this.Obesidad.setSelected(true);
            Alert dialogoAlerta = new Alert(Alert.AlertType.ERROR);
            dialogoAlerta.setTitle("Obesidad");
            dialogoAlerta.setHeaderText("Sufres una enfermedad crónica de origen multifactorial prevenible, caracterizada por la acumulación excesiva de grasa en el cuerpo");
            dialogoAlerta.setContentText("La obesidad es el quinto factor principal de riesgo de defunción humana en el mundo.\n Cada año fallecen por lo menos 2,8 millones de personas adultas como consecuencia \n de la obesidad. ¿Vas a ser el siguiente?");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
        }
        if(imc<29.9 && imc>25){
             this.Obesidad.setSelected(false);
       this.Normal.setSelected(false);
       this.Delgadez.setSelected(false);
            this.SobrePreso.setSelected(true);
             Alert dialogoAlerta = new Alert(Alert.AlertType.WARNING);
            dialogoAlerta.setTitle("Sobrepeso");
            dialogoAlerta.setHeaderText("Estás dentro del ambito del sobrepeso");
            dialogoAlerta.setContentText("Sería recomendable que cambiaras tus habitos, una alimentación más saludable y hacer mas ejercicios puede ayudarte a llevar a cabo un vida más saludable, por favor PIENSALO.");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
          }
        if (imc<24.9 && imc>18.5) {
             this.Obesidad.setSelected(false);
       this.SobrePreso.setSelected(false);
       this.Delgadez.setSelected(false);
              this.Normal.setSelected(true);
              Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("Peso Normal");
            dialogoAlerta.setHeaderText("Tus valores de IMC se encuentran en un nivel adecuado");
            dialogoAlerta.setContentText("No descuides, es muy facil entrar en malos habitos alimenticios y en una vida sedentaria.");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
        }
        if(imc<18.5){
             this.Obesidad.setSelected(false);
       this.SobrePreso.setSelected(false);
       this.Normal.setSelected(false);
           this.Delgadez.setSelected(true);
            Alert dialogoAlerta = new Alert(Alert.AlertType.INFORMATION);
            dialogoAlerta.setTitle("Extrema Delgadez");
            dialogoAlerta.setHeaderText("Tus valores de IMC se encuentran por debajo de un nivel adecuado");
            dialogoAlerta.setContentText("Los trastornos alimenticios (TCS) engloban varias enfermedades crónicas que, a pesar de que se manifiestan a través de la conducta alimentaria, consisten en una gama muy compleja de síntomas entre los que prevalece una alteración de la auto-imagen corporal, un gran temor a subir de peso y la adquisición de una serie de valores a través de una imagen corporal.");
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
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
        this.Peso.setText(String.valueOf(this.ScrollPeso.getValue()).substring(0, 6));
    }

    
}
