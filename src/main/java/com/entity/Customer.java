package com.entity;

import java.util.Calendar;

public class Customer {
    private long id;
    private String name;
    private String address;
    private String phone_No;
    private String purchase_order;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_No() {
        return phone_No;
    }

    public void setPhone_No(String phone_No) {
        this.phone_No = phone_No;
    }

    public String getPurchase_order() {
        return purchase_order;
    }

    public void setPurchase_order(String purchase_order) {
        this.purchase_order = purchase_order;
    }

    public static final class CustomerBuilder {
        private long id;
        private String name;
        private String address;
        private String phone_No;
        private String purchase_order;

        private CustomerBuilder() {
            this.id = Calendar.getInstance().getTimeInMillis();
        }

        public static CustomerBuilder aCustomer() {
            return new CustomerBuilder();
        }

        public CustomerBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public CustomerBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder withPhone_No(String phone_No) {
            this.phone_No = phone_No;
            return this;
        }

        public CustomerBuilder withPurchase_order(String purchase_order) {
            this.purchase_order = purchase_order;
            return this;
        }

        public Customer build() {
            Customer customer = new Customer();
            customer.setId(id);
            customer.setName(name);
            customer.setAddress(address);
            customer.setPhone_No(phone_No);
            customer.setPurchase_order(purchase_order);
            return customer;
        }
    }
}
