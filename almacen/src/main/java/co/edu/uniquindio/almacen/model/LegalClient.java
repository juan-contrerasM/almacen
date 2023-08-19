package co.edu.uniquindio.almacen.model;

public class LegalClient extends Client {

    private String nitNumber;

    /*

  significados:

  nitNumber= numero de nit
     */


    public LegalClient() {
    }


    public LegalClient(String name, String lastName, String id, String address, String phoneNumber, String nitNumber, String typeClient) {
        super(name, lastName, id, address, phoneNumber, typeClient);
        this.nitNumber = nitNumber;
    }

    public String getNitNumber() {
        return nitNumber;
    }

    public void setNitNumber(String nitNumber) {
        this.nitNumber = nitNumber;
    }
}