package co.edu.uniquindio.almacen.model;

public abstract class Client {

/*
significados:

name=nombre
lastname=apellido
id =identificacion
address =direccion
phonenumber=numero de telefono

 */

    protected String name;
    protected String lastName;
    protected String id;
    protected String address;
    protected String phoneNumber;


    public Client(String name,String lastName, String id,String address,String phoneNumber){
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
