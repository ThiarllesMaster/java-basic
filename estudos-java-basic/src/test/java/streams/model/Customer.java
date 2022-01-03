package streams.model;

public class Customer {

    private String name;
    private Integer tier;

    Customer(String name, Integer tier) {
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public Integer getTier() {
        return tier;
    }
}
