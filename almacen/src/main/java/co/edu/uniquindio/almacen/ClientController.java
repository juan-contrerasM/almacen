package co.edu.uniquindio.almacen;

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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;




public class ClientController implements Initializable {


        @FXML
        private Label lblInvetario;
        @FXML
        private Pane paneBorder4;

        @FXML
        private TextArea textAreaInventario;
        @FXML
        private Button btnClean;

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
        private Button btnVisualizar;

        @FXML
        private Button btnloading;

        @FXML
        private TextField txtDireccion;

        @FXML
        private ComboBox<String> comboCliente;

        @FXML
        private Pane contenedor;

        @FXML
        private Pane contenedor2;

        @FXML
        private ImageView imgLogo;

        @FXML
        private Pane paneBorder3;

        @FXML
        private TextField txtApellido;

        @FXML
        private TextField txtCorreo;

        @FXML
        private TextField txtCumpleanos;


        @FXML
        private TextField txtIdentificacion;

        @FXML
        private TextField txtNameConsult;

        @FXML
        private TextField txtNombre;

        @FXML
        private TextField txtNumeroNit;

        @FXML
        private TextField txtTelefono;



        // funciones de acciones


        //array donde vamos a guardar los productos
        private ArrayList<NaturalClient> listNaturalClients = new ArrayList<NaturalClient>();
        private ArrayList<LegalClient> listLegalClient = new ArrayList<LegalClient>();
        private ArrayList<String> inventaryC = new ArrayList<>();


        private ArrayList<RefrigeratedProduct> listRefrigerateProducts=new ArrayList<RefrigeratedProduct>();
        private ArrayList<PackagedProduct>listPackagedProduc= new ArrayList<PackagedProduct>();
        private ArrayList<PerishableProduct>perishableProductList= new ArrayList<PerishableProduct>();
        private ArrayList<String>inventary =new ArrayList<>();

        // para poder comunicar las ventanas
        private MenuController menuController;
        private Stage stage;


        @FXML
        void consult(ActionEvent event) {
                String nameConsult = txtNameConsult.getText();

                for (NaturalClient naturalClient : listNaturalClients) {
                        if (nameConsult.equals(naturalClient.getName())) {
                                txtNombre.setText(naturalClient.getName());
                                txtApellido.setText(naturalClient.getLastName());
                                txtIdentificacion.setText(naturalClient.getId());
                                txtDireccion.setText(naturalClient.getAddress());
                                txtTelefono.setText(naturalClient.getPhoneNumber());
                                txtCorreo.setText((naturalClient.getEmail()));
                                txtCumpleanos.setText(naturalClient.getBirthDate());
                                comboCliente.setValue(naturalClient.getTypeClient());

                                disableTextfields();
                        }
                }


                for (LegalClient legalClient : listLegalClient) {
                        if (nameConsult.equals(legalClient.getName())) {
                                txtNombre.setText(legalClient.getName());
                                txtApellido.setText(legalClient.getLastName());
                                txtIdentificacion.setText(legalClient.getId());
                                txtDireccion.setText(legalClient.getAddress());
                                txtTelefono.setText(legalClient.getPhoneNumber());
                                txtNumeroNit.setText(legalClient.getNitNumber());
                                comboCliente.setValue(legalClient.getTypeClient());
                                disableTextfields();

                        }

                }


        }

        @FXML
        void create(ActionEvent event) {
                //obteniendo la informacion atributos globales
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String identificacion = txtIdentificacion.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();
                String tipo = comboCliente.getSelectionModel().getSelectedItem();
                // String tipoClase =(String)  comboCliente.getSelectionModel().getSelectedItem();

                //valida que no haya campos vacios y que haya un  tipo en el combo box seleccionado
                if (comboCliente.getValue() == null || (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtIdentificacion.getText().isEmpty() || txtDireccion.getText().isEmpty() || txtTelefono.getText().isEmpty())) {
                        JOptionPane.showMessageDialog(null, " Hay campos sin completar, es obligatiorio seleccionar el tipo");

                } else if (comboCliente.getValue().equals("natural")) {

                        NaturalClient naturalClient = new NaturalClient();

                        String correo = txtCorreo.getText();
                        System.out.println(correo);
                        String cumpleanos = txtCumpleanos.getText();


                        //se setean los atributos y se intancia un tipo de ese producto
                        naturalClient.setName(txtNombre.getText());
                        naturalClient.setLastName(txtApellido.getText());
                        naturalClient.setId(txtIdentificacion.getText());
                        naturalClient.setAddress(txtDireccion.getText());
                        naturalClient.setPhoneNumber(txtTelefono.getText());
                        naturalClient.setEmail(txtCorreo.getText());
                        naturalClient.setBirthDate(txtCumpleanos.getText());
                        naturalClient.setTypeClient(tipo);


                        listNaturalClients.add(naturalClient);


                        System.out.println(naturalClient);
                        JOptionPane.showMessageDialog(null, "Se ha guardado el producto");
                        cleanSpeaces();
                        enableTextfields();


                } else if (comboCliente.getValue().equals("juridico")) {


                        //se setean los atributos y se intancia un tipo de ese producto
                        LegalClient legalClient = new LegalClient();
                        String numeronit = txtNumeroNit.getText();


                        legalClient.setName(txtNombre.getText());
                        legalClient.setLastName(txtApellido.getText());
                        legalClient.setId(txtIdentificacion.getText());
                        legalClient.setAddress(txtDireccion.getText());
                        legalClient.setPhoneNumber(txtTelefono.getText());
                        legalClient.setNitNumber(txtNumeroNit.getText());
                        legalClient.setTypeClient(comboCliente.getAccessibleText());
                        legalClient.setTypeClient(tipo);

                        System.out.println(legalClient);

                        listLegalClient.add(legalClient);
                        JOptionPane.showMessageDialog(null, "Se ha guardado el producto");
                        cleanSpeaces();
                        enableTextfields();

                }
                addInventary(nombre);

        }


        @FXML
        void clean(ActionEvent event) {

                cleanSpeaces();
        }


        @FXML
        void delete(ActionEvent event) {
                String name = txtNameConsult.getText();
                for (int i = 0; i < listNaturalClients.size(); i++) {
                        if (listNaturalClients.get(i).getName().equals(name)) {
                                listNaturalClients.remove(i);
                        }
                }
                for (int i = 0; i < listLegalClient.size(); i++) {
                        if (listLegalClient.get(i).getName().equals(name)) {
                                listLegalClient.remove(i);
                        }
                }

                JOptionPane.showMessageDialog(null, "accion exitosa");
                cleanSpeaces();

                deleteInvetar(name);


        }

        @FXML
        void openManu(ActionEvent event) throws IOException {
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
        void update(ActionEvent event) {

                create(event);
                delete(event);


        }


        public void setStage(Stage stage) {
                this.stage = stage;
        }


        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                comboCliente.getItems().addAll("natural", "juridico");


        }

        public void cleanSpeaces() {
                txtNombre.setText("");
                txtApellido.setText("");
                txtIdentificacion.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
                txtCorreo.setText("");
                txtNumeroNit.setText("");
                txtCumpleanos.setText("");

                enableTextfields();


        }

        public void disableTextfields() {
                if (comboCliente.getValue() != null) {
                        if (comboCliente.getValue().equals("natural")) {
                                txtNumeroNit.setDisable(true);

                                System.out.println(comboCliente.getValue());
                        } else if (comboCliente.getValue().equals("juridico")) {
                                txtCorreo.setDisable(true);
                                txtCumpleanos.setDisable(true);
                                System.out.println(comboCliente.getValue());

                        } else {
                                JOptionPane.showMessageDialog(null, "seleccione el tipo de producto");
                        }

                }
        }

        public void enableTextfields() {
                txtCorreo.setDisable(false);
                txtCumpleanos.setDisable(false);
                txtNumeroNit.setDisable(false);
        }

        @FXML
        void loadingS(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "ahora cree rellene los espacios disponibles y uncale en crear");
                disableTextfields();

        }

        // aca se agrega al inventario cuando se crea el objeto
        public void addInventary(String name) {
                String info = "";
                //se agrega al arraylist
                inventaryC.add(name);

                for (String dato : inventaryC) {
                        info += " producto: " + dato + "  \n";

                }
                textAreaInventario.setText(info);

        }

        // aca cuando se elimina un producto se elimina del inventario
        public void deleteInvetar(String name) {
                String info = "";
                //se busca en el arraylist del inventario y se elima el nombre que se pasa por un lbl
                for (int i = 0; i < inventaryC.size(); i++) {
                        if (inventaryC.get(i).equals(name)) {
                                inventaryC.remove(i);
                        }
                }
                for (String dato:inventaryC) {
                        info+=" producto: "+ dato+"  \n";

                }
                textAreaInventario.setText(info);

        }
        //getter y setter de los arraylist

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

        public ArrayList<String> getInventaryc() {
                return inventaryC;
        }

        public void setInventaryc(ArrayList<String> inventaryc) {
                this.inventaryC = inventaryC;
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
}


