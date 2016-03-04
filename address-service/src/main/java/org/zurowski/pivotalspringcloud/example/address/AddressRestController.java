package org.zurowski.pivotalspringcloud.example.address;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/customers/{customerId}/address")
@RestController
public class AddressRestController {

    private static final Logger log = LoggerFactory.getLogger(AddressRestController.class);

    private final Map<Long, Address> addresses;

    public AddressRestController() {
        addresses = new HashMap<>();
        addresses.put(1l, Address.create("70000", "Stuttgart"));
        addresses.put(2l, Address.create("1000", "Vienna"));
        addresses.put(3l, Address.create("10000", "Brooklyn"));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Address> get(@PathVariable long customerId) {
        log.info("All addresses for customerId={} requested", customerId);
        return ResponseEntity.ok(addresses.get(customerId));
    }

}
