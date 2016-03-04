package org.zurowski.pivotalspringcloud.example.address;

public class Address {

    private String zip;

    private String city;

    public static Address create(String zip, String city) {
        Address address = new Address();
        address.zip = zip;
        address.city = city;
        return address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address [zip=" + zip + ", city=" + city + "]";
    }

}
