package co.edu.uniquindio.almacen.model;

public class SaleDetail {

    /*
    Del detalle de la venta se debe registrar la cantidad de productos vendidos,
     el subtotal, el producto vendido(relación)

     significado:
     quantityProducts=cantidad de productos
     */

    private int quantityProducts;
    private double subTotal;
    private Product product;

    public SaleDetail(int quantityProducts,double subTotal,Product product){
        this.quantityProducts= quantityProducts;
        this.subTotal= subTotal;
        this.product=product;

    }

    public int getQuantityProducts() {
        return quantityProducts;
    }

    public void setQuantityProducts(int quantityProducts) {
        this.quantityProducts = quantityProducts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}