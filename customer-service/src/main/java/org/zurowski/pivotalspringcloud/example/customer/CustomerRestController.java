package org.zurowski.pivotalspringcloud.example.customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zurowski.pivotalspringcloud.example.address.Address;

@RequestMapping(value = "/customers")
@RestController
public class CustomerRestController {

    private static final Logger log = LoggerFactory.getLogger(CustomerRestController.class);

    private final Map<Long, Customer> customers;

    @Autowired
    AddressService addressService;

    public CustomerRestController() {
        customers = new HashMap<>();
        customers.put(1l, Customer.create(1, "Thomas", "Seibert"));
        customers.put(2l, Customer.create(2, "John", "Rhoton"));
        customers.put(3l, Customer.create(3, "Gregor", "Zurowski"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Customer>> getAll() {
        log.info("All customers requested");
        return ResponseEntity.ok(customers.values());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> get(@PathVariable long id) {
        log.info("Customer with id={} requested", id);
        return customers.containsKey(id) ? ResponseEntity.ok(customers.get(id))
                : new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}/address", method = RequestMethod.GET)
    public ResponseEntity<Address> getAddress(@PathVariable long id) {
        log.info("Address for customer with id={} requested", id);

        Address address = addressService.findAddress(id);
        return ResponseEntity.ok(address);
    }

}
