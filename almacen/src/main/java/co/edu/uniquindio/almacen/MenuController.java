package co.edu.uniquindio.almacen;

import co.edu.uniquindio.almacen.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class MenuController  {
    //sirve parar abrir ventana
    private Stage stage;
    private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
    private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
    private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();
    private ArrayList<String>inventary =new ArrayList<>();

    private ArrayList<NaturalClient> listNaturalClients = new ArrayList<NaturalClient>();
    private ArrayList<LegalClient> listLegalClient = new ArrayList<LegalClient>();
    private ArrayList<String> inventaryC = new ArrayList<>();

    // atributos fx
    @FXML
    private Button btnClients;

    @FXML
    private Button btnProducts;

    @FXML
    private Button btnSales;
    @FXML
    private Label lblDescription;
    @FXML
    private ImageView imgClients;

    @FXML
    private ImageView imgLogoAlmacen;

    @FXML
    private ImageView imgProducts;

    @FXML
    private ImageView imgSales;

    @FXML
    private Label lblMenuMain;

    @FXML
    private Pane paneColor;
 // abre ventana clientes
    @FXML
    void openClients(ActionEvent event) throws IOException {
        String info="";
        System.out.println("hola");
        for (String dato:inventaryC ) {
            info += " producto: " + dato + "  \n";
            System.out.println(info + " se esta mostrasndo desde menucontrooler client( menu)");
        }
        JOptionPane.showMessageDialog(null, "Cargando");
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Client.fxml"));
        Parent root= loader.load();
        ClientController controller= loader.getController();
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


    }
//abre venta productos
    @FXML
    void openProducts(ActionEvent event) throws IOException {

        String info="";
        System.out.println("hola");
        for (String dato:inventary ) {
            info += " producto: " + dato + "  \n";
            System.out.println(info + " se esta mostrasndo desde menucontrooler ( menu)");
        }
        JOptionPane.showMessageDialog(null, "primero seleccionar el tipo de producto y undir en el boton cargar");
        FXMLLoader loader= new FXMLLoader(getClass().getResource("products.fxml"));
        Parent root= loader.load();
        ProductsController controller= loader.getController();
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



    @FXML
    void openSales(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("sail.fxml"));
        Parent root= loader.load();
        SailController controller= loader.getController();
        controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventana
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();




    }
  // esta funcion sivre para que se muestre la primera interfaz
    public void setStage(Stage stage) {
       this.stage= stage;
    }

 // get y set de los arraylist
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
