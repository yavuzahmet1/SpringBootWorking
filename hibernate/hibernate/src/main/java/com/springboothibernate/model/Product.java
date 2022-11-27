package com.springboothibernate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "product_gen",strategy = GenerationType.SEQUENCE)
    //@GeneratedValue stratejisini belirtmezsek aouto olarak çalışacak ve performanslı olmaayacaktır.
    //IDENTITY->ilgili tablodaki son primary key değerinin bir fazlasını alır bu da performaslı değildir.
    //SEQUIENCE->performans olarak en iyisidir.
    @SequenceGenerator(name = "product_gen",sequenceName = "product_seq",initialValue = 1000,allocationSize = 10)
    //@SequenceGenerator->Sequence'yi özelleştirmek için kullanılır
    //name ile generator ismini belirtiriz
    //sequenceName ile databasedeki table'ın ismini belirtiyuoruz
    //initialValue ile başlangıç değeri belirtilir.
    //allocationSize kaç kaç artması gerektiği belitirilir. 1 dersek 1 1, 10 dersek 10 10.
    //@SequenceGenerator kullanılacaksa, @GeneratedValue anatasyonunda strategy belirtilmeden önce generator kullanarak özelleştirdiğimiz sequence'yi belirtmemiz gereklidir yukarıda belirttik.
    //Table ->çok kullanılmaz veri tabanı düzeyinde sequence desteklenmediğinde kullnılır ama çık iyi performans vermez
    //@TableGenerator anatasyonu ile özelleştirilir.
    @Column(name = "id",length = 100)
    private int id;
    @Column(name = "name",length = 100)
    private String name;
    @Column(name = "stock",length = 100)
    private int stock;
    @Column(name = "price",length = 100)
    private double price;
    @Column(name = "description",length = 100)
    private String description;
}
