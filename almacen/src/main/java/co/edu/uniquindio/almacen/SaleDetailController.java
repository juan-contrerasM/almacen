package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.util.ArrayList;

public class SaleDetailController {

    private Stage stage;
    private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
    private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
    private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();
    private ArrayList<String>inventary =new ArrayList<>();

    private ArrayList<NaturalClient> listNaturalClients = new ArrayList<NaturalClient>();
    private ArrayList<LegalClient> listLegalClient = new ArrayList<LegalClient>();
    private ArrayList<String> inventaryC = new ArrayList<>();

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
    private ImageView imgLogo;

    @FXML
    private ImageView imglogo1;

    @FXML
    void openMenu(ActionEvent event) {

    }

    @FXML
    void openSale(ActionEvent event) {

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
}