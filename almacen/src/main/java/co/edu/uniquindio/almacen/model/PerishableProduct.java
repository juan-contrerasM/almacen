package co.edu.uniquindio.almacen.model;

import java.time.LocalDate;

public class PerishableProduct extends Product {

    //duedate significa fecha de vencimiento

    private String dueDate;

    public PerishableProduct(String code,String name,String description,double unitValue,int amount,String dueDate){
        super(code,name,description,unitValue,amount);
        this.dueDate=dueDate;
    }
    public  PerishableProduct(){

    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "PerishableProduct{" +
                "dueDate='" + dueDate + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitValue=" + unitValue +
                ", amount=" + amount +
                '}';
    }
}