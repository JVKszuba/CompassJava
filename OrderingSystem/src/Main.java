import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Order order;
        OrderItem orderItem;
        Client client;
        Product product;
        OrderStatus status;
        String nameClient, emailClient, birthDateClient, nameProduct;

        int quantityProduct, quantityStock;
        double priceProduct;

        System.out.println("Enter client data: ");

        System.out.print("Name: ");
        nameClient = sc.nextLine();

        System.out.print("Email: ");
        emailClient = sc.nextLine();

        System.out.print("Birth date (DD/MM/YYYY): ");
        birthDateClient = sc.nextLine();

        client = new Client(nameClient, emailClient, LocalDate.parse(birthDateClient, Client.formatter));

        System.out.println("\nEnter order data:");

        System.out.print("Status: ");
        status = OrderStatus.valueOf(sc.next().toUpperCase());

        order = new Order(client, LocalDateTime.now(), status);

        System.out.print("How many items to this order: ");
        quantityProduct = sc.nextInt();

        for  (int i = 1; i <= quantityProduct; i++) {

            System.out.println("\nEnter #" + i + " item data: ");

            System.out.print("Product name: ");
            sc.nextLine();
            nameProduct = sc.nextLine();

            System.out.print("Product price: ");
            priceProduct = sc.nextDouble();

            product = new Product(nameProduct, priceProduct);

            System.out.print("Quantity: ");
            quantityStock = sc.nextInt();

            orderItem = new OrderItem(product, quantityStock, priceProduct);
            order.addItem(orderItem);
        }

        System.out.println("\nORDER SUMMARY: \n" + order);

        sc.close();
    }
}