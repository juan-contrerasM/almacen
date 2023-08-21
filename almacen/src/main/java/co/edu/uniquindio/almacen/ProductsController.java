package co.edu.uniquindio.almacen;
import co.edu.uniquindio.almacen.MenuController;
import co.edu.uniquindio.almacen.model.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;




public class ProductsController implements Initializable {


        //arrays donde vamos a guardar los productos e informacion
        private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
        private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
        private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();
        private ArrayList<String>inventary =new ArrayList<>();

        private ArrayList<NaturalClient> listNaturalClients = new ArrayList<NaturalClient>();
        private ArrayList<LegalClient> listLegalClient = new ArrayList<LegalClient>();
        private ArrayList<String> inventaryC = new ArrayList<>();









        // para poder comunicar las ventanas
        private MenuController menuController;
        private Stage stage;




        // atributo fxml
        @FXML
        private Button btnClean;

        @FXML

        private TextArea TextADercripcion;

        @FXML
        private Button btnConsult;

        @FXML
        private Button btnCreate;

        @FXML
        private Button btnDelete;

        @FXML
        private Button btnMenu;

        @FXML
        private Button btnUpdate;


        @FXML
        private Button btnloading;

        @FXML
        private TextArea txtAreaInventario;

        @FXML
        private Pane paneBorder4;

        @FXML
        private Button btnVisualizar;

        @FXML
        private Label lblInventario;



        @FXML
        private ComboBox<String> comboOrigen;

        @FXML
        private ComboBox<String> comboTipo;

        @FXML
        private ImageView imgLogo;

        @FXML
        private Pane paneBorder;

        @FXML
        private Pane paneBorder2;

        @FXML
        private Pane paneBorder3;

        @FXML
        private TextField textCodeApprobation;

        @FXML
        private TextField txtCant;

        @FXML
        private TextField txtCode;

        @FXML
        private TextField txtContainerWeight;

        @FXML
        private TextField txtExpirationDate;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtNameConsult;

        @FXML
        private TextField txtPackagingDate;

        @FXML
        private TextField txtTemperature;

        @FXML
        private TextField txtValue;
        @FXML
        private Label lblDescription;

        // funciones de acciones






        @FXML
        // Esta funcion lo que hace es que de acuero al tipo selecionado por el combobox, va y lo busca en los 3 arraylist y cuando lo encutra lo carga en los arraylist
        void consult(ActionEvent event) {
                //nombre para buscar porducto
                String nameConsult= txtNameConsult.getText();

                //recore una lista de producto tipo envasados y busca si hay alguno con el nombre a buscar y llena los campos de la vista
                for (PackagedProduct packagedProduct:listPackagedProduc) {
                        if(nameConsult.equals(packagedProduct.getName())){

                                txtName.setText(packagedProduct.getName());
                                txtValue.setText((packagedProduct.getUnitValue()+""));
                                txtCode.setText(packagedProduct.getCode());
                                txtCant.setText(packagedProduct.getAmount()+"");
                                TextADercripcion.setText(packagedProduct.getDescription());
                                txtPackagingDate.setText(packagedProduct.getPackagingDate());
                                txtContainerWeight.setText(packagedProduct.getContainerWeight()+"");
                                comboTipo.setValue(packagedProduct.getTipo());

                                //funcion para desahbilitar campos que no le corresponden llenar cuando vana crear este tipo de objetos
                                disableTextfields();
                         }
                }
                for (PerishableProduct perishableProduct :perishableProductList) {
                        if(nameConsult.equals(perishableProduct.getName())){

                                txtName.setText(perishableProduct.getName());
                                txtValue.setText((perishableProduct.getUnitValue()+""));
                                txtCode .setText(perishableProduct.getCode());
                                txtCant.setText(perishableProduct.getAmount()+"");
                                TextADercripcion.setText(perishableProduct.getDescription());
                                txtExpirationDate.setText(perishableProduct.getDueDate());
                                comboTipo.setValue(perishableProduct.getTipo());

                                disableTextfields();

                        }

                }
                for (RefrigeratedProduct refrigeratedProduct :listRefrigerateProducts) {

                        if(nameConsult.equals(refrigeratedProduct.getName())){
                                txtName.setText(refrigeratedProduct.getName());
                                txtValue.setText((refrigeratedProduct.getUnitValue()+""));
                                txtCode.setText(refrigeratedProduct.getCode());
                                txtCant.setText(refrigeratedProduct.getAmount()+"");
                                TextADercripcion.setText(refrigeratedProduct.getDescription());
                                textCodeApprobation.setText(refrigeratedProduct.getApprovalCode());
                                txtTemperature.setText(refrigeratedProduct.getTemperature()+"");
                                comboTipo.setValue(refrigeratedProduct.getTipo());

                                disableTextfields();

                        }

                }





        }
        // Esta funcion perimite guardar la informacion que escibieron en los labels y lo almacena de acuerdo el tipo producto que seleccionaron
        @FXML
        void create(ActionEvent event) {

                //obteniendo la informacion atributos globales
                String code =txtCode.getText();
                String name=txtName.getText();
                String description =TextADercripcion.getText();
                String tipo =  comboTipo.getSelectionModel().getSelectedItem();
                double unitValue=0;
                int amount=0;



                //valida que no haya campos vacios y que haya un  tipo de producto en el combobox seleccion
              if(comboTipo.getValue()==null||(txtValue.getText().isEmpty() || txtCant.getText().isEmpty()|| txtCode.getText().isEmpty()|| txtName.getText().isEmpty())) {
                      JOptionPane.showMessageDialog(null," Hay campos sin completar y es obligatiorio seleccionar el tipo de prodcuto");

              }
              //aca se valida el tipo de dato para guardar la informacion de acuerdo acada dato
              else if (comboTipo.getValue().equals("Perecederos")) {
                              //se hace convercion aca para evitar la excepcion por conversion de dato
                              unitValue = Double.parseDouble(txtValue.getText());
                              amount = Integer.parseInt(txtCant.getText());



                              //atributos unicos del objeto
                              String expirationDate = txtExpirationDate.getText();
                              PerishableProduct perishableProduct = new PerishableProduct();

                              //se setean los atributos y se intancia un tipo de ese producto
                              perishableProduct.setName(name);
                              perishableProduct.setCode(code);
                              perishableProduct.setAmount(amount);
                              perishableProduct.setDescription(description);
                              perishableProduct.setUnitValue(unitValue);
                              perishableProduct.setDueDate(expirationDate);
                              perishableProduct.setTipo(tipo);
                                //se agrega a una lista la intancia creada
                              perishableProductList.add(perishableProduct);

                              JOptionPane.showMessageDialog(null,"Se ha guardado el producto");
                              //llama una funcion para limpiar los labels
                              cleanSpeaces();
                              //llama una funcion para activar los labels
                              enableTextfields();



                      } else if (comboTipo.getValue().equals("Refrigerados")) {


                              unitValue = Double.parseDouble(txtValue.getText());
                              amount = Integer.parseInt(txtCant.getText());

                              // se capturan atributos unicos
                              String codeApprobation = textCodeApprobation.getText();
                              int temperature = Integer.parseInt(txtTemperature.getText());

                              //se setean los atributos y se intancia un tipo de ese producto
                              RefrigeratedProduct refrigeratedProduct = new RefrigeratedProduct();
                              refrigeratedProduct.setName(name);
                              refrigeratedProduct.setCode(code);
                              refrigeratedProduct.setAmount(amount);
                              refrigeratedProduct.setDescription(description);
                              refrigeratedProduct.setTemperature(temperature);
                              refrigeratedProduct.setApprovalCode(codeApprobation);
                              refrigeratedProduct.setUnitValue(unitValue);
                              refrigeratedProduct.setTipo(tipo);


                              listRefrigerateProducts.add(refrigeratedProduct);
                              JOptionPane.showMessageDialog(null,"Se ha guardado el producto");

                              cleanSpeaces();

                              enableTextfields();

                      } else if (comboTipo.getValue().equals("Envasados")) {
                              unitValue = Double.parseDouble(txtValue.getText());
                              amount = Integer.parseInt(txtCant.getText());

                              String origin = comboOrigen.getValue();
                              String packageDate = txtPackagingDate.getText();
                              double cointarWeight = Double.parseDouble(txtContainerWeight.getText());

                              PackagedProduct packagedProduct = new PackagedProduct();
                              packagedProduct.setName(name);
                              packagedProduct.setCode(code);
                              packagedProduct.setAmount(amount);
                              packagedProduct.setDescription(description);
                              packagedProduct.setOrigin(origin);
                              packagedProduct.setContainerWeight(cointarWeight);
                              packagedProduct.setPackagingDate(packageDate);
                              packagedProduct.setUnitValue(unitValue);
                              packagedProduct.setTipo(tipo);
                              listPackagedProduc.add(packagedProduct);

                              JOptionPane.showMessageDialog(null,"Se ha guardado el producto");

                              cleanSpeaces();

                              enableTextfields();


                      }
              // se llamo la funcion  para agregar al inventario
              addInventary(name);

              }


        @FXML
        // esta funcion llama a otra funcion para limpiar los labels
        void clean(ActionEvent event) {

                cleanSpeaces();
        }





        //Esta funcion elimina el producto que consulte, por eso se captura un label que es el que contiene el nombre
        @FXML
        void delete(ActionEvent event) {
                //variable obtenida por lbl
                String name= txtNameConsult.getText();

                // recorre un for de tipo de producto y lo compara con el enviado y si lo encuentra lo elimina de la lista
                for (int i = 0; i <perishableProductList.size() ; i++) {
                        if (perishableProductList.get(i).getName().equals(name)) {
                                perishableProductList.remove(i);
                        }
                }

                for (int i = 0; i <listPackagedProduc.size() ; i++) {
                        if (listPackagedProduc.get(i).getName().equals(name)) {
                                listPackagedProduc.remove(i);
                        }
                }

                for (int i = 0; i <listRefrigerateProducts.size() ; i++) {
                        if (listRefrigerateProducts.get(i).getName().equals(name)) {
                                listRefrigerateProducts.remove(i);
                        }
                }

                JOptionPane.showMessageDialog(null ,"accion exitosa");

                cleanSpeaces();

                deleteInvetar(name);


        }

                        //abre la ventana menu
        @FXML
        void openManu(ActionEvent event) throws IOException {
                String info="";
                System.out.println("hola2");
                for (String dato:inventary ) {
                        info += " producto: " + dato + "  \n";
                        System.out.println(info + " se esta mostrasndo desde products controoler (open menu)");
                }

                        FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
                Parent root = loader.load();
                MenuController controller = loader.getController();
                controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventanacontroller.setInventary(inventary);
                controller.setInventaryC(inventaryC);
                controller.setInventary(inventary);
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

                // esta funcion lo que hace es actulizar los datos, pero lo hace  de esta forma: primera llama la funcion creat para
                // que crre un objeto con los lbl qu estan llenos, porque el  cliente primero debe consultar si el producto si fue creado
                // cuando le und el boton se cra automaticamente y se elimina el anterior
        @FXML
        void update(ActionEvent event) {

                create(event);

                delete(event);

                loadingInventary();




                }







        //aca se llenan los combobox y se envian advertencias
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                comboTipo.getItems().addAll("Perecederos", "Refrigerados", "Envasados");
                comboOrigen.getItems().addAll("Colombia", "Chile", "Ecuador","Argentina", "Peru");
               loadingInventary();
        }
        // esta funcion limpia los lbls seteando espacion vacios a ellos mismos

        public void cleanSpeaces(){
                txtName.setText("");
                txtValue.setText("");
                txtCode.setText("");
                txtCant.setText("");
                TextADercripcion.setText("");
                txtPackagingDate.setText("");
                txtContainerWeight.setText("");
                txtTemperature.setText("");
                textCodeApprobation.setText("");
                txtExpirationDate.setText("");
                //llama la funcion para volver que todos los lbl esten activados
                enableTextfields();


        }
                // sirve para desactivar los lbl de acuerdo el tipo de producto
        public void disableTextfields(){
                //verifica wue no este vacio el combobox
                if (comboTipo.getValue()!=null) {
                        if (comboTipo.getValue().equals("Perecederos")) {
                                //deshabilita la edccion de acuerdo al objeto
                                txtPackagingDate.setDisable(true);
                                txtContainerWeight.setDisable(true);
                                txtTemperature.setDisable(true);
                                textCodeApprobation.setDisable(true);

                        } else if (comboTipo.getValue().equals("Refrigerados")) {

                                txtPackagingDate.setDisable(true);
                                txtContainerWeight.setDisable(true);
                                txtExpirationDate.setDisable(true);

                        } else if (comboTipo.getValue().equals("Envasados")) {

                                txtTemperature.setDisable(true);
                                textCodeApprobation.setDisable(true);
                                txtExpirationDate.setDisable(true);
                        }
                }  else {
                        JOptionPane.showMessageDialog(null, "seleccione el tipo de producto");
                }

        }
        //aca se habilitan todos los campos que se pueden deshabilitar
        public void enableTextfields(){
                txtPackagingDate.setDisable(false);
                txtContainerWeight.setDisable(false);
                txtTemperature.setDisable(false);
                textCodeApprobation.setDisable(false);
                txtExpirationDate.setDisable(false);

        }
        @FXML
                // este funcion sirve para que cuando le undan el boton cargar sepan que lbl deben llenar y se deshabiliten lo que no pueden llenar
        void loadingS(ActionEvent event) {
                JOptionPane.showMessageDialog(null,"Ahora  rellene los espacios disponibles");

                disableTextfields();
                loadingInventary();

        }
        // aca se agrega al inventario cuando se crea el objeto
        public void addInventary(String name){
                String info="";
                //se agrega al arraylist
                inventary.add(name);
                for (String dato:inventary) {
                        info+=" producto: "+ dato+"  \n";

                }
                txtAreaInventario.setText(info);

        }
        // aca cuando se elimina un producto se elimina del inventario
        public void deleteInvetar(String name){
                String info="";
                //se busca en el arraylist del inventario y se elima el nombre que se pasa por un lbl
                for (int i = 0; i <inventary.size() ; i++) {
                        if(inventary.get(i).equals(name)){
                                inventary.remove(i);
                        }
                }

                for (String dato:inventary) {
                        info+=" producto: "+ dato+"  \n";

                }
                txtAreaInventario.setText(info);
        }

       //terminar
        public void  loadingInventary(){
                String info="";
                for (String dato:inventary ) {
                        info+=" producto: "+ dato+"  \n";


                }
                txtAreaInventario.setText(info);
        }
       // sirve para trasnportar la informacion obtenida por el progama
        public ArrayList<PerishableProduct> getPerishableProductList() {
                return perishableProductList;
        }

        public void setPerishableProductList(ArrayList<PerishableProduct> perishableProductList) {
                this.perishableProductList = perishableProductList;
        }
        //esto srive para abrir ventana
        public void setStage(Stage stage) {
                this.stage= stage;
        }

        //getter y seters arraylist

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



