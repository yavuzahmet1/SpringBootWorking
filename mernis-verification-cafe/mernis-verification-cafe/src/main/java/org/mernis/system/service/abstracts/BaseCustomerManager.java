package org.mernis.system.service.abstracts;

import org.mernis.system.entities.Customer;

public abstract class BaseCustomerManager implements CustomerService{
    @Override
    public void save(Customer customer) {
        System.out.println("Saved to DB : "+customer.getName());
    }
}
