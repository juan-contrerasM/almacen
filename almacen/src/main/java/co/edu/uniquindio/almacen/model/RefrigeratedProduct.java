package co.edu.uniquindio.almacen.model;

public class RefrigeratedProduct extends Product {

    /*
       significados:

       approvalCode=codigo de aprobacion
       temperature= temperatura
     */

    private  String approvalCode;
    private int temperature;
    public RefrigeratedProduct(String code,String name,String description,double unitValue,int amount,String approvalCode,int temperature,String tipo){
        super(code,name,description,unitValue,amount, tipo);
        this.approvalCode = approvalCode;
        this.temperature = temperature;

    }
    public RefrigeratedProduct(){

    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "RefrigeratedProduct{" +
                "approvalCode='" + approvalCode + '\'' +
                ", temperature=" + temperature +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", unitValue=" + unitValue +
                ", amount=" + amount +
                "tipo="+tipo+
                '}';
    }
}