module co.edu.uniquindio.almacen.almacen {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens co.edu.uniquindio.almacen to javafx.fxml;
    exports co.edu.uniquindio.almacen;
    exports co.edu.uniquindio.almacen.controller;
    opens co.edu.uniquindio.almacen.controller to javafx.fxml;
    
}