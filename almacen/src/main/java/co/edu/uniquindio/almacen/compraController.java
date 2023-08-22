package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class compraController extends Application implements Initializable  {


    @FXML
    private Label Carrito;

    @FXML
    private Button btnCompra;

    @FXML
    private Button btnMenu;

    @FXML
    private ChoiceBox<String> desplegable;

    @FXML
    private Pane paneExterior;

    @FXML
    private Pane paneInterior;

    @FXML
    private TextArea txtAreaValorCompra;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextArea txtFactura;

    @FXML
    void Comprar(ActionEvent event) {
        int cantidad = Integer.parseInt(txtCantidad.getText());
        System.out.println(cantidad);
        //textAreaValorCompra();


    }

    @FXML
    void desplegar(MouseEvent event) {




    }

    @FXML
    void openMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        controller.setInventary(inventary);
        controller.setInventaryC(inventaryC);
        controller.setListRefrigerateProducts(listRefrigerateProducts);
        controller.setListPackagedProduc(listPackagedProduc);
        controller.setPerishableProductList(perishableProductList);
        controller.setListLegalClient(listLegalClient);
        controller.setListNaturalClients(listNaturalClients);
        controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventana
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // Cierra el stage actual al regresar al menú
        ((Stage) btnMenu.getScene().getWindow()).close();

    }

    @FXML
    void textAreaValorCompra(MouseEvent event) {
        //   int info =totalProduct.get()
        // txtAreaValorCompra.setText(String.valueOf(info));


    }
    public void addInventary(String name){
        String info="";
        //se agrega al arraylist
        inventary.add(name);
        for (String dato:inventary) {
            info+=" producto: "+ dato+"  \n";

        }
        txtFactura.setText(info);

    }

    @FXML
    void textFactura(MouseEvent event) {


    }

    @FXML
    void txtCantidad(ActionEvent event) {

    }


    private Stage stage;
    private ArrayList<RefrigeratedProduct> listRefrigerateProducts = new ArrayList<RefrigeratedProduct>();
    private ArrayList<PackagedProduct> listPackagedProduc = new ArrayList<PackagedProduct>();
    private ArrayList<PerishableProduct> perishableProductList = new ArrayList<PerishableProduct>();
    private ArrayList<String> inventary = new ArrayList<>();

    private ArrayList<NaturalClient> listNaturalClients = new ArrayList<NaturalClient>();
    private ArrayList<LegalClient> listLegalClient = new ArrayList<LegalClient>();
    private ArrayList<String> inventaryC = new ArrayList<>();
    private ArrayList<Product> totalProduct = new ArrayList<>();

    private ArrayList<String> nombreProductos = new ArrayList<>();



    public void llenarArraylist() {
        totalProduct.addAll(perishableProductList);
        totalProduct.addAll(listPackagedProduc);
        totalProduct.addAll(listRefrigerateProducts);

    }



    public Label getCarrito() {
        return Carrito;
    }

    public void setCarrito(Label carrito) {
        Carrito = carrito;
    }

    public Button getBtnCompra() {
        return btnCompra;
    }

    public void setBtnCompra(Button btnCompra) {
        this.btnCompra = btnCompra;
    }

    public Button getBtnMenu() {
        return btnMenu;
    }

    public void setBtnMenu(Button btnMenu) {
        this.btnMenu = btnMenu;
    }

    public ChoiceBox<String> getDesplegable() {
        return desplegable;
    }

    public void setDesplegable(ChoiceBox<String> desplegable) {
        this.desplegable = desplegable;
    }

    public Pane getPaneExterior() {
        return paneExterior;
    }

    public void setPaneExterior(Pane paneExterior) {
        this.paneExterior = paneExterior;
    }

    public Pane getPaneInterior() {
        return paneInterior;
    }

    public void setPaneInterior(Pane paneInterior) {
        this.paneInterior = paneInterior;
    }

    public TextArea getTxtAreaValorCompra() {
        return txtAreaValorCompra;
    }

    public void setTxtAreaValorCompra(TextArea txtAreaValorCompra) {
        this.txtAreaValorCompra = txtAreaValorCompra;
    }

    public TextField getTxtCantidad() {
        return txtCantidad;
    }

    public void setTxtCantidad(TextField txtCantidad) {
        this.txtCantidad = txtCantidad;
    }

    public TextArea getTxtFactura() {
        return txtFactura;
    }

    public void setTxtFactura(TextArea txtFactura) {
        this.txtFactura = txtFactura;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public ArrayList<RefrigeratedProduct> getListRefrigerateProducts() {
        return listRefrigerateProducts;
    }

    public void setListRefrigerateProducts(ArrayList<RefrigeratedProduct> listRefrigerateProducts) {
        this.listRefrigerateProducts = listRefrigerateProducts;
    }

    public ArrayList<PackagedProduct> getListPackagedProduc() {
        return listPackagedProduc;
    }

    public void setListPackagedProduc(ArrayList<PackagedProduct> listPackagedProduc) {
        this.listPackagedProduc = listPackagedProduc;
    }

    public ArrayList<PerishableProduct> getPerishableProductList() {
        return perishableProductList;
    }

    public void setPerishableProductList(ArrayList<PerishableProduct> perishableProductList) {
        this.perishableProductList = perishableProductList;
    }

    public ArrayList<String> getInventary() {
        return inventary;
    }

    public void setInventary(ArrayList<String> inventary) {
        this.inventary = inventary;
    }

    public ArrayList<NaturalClient> getListNaturalClients() {
        return listNaturalClients;
    }

    public void setListNaturalClients(ArrayList<NaturalClient> listNaturalClients) {
        this.listNaturalClients = listNaturalClients;
    }

    public ArrayList<LegalClient> getListLegalClient() {
        return listLegalClient;
    }

    public void setListLegalClient(ArrayList<LegalClient> listLegalClient) {
        this.listLegalClient = listLegalClient;
    }

    public ArrayList<String> getInventaryC() {
        return inventaryC;
    }

    public void setInventaryC(ArrayList<String> inventaryC) {
        this.inventaryC = inventaryC;
    }

    public ArrayList<Product> getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(ArrayList<Product> totalProduct) {
        this.totalProduct = totalProduct;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        desplegable.getItems().addAll("arroz");
        llenarArraylist();


    }
    public void main(){
        llenarArraylist();
    }



    }

