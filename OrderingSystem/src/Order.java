import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private List<OrderItem> items = new ArrayList<>();
    private Client client;

    private LocalDateTime moment;
    private OrderStatus orderStatus;

    //Constructors
    public Order() {}

    public Order(Client client, LocalDateTime moment, OrderStatus orderStatus) {

        this.client = client;
        this.moment = moment;
        this.orderStatus = orderStatus;
    }

    //Getters and setters methods
    public Client getClient() {return client;}
    public LocalDateTime getMoment() {return moment;}
    public OrderStatus getOrderStatus() {return orderStatus;}
    public List<OrderItem> getOrderItems() {return items;}

    public void setClient(Client client) {this.client = client;}
    public void setMoment(LocalDateTime moment) {this.moment = moment;}
    public void setOrderStatus(OrderStatus orderStatus) {this.orderStatus = orderStatus;}

    //General methods
    public void addItem(OrderItem orderItem) {

        items.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {

        items.remove(orderItem);
    }

    public Double total() {

        double total = 0;

        for (OrderItem item : items) {

            total += item.subTotal();
        }

        return total;
    }

    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Order moment: ").append(getMoment().format(formatter)).append("\n");
        sb.append("Order status: ").append(getOrderStatus()).append("\n");
        sb.append("Client : ").append(getClient()).append("\n");
        sb.append("Order items: ").append("\n");

        for  (OrderItem item : items) sb.append(item).append("\n");

        sb.append("Total price: $").append(total()).append("\n");

        return sb.toString();

    }
}
