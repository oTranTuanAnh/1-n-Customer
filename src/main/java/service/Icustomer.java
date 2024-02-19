package service;

import model.Customer;

public interface Icustomer extends Iservice<Customer>{
void save(Customer c, int p_id);
}
