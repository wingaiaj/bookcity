package com.zx.Fruit.impl;

import com.zx.Fruit.pojo.Fruit;

import java.sql.Connection;
import java.util.List;

/**
 * @ClassName fruitDao
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/12 20:07
 * @Version 1.0
 */
public interface fruitDao {
    List<Fruit> QueryList(Connection connection,int pageNumber,String keyword);

    Fruit Query(Connection connection, int id);

    boolean insert(Connection connection, Fruit fruit);

    Long count(Connection connection,String keyword);

    boolean update(Connection connection, Fruit fruit);

    boolean del(Connection connection,int id);

//    boolean add(Connection connection,Fruit fruit);


}
