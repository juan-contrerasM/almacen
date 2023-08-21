package co.edu.uniquindio.almacen;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

public class SaleDetailController {

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

}