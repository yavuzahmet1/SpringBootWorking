package com.example.yvzbytes.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "people")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of={"id"})
@ToString
public class Person {
    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "address", length = 100)
    private String name;
    @Column(name = "last_name", length = 100)
    private String lastName;

    @OneToMany//bir kişi birçok adrese atanabilir anlamında
    @JoinColumn(name = "person_address_id") //nasıl bir field ile yapacağımızı belirtiyoruz
    List<Address> addressList;//join işlemi yaptık bunun içinde ilişki kuruyoruz
}
