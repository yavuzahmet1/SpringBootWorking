package com.account;

import com.account.model.Customer;
import com.account.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class AccountFolksdevApplication implements CommandLineRunner {
	private final CustomerRepository customerRepository;

	public AccountFolksdevApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountFolksdevApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer=new Customer("","Ahmet","YAVUZ",new HashSet<>());
		System.out.println(customer.getId()+customer.getName());

	}
}
