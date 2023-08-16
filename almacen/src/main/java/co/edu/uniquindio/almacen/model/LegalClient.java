package co.edu.uniquindio.almacen.model;

public class LegalClient extends Client {

    /*

  significados:

  nitNumber= numero de nit
     */


    private  String nitNumber;

    public LegalClient(String name,String lastName, String id,String address,String phoneNumber,String nitNumber){
        super(name,lastName,id,address,phoneNumber);
        this.nitNumber=nitNumber;
    }

    public String getNitNumber() {
        return nitNumber;
    }

    public void LegalClient(String nitNumber) {
        this.nitNumber = nitNumber;
    }
}