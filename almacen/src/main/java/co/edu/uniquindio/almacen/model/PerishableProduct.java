package co.edu.uniquindio.almacen.model;

import java.time.LocalDate;

public class PerishableProduct extends Product {

    //duedate significa fecha de vencimiento

    private LocalDate dueDate;

    public PerishableProduct(String code,String name,String description,double unitValue,int amount,LocalDate dueDate){
        super(code,name,description,unitValue,amount);
        this.dueDate=dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}