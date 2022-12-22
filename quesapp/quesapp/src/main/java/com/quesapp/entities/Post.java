package com.quesapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "posts")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)//User objesini databaseden hemen çekme post objesini çektiğimde ilgili useri bana getirmene gerek yok diyorum.
    //fetch = FetchType.EAGER yazsaydım ilgili objeyi direk getirecekti
    //Birçok postun bir useri vardır
    @JoinColumn(name = "user_id",nullable = false)//databasedeki User_id colomn'a bağlandığımızı belirtmek için bunu yazıyoruz
    @OnDelete(action = OnDeleteAction.CASCADE)//Bir user silindiğinde onun tüm postları silinsin istiyoruz
    @JsonIgnore//serizilasion da bana sıkıntı çıkmasın
    private User user;

    private String title;

    @Column(columnDefinition = "text")
    private String text;
}
