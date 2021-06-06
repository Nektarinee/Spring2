package com.flamexander.spring.ws.HW;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;

public class SoapCategory
{
    @XmlElement(required = true)
    protected String Title;
    protected long id;
    @XmlElement(required = true)
    protected List<Product> products;



    public String getTitle()
    {
        return Title;
    }

    public void setTitle()
    {
        this.Title = value;
    }

    public long getId()
    {
        return id;
    }
    public List<Product> getProducts()
    {
        if (products == null)
        {
            products = new ArrayList<Product>();
        }
        return this.products;
    }
}