package com.example.examen2023ej2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    void Calcular(ActionEvent event) {

    }

    @FXML
    void Cancelar(ActionEvent event) {

    }

    @FXML
    void Guardar(ActionEvent event) {

    }

    @FXML
    void Mostrar(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FXCollections.observableArrayList("Madrid", "Barcelona","Malaga");

    }
}
