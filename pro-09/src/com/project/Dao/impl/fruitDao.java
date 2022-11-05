package com.project.Dao.impl;


import com.project.Dao.pojo.Fruit;

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
    List<Fruit> QueryList( int pageNumber, String keyword);

    Fruit Query( int id);

    boolean insert( Fruit fruit);

    Long count(String keyword);

    boolean update( Fruit fruit);

    boolean del(int id);

//    boolean add(Connection connection,Fruit fruit);


}
