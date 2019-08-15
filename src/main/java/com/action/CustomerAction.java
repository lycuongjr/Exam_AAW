package com.action;
import com.entity.Customer;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer;
    private  CustomerService customerService = new CustomerService();
    public String create(){
        this.customer = Customer.CustomerBuilder.aCustomer().build();
        return INPUT;
    }
        public String store(){

            customerService.save(customer);
            return SUCCESS;

        }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public Customer getModel() {
        return null;
    }
}
