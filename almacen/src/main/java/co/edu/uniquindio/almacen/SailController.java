package co.edu.uniquindio.almacen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SailController {
    private Stage stage;

    @FXML
    private Button btnMenu;

    @FXML
    private Button btnVenta;

    @FXML
    private TableColumn<?, ?> columnaDos;

    @FXML
    private TableColumn<?, ?> columnaTres;

    @FXML
    private TableColumn<?, ?> columnaUno;

    @FXML
    private Pane paneBody;

    @FXML
    private Pane paneHead;

    @FXML
    private TableView<?> tabla;

    @FXML
    private Label titleSaleDetail;

    @FXML
    void openMenu(ActionEvent event) {

    }

    @FXML
    void openSale(ActionEvent event) {

    }

    public void setStage(Stage stage) {
        this.stage=stage;
    }
}
