package com.zx.qqzone.DAO;

import com.zx.qqzone.pojo.Fruit;

import java.util.List;

/**
 * @ClassName fruitDao
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/12 20:07
 * @Version 1.0
 */
public interface fruitDao {
    List<Fruit> QueryList(int pageNumber, String keyword);

    Fruit Query(int id);

    boolean insert(Fruit fruit);

    Long count(String keyword);

    boolean update(Fruit fruit);

    boolean del(int id);


}
