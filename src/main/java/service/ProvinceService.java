package service;

import controller.ConnectionJDBC;
import model.Province;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProvinceService implements Iprovince{
    public static final String SELECT_FROM_PROVINCE_WHERE_ID = "select * from province where id = ?;";
    Connection connection = ConnectionJDBC.getConnection();
    @Override
    public List<Province> findAll() {
        return null;
    }

    @Override
    public Province findById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FROM_PROVINCE_WHERE_ID);
            statement.setString(1, String.valueOf(id));
            ResultSet resultSet = statement.executeQuery();
            int p_id = 0;
            String p_name ="";
            while (resultSet.next()){
                p_id = resultSet.getInt("id");
                p_name = resultSet.getString("name");
            }
            return new Province(p_id, p_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save(Province province) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id) {

    }
}
