package com.daliu.dao.impl;

import com.daliu.dao.ItemsDao;
import com.daliu.domain.Items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao {
    public List<Items> findAll() throws Exception {
        List<Items> list = new ArrayList<Items>();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///daliu", "root", "110");
            pstmt = connection.prepareStatement("SELECT * FROM items");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Items items = new Items();
                items.setId(resultSet.getInt("id"));
                items.setName(resultSet.getString("name"));
                list.add(items);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            pstmt.close();
            resultSet.close();
        }
        return list;
    }
}
