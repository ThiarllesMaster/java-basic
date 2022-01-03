package streams.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Product> getProducts() {
       //  Product(String name, String category, Double price)
        Product p1 = new Product("p1", "category1", 1.00);
        Product p2 = new Product("p2", "category2", 2.00);
        Product p3 = new Product("p3", "category3", 3.00);
        Product p4 = new Product("p4", "category4", 4.00);
        Product p5 = new Product("p5", "category5", 5.00);
        Product p6 = new Product("p6", "Books", 5.00);
        Product p7 = new Product("p7", "Books", 15.00);

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        products.add(p5);
        products.add(p6);
        products.add(p7);

        return products;
    }

    public static List<Order> getOrders() {
     // public Order(String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products)
        //Customer(String name, Integer tier)
        Customer customer = new Customer("Rafinha", 6);
        Order order1 = new Order("StatusOrder1", LocalDate.of(2021,2, 20),LocalDate.of(2021,3, 20),
                                 getProducts(), customer);
        List<Order> orders = new ArrayList<>();
        orders.add(order1);

        return orders;
    }
}
