package co.edu.uniquindio.almacen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClienteController {

    @FXML
    private Button btnRegister;

    @FXML
    private Label lblName;

    @FXML
    private Label lblTitle;
    @FXML
    private TextField txtName;

    @FXML
    void register(ActionEvent event) {
        String name= txtName.getText();

    }

}