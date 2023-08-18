package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.PackagedProduct;
import co.edu.uniquindio.almacen.model.PerishableProduct;
import co.edu.uniquindio.almacen.model.Product;
import co.edu.uniquindio.almacen.model.RefrigeratedProduct;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConsultProductsController implements Initializable {
    Stage stage;
    private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
    private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
    private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();
    private ConsultProductsController(){

    }
    public ConsultProductsController(ArrayList<RefrigeratedProduct> listRefrigerateProducts,ArrayList<PackagedProduct>listPackagedProduc,ArrayList<PerishableProduct>perishableProductList){
        this.listPackagedProduc=listPackagedProduc;
        this.listRefrigerateProducts=listRefrigerateProducts;
        this.perishableProductList=perishableProductList;
    }

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
    void openMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventana
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // Cierra el stage actual al regresar al menú
        ((Stage) lblMenu.getScene().getWindow()).close();

    }

    @FXML
    void openProdcuts(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("products.fxml"));
        Parent root = loader.load();
        ProductsController controller = loader.getController();
        controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventana
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // Cierra el stage actual al regresar al menú
        ((Stage) btnProduct.getScene().getWindow()).close();

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