package org.mernis.system.adapters;

import org.mernis.system.entities.Customer;
import org.mernis.system.nvi.GAVKPSPublicSoap12;
import org.mernis.system.service.abstracts.CustomerCheckService;

public class MernisServiceAdapter implements CustomerCheckService {
    @Override
    public boolean checkIfRealPerson(Customer customer) throws Exception {
        GAVKPSPublicSoap12 client=new GAVKPSPublicSoap12();
        return client.TCKimlikNoDogrula(customer.getNationalityId(),customer.getName(),customer.getLastName(),customer.getDateOfBirth());
    }
}
