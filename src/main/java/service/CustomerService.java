package service;

import controller.ConnectionJDBC;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService implements Icustomer{
    public static final String SELECT_FROM_CUSTOMER = "select * from customer;";
    public static final String INSERT_INTO_CUSTOMER_NAME_ADDRESS_EMAIL_PHONE_PROVINCE_ID_VALUES = "insert into customer(name, address, email, phone, province_id) values (?,?, ?,?, ?);";
    Iprovince iprovince = new ProvinceService();
    Connection connectionJDBC = ConnectionJDBC.getConnection();

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement statement = connectionJDBC.prepareStatement(SELECT_FROM_CUSTOMER);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int c_id = resultSet.getInt("id");
                String c_name = resultSet.getString("name");
                String c_address = resultSet.getString("address");
                String c_email = resultSet.getString("email");
                String c_phone = resultSet.getString("phone");
                int p_id = resultSet.getInt("province_id");
                String c_province = iprovince.findById(p_id).getName();
                Customer customer = new Customer(c_id, c_name, c_address, c_email, c_phone, c_province);
                customerList.add(customer);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id) {

    }

    @Override
    public void save(Customer c, int p_id) {
        try {
            PreparedStatement statement = connectionJDBC.prepareStatement(INSERT_INTO_CUSTOMER_NAME_ADDRESS_EMAIL_PHONE_PROVINCE_ID_VALUES);
            statement.setString(1, c.getName());
            statement.setString(2, c.getAddress());
            statement.setString(3, c.getEmail());
            statement.setString(4, c.getPhone());
            statement.setString(5, String.valueOf(p_id));
            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
