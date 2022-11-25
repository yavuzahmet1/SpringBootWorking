package de.eretantoker.tutorials.customerservice.service;

import de.eretantoker.tutorials.customerservice.exception.EntityAlreadyExistsException;
import de.eretantoker.tutorials.customerservice.exception.EntityNotFoundException;
import de.eretantoker.tutorials.customerservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private static List<Customer> customers;

    private static final String ALREADY_EXISTS_MESSAGE = "Customer with firstName: %s and lastName: %s is already existing";

    public List<Customer> getCustomers() {
        initCustomers();
        return customers;
    }

    private void initCustomers() {
        if (customers == null) {
            Customer customer = new Customer();
            customer.setId(UUID.randomUUID().toString());
            customer.setFirstName("Albert");
            customer.setLastName("Einstein");
            customer.setAge(55);

            Customer customer2 = new Customer();
            customer2.setId(UUID.randomUUID().toString());
            customer2.setFirstName("Otto");
            customer2.setLastName("Hahn");
            customer2.setAge(60);

            customers = new ArrayList<>();
            customers.add(customer);
            customers.add(customer2);
        }
    }

    public Customer getCustomerById(String id) {
        return customers.stream()
                .filter(cus -> cus.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException(String.format("Customer not found with id: %s", id)));
    }

    public Customer createCustomer(Customer customer) {

        checkExistingCustomer(customer);

        customer.setId(UUID.randomUUID().toString());
        customers.add(customer);

        return customer;
    }

    private void checkExistingCustomer(Customer customer) {
        customers.stream()
                .filter(cus -> cus.getFirstName().equals(customer.getFirstName()))
                .filter(cus -> cus.getLastName().equals(customer.getLastName()))
                .findFirst()
                .ifPresent(cus -> {
                    throw new EntityAlreadyExistsException(String.format(ALREADY_EXISTS_MESSAGE, customer.getFirstName(), customer.getLastName()));
                });
    }

    public void deleteCustomer(String id) {
        customers = customers.stream()
                .filter(customer -> !customer.getId().equals(id))
                .collect(Collectors.toList());
    }
}
