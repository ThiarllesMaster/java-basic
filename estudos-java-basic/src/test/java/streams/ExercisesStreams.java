package streams;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import streams.model.Customer;
import streams.model.Database;
import streams.model.Order;
import streams.model.Product;

public class ExercisesStreams {

    List<Product> products;
    List<Order> orders;

    @BeforeEach
    public void setUp() {
        products = Database.getProducts();
        orders = Database.getOrders();
    }

    //Obtain a list of products belongs to category “category1” with price >= 1.00
    @Test
    public void exercise1() {
        List<Product> productsResult = products.stream()
                .filter(p -> p.getCategory().equals("category1"))
                .filter(p -> p.getPrice() == 1.00)
                .collect(Collectors.toList());

        productsResult.forEach(p -> System.out.println(p.getName()));
    }

    //Obtain a list of order with products belong to category “category1”. Use o match
    @Test
    public void exercise2() {
      List<Order> ordersResult = orders.stream()
              .filter(order -> order.getProducts().stream().anyMatch(p -> p.getCategory().equals("category1")))
              .collect(Collectors.toList());
      ordersResult.stream().forEach(o -> System.out.println(o.getStatus()));
    }

    // Obtain a list of product with category = “Toys” and then apply 10% discount
    @Test
    public void exercise3() {
        Consumer<Product> productConsumer = product -> product.setPrice(product.getPrice() * 90 / 100);
        List<Product> productsResult = products.stream()
                .filter(p -> p.getCategory().equals("category1"))
                .peek(productConsumer)
                .collect(Collectors.toList());
        productsResult.stream().forEach(p -> System.out.println(p.getPrice()));
    }

    //Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
    @Test
    public void exercise4() {
        List<Product> products = orders.stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
                .distinct()
                .flatMap(o -> o.getProducts().stream())
                .collect(Collectors.toList());
    }

    //Get the cheapest products of “Books” category
    @Test
    public void exercise5() {
        Product product = products.stream()
                .filter(p -> p.getCategory().equals("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst().get();

        assertEquals(product.getPrice(), 5.00);
    }

    //Get the 3 most recent placed order
    @Test
    public void exercise6() {
        List<Order> ordersResult = orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDate))
                .limit(3)
                .collect(Collectors.toList());

    }

    //Calculate total lump sum of all orders placed in Feb 2021
    @Test
    public void exercise8() {
        Double total = orders.stream()
                .filter(o -> o.getOrderDate().equals(LocalDate.of(2021,2, 20)))
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    //Calculate order average payment placed on 14-Mar-2021
    @Test
    public void exercise9() {
        Double average =  orders.stream()
                .filter(o -> o.getDeliveryDate().equals(LocalDate.of(2021,3, 20)))
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .average().getAsDouble();
    }

    //Produce a data map with order records grouped by customer
    @Test
    public void exercise10() {
        Map<Customer, List<Order>> groupByCustomer = orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }

    // Obtain a data map with list of product name by category
    @Test
    public void exercise11() {
        Map<String, List<String>> nameCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                                               Collectors.mapping(product -> product.getName(), Collectors.toList())));

    }

    //Get the most expensive product by category
    @Test
    public void exercise12() {
        Map<String, Optional<Product>> map = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                         Collectors.maxBy(Comparator.comparing(Product::getPrice))));
    }
}
