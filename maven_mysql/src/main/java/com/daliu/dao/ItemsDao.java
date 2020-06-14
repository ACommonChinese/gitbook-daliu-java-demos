package com.daliu.dao;

import com.daliu.domain.Items;

import java.util.List;

public interface ItemsDao {
    public List<Items> findAll() throws Exception;
}
