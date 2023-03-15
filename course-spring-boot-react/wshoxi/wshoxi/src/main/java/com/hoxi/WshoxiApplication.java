package com.hoxi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class )
//Spring Security pom.xml'de yüklü olduğunbdan güvenlik gerekçesiyle password isteyecektir.
//işte bunu geçici olarak kaldırabiliriz bunun için (exclude=SecurityAutoConfiguration.class) yazılır ve
//geçici oarak bunu devredışı brakabiliriz.
public class WshoxiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WshoxiApplication.class, args);
	}

}
