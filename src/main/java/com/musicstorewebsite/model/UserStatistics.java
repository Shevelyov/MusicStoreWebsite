package com.musicstorewebsite.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_stats")
public class UserStatistics {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_stat_id")
    private int user_stat_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;

    @Column(name = "number_of_clicks")
    private int clicksCount;

    @Column(name = "button_name")
    private String buttonName;


    public int getUser_stat_id() {
        return user_stat_id;
    }

    public void setUser_stat_id(int user_stat_id) {
        this.user_stat_id = user_stat_id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getClicksCount() {
        return clicksCount;
    }

    public void setClicksCount(int clicksCount) {
        this.clicksCount = clicksCount;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }
}