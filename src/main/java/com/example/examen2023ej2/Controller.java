package com.example.examen2023ej2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btnCalcular;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnMostrar;

    @FXML
    private CheckBox chCena;

    @FXML
    private CheckBox chComida;

    @FXML
    private CheckBox chDesayuno;

    @FXML
    private Label lbCiudadDestino;

    @FXML
    private Label lbCiudadOrigen;

    @FXML
    private Label lbExtras;

    @FXML
    private Label lbNombre;

    @FXML
    private Label lbTarifa;

    @FXML
    private ChoiceBox<String> tfCiudadDestino;

    @FXML
    private TextField tfCiudadOrigen;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfTarifa;
    ObservableList<String> listaDestinos;
    ObservableList<CheckBox> extras;
    Double tarifa;

    @FXML
    void Calcular(ActionEvent event) {
        tarifa=0.0;
        if(tfCiudadDestino.getSelectionModel().getSelectedItem().equals("Madrid")){
            tarifa+=50;
        }
        if(tfCiudadDestino.getSelectionModel().getSelectedItem().equals("Barcelona")){
            tarifa+=90;
        }
        if(tfCiudadDestino.getSelectionModel().getSelectedItem().equals("Malaga")){
            tarifa+=100;
        }

        for (CheckBox ch:extras){
            if(ch.isSelected()){
                tarifa+=(Integer)ch.getUserData();
            }
        }
        tfTarifa.setText(tarifa.toString());

    }

    @FXML
    void Cancelar(ActionEvent event) {
        tfNombre.setText("");
        tfTarifa.setText("");
        tfCiudadDestino.getItems().clear();
        listaDestinos=FXCollections.observableArrayList("Madrid", "Barcelona","Malaga");
        tfCiudadDestino.setItems(listaDestinos);
        for(CheckBox ch:extras){
            ch.setSelected(false);
        }


    }

    @FXML
    void Guardar(ActionEvent event) {

        CrearAlerta("INFORMATION","Billete","El usuario "+tfNombre.getText() + " ha comprado un billete con origen Vigo y destino "+
                tfCiudadDestino.getSelectionModel().getSelectedItem()+ " y la tarifa es "+tfTarifa.getText()+"€");

    }

    @FXML
    void Mostrar(ActionEvent event) {

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("viewej1.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Ciudades");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);

            //loader.getController(): Este método devuelve el controlador asociado al archivo FXML que se está cargando
            Controllerej1 controller=loader.getController();
            //controller.MostrarDatos(alumno);
            stage.showAndWait();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("JOLS");
        }



    }


    private void CrearAlerta(String tipoAlerta, String titulo, String mensaje) {
        Alert alert=new Alert(Alert.AlertType.valueOf(tipoAlerta));
        //alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaDestinos=FXCollections.observableArrayList("Madrid", "Barcelona","Malaga");
        tfCiudadDestino.setItems(listaDestinos);
        chCena.setUserData(25);
        chDesayuno.setUserData(15);
        chComida.setUserData(30);
        extras=FXCollections.observableArrayList(chCena,chComida,chDesayuno);

    }
}
