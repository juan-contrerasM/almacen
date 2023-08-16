package co.edu.uniquindio.almacen.model;

public class RefrigeratedProduct extends Product {

    /*
       significados:

       approvalCode=codigo de aprobacion
       temperature= temperatura
     */

    private  String approvalCode;
    private int temperature;
    public RefrigeratedProduct(String code,String name,String description,double unitValue,int amount,String approvalCode,int temperature){
        super(code,name,description,unitValue,amount);
        this.approvalCode = approvalCode;
        this.temperature = temperature;
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
}