package co.edu.uniquindio.almacen.model;
import java.time.LocalDate;
 import java.util.ArrayList;

public class Sale {
     /*



 significado:
  code=codigo
  date=fecha
  Client =cliente
  saleDetail= detalle venta

  se genero con el id el get y set del arrylist mirar si estan bien

      */

    private String code;
    private String date;
    private ArrayList<SaleDetail> saleDetail = new ArrayList();
    private Client client;
    private double total;
    private double iva;

    public Sale(String code,String date,SaleDetail saleDetail, Client client,double total,double iva){
        this.code= code;
        this.date = date;
        //falta almacenar el detalle venta
        this.client= client;
        this.total = total;
        this.iva = iva;

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<SaleDetail> getSaleDetail() {
        return saleDetail;
    }

    public void setSaleDetail(ArrayList<SaleDetail> saleDetail) {
        this.saleDetail = saleDetail;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
}