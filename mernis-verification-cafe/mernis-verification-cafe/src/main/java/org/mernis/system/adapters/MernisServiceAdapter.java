package org.mernis.system.adapters;

import org.mernis.system.entities.Customer;
import org.mernis.system.mernis.LJEKPSPublicSoap;
import org.mernis.system.service.abstracts.CustomerCheckService;

public class MernisServiceAdapter implements CustomerCheckService {
    @Override
    public boolean checkIfRealPerson(Customer customer) throws Exception {
        LJEKPSPublicSoap client=new LJEKPSPublicSoap();
        return client.TCKimlikNoDogrula(customer.getNationalityId(),customer.getName(),customer.getLastName(),customer.getDateOfBirth());
    }
}
