package com.zx.qqzone.service;

import com.zx.qqzone.DAO.fruitDao;
import com.zx.qqzone.pojo.Fruit;

import java.util.List;

/**
 * @ClassName FruitServiceImp
 * @Description TODO
 * @Author xpower
 * @Date 2022/10/19 16:44
 * @Version 1.0
 */
public class FruitServiceImp implements FruitService {
    fruitDao fruitDao = null;

    @Override
    public List<Fruit> getFruitList(Integer pageNo, String keyword) {
        return fruitDao.QueryList(pageNo, keyword);
    }

    @Override
    public Fruit getFruit(Integer fid) {
        return fruitDao.Query(fid);
    }

    @Override
    public Long getFruitCount(String keyword) {
        Long count = fruitDao.count(keyword);
        return (count + 6 - 1) / 6;
    }

    @Override
    public boolean addFruit(Fruit fruit) {return fruitDao.insert(fruit);}

    @Override
    public boolean delFruit(Integer fid) {return fruitDao.del(fid);}

    @Override
    public boolean editFruit(Fruit fruit) {return fruitDao.update(fruit);}
}
