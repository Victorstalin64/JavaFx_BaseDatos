module com.tarea.tienda {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.tarea.tienda to javafx.fxml;

    exports com.tarea.tienda;
}