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

        // atributo fxml
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


        //array donde vamos a guardar la informacion
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

        // Esta funcion lo que hace es que de acuero al tipo selecionado por el combobox, va y lo busca en los 3 arraylist y cuando lo encutra lo carga en los arraylist
        @FXML
        void consult(ActionEvent event) {
                //nombre para buscar porducto
                String nameConsult = txtNameConsult.getText();
                //recore una lista de producto tipo envasados y busca si hay alguno con el nombre a buscar y llena los campos de la vista
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
                        //funcion para desahbilitar campos que no le corresponden llenar cuando vana crear este tipo de objetos
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
        // Esta funcion perimite guardar la informacion que escibieron en los labels y lo almacena de acuerdo el tipo producto que seleccionaron
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

                        //aca se valida el tipo de dato para guardar la informacion de acuerdo acada dato
                } else if (comboCliente.getValue().equals("natural")) {
                        //se hace convercion aca para evitar la excepcion por conversion de dato
                        NaturalClient naturalClient = new NaturalClient();

                        //atributos unicos del objeto
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

                        //se agrega a una lista la intancia creada
                        listNaturalClients.add(naturalClient);



                        JOptionPane.showMessageDialog(null, "Se ha guardado el cliente");
                        //llama una funcion para limpiar los labels
                        cleanSpeaces();
                        //llama una funcion para activar los labels
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
                        JOptionPane.showMessageDialog(null, "Se ha guardado el cliente");
                        cleanSpeaces();
                        enableTextfields();

                }
                // se llamo la funcion  para agregar al inventario
                addInventary(nombre);

        }

        // esta funcion llama a otra funcion para limpiar los labels
        @FXML
        void clean(ActionEvent event) {

                cleanSpeaces();
        }

        //Esta funcion elimina el producto que consulte, por eso se captura un label que es el que contiene el nombre
        @FXML
        void delete(ActionEvent event) {
                //variable obtenida por lbl
                String name = txtNameConsult.getText();
                // recorre un for de tipo de producto y lo compara con el enviado y si lo encuentra lo elimina de la lista
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
        //abre la ventana menu
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

        // esta funcion lo que hace es actulizar los datos, pero lo hace  de esta forma: primera llama la funcion creat para
        // que crre un objeto con los lbl qu estan llenos, porque el  cliente primero debe consultar si el producto si fue creado
        // cuando le und el boton se cra automaticamente y se elimina el anterior

        @FXML
        void update(ActionEvent event) {

                create(event);
                delete(event);
                loadingInventary();


        }


        public void setStage(Stage stage) {
                this.stage = stage;
        }

        //aca se llenan los combobox y se envian advertencias
        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

                comboCliente.getItems().addAll("natural", "juridico");


        }
        // esta funcion limpia los lbls seteando espacion vacios a ellos mismos
        public void cleanSpeaces() {
                txtNombre.setText("");
                txtApellido.setText("");
                txtIdentificacion.setText("");
                txtDireccion.setText("");
                txtTelefono.setText("");
                txtCorreo.setText("");
                txtNumeroNit.setText("");
                txtCumpleanos.setText("");
//llama la funcion para volver que todos los lbl esten activados
                enableTextfields();


        }
        // sirve para desactivar los lbl de acuerdo el tipo de producto
        public void disableTextfields() {
                //verifica wue no este vacio el combobox
                if (comboCliente.getValue() != null) {
                        if (comboCliente.getValue().equals("natural")) {
                                txtNumeroNit.setDisable(true);

                                System.out.println(comboCliente.getValue());
                        } else if (comboCliente.getValue().equals("juridico")) {
                                txtCorreo.setDisable(true);
                                txtCumpleanos.setDisable(true);
                                System.out.println(comboCliente.getValue());

                        } else {
                                JOptionPane.showMessageDialog(null, "seleccione el tipo de cliente");
                        }

                }
        }
        //aca se habilitan todos los campos que se pueden deshabilitar
        public void enableTextfields() {
                txtCorreo.setDisable(false);
                txtCumpleanos.setDisable(false);
                txtNumeroNit.setDisable(false);
        }
// este funcion sirve para que cuando le undan el boton cargar sepan que lbl deben llenar y se deshabiliten lo que no pueden llenar
        @FXML
        void loadingS(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "ahora cree rellene los espacios disponibles y undale en crear");
                disableTextfields();
                loadingInventary();

        }

        // aca se agrega al inventario cuando se crea el objeto
        public void addInventary(String name) {
                String info = "";
                //se agrega al arraylist
                inventaryC.add(name);

                for (String dato : inventaryC) {
                        info += " cliente: " + dato + "  \n";

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
                        info+=" cliente: "+ dato+"  \n";

                }
                textAreaInventario.setText(info);

        }
       //aca carga el inventario cuando se sale de la venta y vuelve a ingresar
        public void  loadingInventary(){
                String info="";

                for (String dato:inventaryC ) {
                        info+=" cliente: "+ dato+"  \n";


                }
                textAreaInventario.setText(info);
        }

        //getter y setter de los arraylist


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

        public Stage getStage() {
                return stage;
        }

}


