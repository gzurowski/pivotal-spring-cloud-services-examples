package org.zurowski.pivotalspringcloud.example.customer;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.zurowski.pivotalspringcloud.example.customer.support.MdcIpAddressFilter;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {

    @Bean
    public Filter mdcIpAddressFilter() {
        return new MdcIpAddressFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
