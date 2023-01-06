package org.mernis.system;

import org.mernis.system.entities.Customer;
import org.mernis.system.service.abstracts.BaseCustomerManager;
import org.mernis.system.service.concretes.NeroCustomerManager;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BaseCustomerManager baseCustomerManager=new NeroCustomerManager();
        baseCustomerManager.save(new Customer(1,"Ahmet","YAVUZ",1990,"12345678901"));
    }
}