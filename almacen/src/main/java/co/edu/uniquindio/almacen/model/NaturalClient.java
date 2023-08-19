package co.edu.uniquindio.almacen.model;

import java.time.LocalDate;


public class NaturalClient extends Client {

    /*
  significados:

  email =correo
  birthDate= fecha de nacimiento
     */

    private String email;
    private String birthDate;

    public NaturalClient() {
    }

    public NaturalClient(String name, String lastName, String id, String address, String phoneNumber, String email, String birthDate, String typeClient) {
       super(name,lastName,id,address,phoneNumber,typeClient);
        this.email = email;
        this.birthDate=birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "NaturalClient{" +
                "email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", typeClient='" + typeClient + '\'' +
                '}';
    }
}