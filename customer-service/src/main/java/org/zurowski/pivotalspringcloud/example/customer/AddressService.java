package org.zurowski.pivotalspringcloud.example.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zurowski.pivotalspringcloud.example.address.Address;

@Service
public class AddressService {

    public static final Logger log = LoggerFactory.getLogger(AddressService.class);

    @Value("${address.service.id:localhost}")
    private String addressServiceId;

    @Autowired
    RestTemplate restTemplate;

    public Address findAddress(long id) {
        Address address = restTemplate
                .getForObject(String.format("https://%s/customers/%s/address", addressServiceId, id), Address.class);
        log.info("Retrieved address={} from address service.", address);

        return address;
    }

}
