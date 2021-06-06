package com.flamexander.spring.ws.HW;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
public class Category implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "category", propOrder =
        {
                "title",
                "id",
                "products"
        })
