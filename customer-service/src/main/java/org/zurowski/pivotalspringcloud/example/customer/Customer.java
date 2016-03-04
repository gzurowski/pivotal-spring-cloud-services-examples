package org.zurowski.pivotalspringcloud.example.customer;

public class Customer {

    private Long id;

    private String firstName;

    private String lastName;

    public Customer() {
    }

    public static Customer create(long id, String firstName, String lastName) {
        Customer customer = new Customer();
        customer.id = id;
        customer.firstName = firstName;
        customer.lastName = lastName;

        return customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
