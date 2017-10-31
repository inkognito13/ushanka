package ru.sstu.ushankashop.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sstu.ushankashop.domain.ItemEntity;
import ru.sstu.ushankashop.dto.Item;
import ru.sstu.ushankashop.dao.ItemDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class ItemDAOImpl implements ItemDAO {

    @Autowired
    DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<ItemEntity> getAllItems() {
        Connection connection = null;
        List<ItemEntity> result = new ArrayList<ItemEntity>();
        try {
            connection = getDataSource().getConnection();
            ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM ITEM");
            while (rs.next()) {
                result.add(new ItemEntity(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getString("manufacturer")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public ItemEntity getItemById(Long id) {
        Connection connection = null;
        ItemEntity result = null;
        try {
            connection = getDataSource().getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ITEM WHERE id = ?");
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                result = new ItemEntity(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("stock"),
                        rs.getString("manufacturer")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
