package org.mernis.system.service.abstracts;

import org.mernis.system.entities.Customer;

public interface CustomerCheckService {
    boolean checkIfRealPerson(Customer customer);
}
