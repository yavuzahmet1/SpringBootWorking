package com.example.yvzbytes.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "addresses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"}) //iki tane adres nesnesinin İd si eşitse bu iki nesne birbirine eşittir anatasyonudur.
@ToString
public class Address implements Serializable {//Jpa entitilerin seriazable interfacesinden gelmesi lazım
    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "address", length = 500)
    private String address;
    @Enumerated
    private AddressType addressType;
    @Column(name = "active")
    Boolean isActive;

    @ManyToOne//EAGER->veritanında her adres select edildiğinde onun tüm ilgili kişiside gelsin
    //LAZY->sadece bu kişinin getteri çağrılırsa yani getPeron denilirse kullanılır
    @JoinColumn(name = "person_address_id")
    private Person person;

    public static enum AddressType {
        HOME_ADDRESS,
        WORK_ADDRESS,
        OTHER
    }
}
