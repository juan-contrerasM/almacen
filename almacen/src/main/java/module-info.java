module co.edu.uniquindio.almacen.almacen {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens co.edu.uniquindio.almacen to javafx.fxml;
    exports co.edu.uniquindio.almacen;

}