package org.mernis.system.service.concretes;

import org.mernis.system.entities.Customer;
import org.mernis.system.mernis.LJEKPSPublicSoap;
import org.mernis.system.service.abstracts.CustomerCheckService;

public class CustomerCheckManager implements CustomerCheckService {
    @Override
    public boolean checkIfRealPerson(Customer customer) {

        return true;
    }
}
