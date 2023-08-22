package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class SailController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnMenu;

    @FXML
    private TableColumn<Product, String> columnaDos;

    @FXML
    private TableColumn<Product, String> columnaTres;

    @FXML
    private TableColumn<Product, String> columnaUno;

    @FXML
    private Pane paneBody;

    @FXML
    private Pane paneHead;

    @FXML
    private TableView<Product> tabla;

    @FXML
    private Label titleSaleDetail;

    @FXML
    void Actualizar(ActionEvent event) {
        System.out.println("hola");
        llenarArraylist();
        imprimir();
        ObservableList<Product> totalProduct2 = FXCollections.observableArrayList();
        totalProduct2.addAll(totalProduct);
        columnaUno.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        columnaDos.setCellValueFactory(new PropertyValueFactory<Product, String>("amount"));
        columnaTres.setCellValueFactory(new PropertyValueFactory<Product, String>("unitValue"));
        tabla.setItems(totalProduct2);
       // initialize();
    }
    @FXML
    private Button btnCompra;













    @FXML
    void compra(ActionEvent event)throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("compra.fxml"));
        Parent root= loader.load();
        compraController  controller= loader.getController();
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
        // No cierres el stage actual aquí

    }
    public void imprimirInformacion(){

    }



    private Stage stage;
    private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
    private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
    private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();
    private ArrayList<String>inventary =new ArrayList<>();

    private ArrayList<NaturalClient> listNaturalClients = new ArrayList<NaturalClient>();
    private ArrayList<LegalClient> listLegalClient = new ArrayList<LegalClient>();
    private ArrayList<String> inventaryC = new ArrayList<>();
    private ArrayList<Product> totalProduct = new ArrayList<>();

    public void llenarArraylist() {
        totalProduct.addAll(perishableProductList);
        totalProduct.addAll(listPackagedProduc);
        totalProduct.addAll(listRefrigerateProducts);
    }


   /*public void initialize(){
        ObservableList<Product> totalProduct2 = FXCollections.observableArrayList();
        totalProduct2.addAll(totalProduct);
        columnaUno.setCellValueFactory(new PropertyValueFactory<Product, String>(totalProduct2.get(0).getName()));
        columnaDos.setCellValueFactory(new PropertyValueFactory<Product, String>(String.valueOf(totalProduct2.get(0).getAmount())));
        columnaTres.setCellValueFactory(new PropertyValueFactory<Product, String>(String.valueOf(totalProduct2.get(0).getUnitValue())));
        tabla.setItems(totalProduct2);

    }*/


    public void imprimir(){
        System.out.println("hola");
        for (int i = 0; totalProduct.size() > i; i++) {

        System.out.println(totalProduct.get(i).getName() + totalProduct.get(i).getAmount() + totalProduct.get(i).getUnitValue());

    }

    }

    /*public void setBtnActualizar(Button btnActualizar) {
    }

     */

    public void setBtnMenu(Button btnMenu) {
        this.btnMenu = btnMenu;
    }

    public void setColumnaDos(TableColumn<Product, String> columnaDos) {
        this.columnaDos = columnaDos;
    }

    public void setColumnaTres(TableColumn<Product, String> columnaTres) {
        this.columnaTres = columnaTres;
    }

    public void setColumnaUno(TableColumn<Product, String> columnaUno) {
        this.columnaUno = columnaUno;
    }

    public void setPaneBody(Pane paneBody) {
        this.paneBody = paneBody;
    }

    public void setPaneHead(Pane paneHead) {
        this.paneHead = paneHead;
    }

    public void setBtnActualizar(Button btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public void setTabla(TableView<Product> tabla) {
        this.tabla = tabla;
    }

    public void setTotalProduct(ArrayList<Product> totalProduct) {
        this.totalProduct = totalProduct;
    }

    public void setTitleSaleDetail(Label titleSaleDetail) {
        this.titleSaleDetail = titleSaleDetail;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setListRefrigerateProducts(ArrayList<RefrigeratedProduct> listRefrigerateProducts) {
        this.listRefrigerateProducts = listRefrigerateProducts;
    }

    public void setListPackagedProduc(ArrayList<PackagedProduct> listPackagedProduc) {
        this.listPackagedProduc = listPackagedProduc;
    }

    public void setPerishableProductList(ArrayList<PerishableProduct> perishableProductList) {
        this.perishableProductList = perishableProductList;
    }

    public void setInventary(ArrayList<String> inventary) {
        this.inventary = inventary;
    }

    public void setListNaturalClients(ArrayList<NaturalClient> listNaturalClients) {
        this.listNaturalClients = listNaturalClients;
    }

    public void setListLegalClient(ArrayList<LegalClient> listLegalClient) {
        this.listLegalClient = listLegalClient;
    }

    public void setInventaryC(ArrayList<String> inventaryC) {
        this.inventaryC = inventaryC;
    }


    @FXML
    void openMenu(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventanacontroller.setInventary(inventary);
        controller.setInventaryC(inventaryC);
        controller.setListRefrigerateProducts(listRefrigerateProducts);
        controller.setListPackagedProduc(listPackagedProduc);
        controller.setPerishableProductList(perishableProductList);
        controller.setListLegalClient(listLegalClient);
        controller.setListNaturalClients(listNaturalClients);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        // Cierra el stage actual al regresar al menú
        ((Stage) btnMenu.getScene().getWindow()).close();

    }
   // public void imprimirInformacion(){
    // }

    public Button getBtnActualizar() {
        return btnActualizar;
    }

    public Button getBtnMenu() {
        return btnMenu;
    }

    public TableColumn<?, ?> getColumnaDos() {
        return columnaDos;
    }

    public TableColumn<?, ?> getColumnaTres() {
        return columnaTres;
    }

    public TableColumn<?, ?> getColumnaUno() {
        return columnaUno;
    }

    public Pane getPaneBody() {
        return paneBody;
    }

    public Pane getPaneHead() {
        return paneHead;
    }

    public TableView<?> getTabla() {
        return tabla;
    }

    public Label getTitleSaleDetail() {
        return titleSaleDetail;
    }

    public Stage getStage() {
        return stage;
    }

    public ArrayList<RefrigeratedProduct> getListRefrigerateProducts() {
        return listRefrigerateProducts;
    }

    public ArrayList<PackagedProduct> getListPackagedProduc() {
        return listPackagedProduc;
    }

    public ArrayList<PerishableProduct> getPerishableProductList() {
        return perishableProductList;
    }

    public ArrayList<String> getInventary() {
        return inventary;
    }

    public ArrayList<NaturalClient> getListNaturalClients() {
        return listNaturalClients;
    }

    public ArrayList<LegalClient> getListLegalClient() {
        return listLegalClient;
    }

    public ArrayList<String> getInventaryC() {
        return inventaryC;
    }

    public ArrayList<Product> getTotalProduct() {
        return totalProduct;
    }
}