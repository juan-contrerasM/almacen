package co.edu.uniquindio.almacen.model;

import java.time.LocalDate;


public class PackagedProduct extends Product {

    /*
     significados:
        PackagedProduct=productos envasados
        packaging date = fecha envasado
        containerWeight= peso del envase
     */
    private String packagingDate;
    private double containerWeight;
    private String origin;

     public PackagedProduct(String code,String name,String description,double unitValue,int amount,String packagingDate,double containerWeight, String origin){
         super(code,name,description,unitValue,amount);
         this.packagingDate=packagingDate;
         this.containerWeight= containerWeight;
         this.origin=origin;

     }
    public PackagedProduct() {

    }
    public String getPackagingDate() {
        return packagingDate;
    }

    public void setPackagingDate(String packagingDate) {
        this.packagingDate = packagingDate;
    }

    public double getContainerWeight() {
        return containerWeight;
    }

    public void setContainerWeight(double containerWeight) {
        this.containerWeight = containerWeight;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "PackagedProduct{" +
                "packagingDate='" + packagingDate + '\'' +
                ", containerWeight=" + containerWeight +
                ", origin='" + origin + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitValue=" + unitValue +
                ", amount=" + amount +
                '}';
    }
}