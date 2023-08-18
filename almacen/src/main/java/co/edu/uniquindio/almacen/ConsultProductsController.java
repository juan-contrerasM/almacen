package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.net.URL;
import java.util.ResourceBundle;

public class ConsultProductsController implements Initializable {
    Stage stage;

    @FXML
    private Button btnProduct;

    @FXML
    private ImageView imgLogo;

    @FXML
    private Button lblMenu;

    @FXML
    private Label lblTitle;

    @FXML
    private Pane paneBorder4;


    @FXML
    private TableView<Product> tabProducts;
    @FXML
    private TableColumn<Product, Integer> colCant;

    @FXML
    private TableColumn<Product,String> colCodigo;


    @FXML
    private TableColumn<Product,String > colNombre;

    @FXML
    private TableColumn<Product, Double> colValor;

    private ObservableList <Product> products= FXCollections.observableArrayList();


    @FXML
    void openMenu(ActionEvent event) {

    }

    @FXML
    void openProdcuts(ActionEvent event) {

    }
    public void setStage(Stage stage) {
        this.stage= stage;
    }

//para llenar la tabla
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCant.setCellValueFactory(new PropertyValueFactory<>("unitValue"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("code"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("amount"));
    }
    @FXML // rellenar tabla
    private void rellenarTabla(){

    }
}