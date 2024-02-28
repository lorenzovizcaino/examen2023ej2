module com.example.examen2023ej2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.examen2023ej2 to javafx.fxml;
    exports com.example.examen2023ej2;
}