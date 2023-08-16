package co.edu.uniquindio.almacen.model;

public  abstract class  Product {

    /*
        significados:
        code=codigo
        name=nombre
        description=descripcion
        unitValue=valor unitario
        amount =cantidad
     */


    protected String code;
    protected String name;
    protected String description;
    protected double unitValue;
    protected int amount;

    public Product(String code,String name,String description,double unitValue,int amount) {
        this.code= code;
        this.name= name;
        this.description=description;
        this.unitValue=unitValue;
        this.amount=amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(double unitValue) {
        this.unitValue = unitValue;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}