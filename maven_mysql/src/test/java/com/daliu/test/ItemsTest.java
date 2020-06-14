package com.daliu.test;

import com.daliu.dao.ItemsDao;
import com.daliu.dao.impl.ItemsDaoImpl;
import com.daliu.domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() throws Exception {
        ItemsDao itemsDao = new ItemsDaoImpl();
        List<Items> list = itemsDao.findAll();
        for (Items items : list) {
            System.out.println(items);
        }
    }
}
