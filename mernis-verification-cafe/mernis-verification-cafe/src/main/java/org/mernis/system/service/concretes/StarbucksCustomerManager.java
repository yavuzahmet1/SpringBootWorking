package org.mernis.system.service.concretes;

import org.mernis.system.entities.Customer;
import org.mernis.system.service.abstracts.BaseCustomerManager;
import org.mernis.system.service.abstracts.CustomerCheckService;
import org.mernis.system.service.abstracts.CustomerService;

public class StarbucksCustomerManager extends BaseCustomerManager {
    CustomerCheckManager customerCheckManager;

    @Override
    public void save(Customer customer) {
        if (customerCheckManager.checkIfRealPerson(customer)) {
            save(customer);
            System.out.println("Saved to DB : " + customer.getName());
        } else {
            System.out.println("Not real person");
        }


    }


}
