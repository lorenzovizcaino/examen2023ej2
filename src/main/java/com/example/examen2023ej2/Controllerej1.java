package com.example.examen2023ej2;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controllerej1 implements Initializable {

    @FXML
    private GridPane panelPrincipal;


    @FXML
    private Button btnAsignarEstilo;

    @FXML
    private Button btnQuitarEstilo;

    @FXML
    private ListView<Ciudad> listaVistaCiudades;
    @FXML
    private ImageView imagenCiudades;

    @FXML
    private  ObservableList <Ciudad> listaCiudades;
    private String rutaAbsoluta = new File("src\\main\\resources").getAbsolutePath();

    @FXML
    void AsignarEstilo(ActionEvent event) {
        Scene scene=panelPrincipal.getScene();
        try{
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("css/estilo.css")).toExternalForm());
        }catch (Exception e){
            System.out.println("no lo encuentro");
        }
    }

    @FXML
    void QuitarEstilo(ActionEvent event) {
        Scene scene=panelPrincipal.getScene();
        try{
            scene.getStylesheets().clear();

        }catch (Exception e){
            e.printStackTrace();
        }

    }







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaCiudades = FXCollections.observableArrayList(
                (new Ciudad("Madrid", rutaAbsoluta + "\\imagenes\\Madrid.jpg")),
                (new Ciudad("Barcelona", rutaAbsoluta + "\\imagenes\\Barcelona.jpg")),
                (new Ciudad("Sevilla", rutaAbsoluta + "\\imagenes\\Sevilla.jpg")),
                (new Ciudad("Malaga", rutaAbsoluta + "\\imagenes\\Malaga.jpg")),
                (new Ciudad("Valencia", rutaAbsoluta + "\\imagenes\\Valencia.jpg")),
                (new Ciudad("Oporto", rutaAbsoluta + "\\imagenes\\Oporto.jpg"))
        );


    // Vamos a asignar la lista observable a la lista
        listaVistaCiudades.setItems(listaCiudades);
    //Debes modificar el ListView para que funcione con la clase Ciudad.
        listaVistaCiudades
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Ciudad>() {
                    @Override
                    public void changed(ObservableValue<? extends Ciudad> observableValue, Ciudad ciudadVieja, Ciudad ciudadNueva) {
                        Image image=new Image(ciudadNueva.getUrl());
                        imagenCiudades.setImage(image);

                    }


        });
    }
}