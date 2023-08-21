package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SailController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnMenu;

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
    void actualizar(ActionEvent event) {
        llenarArraylist();
        imprimir();
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

    public void llenarArraylist(){
            totalProduct.addAll(perishableProductList);
            totalProduct.addAll(listPackagedProduc);
            totalProduct.addAll(listRefrigerateProducts);
    }
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

    public void setColumnaDos(TableColumn<?, ?> columnaDos) {
        this.columnaDos = columnaDos;
    }

    public void setColumnaTres(TableColumn<?, ?> columnaTres) {
        this.columnaTres = columnaTres;
    }

    public void setColumnaUno(TableColumn<?, ?> columnaUno) {
        this.columnaUno = columnaUno;
    }

    public void setPaneBody(Pane paneBody) {
        this.paneBody = paneBody;
    }

    public void setPaneHead(Pane paneHead) {
        this.paneHead = paneHead;
    }

    public void setTabla(TableView<?> tabla) {
        this.tabla = tabla;
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
    public void imprimirInformacion(){

    }

}