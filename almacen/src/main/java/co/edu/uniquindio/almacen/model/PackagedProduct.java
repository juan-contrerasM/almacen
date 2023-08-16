package co.edu.uniquindio.almacen.model;

import java.time.LocalDate;


public class PackagedProduct extends Product {

    /*
     significados:
        PackagedProduct=productos envasados
        packaging date = fecha envasado
        containerWeight= peso del envase
     */
    private LocalDate packagingDate;
     private double containerWeight;

     public PackagedProduct(String code,String name,String description,double unitValue,int amount,LocalDate packagingDate,double containerWeight){
         super(code,name,description,unitValue,amount);
         this.packagingDate=packagingDate;
         this.containerWeight= containerWeight;

     }

    public LocalDate getPackagingDate() {
        return packagingDate;
    }

    public void setPackagingDate(LocalDate packagingDate) {
        this.packagingDate = packagingDate;
    }

    public double getContainerWeight() {
        return containerWeight;
    }

    public void setContainerWeight(double containerWeight) {
        this.containerWeight = containerWeight;
    }
}