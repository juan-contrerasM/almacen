package co.edu.uniquindio.almacen.model;

import java.time.LocalDate;


public class NaturalClient extends Client {

    /*
  significados:

  email =correo
  birthDate= fecha de nacimiento
     */

    private String email;
    private LocalDate birthDate;


    public NaturalClient(String name,String lastName, String id,String address,String phoneNumber,String email, LocalDate birthDate) {
       super(name,lastName,id,address,phoneNumber);
        this.email = email;
        this.birthDate=birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}