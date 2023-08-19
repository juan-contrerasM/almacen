package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.PackagedProduct;
import co.edu.uniquindio.almacen.model.PerishableProduct;
import co.edu.uniquindio.almacen.model.Product;
import co.edu.uniquindio.almacen.model.RefrigeratedProduct;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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

public class ConsultProductsController  {
    //atributos java
   private Stage stage;



    private ArrayList<Product> products= new ArrayList<Product>();
    private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
    private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
    private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();

//atributo java fx

    @FXML
    private Button btnProduct;

    @FXML
    private Button btnActualizar;


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
    private TableColumn<Product, String> colCodigo;

    @FXML
    private TableColumn<Product, String> colNombre;

    @FXML
    private TableColumn<Product, Double> colValor;

    @FXML
    private TableColumn<Product, String> colDescription; // Nueva columna

    @FXML
    private TableColumn<Product, String> colTipo; // Nueva columna

    private ObservableList<Product> productData = FXCollections.observableArrayList(products);



    //sirve para abir la venta menu

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
    //sirve para abirir la ventana open
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


//para llenar la  desde el metodo inicializador






    //para abrir las ventanas
    public void setStage(Stage stage) {
        this.stage= stage;
    }

    // rellenar tabla
    public void rellenarTabla() {
        for (PerishableProduct perishableProduct:perishableProductList) {
            Product product=new Product();
            product.setName(perishableProduct.getName());
            product.setAmount(perishableProduct.getAmount());
            product.setTipo(perishableProduct.getTipo());
            product.setCode(perishableProduct.getCode());
            product.setDescription(perishableProduct.getDescription());
            product.setUnitValue(perishableProduct.getUnitValue());
            System.out.println(perishableProduct);
            productData.add(product);

        }
        colCant.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("code"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("name"));
        colValor.setCellValueFactory(new PropertyValueFactory<>("unitValue"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo")); // Vincular con la propiedad "tipo"
        colValor.setCellValueFactory(new PropertyValueFactory<>("unitValue"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));


        tabProducts.setItems(productData);
       /* for (RefrigeratedProduct refrigeratedProduct:listRefrigerateProducts) {
            Product product=new Product();
            product.setName(refrigeratedProduct.getName());
            product.setAmount(refrigeratedProduct.getAmount());
            product.setTipo(refrigeratedProduct.getTipo());
            product.setCode(refrigeratedProduct.getCode());
            product.setDescription(refrigeratedProduct.getDescription());
            product.setUnitValue(refrigeratedProduct.getUnitValue());
            products.add(product);
        }
        for (PackagedProduct packagedProduct:listPackagedProduc) {
            Product product=new Product();
            product.setName(packagedProduct.getName());
            product.setAmount(packagedProduct.getAmount());
            product.setTipo(packagedProduct.getTipo());
            product.setCode(packagedProduct.getCode());
            product.setDescription(packagedProduct.getDescription());
            product.setUnitValue(packagedProduct.getUnitValue());
            products.add(product);
        }*/




    }
    public ArrayList<PerishableProduct> getPerishableProductList() {
        return perishableProductList;
    }

    public void setPerishableProductList(ArrayList<PerishableProduct> perishableProductList) {
        this.perishableProductList = perishableProductList;
        System.out.println("Hola2");

    }
    @FXML
    void actualizar(ActionEvent event) {
        rellenarTabla();
        // Configurar columnas de la tabla

    }










}
