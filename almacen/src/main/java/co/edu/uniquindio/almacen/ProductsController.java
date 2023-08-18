package co.edu.uniquindio.almacen;
import co.edu.uniquindio.almacen.MenuController;
import co.edu.uniquindio.almacen.model.PackagedProduct;
import co.edu.uniquindio.almacen.model.PerishableProduct;
import co.edu.uniquindio.almacen.model.RefrigeratedProduct;

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

        //array donde vamos a guardar los productos
        private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
        private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
        private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();

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
        private Button btnVisualizar;

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
        void consult(ActionEvent event) {
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

        @FXML
        void create(ActionEvent event) {

                //obteniendo la informacion atributos globales
                String code =txtCode.getText();
                String name=txtName.getText();
                String description =TextADercripcion.getText();
                String tipo =  comboTipo.getSelectionModel().getSelectedItem();
                double unitValue=0;
                int amount=0;



                //valida que no haya campos vacios y que haya un  tipo en el combo box seleccionado
              if(comboTipo.getValue()==null||(txtValue.getText().isEmpty() || txtCant.getText().isEmpty()|| txtCode.getText().isEmpty()|| txtName.getText().isEmpty())) {
                      JOptionPane.showMessageDialog(null," Hay campos sin completar, es obligatiorio seleccionar el tipo");

              } else if (comboTipo.getValue().equals("Perecederos")) {
                              //se hace convercion aca para evitar la excepcion por conversion de dato
                              unitValue = Double.parseDouble(txtValue.getText());
                              amount = Integer.parseInt(txtCant.getText());



                              //atributos unicos
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

                              perishableProductList.add(perishableProduct);


                      System.out.println(perishableProduct);
                              JOptionPane.showMessageDialog(null,"Se ha guardado el producto");
                              cleanSpeaces();
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

                                System.out.println(refrigeratedProduct);
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
                      System.out.println(packagedProduct);
                      cleanSpeaces();
                              enableTextfields();


                      }
              }


        @FXML
        void clean(ActionEvent event) {

                cleanSpeaces();
        }





        @FXML
        void delete(ActionEvent event) {
                String name= txtNameConsult.getText();
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


        }

        @FXML
        void openManu(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
                Parent root = loader.load();
                MenuController controller = loader.getController();
                controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventana
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                // Cierra el stage actual al regresar al menú
                ((Stage) btnMenu.getScene().getWindow()).close();

        }


        @FXML
        void update(ActionEvent event) {

                create(event);
                delete(event);




                }





        @FXML
        void lista(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("consultProducts.fxml"));
                Parent root = loader.load();
                ConsultProductsController controllerDataBase= new ConsultProductsController(listRefrigerateProducts,listPackagedProduc,perishableProductList);
                ConsultProductsController controller = loader.getController();
                controller.setStage(stage); // Pasar la referencia del Stage actual a la nueva ventana
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                // Cierra el stage actual al regresar al menú
                ((Stage) btnVisualizar.getScene().getWindow()).close();

        }

        public void setStage(Stage stage) {
                this.stage= stage;
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
                comboTipo.getItems().addAll("Perecederos", "Refrigerados", "Envasados");
                comboOrigen.getItems().addAll("Colombia", "Chile", "Ecuador","Argentina", "Peru");


        }

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
                enableTextfields();


        }

        public void disableTextfields(){
                if (comboTipo.getValue()!=null) {
                        if (comboTipo.getValue().equals("Perecederos")) {
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
        public void enableTextfields(){
                txtPackagingDate.setDisable(false);
                txtContainerWeight.setDisable(false);
                txtTemperature.setDisable(false);
                textCodeApprobation.setDisable(false);
                txtExpirationDate.setDisable(false);

        }
        @FXML
        void loadingS(ActionEvent event) {
                JOptionPane.showMessageDialog(null,"ahora cree rellene los espacios disponibles y uncale en crear");
                disableTextfields();

        }

}



