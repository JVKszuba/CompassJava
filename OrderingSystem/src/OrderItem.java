public class OrderItem {

    private Product product;

    private Integer quantity;
    private Double price;

    //Constructors
    public OrderItem() {}

    public OrderItem(Product product, Integer quantity, Double price) {

        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    //Getters and setters methods
    public Product getProduct() {return this.product;}
    public Integer getQuantity() {return quantity;}
    public Double getPrice() {return price;}

    public void setProduct(Product product) {this.product = product;}
    public void setQuantity(Integer quantity) {this.quantity = quantity;}
    public void setPrice(Double price) {this.price = price;}

    //General methods
    public Double subTotal() {

        return price * quantity;
    }

    public String toString() {

        return product.getName() + ", $" + getPrice() + ", Quantity: " + getQuantity() + ", SubTotal: $" + subTotal();
    }
}
