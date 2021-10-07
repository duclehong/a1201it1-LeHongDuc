package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.List;

public class HibernateCustomerServiceImpl implements CustomerService {
    @Bean
    public CustomerService customerService() {
        return new HibernateCustomerServiceImpl();
    }
    @Override
    public List<Customer> findAll() {
        return Collections.emptyList();
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(Long id) {

    }
}