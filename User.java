package ru.geekbrains.april.market.HW;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class User
{
    @ManyToMany
    @JoinTable(name = "user_adress", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name ="address_id" ))
    private collection<Addresses> addresses;
}
